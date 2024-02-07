package com.fan.hackernewsapiintegration.implementation;

import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
import com.fan.hackernewsapiintegration.models.StoryData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class GsonParser {
    public static StoriesData parseStoryData(String content){
        try{
            Gson gson = new GsonBuilder().create();
            StoryData storyData =  gson.fromJson(content, StoryData.class);
            if(storyData != null){
                return reflectOnlineData(storyData);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static StoriesData reflectOnlineData(StoryData storyData){
        StoriesData storiesData = new StoriesData();
        storiesData.setId(storyData.getId());
        storiesData.setCode(storyData.getId());
        storiesData.setStory(storyData.getTitle());
        storiesData.setCommentCount(storyData.getKids() != null? String.valueOf(storyData.getKids().length):"");
        storiesData.setUpVoteLastUpdated("");
        storiesData.setLink(storyData.getUrl());
        storiesData.setUpVoteCount(storyData.getPoll());

        return storiesData;
    }

}
