package com.miniproject.bhojanamv3.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.activity.HomeActivity;
import com.miniproject.bhojanamv3.activity.LoginActivity;
import com.miniproject.bhojanamv3.adapter.CategoryAdapter;
import com.miniproject.bhojanamv3.data.CategoryData;
import com.miniproject.bhojanamv3.data.UserData;
import com.miniproject.bhojanamv3.dialog.DialogCategory;
import com.miniproject.bhojanamv3.dialog.DialogEditDistance;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.GoogleMap;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ProfileFragment extends Fragment implements CategoryAdapter.OnCategorySelected, DialogEditDistance.OnEditDistance {
    ArrayList<CategoryData> data = new ArrayList<>();
    GridLayoutManager gridLayoutManager;
    ImageView imgLogout;
    ImageView imgProfile;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    CategoryAdapter skillAdapter;
    TextView txtAddSkill;
    TextView txtAddress;
    TextView txtDistance;
    TextView txtEditAddress;
    TextView txtName;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        this.sharedPreferences = getActivity().getSharedPreferences(Constants.MY_PREF, 0);
        this.txtName = (TextView) view.findViewById(R.id.txtProfileUsername);
        this.imgProfile = (ImageView) view.findViewById(R.id.imgProfile);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerProfileSkill);
        this.txtAddSkill = (TextView) view.findViewById(R.id.txtProfileAddSkill);
        this.imgLogout = (ImageView) view.findViewById(R.id.imgProfileLogout);
        this.txtEditAddress = (TextView) view.findViewById(R.id.txtProfileEditAddress);
        this.txtAddress = (TextView) view.findViewById(R.id.txtProfileAddress);
        this.txtDistance = (TextView) view.findViewById(R.id.txtProfileDistance);
        this.gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        this.txtDistance.setText("PICKUP DISTANCE - " + this.sharedPreferences.getString(Constants.DISTANCE, "NA") + "KM");
        this.txtAddress.setText(this.sharedPreferences.getString(Constants.ADDRESS, "--"));
        this.txtName.setText("HELLO " + this.sharedPreferences.getString(Constants.USERNAME, "") + "!");
        Picasso.get().load(this.sharedPreferences.getString(Constants.IMAGE_LINK, "no_image")).error((int) R.drawable.ic_person).into(this.imgProfile);
        this.txtEditAddress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProfileFragment.this.startActivityForResult(new Intent(ProfileFragment.this.getActivity(), GoogleMap.class), 101);
            }
        });
        this.txtDistance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new DialogEditDistance(ProfileFragment.this).show(ProfileFragment.this.getActivity().getSupportFragmentManager(), "Dialog Distance");
            }
        });
        final DialogProgress dialogProgress = new DialogProgress("One Moment, Please");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        FirebaseDatabase.getInstance().getReference("Users/" + this.sharedPreferences.getString(Constants.USERNAME, "guest") + "/skillData").addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CategoryData skillData = (CategoryData) dataSnapshot.getValue(CategoryData.class);
                    skillData.setCategorySelected(false);
                    ProfileFragment.this.data.add(skillData);
                }
                ProfileFragment.this.skillAdapter = new CategoryAdapter(ProfileFragment.this.data, ProfileFragment.this.getContext(), ProfileFragment.this, 2);
                ProfileFragment.this.recyclerView.setAdapter(ProfileFragment.this.skillAdapter);
                ProfileFragment.this.recyclerView.setLayoutManager(ProfileFragment.this.gridLayoutManager);
                dialogProgress.dismiss();
            }

            public void onCancelled(DatabaseError error) {
                dialogProgress.dismiss();
                new ToastHelper().makeToast(ProfileFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
        this.txtAddSkill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new DialogCategory().show(ProfileFragment.this.getActivity().getSupportFragmentManager(), "Dialog Skill");
            }
        });
        this.imgLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FirebaseMessaging.getInstance().unsubscribeFromTopic(ProfileFragment.this.sharedPreferences.getString(Constants.USERNAME, "guest")).addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(Task<Void> task) {
                    }
                });
                ProfileFragment.this.sharedPreferences.edit().clear().apply();
                ProfileFragment.this.sharedPreferences.edit().putBoolean(Constants.SHOW_ONBOARDING, false).apply();
                ProfileFragment.this.startActivity(new Intent(ProfileFragment.this.getActivity(), LoginActivity.class));
                ProfileFragment.this.getActivity().overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                ProfileFragment.this.getActivity().finish();
            }
        });
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        Intent intent = data2;
        super.onActivityResult(requestCode, resultCode, data2);
        if (requestCode != 101) {
            int i = resultCode;
        } else if (resultCode == -1) {
            double latitude = Double.parseDouble(intent.getBundleExtra("result").getString("lat"));
            double longitude = Double.parseDouble(intent.getBundleExtra("result").getString("long"));
            final DialogProgress dialogProgress = new DialogProgress("Updating address");
            dialogProgress.setCancelable(false);
            dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            final double d = latitude;
            DatabaseReference databaseReference = firebaseDatabase.getReference("Users/" + this.sharedPreferences.getString(Constants.USERNAME, "guest"));
            AnonymousClass6 r9 = r0;
            final double d2 = longitude;
            final Intent intent2 = data2;
            FirebaseDatabase firebaseDatabase2 = firebaseDatabase;
            final DatabaseReference databaseReference2 = databaseReference;
            DialogProgress dialogProgress2 = dialogProgress;
            AnonymousClass6 r0 = new ValueEventListener() {
                public void onDataChange(DataSnapshot snapshot) {
                    UserData userData = (UserData) snapshot.getValue(UserData.class);
                    userData.setLatitude(String.valueOf(d));
                    userData.setLongitude(String.valueOf(d2));
                    userData.setAddress(intent2.getBundleExtra("result").getString("area"));
                    databaseReference2.setValue(userData).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                dialogProgress.dismiss();
                                if (intent2.getBundleExtra("result") != null) {
                                    ProfileFragment.this.txtAddress.setText(intent2.getBundleExtra("result").getString("area"));
                                }
                                ProfileFragment.this.sharedPreferences.edit().putString(Constants.ADDRESS, intent2.getBundleExtra("result").getString("area")).apply();
                                ProfileFragment.this.sharedPreferences.edit().putString(Constants.LATITUDE, String.valueOf(d)).apply();
                                ProfileFragment.this.sharedPreferences.edit().putString(Constants.LONGITUDE, String.valueOf(d2)).apply();
                                new ToastHelper().makeToast(ProfileFragment.this.getActivity(), "Address updated.", 1);
                                return;
                            }
                            dialogProgress.dismiss();
                            new ToastHelper().makeToast(ProfileFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                        }
                    });
                }

                public void onCancelled(DatabaseError error) {
                    dialogProgress.dismiss();
                    new ToastHelper().makeToast(ProfileFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                }
            };
            databaseReference.addListenerForSingleValueEvent(r9);
        }
    }

    public void onCategorySelected(CategoryData categoryData) {
    }

    public void onCategoryDelete(CategoryData categoryData) {
        if (this.data.size() > 1) {
            final DialogProgress dialogProgress = new DialogProgress("Removing skill");
            dialogProgress.setCancelable(false);
            dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
            FirebaseDatabase.getInstance().getReference("Users/" + this.sharedPreferences.getString(Constants.USERNAME, "guest") + "/skillData/" + categoryData.getCategory_name()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        dialogProgress.dismiss();
                        HomeActivity homeActivity = (HomeActivity) ProfileFragment.this.getActivity();
                        HomeActivity.bottomNavigationView.setSelectedItemId(R.id.nav_profile);
                        return;
                    }
                    dialogProgress.dismiss();
                    new ToastHelper().makeToast(ProfileFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                }
            });
            return;
        }
        new ToastHelper().makeErrorToast(getActivity(), "At-least one skill needed!", 1, this.recyclerView);
    }

    public void onDistanceEdited(final String distance) {
        final DialogProgress dialogProgress = new DialogProgress("Updating distance");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users/" + this.sharedPreferences.getString(Constants.USERNAME, "guest"));
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                UserData userData = (UserData) snapshot.getValue(UserData.class);
                userData.setDistance(distance);
                databaseReference.setValue(userData).addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()) {
                            dialogProgress.dismiss();
                            ProfileFragment.this.sharedPreferences.edit().putString(Constants.DISTANCE, distance).apply();
                            new ToastHelper().makeToast(ProfileFragment.this.getActivity(), "Distance updated.", 1);
                            ProfileFragment.this.txtDistance.setText("PICKUP DISTANCE - " + ProfileFragment.this.sharedPreferences.getString(Constants.DISTANCE, "NA") + "KM");
                            return;
                        }
                        dialogProgress.dismiss();
                        new ToastHelper().makeToast(ProfileFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                    }
                });
            }

            public void onCancelled(DatabaseError error) {
                dialogProgress.dismiss();
                new ToastHelper().makeToast(ProfileFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }
}
