package com.fan.hackernewsapiintegration.implementation;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fan.hackernewsapiintegration.R;
import com.fan.hackernewsapiintegration.greendao.implemenation.Insert;
import com.fan.hackernewsapiintegration.greendao.implemenation.Select;
import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
import com.fan.hackernewsapiintegration.models.RequestPackage;

import org.json.JSONObject;

import java.util.List;

public class MainOp implements Volley.OnCallDone{
    private final String TAG = MainOp.this.getClass().getSimpleName();
    Context context;
    public OnMainOpDone onMainOpDone;
    public interface OnMainOpDone{
        void onDataGetSuccess(StoriesData storiesData);
        void onLocalDataGetSuccess(List<StoriesData> storiesDataList);
        void onDataGetError(String error);
    }

    public MainOp(Context context){
        this.context = context;
    }
    public static void insertStory(Context context, StoriesData storiesData){
        Insert.insertStoryData(context,storiesData);
    }
    public static List<StoriesData> getLocalStories(Context context){
        return Select.fetchStoryList(context);
    }

    public static StoriesData getLocalStory(Context context,long id){
        return Select.fetchStoryWithId(context,id);
    }

    public boolean checkConnection(){
        return true;
    }
    public void getOnlineStory(long id){
        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setUri(context.getResources().getString(R.string.story_base_url,id));
        requestPackage.setMethod(Request.Method.GET);
        int timeOut = 1 * 60 * 1000;
        Volley volley = new Volley(context,requestPackage,timeOut);
        volley.onCallDone =this;
        volley.getJsonObject();
    }


    @Override
    public void onJsonObjectResponse(JSONObject response) {
        Log.v(TAG, "Data "+response);
        StoriesData storiesData = GsonParser.parseStoryData(response.toString());
        if(storiesData != null){
            insertStory(context,storiesData);
            onMainOpDone.onDataGetSuccess(storiesData);
        }else{
            onMainOpDone.onDataGetError("Failed to get data");
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.v(TAG, "Error "+error);
    }
}
