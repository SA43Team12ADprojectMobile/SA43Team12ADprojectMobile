package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface itemDao {
    public Item getItem(int id);
    public List<Item> getAllItem();
    public List<Item> getItemByItemTransaction(ItemTransaction itemTransaction);
    public Item getItemByItemTrans(ItemTransaction itemTransaction);
}
