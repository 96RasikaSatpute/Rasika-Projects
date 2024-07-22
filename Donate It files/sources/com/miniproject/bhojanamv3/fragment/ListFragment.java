package com.miniproject.bhojanamv3.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.chip.Chip;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.Constants;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.activity.HomeActivity;
import com.miniproject.bhojanamv3.data.CategoryData;
import com.miniproject.bhojanamv3.data.ListData;
import com.miniproject.bhojanamv3.data.MatchData;
import com.miniproject.bhojanamv3.data.SubCategoryData;
import com.miniproject.bhojanamv3.data.UserData;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import com.miniproject.bhojanamv3.network.APIClient;
import com.miniproject.bhojanamv3.network.Api;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.GoogleMap;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.cache.DiskLruCache;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {
    CheckBox cbLocation;
    CardView cvSubmit;
    EditText etDescription;
    EditText etDistance;
    EditText etSubSkill;
    FlexboxLayout flList;
    boolean isLocationRequired = false;
    boolean isLocationSelected = false;
    double latitude = 0.0d;
    double longitude = 0.0d;
    SharedPreferences sharedPreferences;
    Spinner spnSkill;
    ArrayList<CategoryData> spnSkillList = new ArrayList<>();
    ArrayList<String> spnSkillListName = new ArrayList<>();
    ArrayList<SubCategoryData> subSkills = new ArrayList<>();
    ScrollView svList;
    TextView txtLocation;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        this.etSubSkill = (EditText) view.findViewById(R.id.etListSubSkill);
        this.etDescription = (EditText) view.findViewById(R.id.etListDescription);
        this.txtLocation = (TextView) view.findViewById(R.id.txtListLocation);
        this.cbLocation = (CheckBox) view.findViewById(R.id.cbListLocation);
        this.spnSkill = (Spinner) view.findViewById(R.id.spnListSkill);
        this.flList = (FlexboxLayout) view.findViewById(R.id.flList);
        this.svList = (ScrollView) view.findViewById(R.id.svList);
        this.cvSubmit = (CardView) view.findViewById(R.id.btnListSubmit);
        this.etDistance = (EditText) view.findViewById(R.id.etListDistance);
        this.sharedPreferences = getActivity().getSharedPreferences(Constants.MY_PREF, 0);
        this.txtLocation.setVisibility(8);
        this.etDistance.setVisibility(8);
        this.svList.setVisibility(8);
        this.spnSkillListName.add("Select Category");
        this.cbLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ListFragment.this.clearFocus();
                ListFragment.this.isLocationRequired = b;
                if (ListFragment.this.isLocationRequired) {
                    ListFragment.this.txtLocation.setVisibility(0);
                    ListFragment.this.etDistance.setVisibility(0);
                    return;
                }
                ListFragment.this.etDistance.setVisibility(8);
                ListFragment.this.txtLocation.setVisibility(8);
            }
        });
        this.etSubSkill.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().endsWith(" ")) {
                    ListFragment.this.addNewChip(charSequence.toString().trim(), ListFragment.this.flList, new SubCategoryData(charSequence.toString().trim()));
                }
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.spnSkill.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ListFragment.this.clearFocus();
                if (ListFragment.this.spnSkill.getSelectedItemPosition() == 0) {
                    ((TextView) view).setTextColor(ListFragment.this.getResources().getColor(R.color.hint, ListFragment.this.getActivity().getTheme()));
                } else {
                    ((TextView) view).setTextColor(ListFragment.this.getResources().getColor(R.color.black_02, ListFragment.this.getActivity().getTheme()));
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.txtLocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListFragment.this.clearFocus();
                ListFragment.this.startActivityForResult(new Intent(ListFragment.this.getActivity(), GoogleMap.class), 101);
            }
        });
        this.cvSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String distance;
                ListFragment.this.clearFocus();
                String description = ListFragment.this.etDescription.getText().toString().trim();
                String distance2 = ListFragment.this.etDistance.getText().toString().trim();
                if (ListFragment.this.spnSkill.getSelectedItemPosition() == 0) {
                    new ToastHelper().makeErrorToast(ListFragment.this.getActivity(), "Select skill!", 1, ListFragment.this.spnSkill);
                } else if (ListFragment.this.subSkills.isEmpty()) {
                    new ToastHelper().makeErrorToast(ListFragment.this.getActivity(), "Enter sub skills!", 1, ListFragment.this.flList);
                } else if (description.isEmpty()) {
                    new ToastHelper().makeErrorToast(ListFragment.this.getActivity(), "Enter description!", 1, ListFragment.this.etDescription);
                } else if (!ListFragment.this.isLocationRequired || (ListFragment.this.isLocationSelected && !distance2.isEmpty() && !distance2.equals("0"))) {
                    final DialogProgress dialogProgress = new DialogProgress("Listing your donation");
                    dialogProgress.setCancelable(false);
                    dialogProgress.show(ListFragment.this.getActivity().getSupportFragmentManager(), "Dialog Progress");
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    if (!ListFragment.this.isLocationSelected) {
                        ListFragment listFragment = ListFragment.this;
                        listFragment.latitude = Double.parseDouble(listFragment.sharedPreferences.getString(Constants.LATITUDE, "0.0"));
                        ListFragment listFragment2 = ListFragment.this;
                        listFragment2.longitude = Double.parseDouble(listFragment2.sharedPreferences.getString(Constants.LONGITUDE, "0.0"));
                        distance = "0";
                    } else {
                        distance = distance2;
                    }
                    DatabaseReference databaseReference = firebaseDatabase.getReference("List/" + ListFragment.this.spnSkill.getSelectedItem().toString().trim() + "/" + ListFragment.this.sharedPreferences.getString(Constants.USERNAME, "guest"));
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String timeStamp = simpleDateFormat.format(calendar.getTime());
                    String string = ListFragment.this.sharedPreferences.getString(Constants.USERNAME, "guest");
                    String string2 = ListFragment.this.sharedPreferences.getString(Constants.MOBILE, "guest");
                    String string3 = ListFragment.this.sharedPreferences.getString(Constants.IMAGE_LINK, "NO_IMAGE");
                    String trim = ListFragment.this.spnSkill.getSelectedItem().toString().trim();
                    String timeStamp2 = timeStamp;
                    String valueOf = String.valueOf(ListFragment.this.latitude);
                    String valueOf2 = String.valueOf(ListFragment.this.longitude);
                    String timeStamp3 = timeStamp2;
                    SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                    String str = description;
                    FirebaseDatabase firebaseDatabase2 = firebaseDatabase;
                    ArrayList<SubCategoryData> arrayList = ListFragment.this.subSkills;
                    String str2 = Constants.USERNAME;
                    final ListData listData = new ListData(string, string2, string3, description, trim, valueOf, valueOf2, timeStamp3, distance, arrayList, "0");
                    String timeStamp4 = timeStamp3;
                    databaseReference.child(timeStamp4).setValue(listData).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                dialogProgress.dismiss();
                                new ToastHelper().makeToast(ListFragment.this.getActivity(), "Request Submitted!", 1);
                                HomeActivity homeActivity = (HomeActivity) ListFragment.this.getActivity();
                                HomeActivity.bottomNavigationView.setSelectedItemId(R.id.nav_list);
                                new FindListMatch().execute(new ListData[]{listData});
                                return;
                            }
                            dialogProgress.dismiss();
                            new ToastHelper().makeToast(ListFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                        }
                    });
                    FirebaseDatabase firebaseDatabase3 = firebaseDatabase2;
                    firebaseDatabase3.getReference("ListOpen/" + ListFragment.this.sharedPreferences.getString(str2, "guest")).child(timeStamp4).setValue(listData);
                    String str3 = distance;
                    return;
                } else {
                    if (!ListFragment.this.isLocationSelected) {
                        new ToastHelper().makeErrorToast(ListFragment.this.getActivity(), "Select location!", 1, ListFragment.this.txtLocation);
                    }
                    if (distance2.isEmpty()) {
                        new ToastHelper().makeErrorToastForEditText(ListFragment.this.getActivity(), "Enter distance!", "Enter distance in km", 1, ListFragment.this.etDistance);
                    } else if (distance2.equals("0")) {
                        new ToastHelper().makeErrorToastForEditText(ListFragment.this.getActivity(), "Enter distance!", "Distance cannot be 0", 1, ListFragment.this.etDistance);
                    }
                }
                String str4 = description;
            }
        });
        getSkillData();
        return view;
    }

    private void getSkillData() {
        final DialogProgress dialogProgress = new DialogProgress("One Moment, Please");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        FirebaseDatabase.getInstance().getReference("Users/" + this.sharedPreferences.getString(Constants.USERNAME, "guest") + "/skillData").addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CategoryData skillData = (CategoryData) dataSnapshot.getValue(CategoryData.class);
                    ListFragment.this.spnSkillList.add(skillData);
                    ListFragment.this.spnSkillListName.add(skillData.getCategory_name());
                }
                ListFragment.this.spnSkill.setAdapter(new ArrayAdapter(ListFragment.this.getActivity(), R.layout.custom_spinner, ListFragment.this.spnSkillListName));
                ListFragment.this.svList.setVisibility(0);
                dialogProgress.dismiss();
            }

            public void onCancelled(DatabaseError error) {
                dialogProgress.dismiss();
                new ToastHelper().makeToast(ListFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            this.isLocationSelected = true;
            this.latitude = Double.parseDouble(data.getBundleExtra("result").getString("lat"));
            this.longitude = Double.parseDouble(data.getBundleExtra("result").getString("long"));
            if (data.getBundleExtra("result") != null) {
                this.txtLocation.setText(data.getBundleExtra("result").getString("area"));
            }
            this.txtLocation.setTextColor(getResources().getColor(R.color.black_02));
        }
    }

    /* access modifiers changed from: private */
    public void addNewChip(String value, final FlexboxLayout chipGroup, final SubCategoryData subSkillData) {
        final Chip chip = new Chip(getActivity());
        chip.setText(value);
        chip.setCheckable(false);
        chip.setClickable(true);
        chip.setCloseIconEnabled(true);
        FlexboxLayout.LayoutParams params = new FlexboxLayout.LayoutParams(-2, -2);
        params.setMargins(5, 0, 5, 0);
        chip.setLayoutParams(params);
        chipGroup.addView(chip, chipGroup.getChildCount() - 1);
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListFragment.this.clearFocus();
                chipGroup.removeView(chip);
                ListFragment.this.subSkills.remove(subSkillData);
            }
        });
        this.subSkills.add(subSkillData);
        this.etSubSkill.setText((CharSequence) null);
    }

    /* access modifiers changed from: private */
    public void clearFocus() {
        this.etSubSkill.clearFocus();
        this.etDistance.clearFocus();
        this.etDescription.clearFocus();
    }

    public static class FindListMatch extends AsyncTask<ListData, ListData, ListData> {
        /* access modifiers changed from: protected */
        public ListData doInBackground(ListData... listData) {
            final ListData data = listData[0];
            FirebaseDatabase.getInstance().getReference("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                public void onDataChange(DataSnapshot snapshot) {
                    Iterator<DataSnapshot> it;
                    String type;
                    Iterator<DataSnapshot> it2 = snapshot.getChildren().iterator();
                    while (it2.hasNext()) {
                        DataSnapshot dataSnapshot = it2.next();
                        UserData userData = (UserData) dataSnapshot.getValue(UserData.class);
                        if (!data.getUsername().equals(userData.getUsername())) {
                            if (data.getDistance().equals("0")) {
                                type = DiskLruCache.VERSION_1;
                            } else {
                                type = ExifInterface.GPS_MEASUREMENT_2D;
                            }
                            boolean isSkillFound = false;
                            Iterator<Map.Entry<String, CategoryData>> it3 = userData.getSkillData().entrySet().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (it3.next().getValue().getCategory_name().equals(data.getCategory())) {
                                        isSkillFound = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (isSkillFound) {
                                double lat1 = Double.parseDouble(data.getLatitude());
                                double lon1 = Double.parseDouble(data.getLongitude());
                                double lat2 = Double.parseDouble(userData.getLatitude());
                                double dist = 60.0d * ((180.0d * Math.acos((Math.sin((lat1 * 3.141592653589793d) / 180.0d) * Math.sin((lat2 * 3.141592653589793d) / 180.0d)) + ((Math.cos((lat1 * 3.141592653589793d) / 180.0d) * Math.cos((lat2 * 3.141592653589793d) / 180.0d)) * Math.cos(((lon1 - Double.parseDouble(userData.getLongitude())) * 3.141592653589793d) / 180.0d)))) / 3.141592653589793d) * 1.1515d * 1.609344d;
                                it = it2;
                                DataSnapshot dataSnapshot2 = dataSnapshot;
                                if (!type.equals(DiskLruCache.VERSION_1)) {
                                    double seekDistance = Double.parseDouble(data.getDistance());
                                    if (dist <= seekDistance) {
                                        double d = seekDistance;
                                        new SendListNotification().execute(new MatchData[]{new MatchData(userData.getUsername(), userData.getMobile(), userData.getImage_link(), userData.getLatitude(), userData.getLongitude(), data.getTimestamp())});
                                    }
                                } else if (dist <= Double.parseDouble(userData.getDistance())) {
                                    MatchData matchData = new MatchData(userData.getUsername(), userData.getMobile(), userData.getImage_link(), userData.getLatitude(), userData.getLongitude(), data.getTimestamp());
                                    String str = type;
                                    new SendListNotification().execute(new MatchData[]{matchData});
                                }
                            } else {
                                it = it2;
                                DataSnapshot dataSnapshot3 = dataSnapshot;
                                String str2 = type;
                            }
                        } else {
                            it = it2;
                            DataSnapshot dataSnapshot4 = dataSnapshot;
                        }
                        it2 = it;
                    }
                }

                public void onCancelled(DatabaseError error) {
                }
            });
            return null;
        }
    }

    public static class SendListNotification extends AsyncTask<MatchData, MatchData, MatchData> {
        /* access modifiers changed from: protected */
        public MatchData doInBackground(MatchData... matchData) {
            MatchData data = matchData[0];
            Log.d("hello", "Notification Data : " + data.getUsername());
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("to", "/topics/" + data.getUsername());
                JSONObject notificationBody = new JSONObject();
                notificationBody.put("title", "Donation Update!");
                notificationBody.put("body", "Hola, we have found a new donation that matches your interest. Please check activity section for more details.");
                jsonObject.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, notificationBody);
                ((Api) APIClient.getClient().create(Api.class)).sendNotification("key=AAAAfmKzY5M:APA91bFlHROn_ZCr5jl09EGW57MNnfmgkM90QQTGtCOS7KkHUR3C3brp-9roKtwpbZGjWFYu2KNQpimOdVeQh-ZKXBSJyaRy6NA9CYpY0FaDuMPTGR2jM0krn2C9gQaw1eQIspAaZuV8", RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString())).enqueue(new Callback<ResponseBody>() {
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("hello", "Res : " + response.code() + " " + response.message());
                    }

                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("hello", "Res Failed : " + t.getMessage());
                    }
                });
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
