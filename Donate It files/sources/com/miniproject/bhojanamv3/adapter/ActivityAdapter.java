package com.miniproject.bhojanamv3.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.data.ListData;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityViewHolder> {
    Context context;
    ArrayList<ListData> data;
    int mode;
    OnActChatClicked onActChatClicked;

    public interface OnActChatClicked {
        void onBlockClicked(ListData listData);

        void onCancelClicked(ListData listData);

        void onChatClicked(ListData listData);

        void onCompleteClicked(ListData listData);
    }

    public ActivityAdapter(ArrayList<ListData> data2, Context context2, OnActChatClicked onActChatClicked2, int mode2) {
        this.data = data2;
        this.context = context2;
        this.onActChatClicked = onActChatClicked2;
        this.mode = mode2;
    }

    public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ActivityViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_activity, parent, false));
    }

    public int getItemCount() {
        return this.data.size();
    }

    public void onBindViewHolder(ActivityViewHolder holder, final int position) {
        int i = this.mode;
        if (i == 1) {
            holder.cvBlock.setVisibility(0);
            holder.cvCancel.setVisibility(8);
            holder.cvComplete.setVisibility(8);
        } else if (i == 2) {
            holder.cvBlock.setVisibility(8);
            holder.cvCancel.setVisibility(0);
            holder.cvComplete.setVisibility(0);
        } else if (i == 3) {
            holder.cvBlock.setVisibility(8);
            holder.cvCancel.setVisibility(8);
            holder.cvComplete.setVisibility(8);
            holder.imgCall.setVisibility(8);
            holder.imgChat.setVisibility(8);
            holder.imgMatch.setVisibility(8);
            holder.txtUserName.setVisibility(8);
            holder.txtContact.setVisibility(8);
        } else if (i == 4) {
            holder.cvBlock.setVisibility(8);
            holder.cvComplete.setVisibility(8);
            holder.imgCall.setVisibility(8);
            holder.imgChat.setVisibility(8);
            holder.imgMatch.setVisibility(8);
            holder.txtUserName.setVisibility(8);
            holder.txtContact.setVisibility(8);
        }
        ListData activityData = this.data.get(position);
        holder.txtTime.setText("DATE : " + activityData.getTimestamp());
        holder.txtSkill.setText("CATEGORY : " + activityData.getCategory());
        String sub_skill = "";
        for (int i2 = 0; i2 < activityData.getSub_catgeory_data().size(); i2++) {
            if (i2 == activityData.getSub_catgeory_data().size() - 1) {
                sub_skill = sub_skill + activityData.getSub_catgeory_data().get(i2).getValue();
            } else {
                sub_skill = sub_skill + activityData.getSub_catgeory_data().get(i2).getValue() + " , ";
            }
        }
        holder.txtSubSkill.setText("SUB CATEGORY : " + sub_skill);
        holder.txtDes.setText("DESCRIPTION : " + activityData.getDescription());
        if (activityData.getDistance().equals("0")) {
            holder.txtMode.setText("MODE : PICKUP");
        } else {
            holder.txtMode.setText("MODE : DELIVERY");
        }
        holder.txtUserName.setText(this.data.get(position).getUsername());
        holder.txtContact.setText(this.data.get(position).getMobile());
        Picasso.get().load(this.data.get(position).getImage_link()).error((int) R.drawable.ic_user_150).into(holder.imgMatch);
        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityAdapter.this.context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ActivityAdapter.this.data.get(position).getMobile())));
            }
        });
        holder.imgChat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityAdapter.this.onActChatClicked.onChatClicked(ActivityAdapter.this.data.get(position));
            }
        });
        holder.cvBlock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityAdapter.this.onActChatClicked.onBlockClicked(ActivityAdapter.this.data.get(position));
            }
        });
        holder.cvComplete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityAdapter.this.onActChatClicked.onCompleteClicked(ActivityAdapter.this.data.get(position));
            }
        });
        holder.cvCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityAdapter.this.onActChatClicked.onCancelClicked(ActivityAdapter.this.data.get(position));
            }
        });
    }

    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        CardView cvBlock;
        CardView cvCancel;
        CardView cvComplete;
        ImageView imgCall;
        ImageView imgChat;
        ImageView imgMatch;
        TextView txtContact;
        TextView txtDes;
        TextView txtMode;
        TextView txtSkill;
        TextView txtSubSkill;
        TextView txtTime;
        TextView txtUserName;

        public ActivityViewHolder(View itemView) {
            super(itemView);
            this.txtTime = (TextView) itemView.findViewById(R.id.txtActivityTimeStamp);
            this.txtSkill = (TextView) itemView.findViewById(R.id.txtActivitySkill);
            this.txtSubSkill = (TextView) itemView.findViewById(R.id.txtActivitySubSkill);
            this.txtDes = (TextView) itemView.findViewById(R.id.txtActivityDes);
            this.txtMode = (TextView) itemView.findViewById(R.id.txtActivityMode);
            this.txtContact = (TextView) itemView.findViewById(R.id.txtMatchContact);
            this.txtUserName = (TextView) itemView.findViewById(R.id.txtMatchUsername);
            this.imgMatch = (ImageView) itemView.findViewById(R.id.imgMatch);
            this.imgCall = (ImageView) itemView.findViewById(R.id.imgMatchCall);
            this.imgChat = (ImageView) itemView.findViewById(R.id.imgMatchChat);
            this.cvBlock = (CardView) itemView.findViewById(R.id.btnActivityBlock);
            this.cvCancel = (CardView) itemView.findViewById(R.id.btnActivityCancel);
            this.cvComplete = (CardView) itemView.findViewById(R.id.btnActivityComplete);
        }
    }
}
