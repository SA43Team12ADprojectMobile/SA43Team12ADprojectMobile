package com.adprojectmobile.daoApi;

import com.adprojectmobile.apiModel.DisbursementApi;
import com.adprojectmobile.apiModel.DisbursementItemApi;
import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.util.JSONPaser;
import com.adprojectmobile.util.url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/31.
 */

public class confirmDao {
    final String host= url.host;
    public List<DisbursementApi> getPreparedDisbursement(){
        List<DisbursementApi> disbursementApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/disbursement");

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonDisbursement=jsonArray.getJSONObject(i);
                DisbursementApi disbursementApi=new DisbursementApi();
                    disbursementApi = new DisbursementApi(jsonDisbursement.getString("DisbursementID"),jsonDisbursement.getString("CollectionPointName"),jsonDisbursement.getString("RetrievalDate"),jsonDisbursement.getString("DeliveryStatus"),jsonDisbursement.getString("RepName"),jsonDisbursement.getString("RepChecked"),jsonDisbursement.getString("ClerkChecked") );

                disbursementApis.add(disbursementApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return disbursementApis;
    }
    public List<DisbursementItemApi> getDisbursementItem(String id){
        List<DisbursementItemApi> disbursementApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/disbursement/"+id);

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonDisbursement=jsonArray.getJSONObject(i);
                DisbursementItemApi disbursementApi=new DisbursementItemApi();
                disbursementApi = new DisbursementItemApi(jsonDisbursement.getString("Description"),jsonDisbursement.getString("UnitMeasured"),jsonDisbursement.getString("RetrievedQuantity"),jsonDisbursement.getString("ActualQuantity"),jsonDisbursement.getString("NeededQuantity"),jsonDisbursement.getString("TransactionID"),jsonDisbursement.getString("ItemID"),jsonDisbursement.getString("DisburseID") );

                disbursementApis.add(disbursementApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return disbursementApis;
    }
}
