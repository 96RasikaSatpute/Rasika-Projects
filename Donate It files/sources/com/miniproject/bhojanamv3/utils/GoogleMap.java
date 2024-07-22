package com.miniproject.bhojanamv3.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.cache.DiskLruCache;

public class GoogleMap extends AppCompatActivity implements OnMapReadyCallback, LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final int PERMISSIONS_REQUEST_CODE = 1248;
    String[] appermissions = {"android.permission.ACCESS_FINE_LOCATION"};
    Bundle bundle;
    Button button;
    Marker mCurrLocationMarker;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    com.google.android.gms.maps.GoogleMap mMap;
    View mapView;
    DialogProgress progressDialog;
    TextView txtLocationAddress;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_google_map);
        if (!checkAndrequestPermissions()) {
            return;
        }
        if (((LocationManager) getSystemService("location")).isProviderEnabled("gps")) {
            initapp();
        } else {
            showGPSDisabledAlertToUser();
        }
    }

    private void showGPSDisabledAlertToUser() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                GoogleMap.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                GoogleMap.this.finish();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                GoogleMap.this.finish();
            }
        });
        alertDialogBuilder.create().show();
    }

    public void initapp() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        this.mapView = mapFragment.getView();
        this.button = (Button) findViewById(R.id.confirm_address);
        mapFragment.getMapAsync(this);
        TextView textView = (TextView) findViewById(R.id.txtLocationAddress);
        this.txtLocationAddress = textView;
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.txtLocationAddress.setSingleLine(true);
        this.txtLocationAddress.setMarqueeRepeatLimit(-1);
        this.txtLocationAddress.setSelected(true);
        DialogProgress dialogProgress = new DialogProgress("Fetching current location");
        this.progressDialog = dialogProgress;
        dialogProgress.show(getSupportFragmentManager(), "Dialog Progress");
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (GoogleMap.this.bundle != null) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result", GoogleMap.this.bundle);
                    GoogleMap.this.setResult(-1, returnIntent);
                    GoogleMap.this.finish();
                }
            }
        });
    }

    public boolean checkAndrequestPermissions() {
        List<String> listpermissionneeded = new ArrayList<>();
        for (String perm : this.appermissions) {
            if (ContextCompat.checkSelfPermission(this, perm) != 0) {
                listpermissionneeded.add(perm);
            }
        }
        if (listpermissionneeded.isEmpty()) {
            return true;
        }
        ActivityCompat.requestPermissions(this, (String[]) listpermissionneeded.toArray(new String[listpermissionneeded.size()]), PERMISSIONS_REQUEST_CODE);
        return false;
    }

    public void onMapReady(final com.google.android.gms.maps.GoogleMap googleMap) {
        this.mMap = googleMap;
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                buildGoogleApiClient();
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                googleMap.getUiSettings().setMapToolbarEnabled(false);
            }
            View view = this.mapView;
            if (!(view == null || view.findViewById(Integer.parseInt(DiskLruCache.VERSION_1)) == null)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((View) this.mapView.findViewById(Integer.parseInt(DiskLruCache.VERSION_1)).getParent()).findViewById(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_2D)).getLayoutParams();
                layoutParams.addRule(10, 0);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(0, 0, 30, 70);
            }
            this.mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                public void onMapClick(LatLng latLng) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(latLng.latitude + " : " + latLng.longitude);
                    googleMap.clear();
                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                    googleMap.addMarker(markerOptions);
                    GoogleMap.this.getAddressFromLocation(markerOptions.getPosition().latitude, markerOptions.getPosition().longitude);
                }
            });
            return;
        }
        buildGoogleApiClient();
        googleMap.setMyLocationEnabled(true);
    }

    /* access modifiers changed from: protected */
    public synchronized void buildGoogleApiClient() {
        GoogleApiClient build = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        this.mGoogleApiClient = build;
        build.connect();
    }

    public void onLocationChanged(Location location) {
        this.progressDialog.dismiss();
        this.mLastLocation = location;
        Marker marker = this.mCurrLocationMarker;
        if (marker != null) {
            marker.remove();
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(0.0f));
        this.mCurrLocationMarker = this.mMap.addMarker(markerOptions);
        getAddressFromLocation(markerOptions.getPosition().latitude, markerOptions.getPosition().longitude);
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        this.mMap.animateCamera(CameraUpdateFactory.zoomTo(11.0f));
        if (this.mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(this.mGoogleApiClient, (LocationListener) this);
        }
    }

    public void onConnected(Bundle bundle2) {
        LocationRequest locationRequest = new LocationRequest();
        this.mLocationRequest = locationRequest;
        locationRequest.setInterval(1000);
        this.mLocationRequest.setFastestInterval(1000);
        this.mLocationRequest.setPriority(102);
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            LocationServices.FusedLocationApi.requestLocationUpdates(this.mGoogleApiClient, this.mLocationRequest, (LocationListener) this);
        }
    }

    public void onConnectionSuspended(int i) {
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    /* access modifiers changed from: private */
    public void getAddressFromLocation(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
        this.bundle = new Bundle();
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addresses != null) {
            try {
                if (addresses.get(0).getAddressLine(0) != null) {
                    this.bundle.putString("area", addresses.get(0).getAddressLine(0));
                    this.txtLocationAddress.setText(addresses.get(0).getAddressLine(0));
                } else {
                    this.bundle.putString("area", "");
                }
            } catch (IndexOutOfBoundsException e2) {
                Toast.makeText(this, "No Data", 1).show();
            }
            try {
                if (addresses.get(0).getAdminArea() != null) {
                    this.bundle.putString("state", addresses.get(0).getAdminArea());
                } else {
                    this.bundle.putString("state", "");
                }
            } catch (IndexOutOfBoundsException e3) {
                Toast.makeText(this, "No Data", 1).show();
            }
            try {
                if (addresses.get(0).getLocality() != null) {
                    this.bundle.putString("city", addresses.get(0).getLocality());
                } else {
                    this.bundle.putString("city", "");
                }
            } catch (IndexOutOfBoundsException e4) {
                Toast.makeText(this, "No Data", 1).show();
            }
            try {
                if (addresses.get(0).getPostalCode() != null) {
                    this.bundle.putString("pincode", addresses.get(0).getPostalCode());
                } else {
                    this.bundle.putString("pincode", "");
                }
            } catch (IndexOutOfBoundsException e5) {
                Toast.makeText(this, "No Data", 1).show();
            }
            try {
                if (addresses.get(0).hasLatitude()) {
                    this.bundle.putString("lat", String.valueOf(addresses.get(0).getLatitude()));
                } else {
                    this.bundle.putString("lat", "");
                }
            } catch (IndexOutOfBoundsException e6) {
                Toast.makeText(this, "No Data", 1).show();
            }
            try {
                if (addresses.get(0).hasLongitude()) {
                    this.bundle.putString("long", String.valueOf(addresses.get(0).getLongitude()));
                } else {
                    this.bundle.putString("long", "");
                }
            } catch (IndexOutOfBoundsException e7) {
                Toast.makeText(this, "No Data", 1).show();
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        int[] iArr = grantResults;
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            HashMap hashMap = new HashMap();
            int deniedCount = 0;
            for (int i = 0; i < iArr.length; i++) {
                if (iArr[i] == -1) {
                    hashMap.put(permissions[i], Integer.valueOf(iArr[i]));
                    deniedCount++;
                }
            }
            if (deniedCount == 0) {
                initapp();
                return;
            }
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                int intValue = entry.getValue().intValue();
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, entry.getKey())) {
                    showDialog("Permission Required", "We need your location to Auto-fill your Address.", "yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            GoogleMap.this.checkAndrequestPermissions();
                        }
                    }, "No, Exit App", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            GoogleMap.this.finish();
                        }
                    }, false);
                } else {
                    showDialog("Permission Denied", "Help us to know your location for Address", "Settings", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", GoogleMap.this.getPackageName(), (String) null));
                            intent.addFlags(268435456);
                            GoogleMap.this.startActivity(intent);
                        }
                    }, "No, Exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            GoogleMap.this.finish();
                        }
                    }, false);
                    return;
                }
            }
        }
    }

    private AlertDialog showDialog(String title, String message, String positivelable, DialogInterface.OnClickListener positiveclick, String negativelable, DialogInterface.OnClickListener negativeclick, boolean b) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(b);
        builder.setMessage(message);
        builder.setPositiveButton(positivelable, positiveclick);
        builder.setNegativeButton(negativelable, negativeclick);
        AlertDialog alert = builder.create();
        alert.show();
        return alert;
    }

    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", this.bundle);
        setResult(-1, returnIntent);
        finish();
    }
}
