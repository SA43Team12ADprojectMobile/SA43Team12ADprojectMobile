package com.adprojectmobile.daoApi;

import com.adprojectmobile.apiModel.DeliveryDisbursement;
import com.adprojectmobile.apiModel.DepartmentApi;
import com.adprojectmobile.apiModel.RetrievalCollectionPoint;
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


                    deliveryDisbursement = new DeliveryDisbursement(jsonDisbursement.getString("DisbursementID"), jsonDisbursement.getString("CollectionPointName"),
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
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/ackdisbursement/"+deliveryDisbursement.getCollectionPointName());//need collection pointID
        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonDepartment=jsonArray.getJSONObject(i);
                JSONArray departmentItemsJson=new JSONArray();
                DepartmentApi departmentApi=new DepartmentApi();

                if(jsonDepartment.getString("Items")!="null"){
                    departmentItemsJson=jsonDepartment.getJSONArray("Items");
                    departmentApi=new DepartmentApi(jsonDepartment.getString("DepartmentID"),jsonDepartment.getString("DepartmentName"),jsonDepartment.getString("ContactName"),jsonDepartment.getString("TelephoneNumber"),jsonDepartment.getString("FaxNumber"),jsonDepartment.getString("CollectionPointID"),jsonDepartment.getString("CollectionPointName"),departmentItemsJson);
                }
                else {

                    departmentApi=new DepartmentApi(jsonDepartment.getString("DepartmentID"),jsonDepartment.getString("DepartmentName"),jsonDepartment.getString("ContactName"),jsonDepartment.getString("TelephoneNumber"),jsonDepartment.getString("FaxNumber"),jsonDepartment.getString("CollectionPointID"),jsonDepartment.getString("CollectionPointName"));
                }

                departmentApis.add(departmentApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return departmentApis;
    }


}
