package com.miniproject.bhojanamv3.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.dialog.DialogCategory;
import com.miniproject.bhojanamv3.fragment.ActivityFragment;
import com.miniproject.bhojanamv3.fragment.HistoryFragment;
import com.miniproject.bhojanamv3.fragment.ListFragment;
import com.miniproject.bhojanamv3.fragment.ProfileFragment;
import com.miniproject.bhojanamv3.utils.Constants;

public class HomeActivity extends AppCompatActivity {
    public static BottomNavigationView bottomNavigationView;
    SharedPreferences sharedPreferences;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_home);
        SharedPreferences sharedPreferences2 = getSharedPreferences(Constants.MY_PREF, 0);
        this.sharedPreferences = sharedPreferences2;
        if (sharedPreferences2.getBoolean(Constants.SHOW_SKILL, false)) {
            DialogFragment dialogFragment = new DialogCategory();
            dialogFragment.setCancelable(false);
            dialogFragment.show(getSupportFragmentManager(), "Dialog Category");
        }
        FirebaseMessaging.getInstance().subscribeToTopic(this.sharedPreferences.getString(Constants.USERNAME, "guest")).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
            }
        });
        BottomNavigationView bottomNavigationView2 = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView = bottomNavigationView2;
        bottomNavigationView2.setSelectedItemId(R.id.nav_profile);
        openProfile();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.nav_profile) {
                    HomeActivity.this.openProfile();
                    return true;
                } else if (item.getItemId() == R.id.nav_list) {
                    HomeActivity.this.openList();
                    return true;
                } else if (item.getItemId() == R.id.nav_chat) {
                    HomeActivity.this.openChat();
                    return true;
                } else {
                    HomeActivity.this.openActivity();
                    return true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void openProfile() {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein, R.anim.fadeout).replace(R.id.frameLayout, new ProfileFragment()).commit();
    }

    /* access modifiers changed from: private */
    public void openList() {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein, R.anim.fadeout).replace(R.id.frameLayout, new ListFragment()).commit();
    }

    /* access modifiers changed from: private */
    public void openChat() {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein, R.anim.fadeout).replace(R.id.frameLayout, new HistoryFragment()).commit();
    }

    /* access modifiers changed from: private */
    public void openActivity() {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein, R.anim.fadeout).replace(R.id.frameLayout, new ActivityFragment()).commit();
    }
}
