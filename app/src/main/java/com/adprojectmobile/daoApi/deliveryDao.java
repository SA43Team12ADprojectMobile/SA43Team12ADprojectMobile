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
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/disbursement");

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
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/ackdisbursement/3");
        try {
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonDepartment=jsonArray.getJSONObject(i);
//                JSONArray retrievalItemsJson=new JSONArray();
                DepartmentApi departmentApi=new DepartmentApi();


                departmentApi = new DepartmentApi(jsonDepartment.getString("DisbursementID"),jsonDepartment.getString("RetrievalTime"),jsonDepartment.getString("DeliveryStatus"),jsonDepartment.getString("CollectionPointName"),jsonDepartment.getString("RepName"),jsonDepartment.getString("RepChecked"),jsonDepartment.getString("ClerkChecked"),jsonDepartment.getString("DepartmentName"),jsonDepartment.getString("ContactName"),jsonDepartment.getString("TelephoneNumber"),jsonDepartment.getString("Description"),jsonDepartment.getString("ItemID"),jsonDepartment.getString("ActualQty"),jsonDepartment.getString("NeededQty"));
               // public DepartmentApi(String disbursementID, String retrievalTime, String deliveryStatus, String collectionPointName, String repName, String repChecked, String clerkChecked, String departmentName, String contactName, String telephoneNumber, String description, String itemID, String actualQty, String neededQty)

                //  retrievalItems.add(retrievalItem);
                departmentApis.add(departmentApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return departmentApis;
    }
}
