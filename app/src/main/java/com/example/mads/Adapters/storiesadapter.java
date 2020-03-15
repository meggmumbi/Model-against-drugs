package com.example.mads.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mads.Models.stories;
import com.example.mads.R;

import java.util.List;

public class storiesadapter extends RecyclerView.Adapter<storiesadapter.StoriesViewHolder> {
Context mContext;
List<stories> mData;

    public storiesadapter(Context mContext, List<stories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_stories,viewGroup,false);

        return new StoriesViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder storiesViewHolder, int position) {
     //binding data

       storiesViewHolder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition));
       storiesViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));


        storiesViewHolder.tv_title.setText(mData.get(position).getTitle());
        storiesViewHolder.tv_content.setText(mData.get(position).getContent());
        storiesViewHolder.tv_date.setText(mData.get(position).getDate());
        storiesViewHolder.img_user.setImageResource(mData.get(position).getUserPhoto());





    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class StoriesViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title,tv_content,tv_date;
        ImageView img_user;
        RelativeLayout container;




        public StoriesViewHolder(@NonNull View itemView){
            super(itemView);
            container = itemView.findViewById(R.id.container);
            tv_title = itemView.findViewById(R.id.simple_title);
            tv_content = itemView.findViewById(R.id.tv_description);
            tv_date = itemView.findViewById(R.id.tv_date);
            img_user = itemView.findViewById(R.id.img_user);
        }
    }
}
