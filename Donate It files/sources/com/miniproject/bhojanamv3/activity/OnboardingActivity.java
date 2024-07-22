package com.miniproject.bhojanamv3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.adapter.OnboardingAdapter;
import com.miniproject.bhojanamv3.data.OBData;
import com.miniproject.bhojanamv3.utils.Constants;
import java.util.ArrayList;

public class OnboardingActivity extends AppCompatActivity {
    int ctr = 0;
    ImageView imgNext;
    private final ArrayList<OBData> itemList = new ArrayList<>();
    RelativeLayout llObBottom;
    LinearLayout llObReg;
    OnboardingAdapter onboardingAdapter;
    SharedPreferences sharedPreferences;
    TextView txtOBReady;
    TextView txtReg;
    TextView txtSignIn;
    TextView txtSkip;
    public ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_onboarding);
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        this.imgNext = (ImageView) findViewById(R.id.imgObNext);
        this.txtOBReady = (TextView) findViewById(R.id.txtOBReady);
        this.llObBottom = (RelativeLayout) findViewById(R.id.llOB);
        this.llObReg = (LinearLayout) findViewById(R.id.llObSignUp);
        this.txtSkip = (TextView) findViewById(R.id.txtObSkip);
        this.txtSignIn = (TextView) findViewById(R.id.txtOBSignIn);
        this.txtReg = (TextView) findViewById(R.id.txtOBReg);
        SharedPreferences sharedPreferences2 = getSharedPreferences(Constants.MY_PREF, 0);
        this.sharedPreferences = sharedPreferences2;
        sharedPreferences2.edit().putBoolean(Constants.SHOW_ONBOARDING, false).apply();
        this.imgNext.setImageDrawable(getResources().getDrawable(R.drawable.ic_ob_next1));
        this.itemList.add(new OBData("List your donations", "We know finding the right donation listing platform is quite a struggle, we’re here to help you with that", R.drawable.ic_ob1));
        this.itemList.add(new OBData("Find people that match your donation", "Sometimes, you just want to find a perfect match for your donation, and we know that.", R.drawable.ic_ob2));
        this.itemList.add(new OBData("Organizations you’ve never heard", "Somedays, you want to discover organization that are unknown and be a part of their cause, we’ve people with various motives.", R.drawable.ic_ob3));
        this.itemList.add(new OBData("Experience automation", "We understand, donors are gained through experience and so is recommending them, unlock the experience ", R.drawable.ic_ob4));
        this.txtOBReady.setVisibility(8);
        this.imgNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (OnboardingActivity.this.ctr == 0) {
                    OnboardingActivity.this.imgNext.setImageDrawable(OnboardingActivity.this.getResources().getDrawable(R.drawable.ic_ob_next2));
                    OnboardingActivity.this.viewPager.setCurrentItem(1);
                } else if (OnboardingActivity.this.ctr == 1) {
                    OnboardingActivity.this.imgNext.setImageDrawable(OnboardingActivity.this.getResources().getDrawable(R.drawable.ic_ob_next3));
                    OnboardingActivity.this.viewPager.setCurrentItem(2);
                } else if (OnboardingActivity.this.ctr == 2) {
                    OnboardingActivity.this.viewPager.setCurrentItem(3);
                    OnboardingActivity.this.llObBottom.startAnimation(AnimationUtils.loadAnimation(OnboardingActivity.this, R.anim.fadeout));
                    OnboardingActivity.this.llObReg.startAnimation(AnimationUtils.loadAnimation(OnboardingActivity.this, R.anim.fadeout));
                    OnboardingActivity.this.txtOBReady.startAnimation(AnimationUtils.loadAnimation(OnboardingActivity.this, R.anim.fadein));
                    OnboardingActivity.this.llObBottom.setVisibility(4);
                    OnboardingActivity.this.llObReg.setVisibility(4);
                    OnboardingActivity.this.txtOBReady.setVisibility(0);
                }
                OnboardingActivity.this.ctr++;
            }
        });
        this.onboardingAdapter = new OnboardingAdapter(this.itemList);
        this.viewPager.beginFakeDrag();
        this.viewPager.setAdapter(this.onboardingAdapter);
        this.txtSkip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OnboardingActivity.this.startActivity(new Intent(OnboardingActivity.this, AuthActivity.class));
                OnboardingActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                OnboardingActivity.this.finish();
            }
        });
        this.txtOBReady.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OnboardingActivity.this.startActivity(new Intent(OnboardingActivity.this, AuthActivity.class));
                OnboardingActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                OnboardingActivity.this.finish();
            }
        });
        this.txtReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OnboardingActivity.this.startActivity(new Intent(OnboardingActivity.this, RegisterActivity.class));
                OnboardingActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                OnboardingActivity.this.finish();
            }
        });
        this.txtSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OnboardingActivity.this.startActivity(new Intent(OnboardingActivity.this, LoginActivity.class));
                OnboardingActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                OnboardingActivity.this.finish();
            }
        });
    }
}
