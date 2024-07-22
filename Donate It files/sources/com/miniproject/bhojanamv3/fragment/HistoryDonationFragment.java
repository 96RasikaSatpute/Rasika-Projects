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
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.adapter.ActivityAdapter;
import com.miniproject.bhojanamv3.data.ListData;
import com.miniproject.bhojanamv3.utils.Constants;
import java.util.ArrayList;

public class HistoryDonationFragment extends Fragment implements ActivityAdapter.OnActChatClicked {
    ActivityAdapter activityAdapter;
    ArrayList<ListData> data;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    TextView txtNo;

    public HistoryDonationFragment(ArrayList<ListData> listData) {
        this.data = listData;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_donation, container, false);
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
            ActivityAdapter activityAdapter2 = new ActivityAdapter(this.data, getActivity(), this, 3);
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

    public void onBlockClicked(ListData listData) {
    }
}
