package com.example.mads.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mads.Activities.MessageActivity;
import com.example.mads.Models.mentor;
import com.example.mads.R;

import java.util.List;

public class Mentor extends RecyclerView.Adapter<Mentor.ViewHolder> {

    private Context mContext;
    private List<mentor> Umentor;
    private boolean ischat;
    public Mentor( Context mContext, List<mentor> Umentor, boolean ischat) {

        this.mContext =  mContext;
        this.Umentor = Umentor;
        this.ischat = ischat;
    }
    public Mentor(){

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.mentor_item, parent, false);
        return new Mentor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final mentor m = Umentor.get(position);
        holder.username.setText(m.getUsername());

        holder.description.setText(m.getDescription());

        if (m.getImageUrl().equals("default")) {
            holder.profile_image.setImageResource(R.mipmap.ic_launcher);

        } else {
            Glide.with(mContext).load(m.getImageUrl()).into(holder.profile_image);
        }

        if (ischat){
            if (m.getStatus().equals("online")){
                holder.img_on.setVisibility(View.VISIBLE);
                holder.img_off.setVisibility(View.GONE);
            }
            else {
                holder.img_off.setVisibility(View.VISIBLE);
                holder.img_on.setVisibility(View.GONE);
            }
        }
        else{
            holder.img_on.setVisibility(View.GONE);
            holder.img_off.setVisibility(View.GONE);
        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MessageActivity.class);
                intent.putExtra("userid", m.getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Umentor.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public ImageView profile_image;
        private  ImageView img_on;
        private ImageView img_off;
        private TextView description;


        public ViewHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            username = itemView.findViewById(R.id.username);
            profile_image = itemView.findViewById(R.id.profile_image);
            img_on = itemView.findViewById(R.id.img_on);
            img_off = itemView.findViewById(R.id.img_off);

        }
    }


}
