package com.miniproject.bhojanamv3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.data.OBData;
import java.util.ArrayList;

public class OnboardingAdapter extends PagerAdapter {
    private ArrayList<OBData> itemList;

    public OnboardingAdapter(ArrayList<OBData> itemList2) {
        this.itemList = itemList2;
    }

    public int getCount() {
        return this.itemList.size();
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.layout_onboarding, container, false);
        ((TextView) view.findViewById(R.id.txtObDes)).setText(this.itemList.get(position).getDes());
        ((TextView) view.findViewById(R.id.txtObTitle)).setText(this.itemList.get(position).getTitle());
        ((ImageView) view.findViewById(R.id.imgOb)).setImageResource(this.itemList.get(position).getImage());
        container.addView(view);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
