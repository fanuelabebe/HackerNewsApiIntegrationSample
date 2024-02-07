package com.fan.hackernewsapiintegration.models;
//import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

//@Entity
public class StoryData {
    private Long id;
    private Boolean deleted;
    private String by;
    private String type;
    private String time;
    private String text;
    private Boolean dead;
    private Integer parent;
    private String poll;
    private String [] kids;
    private String url;
    private Integer score;
    private String title;
    private String [] parts;
    private Integer descendants;

    public StoryData() {
    }

    public StoryData(Long id, Boolean deleted, String by, String type, String time,
                     String text, Boolean dead, Integer parent, String poll, String[] kids,
                     String url, Integer score, String title, String[] parts, Integer descendants) {
        this.id = id;
        this.deleted = deleted;
        this.by = by;
        this.type = type;
        this.time = time;
        this.text = text;
        this.dead = dead;
        this.parent = parent;
        this.poll = poll;
        this.kids = kids;
        this.url = url;
        this.score = score;
        this.title = title;
        this.parts = parts;
        this.descendants = descendants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getPoll() {
        return poll;
    }

    public void setPoll(String poll) {
        this.poll = poll;
    }

    public String[] getKids() {
        return kids;
    }

    public void setKids(String[] kids) {
        this.kids = kids;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getParts() {
        return parts;
    }

    public void setParts(String[] parts) {
        this.parts = parts;
    }

    public Integer getDescendants() {
        return descendants;
    }

    public void setDescendants(Integer descendants) {
        this.descendants = descendants;
    }
}
