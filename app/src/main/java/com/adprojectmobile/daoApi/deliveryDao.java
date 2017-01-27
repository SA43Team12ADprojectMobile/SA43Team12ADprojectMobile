package com.adprojectmobile.daoApi;

import com.adprojectmobile.apiModel.DeliveryDisbursement;
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
}
