package com.miniproject.bhojanamv3.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.utils.ToastHelper;

public class DialogEditDistance extends DialogFragment {
    CardView btnEdit;
    EditText etDistance;
    OnEditDistance onEditDistance;

    public interface OnEditDistance {
        void onDistanceEdited(String str);
    }

    public DialogEditDistance(OnEditDistance onEditDistance2) {
        this.onEditDistance = onEditDistance2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_edit_distance, container, false);
        this.etDistance = (EditText) view.findViewById(R.id.etProfileEDistance);
        CardView cardView = (CardView) view.findViewById(R.id.btnEditDistance);
        this.btnEdit = cardView;
        cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DialogEditDistance.this.etDistance.clearFocus();
                String dis = DialogEditDistance.this.etDistance.getText().toString().trim();
                if (dis.isEmpty()) {
                    new ToastHelper().makeErrorToastForEditText(DialogEditDistance.this.getActivity(), "Enter distance", "Enter pickup distance", 1, DialogEditDistance.this.etDistance);
                    return;
                }
                DialogEditDistance.this.onEditDistance.onDistanceEdited(dis);
                DialogEditDistance.this.dismiss();
            }
        });
        return view;
    }
}
