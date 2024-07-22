package com.miniproject.bhojanamv3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.miniproject.bhojanamv3.R;

public class AuthActivity extends AppCompatActivity {
    TextView txtReg;
    TextView txtSignIn;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_auth);
        this.txtReg = (TextView) findViewById(R.id.txtAuthReg);
        this.txtSignIn = (TextView) findViewById(R.id.txtAuthSignIn);
        this.txtReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AuthActivity.this.startActivity(new Intent(AuthActivity.this, RegisterActivity.class));
                AuthActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                AuthActivity.this.finish();
            }
        });
        this.txtSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AuthActivity.this.startActivity(new Intent(AuthActivity.this, LoginActivity.class));
                AuthActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                AuthActivity.this.finish();
            }
        });
    }
}
