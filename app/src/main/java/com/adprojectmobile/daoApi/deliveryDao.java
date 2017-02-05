package com.adprojectmobile.daoApi;

import android.util.Log;

import com.adprojectmobile.apiModel.DeliveryDisbursement;
import com.adprojectmobile.apiModel.DeliveryItem;
import com.adprojectmobile.apiModel.DepartmentApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;
import com.adprojectmobile.apiModel.RetrievalCollectionPoint;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.util.JSONPaser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.adprojectmobile.util.url.host;

/**
 * Created by EvEr on 2017/1/27.
 */

public class deliveryDao {
    public List<DeliveryDisbursement> getAllDeliveryDisbursements(){
        List<DeliveryDisbursement> deliveryDisbursements=new ArrayList<>();
        //List<RetrievalItem> retrievalItems=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/ackdisbursement");

        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonDisbursement=jsonArray.getJSONObject(i);
                JSONArray retrievalItemsJson=new JSONArray();
                DeliveryDisbursement deliveryDisbursement=new DeliveryDisbursement();


                    deliveryDisbursement = new DeliveryDisbursement(jsonDisbursement.getString("DisbursementID"),jsonDisbursement.getString("CollectionPointId"), jsonDisbursement.getString("CollectionPointName"),
                            jsonDisbursement.getString("RetrievalDate"), jsonDisbursement.getString("DeliveryStatus"),jsonDisbursement.getString("RepName")
                    ,jsonDisbursement.getString("RepChecked"),jsonDisbursement.getString("ClerkChecked"));

                //  retrievalItems.add(retrievalItem);
                deliveryDisbursements.add(deliveryDisbursement);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return deliveryDisbursements;
    }

    public List<DepartmentApi> getDepartmentByCollectionPoint(DeliveryDisbursement deliveryDisbursement){
        List<DepartmentApi> departmentApis=new ArrayList<>();
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/ackdisbursement/"+deliveryDisbursement.getCollectionPointID());//need collection pointID
        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonDepartment=jsonArray.getJSONObject(i);
                JSONArray departmentItemsJson=new JSONArray();
                DepartmentApi departmentApi=new DepartmentApi();

                if(jsonDepartment.getString("RequisitionItems")!="null"){
                    departmentItemsJson=jsonDepartment.getJSONArray("RequisitionItems");
                    departmentApi=new DepartmentApi(jsonDepartment.getString("DepartmentID"),jsonDepartment.getString("DepartmentName"),jsonDepartment.getString("ContactName"),jsonDepartment.getString("TelephoneNumber"),jsonDepartment.getString("FaxNumber"),jsonDepartment.getString("CollectionPointID"),jsonDepartment.getString("CollectionPointName"),departmentItemsJson);
                }
                else {
                    departmentApi=new DepartmentApi(jsonDepartment.getString("DepartmentID"),jsonDepartment.getString("DepartmentName"),jsonDepartment.getString("ContactName"),jsonDepartment.getString("TelephoneNumber"),jsonDepartment.getString("FaxNumber"),jsonDepartment.getString("CollectionPointID"),jsonDepartment.getString("CollectionPointName"));
                }

                Log.e("items",departmentApi.getItems().toString());
                departmentApis.add(departmentApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return departmentApis;
    }
    public List<RequisitionItemApi> getRequisitionItemByDisbursement(JSONArray jItems){
        List<RequisitionItemApi> retrievalItemList=new ArrayList<>();
        if(jItems!=null){
            JSONArray jsonArray=jItems;
            try {
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);

                    RequisitionItemApi retrievalItem=new RequisitionItemApi(jsonObject.getString("ItemCode"),jsonObject.getString("ItemName"),jsonObject.getString("Quantity"),jsonObject.getString("NeededQuantity"),jsonObject.getString("RetrieveQuantity"));
                    Log.e("success add one",retrievalItem.getItemName());
                    retrievalItemList.add(retrievalItem);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return  retrievalItemList;
    }

    public void acknowledgeDelivery(DeliveryDisbursement d){
        JSONObject jDis=new JSONObject();
        try{
            jDis.put("DisbursementID",d.getDisbursementID());
            jDis.put("CollectionPointName",d.getCollectionPointID());
            jDis.put("DeliveryStatus","Delivered");
            jDis.put("RepName",d.getRepName());
            jDis.put("RepChecked","true");
            jDis.put("ClerkChecked","true");

        }catch (Exception e){}
        Log.e("JsonDis",jDis.toString());
        Log.e("Ack","Acknowledge");
        JSONPaser.postStream(host+"/ackdisbursement",jDis.toString());
    }

    public void rejectDelivery(DeliveryDisbursement d){
        JSONObject jDis=new JSONObject();
        try{
            jDis.put("DisbursementID",d.getDisbursementID());
            jDis.put("CollectionPointName",d.getCollectionPointID());
            jDis.put("DeliveryStatus","Prepared");
            jDis.put("RepName",d.getRepName());
            jDis.put("RepChecked","false");
            jDis.put("ClerkChecked","false");

        }catch (Exception e){}
        Log.e("JsonDis",jDis.toString());
        Log.e("Reject","Reject");
        JSONPaser.postStream(host+"/ackdisbursement",jDis.toString());
    }


}
