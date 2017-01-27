package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.Dao.itemTransactionDao;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/23.
 */

public class itemTransactionDaoImpl implements itemTransactionDao {
    @Override
    public ItemTransaction getItemTransaction(int id) {
        return DummyData.itemTransactions.get(id);
    }

    @Override
    public List<ItemTransaction> getAllItemTransactions() {
        return DummyData.itemTransactions;
    }

    @Override
    public List<ItemTransaction> getItemTransationsByRequisitionItem(RequisitionItem requisitionItem) {
        List<ItemTransaction> returnList=new ArrayList<>();
        List<RequisitionItem> requisitionItems=DummyData.requisitionItems;
        for (RequisitionItem req:requisitionItems
             ) {
            if(req!=null&&requisitionItem!=null){
                if(req.getRequisitionItemId()==requisitionItem.getRequisitionItemId()){
//                    ItemTransaction item= req.getTransactionID();
//                    returnList.add(item);
                }
            }

        }
        return returnList;
    }

    @Override
    public ItemTransaction getItemTransactionByAdjustmentItem(AdjustmentItem adjustmentItem) {
        ItemTransaction returnItemTransaction=new ItemTransaction();
        adjustmentItemDao adjItemDao=new adjustmentItemDaoImpl();
        List<AdjustmentItem> adjustmentItems=adjItemDao.getAllAdjustmentItems();
        for (AdjustmentItem adji :
                adjustmentItems) {
            if(adji!=null&&adjustmentItem!=null){
                if (adji.getItemTransaction().equals(adjustmentItem.getItemTransaction())){
                    returnItemTransaction=adji.getItemTransaction();
                }
            }
        }
        return returnItemTransaction;
    }
}
