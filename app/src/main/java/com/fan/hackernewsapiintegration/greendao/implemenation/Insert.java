package com.fan.hackernewsapiintegration.greendao.implemenation;

import android.content.Context;

import com.fan.hackernewsapiintegration.Singleton;
import com.fan.hackernewsapiintegration.greendao.models.DaoSession;
import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
import com.fan.hackernewsapiintegration.greendao.models.StoriesDataDao;

public class Insert {
    public static boolean insertStoryData(Context context, StoriesData storiesData){
        StoriesDataDao storiesDataDao = Common.getStoriesDao(context);
        if(storiesDataDao != null){
            try {
                storiesDataDao.insertOrReplace(storiesData);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }


        }
        return false;
    }
}
