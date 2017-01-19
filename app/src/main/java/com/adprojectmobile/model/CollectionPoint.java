package com.adprojectmobile.model;

/**
 * Created by EvEr on 2017/1/19.
 */

public class CollectionPoint {
    private int collectionPointId;
    private String collectionPointName;
    private String deliverBy;

    public CollectionPoint(int collectionPointId, String collectionPointName, String deliverBy) {
        this.collectionPointId = collectionPointId;
        this.collectionPointName = collectionPointName;
        this.deliverBy = deliverBy;
    }

    public CollectionPoint(int collectionPointId, String collectionPointName) {

        this.collectionPointId = collectionPointId;
        this.collectionPointName = collectionPointName;
    }

    public CollectionPoint() {

    }

    public int getCollectionPointId() {
        return collectionPointId;
    }

    public void setCollectionPointId(int collectionPointId) {
        this.collectionPointId = collectionPointId;
    }

    public String getCollectionPointName() {
        return collectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        this.collectionPointName = collectionPointName;
    }

    public String getDeliverBy() {
        return deliverBy;
    }

    public void setDeliverBy(String deliverBy) {
        this.deliverBy = deliverBy;
    }
}
