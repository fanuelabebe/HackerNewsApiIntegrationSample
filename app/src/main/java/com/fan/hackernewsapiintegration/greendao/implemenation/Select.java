package com.fan.hackernewsapiintegration.greendao.implemenation;

import android.content.Context;
import com.fan.hackernewsapiintegration.greendao.models.StoriesData;
import com.fan.hackernewsapiintegration.greendao.models.StoriesDataDao;

import java.util.List;

public class Select {
    public static StoriesData fetchStoryWithId(Context context,long id){
        StoriesDataDao storiesDataDao = Common.getStoriesDao(context);
        if (storiesDataDao != null) {
            try {
                StoriesData storiesData = storiesDataDao.queryBuilder().where(StoriesDataDao.Properties.Id.eq(id)).unique();
                if(storiesData != null){
                    return storiesData;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }
    public static List<StoriesData> fetchStoryList(Context context){
        StoriesDataDao storiesDataDao = Common.getStoriesDao(context);
        if (storiesDataDao != null) {
            try {
                List<StoriesData> storiesDataList = storiesDataDao.loadAll();
                if(storiesDataList != null){
                    return storiesDataList;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }


}
