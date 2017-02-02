package com.adprojectmobile.daoApi;

import android.util.Log;
import android.widget.Toast;

import com.adprojectmobile.apiModel.DisbursementApi;
import com.adprojectmobile.apiModel.DisbursementItemApi;
import com.adprojectmobile.apiModel.EmployeeApi;
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
    public List<DisbursementApi> getPreparedDisbursement(EmployeeApi employeeApi){
        List<DisbursementApi> disbursementApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/disbursement/"+employeeApi.getEmployeeID());

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
    public List<DisbursementItemApi> getDisbursementItem(EmployeeApi employeeApi,String disId){
        List<DisbursementItemApi> disbursementApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/disbursement/"+employeeApi.getEmployeeID()+"/"+disId);

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
