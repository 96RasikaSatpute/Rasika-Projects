package com.miniproject.bhojanamv3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.data.UserData;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import okhttp3.internal.cache.DiskLruCache;

public class LoginActivity extends AppCompatActivity {
    EditText etPassword;
    EditText etUsername;
    SharedPreferences sharedPreferences;
    TextView txtLogin;
    TextView txtRegister;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_login);
        this.etUsername = (EditText) findViewById(R.id.etLoginUsername);
        this.etPassword = (EditText) findViewById(R.id.etLoginPassword);
        this.txtLogin = (TextView) findViewById(R.id.txtLogin);
        this.txtRegister = (TextView) findViewById(R.id.txtLoginReg);
        this.sharedPreferences = getSharedPreferences(Constants.MY_PREF, 0);
        this.txtRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginActivity.this.clearFocus();
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                LoginActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                LoginActivity.this.finish();
            }
        });
        this.txtLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginActivity.this.clearFocus();
                String username = LoginActivity.this.etUsername.getText().toString().trim();
                final String password = LoginActivity.this.etPassword.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()) {
                    new ToastHelper().makeToast(LoginActivity.this, "All fields are mandatory!", 1);
                    return;
                }
                final DialogProgress dialogProgress = new DialogProgress("Verifying details...");
                dialogProgress.setCancelable(false);
                dialogProgress.show(LoginActivity.this.getSupportFragmentManager(), "Dialog Progress");
                FirebaseDatabase.getInstance().getReference("Users/" + username).addListenerForSingleValueEvent(new ValueEventListener() {
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.getChildrenCount() == 0) {
                            dialogProgress.dismiss();
                            new ToastHelper().makeErrorToastForEditText(LoginActivity.this, "No user found!", "No user found", 1, LoginActivity.this.etUsername);
                            LoginActivity.this.etPassword.setText((CharSequence) null);
                            LoginActivity.this.clearFocus();
                            return;
                        }
                        UserData userData = (UserData) snapshot.getValue(UserData.class);
                        if (userData.getPassword().equals(password)) {
                            dialogProgress.dismiss();
                            new ToastHelper().makeToast(LoginActivity.this, "Login Successful!", 1);
                            LoginActivity.this.sharedPreferences.edit().putString(Constants.USERNAME, userData.getUsername()).apply();
                            LoginActivity.this.sharedPreferences.edit().putString(Constants.MOBILE, userData.getMobile()).apply();
                            LoginActivity.this.sharedPreferences.edit().putString(Constants.IMAGE_LINK, userData.getImage_link()).apply();
                            LoginActivity.this.sharedPreferences.edit().putString(Constants.LATITUDE, userData.getLatitude()).apply();
                            LoginActivity.this.sharedPreferences.edit().putString(Constants.LONGITUDE, userData.getLongitude()).apply();
                            LoginActivity.this.sharedPreferences.edit().putString(Constants.ADDRESS, userData.getAddress()).apply();
                            LoginActivity.this.sharedPreferences.edit().putBoolean(Constants.IS_LOGGED_IN, true).apply();
                            LoginActivity.this.sharedPreferences.edit().putString(Constants.DISTANCE, userData.getDistance()).apply();
                            if (userData.getFirst_login().equals(DiskLruCache.VERSION_1)) {
                                LoginActivity.this.sharedPreferences.edit().putBoolean(Constants.SHOW_SKILL, true).apply();
                            } else {
                                LoginActivity.this.sharedPreferences.edit().putBoolean(Constants.SHOW_SKILL, false).apply();
                            }
                            LoginActivity.this.startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            LoginActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            LoginActivity.this.finish();
                            return;
                        }
                        dialogProgress.dismiss();
                        new ToastHelper().makeErrorToastForEditText(LoginActivity.this, "Invalid Password!", "Invalid password", 1, LoginActivity.this.etPassword);
                    }

                    public void onCancelled(DatabaseError error) {
                        dialogProgress.dismiss();
                        new ToastHelper().makeToast(LoginActivity.this, "Something went wrong! Please try again later.", 1);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void clearFocus() {
        this.etPassword.clearFocus();
        this.etUsername.clearFocus();
    }
}
