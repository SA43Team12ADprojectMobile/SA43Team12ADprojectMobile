package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.disbursementDao;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.util.DummyData;
import com.adprojectmobile.util.JSONPaser;
import com.adprojectmobile.util.url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class disbursementDaoImpl implements disbursementDao {
    final String host= url.host;
    public Disbursement getDisbursement(int id) {

      return DummyData.disbursements.get(id);
       // return  null;

    }

    public List<Disbursement> getAllDisbursement() {
//        for testdata
      //  return DummyData.disbursements;

        //for WebAPI data
        List<Disbursement> disbursements=new ArrayList<>();

        JSONArray jsonArray=JSONPaser.getJSONArrayFromUrl(host+"/disbursement");
        try {
            for(int i=0;i<jsonArray.length();i++){

                JSONObject jsonDis=jsonArray.getJSONObject(i);
                Disbursement disbursement=new Disbursement(jsonDis.getString("DisbursementID"),jsonDis.getString("RetrievalDate"),jsonDis.getString("DeliveryStatus"),
                        jsonDis.getString("CollectionPointName"),jsonDis.getString("RepName"),Boolean.parseBoolean(jsonDis.getString("RepChecked")),Boolean.parseBoolean(jsonDis.getString("ClerkChecked")));
                disbursements.add(disbursement);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        int a=disbursements.size();
        return disbursements;
//        return  null;
    }

    @Override
    public Disbursement getDisbursementFromJSON(String disbursementId, String retrievalTime, String deliveryStatus, String collectonPoint, String repName, String repChecked, String clerkChecked) {
        Disbursement dis=new Disbursement(disbursementId, retrievalTime, deliveryStatus, collectonPoint, repName,Boolean.parseBoolean(repChecked),Boolean.parseBoolean(clerkChecked));
        return dis;
    }

}
