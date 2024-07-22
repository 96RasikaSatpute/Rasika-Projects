package com.miniproject.bhojanamv3.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.adapter.ViewPagerFragmentAdapter;
import com.miniproject.bhojanamv3.data.CategoryData;
import com.miniproject.bhojanamv3.data.ListData;
import com.miniproject.bhojanamv3.data.UserData;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import com.miniproject.bhojanamv3.fragment.ActivityFragment;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.HorizontalFlipTransformation;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ActivityFragment extends Fragment {
    ArrayList<ListData> data = new ArrayList<>();
    ArrayList<ListData> dataClosed = new ArrayList<>();
    ArrayList<ListData> dataOpen = new ArrayList<>();
    DialogProgress dialogProgress;
    ArrayList<Fragment> fragments = new ArrayList<>();
    SharedPreferences sharedPreferences;
    TabLayout tableLayout;
    /* access modifiers changed from: private */
    public String[] titles = {"OPEN", "BLOCKED"};
    ViewPager2 viewPager2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, container, false);
        this.tableLayout = (TabLayout) view.findViewById(R.id.tlActivity);
        this.viewPager2 = (ViewPager2) view.findViewById(R.id.vpActivity);
        this.sharedPreferences = getActivity().getSharedPreferences(Constants.MY_PREF, 0);
        this.viewPager2.setPageTransformer(new HorizontalFlipTransformation());
        DialogProgress dialogProgress2 = new DialogProgress("One Moment, Please");
        this.dialogProgress = dialogProgress2;
        dialogProgress2.setCancelable(false);
        this.dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        getData();
        return view;
    }

    private void getData() {
        FirebaseDatabase.getInstance().getReference("Users/" + this.sharedPreferences.getString(Constants.USERNAME, "guest")).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                ArrayList<String> ref = new ArrayList<>();
                for (Map.Entry<String, CategoryData> entry : ((UserData) snapshot.getValue(UserData.class)).getSkillData().entrySet()) {
                    ref.add(entry.getValue().getCategory_name());
                }
                Log.d("hello", "Ref Data : " + ref.toString());
                ActivityFragment.this.getList(ref, 0);
            }

            public void onCancelled(DatabaseError error) {
                ActivityFragment.this.dialogProgress.dismiss();
                new ToastHelper().makeToast(ActivityFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getList(ArrayList<String> ref, int size) {
        double seekDistance;
        final int i = size;
        if (i < ref.size()) {
            final ArrayList<String> arrayList = ref;
            FirebaseDatabase.getInstance().getReference("List/" + ref.get(size)).addListenerForSingleValueEvent(new ValueEventListener() {
                public void onDataChange(DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        for (DataSnapshot finalData : dataSnapshot.getChildren()) {
                            ActivityFragment.this.data.add((ListData) finalData.getValue(ListData.class));
                        }
                    }
                    ActivityFragment.this.getList(arrayList, i + 1);
                }

                public void onCancelled(DatabaseError error) {
                    ActivityFragment.this.dialogProgress.dismiss();
                    new ToastHelper().makeToast(ActivityFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                }
            });
            return;
        }
        ArrayList<String> arrayList2 = ref;
        Iterator<ListData> it = this.data.iterator();
        while (it.hasNext()) {
            ListData listData = it.next();
            double lat1 = Double.parseDouble(listData.getLatitude());
            double lon1 = Double.parseDouble(listData.getLongitude());
            double lat2 = Double.parseDouble(this.sharedPreferences.getString(Constants.LATITUDE, "0.0"));
            double lon2 = Double.parseDouble(this.sharedPreferences.getString(Constants.LONGITUDE, "0.0"));
            double theta = lon1 - lon2;
            Iterator<ListData> it2 = it;
            double dist = 60.0d * ((180.0d * Math.acos((Math.sin((lat1 * 3.141592653589793d) / 180.0d) * Math.sin((lat2 * 3.141592653589793d) / 180.0d)) + ((Math.cos((lat1 * 3.141592653589793d) / 180.0d) * Math.cos((lat2 * 3.141592653589793d) / 180.0d)) * Math.cos((theta * 3.141592653589793d) / 180.0d)))) / 3.141592653589793d) * 1.1515d * 1.609344d;
            double d = theta;
            double d2 = lat1;
            Log.d("hello", "Distance Data : " + lat1 + " " + lat2 + " " + lon1 + " " + lon2);
            if (listData.getStatus().equals("0")) {
                double d3 = lon1;
                if (!listData.getUsername().equals(this.sharedPreferences.getString(Constants.USERNAME, "guest"))) {
                    if (listData.getDistance().equals("0")) {
                        seekDistance = Double.parseDouble(this.sharedPreferences.getString(Constants.DISTANCE, "0"));
                    } else {
                        seekDistance = Double.parseDouble(listData.getDistance());
                    }
                    Log.d("hello", "Distance : " + dist + " " + seekDistance);
                    if (dist <= seekDistance) {
                        this.dataOpen.add(listData);
                    }
                }
            }
            ArrayList<String> arrayList3 = ref;
            int i2 = size;
            it = it2;
        }
        FirebaseDatabase.getInstance().getReference("Block/" + this.sharedPreferences.getString(Constants.USERNAME, "guest")).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ActivityFragment.this.dataClosed.add((ListData) dataSnapshot.getValue(ListData.class));
                }
                ActivityFragment.this.fragments.add(new ActivityOpenFragment(ActivityFragment.this.dataOpen));
                ActivityFragment.this.fragments.add(new ActivityClosedFragment(ActivityFragment.this.dataClosed));
                ActivityFragment.this.viewPager2.setAdapter(new ViewPagerFragmentAdapter(ActivityFragment.this.getActivity(), ActivityFragment.this.fragments));
                new TabLayoutMediator(ActivityFragment.this.tableLayout, ActivityFragment.this.viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
                    public final void onConfigureTab(TabLayout.Tab tab, int i) {
                        ActivityFragment.AnonymousClass3.this.lambda$onDataChange$0$ActivityFragment$3(tab, i);
                    }
                }).attach();
                ActivityFragment.this.dialogProgress.dismiss();
            }

            public /* synthetic */ void lambda$onDataChange$0$ActivityFragment$3(TabLayout.Tab tab, int position) {
                tab.setText((CharSequence) ActivityFragment.this.titles[position]);
            }

            public void onCancelled(DatabaseError error) {
                ActivityFragment.this.dialogProgress.dismiss();
                new ToastHelper().makeToast(ActivityFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }
}
