package com.miniproject.bhojanamv3.dialog;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.activity.HomeActivity;
import com.miniproject.bhojanamv3.adapter.CategoryAdapter;
import com.miniproject.bhojanamv3.data.CategoryData;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class DialogCategory extends DialogFragment implements CategoryAdapter.OnCategorySelected {
    ArrayList<CategoryData> data = new ArrayList<>();
    GridLayoutManager gridLayoutManager;
    ImageView imgNext;
    RecyclerView recyclerView;
    ArrayList<CategoryData> selectedSkill = new ArrayList<>();
    SharedPreferences sharedPreferences;
    CategoryAdapter skillAdapter;

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(-1, -1);
            dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_full_dialog));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_category, container, false);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerSkill);
        this.imgNext = (ImageView) view.findViewById(R.id.imgSkillNext);
        this.gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        this.sharedPreferences = getActivity().getSharedPreferences(Constants.MY_PREF, 0);
        this.imgNext.setVisibility(8);
        final DialogProgress dialogProgress = new DialogProgress("One Moment, Please");
        dialogProgress.setCancelable(false);
        dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference("Category").addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CategoryData skillData = (CategoryData) dataSnapshot.getValue(CategoryData.class);
                    skillData.setCategorySelected(false);
                    DialogCategory.this.data.add(skillData);
                }
                DialogCategory.this.skillAdapter = new CategoryAdapter(DialogCategory.this.data, DialogCategory.this.getContext(), DialogCategory.this, 1);
                DialogCategory.this.recyclerView.setAdapter(DialogCategory.this.skillAdapter);
                DialogCategory.this.recyclerView.setLayoutManager(DialogCategory.this.gridLayoutManager);
                dialogProgress.dismiss();
            }

            public void onCancelled(DatabaseError error) {
                dialogProgress.dismiss();
                new ToastHelper().makeToast(DialogCategory.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
        this.imgNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final DialogProgress dialogProgressSkill = new DialogProgress("Setting up your profile!");
                dialogProgressSkill.setCancelable(false);
                dialogProgressSkill.show(DialogCategory.this.getActivity().getSupportFragmentManager(), "Dialog Skill");
                final DatabaseReference databaseReferenceSkill = firebaseDatabase.getReference("Users/" + DialogCategory.this.sharedPreferences.getString(Constants.USERNAME, "guest") + "/skillData");
                databaseReferenceSkill.addListenerForSingleValueEvent(new ValueEventListener() {
                    public void onDataChange(DataSnapshot snapshot) {
                        Iterator<CategoryData> it = DialogCategory.this.selectedSkill.iterator();
                        while (it.hasNext()) {
                            CategoryData skillData = it.next();
                            databaseReferenceSkill.child(skillData.getCategory_name()).setValue(skillData);
                        }
                        firebaseDatabase.getReference("Users/" + DialogCategory.this.sharedPreferences.getString(Constants.USERNAME, "guest")).child("first_login").setValue("0").addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(Task<Void> task) {
                                if (task.isSuccessful()) {
                                    dialogProgressSkill.dismiss();
                                    DialogCategory.this.sharedPreferences.edit().putBoolean(Constants.SHOW_SKILL, false).apply();
                                    DialogCategory.this.dismiss();
                                    HomeActivity homeActivity = (HomeActivity) DialogCategory.this.getActivity();
                                    HomeActivity.bottomNavigationView.setSelectedItemId(R.id.nav_profile);
                                    return;
                                }
                                dialogProgressSkill.dismiss();
                                databaseReferenceSkill.removeValue();
                                new ToastHelper().makeToast(DialogCategory.this.getActivity(), "Something went wrong! Please try again later.", 1);
                            }
                        });
                    }

                    public void onCancelled(DatabaseError error) {
                        dialogProgressSkill.dismiss();
                        new ToastHelper().makeToast(DialogCategory.this.getActivity(), "Something went wrong! Please try again later.", 1);
                    }
                });
            }
        });
        return view;
    }

    public void onCategorySelected(CategoryData categoryData) {
        this.skillAdapter.notifyDataSetChanged();
        if (!this.selectedSkill.contains(categoryData)) {
            this.selectedSkill.add(categoryData);
        } else {
            this.selectedSkill.remove(categoryData);
        }
        if (this.selectedSkill.size() > 0) {
            this.imgNext.setVisibility(0);
        } else {
            this.imgNext.setVisibility(8);
        }
    }

    public void onCategoryDelete(CategoryData categoryData) {
    }
}
