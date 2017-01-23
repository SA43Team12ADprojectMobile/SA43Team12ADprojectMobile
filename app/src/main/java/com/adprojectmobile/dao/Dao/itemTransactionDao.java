package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface itemTransactionDao {
    public ItemTransaction getItemTransaction(int id);
    public List<ItemTransaction> getAllItemTransactions();
    public List<ItemTransaction> getItemTransationsByRequisitionItem(RequisitionItem requisitionItem);
}
