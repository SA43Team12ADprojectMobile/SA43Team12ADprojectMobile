package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by EvEr on 2017/1/26.
 */

public class RetrievalCollectionPoint implements Parcelable{
    private String collectionPointID;
    private String collectionPointName;
   private JSONArray itemJson;
    private String prepared;
    private String itemID;

    public RetrievalCollectionPoint(String collectionPointID, String collectionPointName, JSONArray itemJson, String prepared) {
        this.collectionPointID = collectionPointID;
        this.collectionPointName = collectionPointName;
        this.itemJson = itemJson;
        this.prepared = prepared;
    }

    public RetrievalCollectionPoint(String collectionPointID, String collectionPointName, String prepared) {
        this.collectionPointID = collectionPointID;
        this.collectionPointName = collectionPointName;
        this.prepared = prepared;
    }

    protected RetrievalCollectionPoint(Parcel in) {
        collectionPointID = in.readString();
        collectionPointName = in.readString();
        prepared = in.readString();
    }

    public static final Creator<RetrievalCollectionPoint> CREATOR = new Creator<RetrievalCollectionPoint>() {
        @Override
        public RetrievalCollectionPoint createFromParcel(Parcel in) {
            return new RetrievalCollectionPoint(in);
        }

        @Override
        public RetrievalCollectionPoint[] newArray(int size) {
            return new RetrievalCollectionPoint[size];
        }
    };

    public String getCollectionPointID() {
        return collectionPointID;
    }

    public void setCollectionPointID(String collectionPointID) {
        this.collectionPointID = collectionPointID;
    }

    public String getCollectionPointName() {
        return collectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        this.collectionPointName = collectionPointName;
    }

    public RetrievalCollectionPoint() {
    }

    public JSONArray getItemJson() {

        return itemJson;
    }

    public void setItemJson(JSONArray itemJson) {
        this.itemJson = itemJson;
    }

    public String getPrepared() {
        return prepared;
    }

    public void setPrepared(String prepared) {
        this.prepared = prepared;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionPointID);
        dest.writeString(collectionPointName);
        dest.writeString(prepared);
    }
}
