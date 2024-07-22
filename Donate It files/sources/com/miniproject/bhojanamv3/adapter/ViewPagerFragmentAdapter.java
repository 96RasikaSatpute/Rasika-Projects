package com.miniproject.bhojanamv3.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;

public class ViewPagerFragmentAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments;

    public ViewPagerFragmentAdapter(FragmentActivity fragmentActivity, ArrayList<Fragment> fragments2) {
        super(fragmentActivity);
        this.fragments = fragments2;
    }

    public Fragment createFragment(int position) {
        return this.fragments.get(position);
    }

    public int getItemCount() {
        return this.fragments.size();
    }
}
