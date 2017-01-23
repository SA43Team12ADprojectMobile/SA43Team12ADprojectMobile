package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.itemDao;
import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/23.
 */

public class itemDaoImpl implements itemDao {
    @Override
    public Item getItem(int id) {
        return DummyData.items.get(id);
    }

    @Override
    public List<Item> getAllItem() {
        return DummyData.items;
    }

    @Override
    public List<Item> getItemByItemTransaction(ItemTransaction itemTransaction) {
        List<Item> returnList=new ArrayList<>();
        List<ItemTransaction> itemTransactions=DummyData.itemTransactions;
        for (ItemTransaction req:itemTransactions
                ) {
            if (req!=null){
                ItemTransaction itemCompare=req;
                if(itemCompare.equals(itemTransaction)){
                    Item item=req.getItem();
                    returnList.add(item);
                }
            }

        }
        return returnList;

    }
}
