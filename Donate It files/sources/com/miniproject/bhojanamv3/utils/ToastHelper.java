package com.miniproject.bhojanamv3.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.miniproject.bhojanamv3.R;

public class ToastHelper {
    public void makeToast(Context context, String message, int length) {
        View toastView = LayoutInflater.from(context).inflate(R.layout.toast, (ViewGroup) null);
        Toast toast = new Toast(context);
        ((TextView) toastView.findViewById(R.id.toast_text)).setText(message);
        toast.setView(toastView);
        toast.setDuration(length);
        toast.show();
    }

    public void makeErrorToast(Context context, String message, int length, View view) {
        if (context != null) {
            View toastView = LayoutInflater.from(context).inflate(R.layout.toast, (ViewGroup) null);
            Toast toast = new Toast(context);
            ((TextView) toastView.findViewById(R.id.toast_text)).setText(message);
            toast.setView(toastView);
            toast.setDuration(length);
            toast.show();
            if (view != null) {
                view.clearAnimation();
                view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.shake));
            }
        }
    }

    public void makeErrorToastForEditText(Context context, String message, String hint, int length, EditText editText) {
        if (context != null) {
            View toastView = LayoutInflater.from(context).inflate(R.layout.toast, (ViewGroup) null);
            Toast toast = new Toast(context);
            ((TextView) toastView.findViewById(R.id.toast_text)).setText(message);
            toast.setView(toastView);
            toast.setDuration(length);
            toast.show();
            if (editText != null) {
                editText.setText((CharSequence) null);
                editText.setHint(hint);
                editText.setHintTextColor(context.getColor(R.color.error));
                editText.startAnimation(AnimationUtils.loadAnimation(context, R.anim.shake));
                editText.clearFocus();
            }
        }
    }
}
