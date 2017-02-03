package com.adprojectmobile.daoApi;

import android.util.Log;

import com.adprojectmobile.apiModel.RetrievalCollectionPoint;
import com.adprojectmobile.apiModel.RetrievalItem;
import com.adprojectmobile.util.JSONPaser;
import com.adprojectmobile.util.url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by EvEr on 2017/1/26.
 */

public class retrievalDao {
    final String host= url.host;
    public List<RetrievalCollectionPoint> getAllCollectionPoint(String id){
        List<RetrievalCollectionPoint> retrievalCollectionPointList=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/collectionpoint?eId="+id);

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonCollectionPoint=jsonArray.getJSONObject(i);
                JSONArray retrievalItemsJson=new JSONArray();
                RetrievalCollectionPoint retrievalCollectionPoint=new RetrievalCollectionPoint();
                if (jsonCollectionPoint.getString("Items")!="null") {
                    retrievalItemsJson = jsonCollectionPoint.getJSONArray("Items");
                    retrievalCollectionPoint = new RetrievalCollectionPoint(jsonCollectionPoint.getString("CollectionPointID"), jsonCollectionPoint.getString("CollectionPointName"), retrievalItemsJson, jsonCollectionPoint.getString("AreAllItemPrepared"));

                }
                else {
                    retrievalCollectionPoint = new RetrievalCollectionPoint(jsonCollectionPoint.getString("CollectionPointID"), jsonCollectionPoint.getString("CollectionPointName"), jsonCollectionPoint.getString("AreAllItemPrepared"));
                }

                retrievalCollectionPointList.add(retrievalCollectionPoint);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  retrievalCollectionPointList;
    }

    public List<RetrievalItem> getItemsByCollection(RetrievalCollectionPoint r){
        List<RetrievalItem> retrievalItemList=new ArrayList<>();
        if(r.getItemJson()!=null){
            JSONArray jsonArray=r.getItemJson();
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
    public void savePrepared(String collectionPointId){
        JSONObject jCol=new JSONObject();
        try{
            jCol.put("CollectionPointID",collectionPointId);

        }catch (Exception e){}
        JSONPaser.postStream(host+"/collectionpoint/UpdateStatusByCollectionPoint",jCol.toString());

    }
}
