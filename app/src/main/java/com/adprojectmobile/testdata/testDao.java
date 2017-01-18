package com.adprojectmobile.testdata;

import java.util.List;

/**
 * Created by EvEr on 2017/1/17.
 */

public interface testDao {
    public testCollectionPointModel getCollectionPoint(int id);
    public List<testCollectionPointModel> getAllCollectionPoints();
}
