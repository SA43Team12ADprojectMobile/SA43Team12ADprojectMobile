package com.adprojectmobile.dao.DaoImpl;

/**
 * Created by EvEr on 2017/1/22.
 */


import com.adprojectmobile.dao.Dao.collectionPointDao;
import com.adprojectmobile.model.CollectionPoint;
import com.adprojectmobile.testdata.testDummyData;
import com.adprojectmobile.util.DummyData;

import java.util.List;

public class collectionPointDaoImpl implements collectionPointDao {
    public CollectionPoint getCollectionPoint(int id) {
        return DummyData.collectionPoints.get(id);
    }
    @Override
        public List<CollectionPoint> getAllCollectionPoints() {
            return DummyData.collectionPoints;
    }
}
