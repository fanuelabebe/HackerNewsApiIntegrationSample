package com.fan.hackernewsapiintegration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.VolleyError;
import com.fan.hackernewsapiintegration.databinding.ActivityMainBinding;
import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
import com.fan.hackernewsapiintegration.implementation.MainOp;
import com.fan.hackernewsapiintegration.implementation.StoriesRecyclerAdapter;
import com.fan.hackernewsapiintegration.implementation.Volley;
import com.fan.hackernewsapiintegration.models.StoryData;

import org.json.JSONObject;

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
    }
    // Get Story data
    public void getStoryData(){

    }

    // Populate RecyclerView After getting data
    public void populateList(List<StoriesData> storiesDataList){
        adapter = new StoriesRecyclerAdapter(MainActivity.this,storiesDataList);
        adapter.onItemClick = this;
        binding.storiesLv.setAdapter(adapter);
    }

    // Show/Dismiss Swipe Refresh Layout
    public void showDismissSwipeRefresh(boolean isShow){
        binding.swipeRefresh.setRefreshing(isShow);
    }


    public void InsertStoryData(StoryData storyData){

    }
    @Override
    public void onItemClick(StoriesData storiesData) {

    }


    @Override
    public void onDataGetSuccess(StoriesData storiesData) {

    }

    @Override
    public void onLocalDataGetSuccess(List<StoriesData> storiesDataList) {

    }

    @Override
    public void onDataGetError(String error) {

    }
}