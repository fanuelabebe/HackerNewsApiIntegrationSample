package com.fan.hackernewsapiintegration.greendao.models;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class StoriesData {
    @Id(autoincrement = true)
    private long id;
    private String upVoteCount;
    private String upVoteLastUpdated;
    private String story;
    private String link;
    private String commentCount;

    @Generated(hash = 1574568161)
    public StoriesData(long id, String upVoteCount, String upVoteLastUpdated,
            String story, String link, String commentCount) {
        this.id = id;
        this.upVoteCount = upVoteCount;
        this.upVoteLastUpdated = upVoteLastUpdated;
        this.story = story;
        this.link = link;
        this.commentCount = commentCount;
    }

    @Generated(hash = 977171964)
    public StoriesData() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
