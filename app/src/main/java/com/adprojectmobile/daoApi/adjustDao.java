package com.adprojectmobile.daoApi;

import android.util.Log;

import com.adprojectmobile.apiModel.AdjustmentApi;
import com.adprojectmobile.apiModel.AdjustmentItemApi;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.util.JSONPaser;
import com.adprojectmobile.util.url;
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
    public List<AdjustmentApi> getAllAdjustment(String empId){
        List<AdjustmentApi> adjustmentApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/adjustment/"+empId);

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonAdjustment=jsonArray.getJSONObject(i);
                JSONArray adjustItemJson=new JSONArray();
                AdjustmentApi adjustment=new AdjustmentApi();
                if (jsonAdjustment.getString("AdjustmentItems")!="null") {
                    adjustItemJson = jsonAdjustment.getJSONArray("AdjustmentItems");
                    adjustment = new AdjustmentApi(jsonAdjustment.getString("AdjustmentID"),jsonAdjustment.getString("DateIssued"),jsonAdjustment.getString("IssuedBy"),jsonAdjustment.getString("ApprovedBy"),adjustItemJson);
                    Log.e("AdjustJson",jsonAdjustment.toString());
                    Log.e("ItemJson",adjustItemJson.toString());
                }
                else {
                    adjustment = new AdjustmentApi(jsonAdjustment.getString("AdjustmentID"),jsonAdjustment.getString("DateIssued"),jsonAdjustment.getString("IssuedBy"),jsonAdjustment.getString("ApprovedBy"));
                    Log.e("AdjustJson",jsonAdjustment.toString());
                    Log.e("ItemJson",adjustItemJson.toString());
                }

                adjustmentApis.add(adjustment);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return adjustmentApis;
    }

    public List<AdjustmentItemApi> getAllAdjustItem(AdjustmentApi adjustmentApi){
        List<AdjustmentItemApi> adjustmentItemApis=new ArrayList<>();
        if(adjustmentApi.getAdjustmentItems()!=null){
            JSONArray jsonArray=adjustmentApi.getAdjustmentItems();
            try {
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);

                    AdjustmentItemApi adjustmentItemApi=new AdjustmentItemApi(jsonObject.getString("Adjustment_ItemsID"),jsonObject.getString("AdjustmentID"),jsonObject.getString("ItemTransactionID"),jsonObject.getString("ItemID"),jsonObject.getString("Description"),jsonObject.getString("TenderPrice"),jsonObject.getString("ActualQuantity"),jsonObject.getString("Reason"));
                    Log.e("success add item",adjustmentItemApi.toString());
                    adjustmentItemApis.add(adjustmentItemApi);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return adjustmentItemApis;
    }
    public List<AdjustmentApi> getAuthorizeVoucher(String empId){
        List<AdjustmentApi> adjustmentApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/authorizeadjustment/"+empId);

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonAdjustment=jsonArray.getJSONObject(i);
                JSONArray adjustItemJson=new JSONArray();
                AdjustmentApi adjustment=new AdjustmentApi();
                if (jsonAdjustment.getString("AdjustmentItems")!="null") {
                    adjustItemJson = jsonAdjustment.getJSONArray("AdjustmentItems");
                    adjustment = new AdjustmentApi(jsonAdjustment.getString("AdjustmentID"),jsonAdjustment.getString("DateIssued"),jsonAdjustment.getString("IssuedBy"),jsonAdjustment.getString("ApprovedBy"),adjustItemJson);
                    Log.e("AdjustJson",jsonAdjustment.toString());
                    Log.e("ItemJson",adjustItemJson.toString());
                }
                else {
                    adjustment = new AdjustmentApi(jsonAdjustment.getString("AdjustmentID"),jsonAdjustment.getString("DateIssued"),jsonAdjustment.getString("IssuedBy"),jsonAdjustment.getString("ApprovedBy"));
                    Log.e("AdjustJson",jsonAdjustment.toString());
                    Log.e("ItemJson",adjustItemJson.toString());
                }

                adjustmentApis.add(adjustment);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return adjustmentApis;
    }

    public List<AdjustmentItemApi> getAdjustItemById(String id){
        return null;
    }

    public List<AdjustmentItemApi> getAllItemsForAdd(){
        List<AdjustmentItemApi> adjustmentItemApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/authorizeadjustment");

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonAdjustmentItem=jsonArray.getJSONObject(i);
                AdjustmentItemApi adjustmentItemApi=new AdjustmentItemApi();

                adjustmentItemApi = new AdjustmentItemApi(jsonAdjustmentItem.getString("Id"),jsonAdjustmentItem.getString("Description"),jsonAdjustmentItem.getString("price"));
                    Log.e("ItemJson",jsonAdjustmentItem.toString());

                adjustmentItemApis.add(adjustmentItemApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return adjustmentItemApis;

    }
    public List<AdjustmentItemApi> searchItems(String code){
        List<AdjustmentItemApi> itemApis=new ArrayList<>();
        List<AdjustmentItemApi> allItems= getAllItemsForAdd();
        for (AdjustmentItemApi a :
                allItems) {
            if(a.getItemID().contains(code)||a.getDescription().contains(code)){
                itemApis.add(a);
            }
        }
        return itemApis;
    }
    public void saveAdjustment(){}
    public void createNewVoucher(){}
    public void deleteVoucher(){}
    public void authorizeVoucher(){}

    public String formatJsonDate(String d){
        String date=d.substring(0,10);
        return date;
    }

}
