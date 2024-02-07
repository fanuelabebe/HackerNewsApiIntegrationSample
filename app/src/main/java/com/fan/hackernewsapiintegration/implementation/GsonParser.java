package com.fan.hackernewsapiintegration.implementation;

import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
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
            return gson.fromJson(content, StoriesData.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
