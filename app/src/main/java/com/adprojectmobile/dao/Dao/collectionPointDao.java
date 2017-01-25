package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.CollectionPoint;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface collectionPointDao {
    public CollectionPoint getCollectionPoint(int id);
    public List<CollectionPoint> getAllCollectionPoints();
}
