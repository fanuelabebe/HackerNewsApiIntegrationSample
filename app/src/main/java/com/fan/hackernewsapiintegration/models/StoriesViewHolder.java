package com.fan.hackernewsapiintegration.models;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fan.hackernewsapiintegration.R;

import org.w3c.dom.Text;

public class StoriesViewHolder extends RecyclerView.ViewHolder {
    public TextView rawNumberText;
    public TextView upVoteCountText;
    public TextView lastUpdatedText;
    public TextView storyText;
    public TextView commentCountText;
    public TextView linkText;
    public StoriesViewHolder(@NonNull View itemView) {
        super(itemView);
        rawNumberText = itemView.findViewById(R.id.sn_tv);
        upVoteCountText = itemView.findViewById(R.id.points_tv);
        lastUpdatedText = itemView.findViewById(R.id.points_user_tv);
        storyText = itemView.findViewById(R.id.content_tv);
        commentCountText = itemView.findViewById(R.id.comment_count_tv);
        linkText = itemView.findViewById(R.id.link_tv);

    }
}
