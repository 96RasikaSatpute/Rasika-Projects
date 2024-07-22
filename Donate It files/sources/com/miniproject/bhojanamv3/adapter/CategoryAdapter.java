package com.miniproject.bhojanamv3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.data.CategoryData;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<SkillViewHolder> {
    Context context;
    ArrayList<CategoryData> data;
    int mode;
    OnCategorySelected onSkillSelected;

    public interface OnCategorySelected {
        void onCategoryDelete(CategoryData categoryData);

        void onCategorySelected(CategoryData categoryData);
    }

    public CategoryAdapter(ArrayList<CategoryData> data2, Context context2, OnCategorySelected onSkillSelected2, int mode2) {
        this.data = data2;
        this.context = context2;
        this.onSkillSelected = onSkillSelected2;
        this.mode = mode2;
    }

    public SkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SkillViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_category, parent, false));
    }

    public void onBindViewHolder(SkillViewHolder holder, final int position) {
        if (this.mode == 1) {
            holder.imgDelete.setVisibility(8);
        } else {
            holder.imgDelete.setVisibility(0);
        }
        if (this.data.get(position).isCategorySelected()) {
            holder.llSkill.setBackground(this.context.getResources().getDrawable(R.drawable.shape_skill_selected, this.context.getTheme()));
        } else {
            holder.llSkill.setBackground(this.context.getResources().getDrawable(R.drawable.shape_skill_not_selected, this.context.getTheme()));
        }
        Picasso.get().load(this.data.get(position).getCategory_image()).error((int) R.drawable.ic_no_thumb).into(holder.imgSkill);
        holder.txtSkill.setText(this.data.get(position).getCategory_name());
        holder.imgSkill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CategoryAdapter.this.data.get(position).setCategorySelected(!CategoryAdapter.this.data.get(position).isCategorySelected());
                CategoryAdapter.this.onSkillSelected.onCategorySelected(CategoryAdapter.this.data.get(position));
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CategoryAdapter.this.onSkillSelected.onCategoryDelete(CategoryAdapter.this.data.get(position));
            }
        });
    }

    public int getItemCount() {
        return this.data.size();
    }

    public class SkillViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDelete;
        ImageView imgSkill;
        LinearLayout llSkill;
        TextView txtSkill;

        public SkillViewHolder(View itemView) {
            super(itemView);
            this.txtSkill = (TextView) itemView.findViewById(R.id.txtRecSkill);
            this.imgSkill = (ImageView) itemView.findViewById(R.id.imgRecSkill);
            this.llSkill = (LinearLayout) itemView.findViewById(R.id.llSkillStatus);
            this.imgDelete = (ImageView) itemView.findViewById(R.id.imgRecSkillDelete);
        }
    }
}
