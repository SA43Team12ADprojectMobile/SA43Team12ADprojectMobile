package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.adjustmentDao;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.util.DummyData;

import java.util.List;

/**
 * Created by EvEr on 2017/1/24.
 */

public class adjustmentDaoImpl implements adjustmentDao {
    @Override
    public Adjustment getAdjustment(int id) {
        return DummyData.adjustments.get(id);
    }

    @Override
    public List<Adjustment> getAllAdjustments() {
        return DummyData.adjustments;
    }
}
