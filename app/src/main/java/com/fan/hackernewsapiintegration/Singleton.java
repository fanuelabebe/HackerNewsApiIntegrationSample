package com.fan.hackernewsapiintegration;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.fan.hackernewsapiintegration.greendao.models.DaoMaster;
import com.fan.hackernewsapiintegration.greendao.models.DaoSession;


public class Singleton {
    private final String TAG = Singleton.this.getClass().getSimpleName();
    private RequestQueue mRequestQueue;
    private DaoSession daoSession;
    Context context;
    private static Singleton mSingleton;
    public static synchronized Singleton getInstance(Context context){
        if(mSingleton == null){
            mSingleton = new Singleton(context);
        }
        return mSingleton;
    }
    private Singleton(Context context){
        this.context = context;
        initGreenDao(context.getApplicationContext());
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }
    public void initGreenDao(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "hacker_news_db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
//        daoSession.getStoriesDataDao().dropTable(helper.getWritableDb(), true);
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
}
