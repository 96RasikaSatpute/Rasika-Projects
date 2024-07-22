package com.miniproject.bhojanamv3.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.activity.HomeActivity;
import com.miniproject.bhojanamv3.adapter.ActivityAdapter;
import com.miniproject.bhojanamv3.data.ListData;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import java.util.ArrayList;

public class ActivityClosedFragment extends Fragment implements ActivityAdapter.OnActChatClicked {
    ActivityAdapter activityAdapter;
    ArrayList<ListData> data;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    TextView txtNo;

    public ActivityClosedFragment(ArrayList<ListData> listData) {
        this.data = listData;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_closed, container, false);
        this.txtNo = (TextView) view.findViewById(R.id.txtNoActivityClosed);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerActivityClosed);
        this.layoutManager = new LinearLayoutManager(getActivity());
        this.sharedPreferences = getActivity().getSharedPreferences(Constants.MY_PREF, 0);
        this.txtNo.setVisibility(8);
        this.recyclerView.setVisibility(8);
        if (this.data.isEmpty()) {
            this.txtNo.setVisibility(0);
            this.recyclerView.setVisibility(8);
        } else {
            ActivityAdapter activityAdapter2 = new ActivityAdapter(this.data, getActivity(), this, 2);
            this.activityAdapter = activityAdapter2;
            this.recyclerView.setAdapter(activityAdapter2);
            this.recyclerView.setLayoutManager(this.layoutManager);
            this.txtNo.setVisibility(8);
            this.recyclerView.setVisibility(0);
        }
        return view;
    }

    public void onChatClicked(ListData activityData) {
    }

    public void onCancelClicked(ListData listData) {
        DialogProgress dialogProgress = new DialogProgress("One Moment, Please");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        int index = this.data.indexOf(listData);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final int i = index;
        final FirebaseDatabase firebaseDatabase2 = firebaseDatabase;
        final ListData listData2 = listData;
        final DialogProgress dialogProgress2 = dialogProgress;
        firebaseDatabase.getReference("Block/" + this.sharedPreferences.getString(Constants.USERNAME, "guest")).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                for (int i = 0; ((long) i) < snapshot.getChildrenCount(); i++) {
                    if (i == i) {
                        snapshot.getRef().removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(Task<Void> task) {
                                if (task.isSuccessful()) {
                                    firebaseDatabase2.getReference("List/" + listData2.getCategory() + "/" + listData2.getUsername() + "/" + listData2.getTimestamp()).setValue(listData2).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        public void onComplete(Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                dialogProgress2.dismiss();
                                                HomeActivity homeActivity = (HomeActivity) ActivityClosedFragment.this.getActivity();
                                                HomeActivity.bottomNavigationView.setSelectedItemId(R.id.nav_activity);
                                                return;
                                            }
                                            dialogProgress2.dismiss();
                                            new ToastHelper().makeToast(ActivityClosedFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                                        }
                                    });
                                    return;
                                }
                                dialogProgress2.dismiss();
                                new ToastHelper().makeToast(ActivityClosedFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                            }
                        });
                        return;
                    }
                }
            }

            public void onCancelled(DatabaseError error) {
                dialogProgress2.dismiss();
                new ToastHelper().makeToast(ActivityClosedFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }

    public void onCompleteClicked(ListData listData) {
        DialogProgress dialogProgress = new DialogProgress("One Moment, Please");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        int index = this.data.indexOf(listData);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final int i = index;
        final FirebaseDatabase firebaseDatabase2 = firebaseDatabase;
        final ListData listData2 = listData;
        final DialogProgress dialogProgress2 = dialogProgress;
        firebaseDatabase.getReference("Block/" + this.sharedPreferences.getString(Constants.USERNAME, "guest")).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                for (int i = 0; ((long) i) < snapshot.getChildrenCount(); i++) {
                    if (i == i) {
                        snapshot.getRef().removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(Task<Void> task) {
                                if (task.isSuccessful()) {
                                    DatabaseReference databaseReference = firebaseDatabase2.getReference("History/" + listData2.getUsername());
                                    firebaseDatabase2.getReference("ListOpen/" + listData2.getUsername() + "/" + listData2.getTimestamp()).removeValue();
                                    databaseReference.push().setValue(listData2).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        public void onComplete(Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                dialogProgress2.dismiss();
                                                HomeActivity homeActivity = (HomeActivity) ActivityClosedFragment.this.getActivity();
                                                HomeActivity.bottomNavigationView.setSelectedItemId(R.id.nav_activity);
                                                return;
                                            }
                                            dialogProgress2.dismiss();
                                            new ToastHelper().makeToast(ActivityClosedFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                                        }
                                    });
                                    return;
                                }
                                dialogProgress2.dismiss();
                                new ToastHelper().makeToast(ActivityClosedFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                            }
                        });
                        return;
                    }
                }
            }

            public void onCancelled(DatabaseError error) {
                dialogProgress2.dismiss();
                new ToastHelper().makeToast(ActivityClosedFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }

    public void onBlockClicked(ListData listData) {
    }
}
