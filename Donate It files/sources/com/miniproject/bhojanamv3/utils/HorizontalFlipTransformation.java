package com.miniproject.bhojanamv3.utils;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

public class HorizontalFlipTransformation implements ViewPager2.PageTransformer {
    public void transformPage(View page, float position) {
        page.setTranslationX((-position) * ((float) page.getWidth()));
        page.setCameraDistance(12000.0f);
        if (((double) position) >= 0.5d || ((double) position) <= -0.5d) {
            page.setVisibility(4);
        } else {
            page.setVisibility(0);
        }
        if (position < -1.0f) {
            page.setAlpha(0.0f);
        } else if (position <= 0.0f) {
            page.setAlpha(1.0f);
            page.setRotationY(((1.0f - Math.abs(position)) + 1.0f) * 180.0f);
        } else if (position <= 1.0f) {
            page.setAlpha(1.0f);
            page.setRotationY(((1.0f - Math.abs(position)) + 1.0f) * -180.0f);
        } else {
            page.setAlpha(0.0f);
        }
    }
}
