package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/24.
 */

public class adjustmentItemDaoImpl implements adjustmentItemDao {
    @Override
    public AdjustmentItem getAdjustmentItem(int id) {
        return DummyData.adjustmentItems.get(id);
    }

    @Override
    public List<AdjustmentItem> getAllAdjustmentItems() {
        return DummyData.adjustmentItems;
    }

    @Override
    public List<AdjustmentItem> getAdjustmentItemsByAdjustment(Adjustment adjustment) {
        List<AdjustmentItem> adjustmentItems=this.getAllAdjustmentItems();
        List<AdjustmentItem> returnList=new ArrayList<>();

        for (AdjustmentItem adj:adjustmentItems
                ) {
            Adjustment a=adj.getAdjustment();
            if(a!=null&&adjustment!=null){
                boolean compare= a.getAdjustmentId().equals(adjustment.getAdjustmentId());
                if (compare){
                    returnList.add(adj);
                }
            }
        }
        return returnList;
    }
}
