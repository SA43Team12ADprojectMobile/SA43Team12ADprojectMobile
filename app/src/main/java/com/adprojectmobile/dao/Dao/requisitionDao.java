package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.Requisition;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface requisitionDao {
    public Requisition getRequisition(int id);
    public List<Requisition> getAllRequisitions();
    public List<Requisition> getDisbursementRequisition(Disbursement disbursement);
    public List<Requisition> getRequisitionByEmployee(Employee employee);

    public void saveRejectedReason(Requisition requisition);
}
