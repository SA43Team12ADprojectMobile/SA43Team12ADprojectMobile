package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.Disbursement;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface disbursementDao {
    public Disbursement getDisbursement(int id);
    public List<Disbursement> getAllDisbursement();

}
