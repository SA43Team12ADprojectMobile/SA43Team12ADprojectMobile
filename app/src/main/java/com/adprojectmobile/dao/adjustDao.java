package com.adprojectmobile.dao;

import android.util.Log;

import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.utilize.JSONPaser;
import com.adprojectmobile.utilize.url;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/30.
 */

public class adjustDao {
    String host=url.host;
    public List<Adjustment> getAllAdjustment(String empId){
        List<Adjustment> adjustments =new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/adjustment/"+empId);

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonAdjustment=jsonArray.getJSONObject(i);
                JSONArray adjustItemJson=new JSONArray();
                Adjustment adjustment=new Adjustment();
                if (jsonAdjustment.getString("AdjustmentItems")!="null") {
                    adjustItemJson = jsonAdjustment.getJSONArray("AdjustmentItems");
                    adjustment = new Adjustment(jsonAdjustment.getString("AdjustmentID"),jsonAdjustment.getString("DateIssued"),jsonAdjustment.getString("IssuedBy"),jsonAdjustment.getString("ApprovedBy"),adjustItemJson);
                    Log.e("AdjustJson",jsonAdjustment.toString());
                    Log.e("ItemJson",adjustItemJson.toString());
                }
                else {
                    adjustment = new Adjustment(jsonAdjustment.getString("AdjustmentID"),jsonAdjustment.getString("DateIssued"),jsonAdjustment.getString("IssuedBy"),jsonAdjustment.getString("ApprovedBy"));
                    Log.e("AdjustJson",jsonAdjustment.toString());
                    Log.e("ItemJson",adjustItemJson.toString());
                }

                adjustments.add(adjustment);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return adjustments;
    }

    public List<AdjustmentItem> getAllAdjustItem(Adjustment adjustment){
        List<AdjustmentItem> adjustmentItems =new ArrayList<>();
        if(adjustment.getAdjustmentItems()!=null){
            JSONArray jsonArray= adjustment.getAdjustmentItems();
            try {
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);

                    AdjustmentItem adjustmentItem =new AdjustmentItem(jsonObject.getString("Adjustment_ItemsID"),jsonObject.getString("AdjustmentID"),jsonObject.getString("ItemTransactionID"),jsonObject.getString("ItemID"),jsonObject.getString("Description"),jsonObject.getString("TenderPrice"),jsonObject.getString("ActualQuantity"),jsonObject.getString("Reason"));
                    Log.e("success add item", adjustmentItem.toString());
                    adjustmentItems.add(adjustmentItem);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return adjustmentItems;
    }
    public List<Adjustment> getAuthorizeVoucher(String empId){
        List<Adjustment> adjustments =new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/authorizeadjustment/"+empId);

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonAdjustment=jsonArray.getJSONObject(i);
                JSONArray adjustItemJson=new JSONArray();
                Adjustment adjustment=new Adjustment();
                if (jsonAdjustment.getString("AdjustmentItem")!="null") {
                    adjustItemJson = jsonAdjustment.getJSONArray("AdjustmentItem");
                    adjustment = new Adjustment(jsonAdjustment.getString("AdjustmentID"),jsonAdjustment.getString("DateIssued"),jsonAdjustment.getString("IssuedBy"),jsonAdjustment.getString("ApprovedBy"),adjustItemJson);
                    Log.e("AdjustJson",jsonAdjustment.toString());
                    Log.e("ItemJson",adjustItemJson.toString());
                }
                else {
                    adjustment = new Adjustment(jsonAdjustment.getString("AdjustmentID"),jsonAdjustment.getString("DateIssued"),jsonAdjustment.getString("IssuedBy"),jsonAdjustment.getString("ApprovedBy"));
                    Log.e("AdjustJson",jsonAdjustment.toString());
                    Log.e("ItemJson",adjustItemJson.toString());
                }

                adjustments.add(adjustment);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return adjustments;
    }

    public List<AdjustmentItem> getAdjustItemById(String id){
        return null;
    }

    public List<AdjustmentItem> getAllItemsForAdd(){
        List<AdjustmentItem> adjustmentItems =new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/authorizeadjustment");

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonAdjustmentItem=jsonArray.getJSONObject(i);
                AdjustmentItem adjustmentItem =new AdjustmentItem();

                adjustmentItem = new AdjustmentItem(jsonAdjustmentItem.getString("Id"),jsonAdjustmentItem.getString("Description"),jsonAdjustmentItem.getString("price"));
                    Log.e("ItemJson",jsonAdjustmentItem.toString());

                adjustmentItems.add(adjustmentItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return adjustmentItems;

    }
    public List<AdjustmentItem> searchItems(String code){
        List<AdjustmentItem> itemApis=new ArrayList<>();
        List<AdjustmentItem> allItems= getAllItemsForAdd();
        for (AdjustmentItem a :
                allItems) {
            if(a.getItemID().contains(code)||a.getDescription().contains(code)){
                itemApis.add(a);
            }
        }
        return itemApis;
    }

    public void createNewVoucher(String eId){
        JSONPaser.postStream(host+"/adjustments/"+eId,"");
    }

    public void deleteVoucher(String adjustId){
        JSONPaser.postStream(host+"/adjustment/delete/"+adjustId,"");
    }

    public void deleteItemInVoucher(String adjustItemId){

        JSONPaser.postStream(host+"/adjustmentitems/delete/"+adjustItemId,"");
    }

    public void approveVoucher(String empId,String adjustId){
        JSONObject jAdj=new JSONObject();
        try {
            jAdj.put("AdjustmentID", adjustId);
            jAdj.put("ApprovementStatus","Approved");
            Log.e("JAdj",jAdj.toString());
        }catch (Exception e){
        }
        JSONPaser.postStream(host+"/authorizeadjustment/"+empId,jAdj.toString());
    }

    public void rejectVoucher(String empId,String adjustId){
        JSONObject jAdj=new JSONObject();
        try {
            jAdj.put("AdjustmentID", adjustId);
            jAdj.put("ApprovementStatus","Rejected");
            Log.e("JAdj",jAdj.toString());
        }catch (Exception e){
        }
        JSONPaser.postStream(host+"/authorizeadjustment/"+empId,jAdj.toString());
    }

    public void addNewItemIntoVoucher(String empId, String itemId, String actualQty,String adjustId,String reason){
        JSONObject jItem=new JSONObject();
        try {
            jItem.put("ItemID", itemId);
            jItem.put("ActualQuantity",actualQty);
            jItem.put("AdjustmentID", adjustId);
            jItem.put("Reason", reason);
            Log.e("jItem",jItem.toString());
        }catch (Exception e){
        }
        JSONPaser.postStream(host+"/adjustmentitems/"+empId,jItem.toString());
    }

    public String formatJsonDate(String d){
        String date=d.substring(0,10);
        return date;
    }

}
