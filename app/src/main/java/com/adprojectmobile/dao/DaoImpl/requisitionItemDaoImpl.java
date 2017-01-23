package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class requisitionItemDaoImpl implements requisitionItemDao {
    @Override
    public RequisitionItem getRequisitionItem(int id) {
        return DummyData.requisitionItems.get(id);
    }

    @Override
    public List<RequisitionItem> getRequisitionItemsByRequisition(Requisition requisition) {
        List<RequisitionItem> requisitionItemList=DummyData.requisitionItems;
        RequisitionItem reqItem;
        List<RequisitionItem> reqItemsInReq=new ArrayList<>();
        for (RequisitionItem req:requisitionItemList
             ) {
            if (req.getRequisition().getRequisitionId()==requisition.getRequisitionId()){
                reqItem=req;
                reqItemsInReq.add(reqItem);
            }
        }
        return reqItemsInReq;
    }

    @Override
    public List<RequisitionItem> getAllRequisitionItems() {
        return DummyData.requisitionItems;
    }

    @Override
    public List<RequisitionItem> getItemsInRequisition(Requisition requisition) {
        List<RequisitionItem> requisitionItemList=DummyData.requisitionItems;
        List<RequisitionItem> requisitionsItemInReq=new ArrayList<RequisitionItem>() ;
        for (RequisitionItem req:requisitionsItemInReq) {
            if (req.getRequisition().getRequisitionId()==requisition.getRequisitionId()){
                RequisitionItem requisitionItem=req;
                requisitionsItemInReq.add(req);
            }
        }
        return requisitionsItemInReq;
    }
}
