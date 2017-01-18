package com.adprojectmobile.testdata;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/17.
 */

public class testCollectionPointModel {
    private int collctionPoingId;
    private String collectionPointName;
    private String deliverDate;

    public testCollectionPointModel() {
    }

    public testCollectionPointModel(int collctionPoingId, String collectionPointName) {
        this.collctionPoingId = collctionPoingId;
        this.collectionPointName = collectionPointName;
    }

    public testCollectionPointModel(int collctionPoingId, String collectionPointName, String deliverDate) {

        this.collctionPoingId = collctionPoingId;
        this.collectionPointName = collectionPointName;
        this.deliverDate = deliverDate;
    }

    public int getCollctionPoingId() {
        return collctionPoingId;
    }

    public void setCollctionPoingId(int collctionPoingId) {
        this.collctionPoingId = collctionPoingId;
    }

    public String getCollectionPointName() {
        return collectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        this.collectionPointName = collectionPointName;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }
}

