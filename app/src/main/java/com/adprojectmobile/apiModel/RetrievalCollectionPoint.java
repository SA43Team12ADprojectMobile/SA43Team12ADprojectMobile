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
    private String date;

    public RetrievalCollectionPoint(String collectionPointID, String collectionPointName, JSONArray itemJson, String prepared, String date) {
        this.collectionPointID = collectionPointID;
        this.collectionPointName = collectionPointName;
        this.itemJson = itemJson;
        this.prepared = prepared;
        this.date = date;
    }

    public RetrievalCollectionPoint(String collectionPointID, String collectionPointName, String prepared, String date) {
        this.collectionPointID = collectionPointID;
        this.collectionPointName = collectionPointName;
        this.prepared = prepared;
        this.date = date;
    }

    public RetrievalCollectionPoint() {
    }

    protected RetrievalCollectionPoint(Parcel in) {
        collectionPointID = in.readString();
        collectionPointName = in.readString();
        prepared = in.readString();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionPointID);
        dest.writeString(collectionPointName);
        dest.writeString(prepared);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
