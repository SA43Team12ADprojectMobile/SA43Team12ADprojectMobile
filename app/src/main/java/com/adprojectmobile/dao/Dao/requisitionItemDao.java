package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface requisitionItemDao {
    public RequisitionItem getRequisitionItem(int id);
    public List<RequisitionItem> getAllRequisitionItems();
    public List<RequisitionItem> getItemsInRequisition(Requisition requisition);
    public List<RequisitionItem> getItemsInDepartment(Department department);
    public List<RequisitionItem> getItemsByDisbursementID(String id);
    public void saveRetrievalQty(RequisitionItem requisitionItem);
}
