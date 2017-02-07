package com.adprojectmobile.dao;

import android.util.Log;

import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.utilize.JSONPaser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.adprojectmobile.utilize.url;

/**
 * Created by EvEr on 2017/1/30.
 */

public class approveDao {
    final String host= url.host;
    public List<Requisition> getAllRequisition(String id){
        List<Requisition> requisitions =new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/requisition?eId="+id);

        if(jsonArray!=null){
            try {
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonRequisition=jsonArray.getJSONObject(i);
                    JSONArray requisitionItemsJson=new JSONArray();
                    Requisition requisition =new Requisition();
                    if (jsonRequisition.getString("Items")!="null") {
                        requisitionItemsJson = jsonRequisition.getJSONArray("Items");
                        requisition = new Requisition(jsonRequisition.getString("Id"),jsonRequisition.getString("CreatedBy"),jsonRequisition.getString("IssuedDate"),jsonRequisition.getString("ApprovedBy"),jsonRequisition.getString("ApprovementStatus"),jsonRequisition.getString("Remarks"),requisitionItemsJson,jsonRequisition.getString("NumberOfItem") );

                    }
                    else {
                        requisition = new Requisition(jsonRequisition.getString("Id"),jsonRequisition.getString("CreatedBy"),jsonRequisition.getString("IssuedDate"),jsonRequisition.getString("ApprovedBy"),jsonRequisition.getString("ApprovementStatus"),jsonRequisition.getString("Remarks"),jsonRequisition.getString("NumberOfItem") );
                    }
                    requisitions.add(requisition);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return requisitions;
    }
    public List<RequisitionItem> getItemByRequisition(Requisition requisition){
        List<RequisitionItem> requisitionItems =new ArrayList<>();
        if(requisition.getItems()!=null){
            JSONArray jsonArray= requisition.getItems();
            try {
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);
                    RequisitionItem retrievalItem=new RequisitionItem(jsonObject.getString("ItemCode"),jsonObject.getString("ItemName"),jsonObject.getString("Quantity"),jsonObject.getString("NeededQuantity"),jsonObject.getString("RetrieveQuantity"));
                    requisitionItems.add(retrievalItem);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return requisitionItems;
    }

    public void approveRequisition(String id,String approveBy){

        JSONObject jReq=new JSONObject();
        Requisition requisition =new Requisition();
        try{
            jReq.put("Id",id);
            jReq.put("ApprovedBy",approveBy);
            jReq.put("ApprovementStatus","Approve");
            jReq.put("Remarks","");
            Log.e("postReq",jReq.toString());
            JSONPaser.postStream(host+"/requisition",jReq.toString());
            Log.e("Message","Approve Sucess");
        }catch (Exception e){

        }
    }
    public void rejectRequisition(String id,String approveBy,String remark){
        JSONObject jReq=new JSONObject();
        Requisition requisition =new Requisition();
        try{
            jReq.put("Id",id);
            jReq.put("ApprovedBy",approveBy);
            jReq.put("ApprovementStatus","Reject");
            if(remark!=null){
                jReq.put("Remarks",remark);
            }
            Log.e("postReq",jReq.toString());
            JSONPaser.postStream(host+"/requisition",jReq.toString());
            Log.e("Message","Reject Sucess");
        }catch (Exception e){

        }
    }
}
