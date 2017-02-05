package com.adprojectmobile.daoApi;

import android.util.Log;

import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.util.JSONPaser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.adprojectmobile.util.url;
import com.google.gson.Gson;

/**
 * Created by EvEr on 2017/1/30.
 */

public class approveDao {
    final String host= url.host;
    public List<RequisitionApi> getAllRequisition(String id){
        List<RequisitionApi> requisitionApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/requisition?eId="+id);

        if(jsonArray!=null){
            try {
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonRequisition=jsonArray.getJSONObject(i);
                    JSONArray requisitionItemsJson=new JSONArray();
                    RequisitionApi requisitionApi=new RequisitionApi();
                    if (jsonRequisition.getString("Items")!="null") {
                        requisitionItemsJson = jsonRequisition.getJSONArray("Items");
                        requisitionApi = new RequisitionApi(jsonRequisition.getString("Id"),jsonRequisition.getString("CreatedBy"),jsonRequisition.getString("IssuedDate"),jsonRequisition.getString("ApprovedBy"),jsonRequisition.getString("ApprovementStatus"),jsonRequisition.getString("Remarks"),requisitionItemsJson,jsonRequisition.getString("NumberOfItem") );

                    }
                    else {
                        requisitionApi = new RequisitionApi(jsonRequisition.getString("Id"),jsonRequisition.getString("CreatedBy"),jsonRequisition.getString("IssuedDate"),jsonRequisition.getString("ApprovedBy"),jsonRequisition.getString("ApprovementStatus"),jsonRequisition.getString("Remarks"),jsonRequisition.getString("NumberOfItem") );
                    }
                    requisitionApis.add(requisitionApi);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return requisitionApis;
    }
    public List<RequisitionItemApi> getItemByRequisition(RequisitionApi requisitionApi){
        List<RequisitionItemApi> requisitionItemApis=new ArrayList<>();
        if(requisitionApi.getItems()!=null){
            JSONArray jsonArray=requisitionApi.getItems();
            try {
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);
                    RequisitionItemApi retrievalItem=new RequisitionItemApi(jsonObject.getString("ItemCode"),jsonObject.getString("ItemName"),jsonObject.getString("Quantity"),jsonObject.getString("NeededQuantity"),jsonObject.getString("RetrieveQuantity"));
                    requisitionItemApis.add(retrievalItem);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return requisitionItemApis;
    }

    public void approveRequisition(String id,String approveBy){

        JSONObject jReq=new JSONObject();
        RequisitionApi requisitionApi=new RequisitionApi();
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
        RequisitionApi requisitionApi=new RequisitionApi();
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
