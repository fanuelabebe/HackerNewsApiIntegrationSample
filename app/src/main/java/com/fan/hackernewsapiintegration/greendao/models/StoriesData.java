package com.fan.hackernewsapiintegration.greendao.models;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class StoriesData {
    @Id(autoincrement = true)
    private long Id;
    @SerializedName("id")
    private long code;
    private String upVoteCount;
    private String upVoteLastUpdated;
    private String story;
    private String link;
    private String commentCount;

    public StoriesData(long code, String upVoteCount, String upVoteLastUpdated,
            String story, String link, String commentCount) {
        this.code = code;
        this.upVoteCount = upVoteCount;
        this.upVoteLastUpdated = upVoteLastUpdated;
        this.story = story;
        this.link = link;
        this.commentCount = commentCount;
    }

    @Generated(hash = 977171964)
    public StoriesData() {
    }

    @Generated(hash = 1564190235)
    public StoriesData(long Id, long code, String upVoteCount,
            String upVoteLastUpdated, String story, String link,
            String commentCount) {
        this.Id = Id;
        this.code = code;
        this.upVoteCount = upVoteCount;
        this.upVoteLastUpdated = upVoteLastUpdated;
        this.story = story;
        this.link = link;
        this.commentCount = commentCount;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(String upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public String getUpVoteLastUpdated() {
        return upVoteLastUpdated;
    }

    public void setUpVoteLastUpdated(String upVoteLastUpdated) {
        this.upVoteLastUpdated = upVoteLastUpdated;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public long getId() {
        return this.Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }
}
