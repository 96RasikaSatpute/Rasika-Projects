package com.miniproject.bhojanamv3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {
    final int REQUEST_PERMISSION = 101;
    String[] permissions = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_splash);
        checkPermissionStatus();
    }

    private void checkPermissionStatus() {
        List<String> permissionsNeeded = new ArrayList<>();
        for (String isPermissionRequired : this.permissions) {
            if (ActivityCompat.checkSelfPermission(this, isPermissionRequired) == -1) {
                permissionsNeeded.add(isPermissionRequired);
            }
        }
        if (permissionsNeeded.isEmpty()) {
            performIntent();
        } else {
            ActivityCompat.requestPermissions(this, (String[]) permissionsNeeded.toArray(new String[permissionsNeeded.size()]), 101);
        }
    }

    private void performIntent() {
        final SharedPreferences sharedPreferences = getSharedPreferences(Constants.MY_PREF, 0);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (sharedPreferences.getBoolean(Constants.SHOW_ONBOARDING, true)) {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, OnboardingActivity.class));
                    SplashActivity.this.finish();
                } else if (sharedPreferences.getBoolean(Constants.IS_LOGGED_IN, false)) {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    SplashActivity.this.finish();
                } else {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    SplashActivity.this.finish();
                }
            }
        }, 1500);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions2, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions2, grantResults);
        if (requestCode == 101) {
            boolean isAllGranted = true;
            int length = grantResults.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (grantResults[i] == -1) {
                    isAllGranted = false;
                    break;
                } else {
                    i++;
                }
            }
            if (isAllGranted) {
                performIntent();
                return;
            }
            new ToastHelper().makeToast(this, "Permission Required.", 1);
            finishAffinity();
        }
    }
}
