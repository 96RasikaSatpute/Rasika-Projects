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
import com.google.firebase.database.FirebaseDatabase;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.activity.HomeActivity;
import com.miniproject.bhojanamv3.adapter.ActivityAdapter;
import com.miniproject.bhojanamv3.data.ListData;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import java.util.ArrayList;

public class ActivityOpenFragment extends Fragment implements ActivityAdapter.OnActChatClicked {
    ActivityAdapter activityAdapter;
    ArrayList<ListData> data;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    TextView txtNo;

    public ActivityOpenFragment(ArrayList<ListData> listData) {
        this.data = listData;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_open, container, false);
        this.txtNo = (TextView) view.findViewById(R.id.txtNoActivityOpen);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerActivityOpen);
        this.layoutManager = new LinearLayoutManager(getActivity());
        this.sharedPreferences = getActivity().getSharedPreferences(Constants.MY_PREF, 0);
        this.txtNo.setVisibility(8);
        this.recyclerView.setVisibility(8);
        if (this.data.isEmpty()) {
            this.txtNo.setVisibility(0);
            this.recyclerView.setVisibility(8);
        } else {
            ActivityAdapter activityAdapter2 = new ActivityAdapter(this.data, getActivity(), this, 1);
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
    }

    public void onCompleteClicked(ListData listData) {
    }

    public void onBlockClicked(final ListData listData) {
        final DialogProgress dialogProgress = new DialogProgress("One Moment, Please");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference("List/" + listData.getCategory() + "/" + listData.getUsername() + "/" + listData.getTimestamp()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    firebaseDatabase.getReference("Block/" + ActivityOpenFragment.this.sharedPreferences.getString(Constants.USERNAME, "guest")).push().setValue(listData).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                dialogProgress.dismiss();
                                HomeActivity homeActivity = (HomeActivity) ActivityOpenFragment.this.getActivity();
                                HomeActivity.bottomNavigationView.setSelectedItemId(R.id.nav_activity);
                                return;
                            }
                            dialogProgress.dismiss();
                            new ToastHelper().makeToast(ActivityOpenFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                        }
                    });
                    return;
                }
                dialogProgress.dismiss();
                new ToastHelper().makeToast(ActivityOpenFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }
}
