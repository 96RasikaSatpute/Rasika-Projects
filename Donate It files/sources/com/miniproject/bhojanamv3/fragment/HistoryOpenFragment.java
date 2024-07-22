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
import java.util.Iterator;

public class HistoryOpenFragment extends Fragment implements ActivityAdapter.OnActChatClicked {
    ActivityAdapter activityAdapter;
    ArrayList<ListData> data;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    TextView txtNo;

    public HistoryOpenFragment(ArrayList<ListData> listData) {
        this.data = listData;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_open, container, false);
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
            ActivityAdapter activityAdapter2 = new ActivityAdapter(this.data, getActivity(), this, 4);
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

    public void onCancelClicked(final ListData listData) {
        final DialogProgress dialogProgress = new DialogProgress("One Moment, Please");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference("ListOpen/" + this.sharedPreferences.getString(Constants.USERNAME, "guest") + "/" + listData.getTimestamp()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    firebaseDatabase.getReference("History/" + HistoryOpenFragment.this.sharedPreferences.getString(Constants.USERNAME, "guest") + "/" + listData.getTimestamp()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                firebaseDatabase.getReference("List/" + listData.getCategory() + "/" + listData.getUsername() + "/" + listData.getTimestamp()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    public void onComplete(Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            firebaseDatabase.getReference("Block").addListenerForSingleValueEvent(new ValueEventListener() {
                                                public void onDataChange(DataSnapshot snapshot) {
                                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                                        Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                break;
                                                            }
                                                            DataSnapshot dataFinal = it.next();
                                                            ListData listDataCheck = (ListData) dataFinal.getValue(ListData.class);
                                                            if (listDataCheck.getUsername().equals(listData.getUsername()) && listDataCheck.getTimestamp().equals(listData.getTimestamp())) {
                                                                dataFinal.getRef().removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    public void onComplete(Task<Void> task) {
                                                                        if (task.isSuccessful()) {
                                                                            dialogProgress.dismiss();
                                                                            HomeActivity homeActivity = (HomeActivity) HistoryOpenFragment.this.getActivity();
                                                                            HomeActivity.bottomNavigationView.setSelectedItemId(R.id.nav_chat);
                                                                            return;
                                                                        }
                                                                        dialogProgress.dismiss();
                                                                        new ToastHelper().makeToast(HistoryOpenFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                                                                    }
                                                                });
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }

                                                public void onCancelled(DatabaseError error) {
                                                    dialogProgress.dismiss();
                                                    new ToastHelper().makeToast(HistoryOpenFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                                                }
                                            });
                                            return;
                                        }
                                        dialogProgress.dismiss();
                                        new ToastHelper().makeToast(HistoryOpenFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                                    }
                                });
                                return;
                            }
                            dialogProgress.dismiss();
                            new ToastHelper().makeToast(HistoryOpenFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                        }
                    });
                    return;
                }
                dialogProgress.dismiss();
                new ToastHelper().makeToast(HistoryOpenFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }

    public void onCompleteClicked(ListData listData) {
    }

    public void onBlockClicked(ListData listData) {
    }
}
