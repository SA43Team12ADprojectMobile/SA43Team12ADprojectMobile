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
    public List<RequisitionItem> getAllRequisitionItems() {
        return DummyData.requisitionItems;
    }


    @Override
    public List<RequisitionItem> getItemsInRequisition(Requisition requisition) {
        List<RequisitionItem> requisitionItemList=DummyData.requisitionItems;
        List<RequisitionItem> requisitionsItemInReq = new ArrayList<RequisitionItem>();
        for (RequisitionItem req : requisitionItemList) {

                Requisition comparereq=req.getRequisition();
                if (comparereq.getRequisitionId().contains(requisition.getRequisitionId())) {
                    RequisitionItem requisitionItem = req;
                    requisitionsItemInReq.add(requisitionItem);
                }

        }
        return requisitionsItemInReq;
    }

    @Override
    public void saveRetrievalQty(RequisitionItem requisitionItem) {



        if(DummyData.requisitionItems.contains(requisitionItem)){
            DummyData.requisitionItems.remove(requisitionItem);
        }
        DummyData.requisitionItems.add(requisitionItem.getRequisitionItemId(),requisitionItem);

    }
}
