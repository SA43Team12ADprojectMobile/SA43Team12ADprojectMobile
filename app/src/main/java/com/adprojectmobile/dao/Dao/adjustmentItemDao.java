package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface adjustmentItemDao {
    public AdjustmentItem getAdjustmentItem(int id);
    public List<AdjustmentItem> getAllAdjustmentItems();
    public List<AdjustmentItem> getAdjustmentItemsByAdjustment(Adjustment adjustment);
}
