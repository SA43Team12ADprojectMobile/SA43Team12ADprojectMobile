package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/19.
 */

public class CollectionPoint implements Parcelable{
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

    protected CollectionPoint(Parcel in) {
        collectionPointId = in.readInt();
        collectionPointName = in.readString();
        deliverBy = in.readString();
    }

    public static final Creator<CollectionPoint> CREATOR = new Creator<CollectionPoint>() {
        @Override
        public CollectionPoint createFromParcel(Parcel in) {
            return new CollectionPoint(in);
        }

        @Override
        public CollectionPoint[] newArray(int size) {
            return new CollectionPoint[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(collectionPointId);
        dest.writeString(collectionPointName);
        dest.writeString(deliverBy);
    }
}
