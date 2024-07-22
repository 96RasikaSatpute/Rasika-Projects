package com.miniproject.bhojanamv3.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.data.CategoryData;
import com.miniproject.bhojanamv3.data.UserData;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import com.miniproject.bhojanamv3.utils.GoogleMap;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.cache.DiskLruCache;

public class RegisterActivity extends AppCompatActivity {
    final int CAMERA_REQ = 102;
    String address = "";
    CardView btnOtp;
    CardView btnSignUp;
    String cPassword;
    String distance;
    EditText etCPassword;
    EditText etDistance;
    EditText etOtp;
    EditText etPassword;
    EditText etPhone;
    EditText etUsername;
    FirebaseAuth firebaseAuth;
    String imageLink = "";
    ImageView imgProfile;
    boolean isImageSelected = false;
    boolean isLocationSelected = false;
    boolean isOTPVerified = false;
    double latitude = 0.0d;
    double longitude = 0.0d;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String mobile;
    String password;
    DialogFragment progressDialogOTP;
    DialogFragment progressDialogSendingOTP;
    TextView txtLocation;
    TextView txtLogin;
    TextView txtOtpDes;
    String username;
    String verificationToken = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_register);
        this.etUsername = (EditText) findViewById(R.id.etRegUsername);
        this.etPassword = (EditText) findViewById(R.id.etRegPassword);
        this.etCPassword = (EditText) findViewById(R.id.etRegCPassword);
        this.etPhone = (EditText) findViewById(R.id.etRegPhone);
        this.txtLogin = (TextView) findViewById(R.id.txtRegLoginIn);
        this.txtLocation = (TextView) findViewById(R.id.txtRegLocation);
        this.imgProfile = (ImageView) findViewById(R.id.imgRegProfile);
        this.btnOtp = (CardView) findViewById(R.id.btnSignUpOtp);
        this.btnSignUp = (CardView) findViewById(R.id.btnSignUp);
        this.etOtp = (EditText) findViewById(R.id.etSignUpOtp);
        this.txtOtpDes = (TextView) findViewById(R.id.txtSignUpOtpDes);
        this.etDistance = (EditText) findViewById(R.id.etRegDistance);
        this.progressDialogOTP = new DialogProgress("Verifying OTP...");
        this.progressDialogSendingOTP = new DialogProgress("Sending OTP...");
        this.progressDialogOTP.setCancelable(false);
        this.progressDialogSendingOTP.setCancelable(false);
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.btnOtp.setVisibility(8);
        this.txtOtpDes.setVisibility(8);
        this.etOtp.setVisibility(8);
        this.txtLocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.clearFocus();
                RegisterActivity.this.startActivityForResult(new Intent(RegisterActivity.this, GoogleMap.class), 101);
            }
        });
        this.txtLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.clearFocus();
                RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                RegisterActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                RegisterActivity.this.finish();
            }
        });
        this.imgProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.clearFocus();
                RegisterActivity.this.isImageSelected = false;
                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                RegisterActivity.this.startActivityForResult(intent, 102);
            }
        });
        this.mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                RegisterActivity.this.progressDialogSendingOTP.dismiss();
                new ToastHelper().makeToast(RegisterActivity.this, "OTP Verified!", 1);
                RegisterActivity.this.onOTPVerified();
            }

            public void onVerificationFailed(FirebaseException e) {
                RegisterActivity.this.progressDialogSendingOTP.dismiss();
                new ToastHelper().makeToast(RegisterActivity.this, "OTP Verification Failed!", 1);
                Log.d("hello", "OTP Failed : " + e.getMessage() + " ");
            }

            public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {
                RegisterActivity.this.progressDialogSendingOTP.dismiss();
                RegisterActivity.this.txtOtpDes.setVisibility(0);
                RegisterActivity.this.etOtp.setVisibility(0);
                RegisterActivity.this.btnSignUp.setVisibility(8);
                RegisterActivity.this.btnOtp.setVisibility(0);
                RegisterActivity.this.txtOtpDes.setText("OTP have been sent to : " + RegisterActivity.this.mobile + ".Please enter OTP to complete verification.");
                new ToastHelper().makeToast(RegisterActivity.this, "OTP sent successfully!", 1);
                RegisterActivity.this.verificationToken = verificationId;
            }
        };
        this.btnOtp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.clearFocus();
                if (!RegisterActivity.this.isOTPVerified) {
                    String otp = RegisterActivity.this.etOtp.getText().toString().trim();
                    if (otp.isEmpty()) {
                        ToastHelper toastHelper = new ToastHelper();
                        RegisterActivity registerActivity = RegisterActivity.this;
                        toastHelper.makeErrorToastForEditText(registerActivity, "Enter OTP!", "Enter OTP", 1, registerActivity.etOtp);
                    } else if (otp.length() < 6) {
                        ToastHelper toastHelper2 = new ToastHelper();
                        RegisterActivity registerActivity2 = RegisterActivity.this;
                        toastHelper2.makeErrorToastForEditText(registerActivity2, "Enter 6 digit OTP!", "Enter 6 digit OTP", 1, registerActivity2.etOtp);
                    } else {
                        RegisterActivity.this.progressDialogOTP.show(RegisterActivity.this.getSupportFragmentManager(), "Dialog Progress");
                        RegisterActivity.this.SigninWithPhone(PhoneAuthProvider.getCredential(RegisterActivity.this.verificationToken, otp));
                    }
                } else {
                    RegisterActivity registerActivity3 = RegisterActivity.this;
                    registerActivity3.username = registerActivity3.etUsername.getText().toString().trim();
                    RegisterActivity registerActivity4 = RegisterActivity.this;
                    registerActivity4.mobile = registerActivity4.etPhone.getText().toString().trim();
                    RegisterActivity registerActivity5 = RegisterActivity.this;
                    registerActivity5.password = registerActivity5.etPassword.getText().toString().trim();
                    RegisterActivity registerActivity6 = RegisterActivity.this;
                    registerActivity6.cPassword = registerActivity6.etCPassword.getText().toString().trim();
                    RegisterActivity registerActivity7 = RegisterActivity.this;
                    registerActivity7.distance = registerActivity7.etDistance.getText().toString().trim();
                    RegisterActivity.this.onOTPVerified();
                }
            }
        });
        this.btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.clearFocus();
                RegisterActivity registerActivity = RegisterActivity.this;
                registerActivity.username = registerActivity.etUsername.getText().toString().trim();
                RegisterActivity registerActivity2 = RegisterActivity.this;
                registerActivity2.mobile = registerActivity2.etPhone.getText().toString().trim();
                RegisterActivity registerActivity3 = RegisterActivity.this;
                registerActivity3.password = registerActivity3.etPassword.getText().toString().trim();
                RegisterActivity registerActivity4 = RegisterActivity.this;
                registerActivity4.cPassword = registerActivity4.etCPassword.getText().toString().trim();
                RegisterActivity registerActivity5 = RegisterActivity.this;
                registerActivity5.distance = registerActivity5.etDistance.getText().toString().trim();
                if (RegisterActivity.this.username.isEmpty() || RegisterActivity.this.mobile.isEmpty() || RegisterActivity.this.password.isEmpty() || RegisterActivity.this.cPassword.isEmpty() || RegisterActivity.this.distance.isEmpty()) {
                    new ToastHelper().makeToast(RegisterActivity.this, "All fields are mandatory!", 1);
                } else if (RegisterActivity.this.mobile.length() < 10) {
                    ToastHelper toastHelper = new ToastHelper();
                    RegisterActivity registerActivity6 = RegisterActivity.this;
                    toastHelper.makeErrorToastForEditText(registerActivity6, "Invalid Contact Number!", "Enter 10 digit contact number", 1, registerActivity6.etPhone);
                } else if (!RegisterActivity.this.password.equals(RegisterActivity.this.cPassword)) {
                    ToastHelper toastHelper2 = new ToastHelper();
                    RegisterActivity registerActivity7 = RegisterActivity.this;
                    toastHelper2.makeErrorToastForEditText(registerActivity7, "Password Mismatch!", "Password mismatch", 1, registerActivity7.etPassword);
                    ToastHelper toastHelper3 = new ToastHelper();
                    RegisterActivity registerActivity8 = RegisterActivity.this;
                    toastHelper3.makeErrorToastForEditText(registerActivity8, "Password Mismatch!", "Password mismatch", 1, registerActivity8.etCPassword);
                } else if (!RegisterActivity.this.isLocationSelected) {
                    ToastHelper toastHelper4 = new ToastHelper();
                    RegisterActivity registerActivity9 = RegisterActivity.this;
                    toastHelper4.makeErrorToast(registerActivity9, "Select location!", 1, registerActivity9.txtLocation);
                } else if (!RegisterActivity.this.isOTPVerified) {
                    RegisterActivity.this.progressDialogSendingOTP.show(RegisterActivity.this.getSupportFragmentManager(), "Dialog Progress");
                    Log.d("hello", "Mobile : " + RegisterActivity.this.mobile);
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    RegisterActivity registerActivity10 = RegisterActivity.this;
                    PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" + RegisterActivity.this.mobile, 60, timeUnit, registerActivity10, registerActivity10.mCallbacks);
                } else {
                    RegisterActivity.this.onOTPVerified();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void SigninWithPhone(PhoneAuthCredential credential) {
        this.firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    RegisterActivity.this.progressDialogOTP.dismiss();
                    new ToastHelper().makeToast(RegisterActivity.this, "OTP Verified!", 1);
                    RegisterActivity.this.onOTPVerified();
                    return;
                }
                RegisterActivity.this.progressDialogOTP.dismiss();
                ToastHelper toastHelper = new ToastHelper();
                RegisterActivity registerActivity = RegisterActivity.this;
                toastHelper.makeErrorToastForEditText(registerActivity, "Invalid OTP!", "Invalid otp", 1, registerActivity.etOtp);
            }
        });
    }

    public void onOTPVerified() {
        this.isOTPVerified = true;
        final DialogFragment progressDialog = new DialogProgress("Creating account...");
        progressDialog.setCancelable(false);
        progressDialog.show(getSupportFragmentManager(), "Dialog Progress");
        if (!this.isImageSelected) {
            this.imageLink = "no_image";
        }
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users/" + this.username);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.getChildrenCount() == 0) {
                    databaseReference.setValue(new UserData(RegisterActivity.this.username, RegisterActivity.this.mobile, RegisterActivity.this.password, RegisterActivity.this.imageLink, DiskLruCache.VERSION_1, (HashMap<String, CategoryData>) null, String.valueOf(RegisterActivity.this.latitude), String.valueOf(RegisterActivity.this.longitude), RegisterActivity.this.address, RegisterActivity.this.distance)).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                new ToastHelper().makeToast(RegisterActivity.this, "Registration successful!", 1);
                                RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                RegisterActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                                RegisterActivity.this.finish();
                                return;
                            }
                            progressDialog.dismiss();
                            new ToastHelper().makeToast(RegisterActivity.this, "Something went wrong! Please try again later.", 1);
                        }
                    });
                    return;
                }
                progressDialog.dismiss();
                ToastHelper toastHelper = new ToastHelper();
                RegisterActivity registerActivity = RegisterActivity.this;
                toastHelper.makeErrorToastForEditText(registerActivity, "User already exists!", "Username not available", 1, registerActivity.etUsername);
            }

            public void onCancelled(DatabaseError error) {
                progressDialog.dismiss();
                new ToastHelper().makeToast(RegisterActivity.this, "Something went wrong! Please try again later.", 1);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 102 && resultCode == -1 && data != null) {
            Log.d("hello", "Intent Proccess");
            Uri selectedImage = data.getData();
            String[] filePathColumn = {"_data"};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, (String) null, (String[]) null, (String) null);
            cursor.moveToFirst();
            String pictureFilePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
            cursor.close();
            File imgFile = new File(pictureFilePath);
            if (imgFile.exists()) {
                Log.d("hello", "Upload Proccess");
                this.imgProfile.setImageURI(Uri.fromFile(imgFile));
                uploadToCloud(selectedImage, System.currentTimeMillis() + "_" + imgFile.getName());
            }
        }
        if (requestCode == 101 && resultCode == -1) {
            this.isLocationSelected = true;
            this.latitude = Double.parseDouble(data.getBundleExtra("result").getString("lat"));
            this.longitude = Double.parseDouble(data.getBundleExtra("result").getString("long"));
            if (data.getBundleExtra("result") != null) {
                this.txtLocation.setText(data.getBundleExtra("result").getString("area"));
            }
            this.txtLocation.setTextColor(getResources().getColor(R.color.black_02));
            this.address = data.getBundleExtra("result").getString("area");
        }
    }

    private void uploadToCloud(Uri file, String filename) {
        Log.d("hello", "Upload Initiated");
        final DialogFragment dialogProgress = new DialogProgress("Uploading Image...");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getSupportFragmentManager(), "Dialog Progress");
        final StorageReference storageRef = FirebaseStorage.getInstance().getReference(filename);
        storageRef.putFile(file).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<UploadTask.TaskSnapshot>() {
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    public void onSuccess(Uri uri) {
                        dialogProgress.dismiss();
                        new ToastHelper().makeToast(RegisterActivity.this, "Image Uploaded Successfully!", 1);
                        RegisterActivity.this.imageLink = uri.toString();
                        RegisterActivity.this.isImageSelected = true;
                    }
                });
            }
        }).addOnFailureListener((OnFailureListener) new OnFailureListener() {
            public void onFailure(Exception exception) {
                dialogProgress.dismiss();
                new ToastHelper().makeToast(RegisterActivity.this, "Something went wrong! Please try again later OR continue without image.", 1);
                Log.d("hello", "Exception : " + exception.getMessage());
            }
        });
    }

    /* access modifiers changed from: private */
    public void clearFocus() {
        this.etUsername.clearFocus();
        this.etPassword.clearFocus();
        this.etCPassword.clearFocus();
        this.etPhone.clearFocus();
        this.etDistance.clearFocus();
    }
}
