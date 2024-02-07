package com.fan.hackernewsapiintegration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fan.hackernewsapiintegration.databinding.ActivityMainBinding;
import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
import com.fan.hackernewsapiintegration.implementation.MainOp;
import com.fan.hackernewsapiintegration.implementation.StoriesRecyclerAdapter;
import com.fan.hackernewsapiintegration.models.StoryData;

import java.util.List;

public class MainActivity extends AppCompatActivity implements StoriesRecyclerAdapter.OnItemClick,
MainOp.OnMainOpDone{
    private final String TAG = MainActivity.this.getClass().getSimpleName();
    ActivityMainBinding binding;
    StoriesRecyclerAdapter adapter;
    MainOp mainOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mainOp = new MainOp(this);
        mainOp.onMainOpDone = this;
        getStoryData();
        setListenersToViews();
    }
    // Get Story data
    public void getStoryData(){
        showDismissSwipeRefresh(true);
        mainOp.getStoryData();
    }
    public void setListenersToViews(){
        binding.swipeRefresh.setOnRefreshListener(() ->   {
            mainOp.getStoryData();
        });
    }
    // Populate RecyclerView After getting data
    public void populateList(List<StoriesData> storiesDataList){
        adapter = new StoriesRecyclerAdapter(MainActivity.this,storiesDataList);
        adapter.onItemClick = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.storiesLv.setLayoutManager(linearLayoutManager);
        binding.storiesLv.setAdapter(adapter);
    }

    // Show/Dismiss Swipe Refresh Layout
    public void showDismissSwipeRefresh(boolean isShow){
        binding.swipeRefresh.setRefreshing(isShow);
    }
    @Override
    public void onItemClick(StoriesData storiesData) {
        if(storiesData != null && storiesData.getLink() != null && !storiesData.getLink().equals("")){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storiesData.getLink()));
            startActivity(browserIntent);
        }else{
            showToast("Faulty Link");
        }
    }


    @Override
    public void onDataGetSuccess(List<StoriesData> storiesDataList) {
        Log.v(TAG,"Online Data: "+storiesDataList);
        populateList(storiesDataList);
        showDismissSwipeRefresh(false);
        showToast("Online Data");

    }
    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocalDataGetSuccess(List<StoriesData> storiesDataList) {
        Log.v(TAG,"Local Data: "+storiesDataList);
        populateList(storiesDataList);
        showDismissSwipeRefresh(false);
        showToast("Local Data");
    }

    @Override
    public void onDataGetError(String error) {
        Log.v(TAG,"Error: "+error);
        showDismissSwipeRefresh(false);
    }
}