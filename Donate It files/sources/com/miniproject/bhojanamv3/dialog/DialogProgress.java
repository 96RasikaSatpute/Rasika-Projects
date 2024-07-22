package com.miniproject.bhojanamv3.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.miniproject.bhojanamv3.R;

public class DialogProgress extends DialogFragment {
    String message;
    TextView txtMessage;

    public DialogProgress(String message2) {
        this.message = message2;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_progress_dialog));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_progress, container, false);
        TextView textView = (TextView) view.findViewById(R.id.txtProgressDialog);
        this.txtMessage = textView;
        textView.setTextColor(getResources().getColor(R.color.black_02, getActivity().getTheme()));
        this.txtMessage.setText(this.message);
        return view;
    }
}
