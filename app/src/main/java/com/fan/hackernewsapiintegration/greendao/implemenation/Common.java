package com.fan.hackernewsapiintegration.greendao.implemenation;

import android.content.Context;

import com.fan.hackernewsapiintegration.Singleton;
import com.fan.hackernewsapiintegration.greendao.models.DaoSession;
import com.fan.hackernewsapiintegration.greendao.models.StoriesDataDao;

public class Common {
    public static StoriesDataDao getStoriesDao(Context context){
        try{
            DaoSession daoSession = Singleton.getInstance(context).getDaoSession();
            if(daoSession != null) {
                StoriesDataDao storiesDataDao = daoSession.getStoriesDataDao();
                if (storiesDataDao != null) {
                    return storiesDataDao;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
