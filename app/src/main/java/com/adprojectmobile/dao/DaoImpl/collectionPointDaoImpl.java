package com.adprojectmobile.dao.DaoImpl;

/**
 * Created by EvEr on 2017/1/22.
 */


import com.adprojectmobile.dao.Dao.collectionPointDao;
import com.adprojectmobile.model.CollectionPoint;
import com.adprojectmobile.testdata.testDummyData;
import com.adprojectmobile.util.DummyData;
import com.adprojectmobile.util.JSONPaser;
import com.adprojectmobile.util.url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class collectionPointDaoImpl implements collectionPointDao {
    final String host= url.host;
    public CollectionPoint getCollectionPoint(int id) {
        return DummyData.collectionPoints.get(id);
    }
    @Override
        public List<CollectionPoint> getAllCollectionPoints() {
            //return DummyData.collectionPoints;

        List<CollectionPoint> collectionPoints=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/collectionpoint");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                CollectionPoint collectionPoint = new CollectionPoint(jsonObject.getInt("CollectionPointID"), jsonObject.getString("CollectionPointName"));
                collectionPoints.add(collectionPoint);
            }

            }catch(JSONException e){
                e.printStackTrace();
            }

        return collectionPoints ;
    }
}
