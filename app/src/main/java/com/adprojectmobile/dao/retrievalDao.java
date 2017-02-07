package com.adprojectmobile.dao;

import android.util.Log;

import com.adprojectmobile.model.RetrievalCollectionPoint;
import com.adprojectmobile.model.RetrievalItem;
import com.adprojectmobile.utilize.JSONPaser;
import com.adprojectmobile.utilize.url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/26.
 */

public class retrievalDao {
    final String host= url.host;
    public List<RetrievalCollectionPoint> getAllCollectionPoint(String id){
        List<RetrievalCollectionPoint> retrievalCollectionPointList=new ArrayList<>();
        JSONArray jsonArray=new JSONArray();
        if(JSONPaser.getJSONArrayFromUrl(host+"/collectionpoint?eId="+id)!=null){
            jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/collectionpoint?eId="+id);
        }

        Log.e("jsonArray",jsonArray.toString());
        try {
        if (jsonArray.toString().equals("null")){}
            else {
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject jsonCollectionPoint = jsonArray.getJSONObject(i);
                JSONArray retrievalItemsJson = new JSONArray();
                RetrievalCollectionPoint retrievalCollectionPoint = new RetrievalCollectionPoint();
                if (jsonCollectionPoint.getString("Items") != "null") {
                    retrievalItemsJson = jsonCollectionPoint.getJSONArray("Items");
                    retrievalCollectionPoint = new RetrievalCollectionPoint(jsonCollectionPoint.getString("CollectionPointID"), jsonCollectionPoint.getString("CollectionPointName"), retrievalItemsJson, jsonCollectionPoint.getString("AreAllItemPrepared"), jsonCollectionPoint.getString("RetrievalTime"));

                } else {
                    retrievalCollectionPoint = new RetrievalCollectionPoint(jsonCollectionPoint.getString("CollectionPointID"), jsonCollectionPoint.getString("CollectionPointName"), jsonCollectionPoint.getString("AreAllItemPrepared"), jsonCollectionPoint.getString("RetrievalTime"));
                }

//                if (retrievalCollectionPoint.getPrepared().equals("false")){
                retrievalCollectionPointList.add(retrievalCollectionPoint);
//            }
            }
        }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  retrievalCollectionPointList;
    }

    public List<RetrievalItem> getItemsByCollection(JSONArray jItems){
        List<RetrievalItem> retrievalItemList=new ArrayList<>();
        if(jItems!=null){
            JSONArray jsonArray=jItems;
            try {
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);

                    RetrievalItem retrievalItem=new RetrievalItem(jsonObject.getString("ItemId"),jsonObject.getString("ItemName"),jsonObject.getString("NeededQuantity"),jsonObject.getString("RetrievedQuantity"));
                    Log.e("success add one",retrievalItem.toString());
                    retrievalItemList.add(retrievalItem);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return retrievalItemList;
    }

    public void updateRetrievalQty(String collectionPointId,String itemId,String itemName,String neededQty,String retrieveQty  ){
       JSONObject jRetrieval=new JSONObject();
        try{
            jRetrieval.put("CollectionPointID",collectionPointId);
            jRetrieval.put("ItemId",itemId);
            jRetrieval.put("ItemName",itemName);
            jRetrieval.put("NeededQuantity",neededQty);
            jRetrieval.put("RetrievedQuantity",retrieveQty);
            Log.e("json",jRetrieval.toString());
        }catch (Exception e){}

        JSONPaser.postStream(host+"/collectionpoint/UpdateItemRetrievalQty",jRetrieval.toString());
    }
    public String savePrepared(String collectionPointId){
        JSONObject jCol=new JSONObject();
        try{
            jCol.put("CollectionPointID",collectionPointId);

        }catch (Exception e){}

        String result=JSONPaser.postStream(host+"/collectionpoint/UpdateStatusByCollectionPoint",jCol.toString());

        return result;
    }
}
