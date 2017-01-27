package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.Disbursement;

import org.json.JSONException;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface disbursementDao {
    public Disbursement getDisbursement(int id) ;
    public List<Disbursement> getAllDisbursement() ;
    public Disbursement getDisbursementFromJSON(String disbursementId, String retrievalTime, String deliveryStatus, String collectonPoint, String repName, String repChecked, String clerkChecked);

}
