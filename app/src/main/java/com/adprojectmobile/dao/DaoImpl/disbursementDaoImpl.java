package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.disbursementDao;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.util.DummyData;

import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class disbursementDaoImpl implements disbursementDao {
    public Disbursement getDisbursement(int id){

        return DummyData.disbursements.get(id);
    }

    public List<Disbursement> getAllDisbursement(){
        return DummyData.disbursements;
    }
}
