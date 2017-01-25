package com.adprojectmobile.testdata;

import java.util.List;

/**
 * Created by EvEr on 2017/1/18.
 */

public class testDaoImpl implements testDao {
    @Override
    public testCollectionPoint getCollectionPoint(int id) {
        return testDummyData.collectionPoints.get(id);
    }
    @Override
    public List<testCollectionPoint> getAllCollectionPoints() {
        return testDummyData.collectionPoints;
    }


}
