package com.adprojectmobile.dao;

import android.util.Log;

import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.DisbursementItem;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.utilize.JSONPaser;
import com.adprojectmobile.utilize.url;

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

    public List<Disbursement> getPreparedDisbursement(Employee employee){
        List<Disbursement> disbursements =new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/disbursement/"+ employee.getEmployeeID());

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonDisbursement=jsonArray.getJSONObject(i);
                Disbursement disbursement =new Disbursement();
                    disbursement = new Disbursement(jsonDisbursement.getString("DisbursementID"),jsonDisbursement.getString("CollectionPointName"),jsonDisbursement.getString("RetrievalDate"),jsonDisbursement.getString("DeliveryStatus"),jsonDisbursement.getString("RepName"),jsonDisbursement.getString("RepChecked"),jsonDisbursement.getString("ClerkChecked") );

                disbursements.add(disbursement);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return disbursements;
    }

    public List<DisbursementItem> getDisbursementItem(Employee employee, String disId){
        List<DisbursementItem> disbursementApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/disbursement/"+ employee.getEmployeeID()+"/"+disId);

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonDisbursement=jsonArray.getJSONObject(i);
                DisbursementItem disbursementApi=new DisbursementItem();
                disbursementApi = new DisbursementItem(jsonDisbursement.getString("Description"),jsonDisbursement.getString("UnitMeasured"),jsonDisbursement.getString("RetrievedQuantity"),jsonDisbursement.getString("ActualQuantity"),jsonDisbursement.getString("NeededQuantity"),jsonDisbursement.getString("TransactionID"),jsonDisbursement.getString("ItemID"),jsonDisbursement.getString("DisburseID") );

                disbursementApis.add(disbursementApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return disbursementApis;
    }

    public void confirmDisbursement(String disbursementId){
        try{
            JSONPaser.postStream(host+"/disbursement/ConfirmCollection/"+disbursementId,"");
        }catch (Exception e){
            Log.e("error","error");
        }

    }

    public  void saveActualQty(String disId,String description,String unit,String retrQty,String actualQty,String needQty,String transId,String itemId){
        JSONObject jItem=new JSONObject();
        try{
            jItem.put("Description",description);
            jItem.put("UnitMeasured",unit);
            jItem.put("RetrievedQuantity",retrQty);
            jItem.put("ActualQuantity",actualQty);
            jItem.put("NeededQuantity",needQty);
            jItem.put("TransactionID",transId);
            jItem.put("ItemID",itemId);
            Log.e("json",jItem.toString());
        }catch (Exception e){
            Log.e("error","error");
        }

        JSONPaser.postStream(host+"/disbursement/"+disId,jItem.toString());

    }
}
