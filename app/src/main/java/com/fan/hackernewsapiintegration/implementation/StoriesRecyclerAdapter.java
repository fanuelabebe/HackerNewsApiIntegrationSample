package com.fan.hackernewsapiintegration.implementation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fan.hackernewsapiintegration.R;
import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
import com.fan.hackernewsapiintegration.models.StoriesViewHolder;

import java.util.List;

public class StoriesRecyclerAdapter extends RecyclerView.Adapter<StoriesViewHolder> {
    Context mContext;
    public List<StoriesData> mStoriesDataList;
    public OnItemClick onItemClick;
    public interface OnItemClick{
        void onItemClick(StoriesData storiesData);
    }
    public StoriesRecyclerAdapter(Context mContext, List<StoriesData> mStoriesDataList) {
        this.mContext = mContext;
        this.mStoriesDataList = mStoriesDataList;
    }

    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewV = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new StoriesViewHolder(viewV);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder holder, int position) {
        StoriesData storiesData = mStoriesDataList.get(position);
        holder.rawNumberText.setText(""+(position + 1));
        holder.upVoteCountText.setText(storiesData.getUpVoteCount());
        holder.lastUpdatedText.setText(storiesData.getUpVoteLastUpdated());
        holder.storyText.setText(storiesData.getStory());
        holder.commentCountText.setText(storiesData.getCommentCount());
        holder.linkText.setText(storiesData.getLink());
        holder.itemView.setOnClickListener(view ->{
            onItemClick.onItemClick(storiesData);
        });
    }

    @Override
    public int getItemCount() {
        return mStoriesDataList.size();
    }
}
