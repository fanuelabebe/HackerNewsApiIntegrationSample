package com.fan.hackernewsapiintegration.implementation;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fan.hackernewsapiintegration.R;
import com.fan.hackernewsapiintegration.greendao.implemenation.Insert;
import com.fan.hackernewsapiintegration.greendao.implemenation.Select;
import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
import com.fan.hackernewsapiintegration.models.RequestPackage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainOp implements Volley.OnCallDone{
    private final String TAG = MainOp.this.getClass().getSimpleName();
    Context context;
    public OnMainOpDone onMainOpDone;
    List<Long> storyIdList;
    Handler handler;
    ExecutorService executor;
    List<StoriesData> storiesDataList;
    public interface OnMainOpDone{
        void onDataGetSuccess(List<StoriesData> storiesDataList);
        void onLocalDataGetSuccess(List<StoriesData> storiesDataList);
        void onDataGetError(String error);
    }
    public MainOp(Context context){
        this.context = context;
        storyIdList = new ArrayList<>();
        storiesDataList = new ArrayList<>();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public boolean isConnected(){
        if(isNetworkConnected()){
            if(isInternetAvailable()){
                return true;
            }
        }
        return false;
    }
    public void getStoryData(){
//        DialogOperations.showNoTextLoadingLayout(noTextLoadingLayout);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            boolean isOnline = isConnected();
            if(isOnline){
                getOnlineStory(context.getResources().getString(R.string.top_stories_base_url),-1);
            }else{
                List<StoriesData> storiesDataList = getLocalStories(context);
                handler.post(()->{
                    onMainOpDone.onLocalDataGetSuccess(storiesDataList);
                });
            }

        });
    }

    // Insert Single Story Data to DB
    public static void insertStory(Context context, StoriesData storiesData){
        Insert.insertStoryData(context,storiesData);
    }

    // Get List of Stories from DB
    public static List<StoriesData> getLocalStories(Context context){
        return Select.fetchStoryList(context);
    }

    public static StoriesData getLocalStory(Context context,long id){
        return Select.fetchStoryWithId(context,id);
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddress = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddress.equals("");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void getOnlineStory(String uri,long id){
        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setUri(uri);
        requestPackage.setMethod(Request.Method.GET);
        int timeOut = 1 * 60 * 1000;
        Volley volley = new Volley(context,requestPackage,timeOut);
        volley.onCallDone =this;

        if(id == -1) {
            volley.getString(requestPackage);
        }else{
            volley.getJsonObject();
        }
    }


    @Override
    public void onJsonObjectResponse(JSONObject response) {
        Log.v(TAG, "Object Data "+response);
        StoriesData storiesData = GsonParser.parseStoryData(response.toString());
        if(storiesData != null){
            insertStory(context,storiesData);
            storiesDataList.add(storiesData);
            goToNextOrFinish();
        }else{
            onMainOpDone.onDataGetError("Failed to get data");
        }
    }

    public void goToNextOrFinish(){
        if(!storyIdList.isEmpty()){
            long id = storyIdList.get(0);
            storyIdList.remove(id);
            getOnlineStory(context.getResources().getString(R.string.story_base_url,id),id);
        }else{
            handler.post(()->{
                onMainOpDone.onDataGetSuccess(storiesDataList);
            });
        }
    }

    @Override
    public void onStringResponse(String response) {
        Log.v(TAG, "String Data "+response);
        try {
            JSONArray jsonArray = new JSONArray(response);
            List<Long> idList = new ArrayList<>();
            for(int i = 0; i < jsonArray.length(); i++){
                idList.add(Long.parseLong(jsonArray.get(i).toString()));
            }
            storyIdList = idList.subList(0,20);
            goToNextOrFinish();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.v(TAG, "Error "+error);
    }
}
