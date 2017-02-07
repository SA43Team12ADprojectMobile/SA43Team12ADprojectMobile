package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/26.
 */

public class RetrievalItem implements Parcelable{

    private String id;
    private String name;
    private String qtyNeeded;
    private String qtyRetrieved;

    public RetrievalItem(String id, String name, String qtyNeeded, String qtyRetrieved) {
        this.id = id;
        this.name = name;
        this.qtyNeeded = qtyNeeded;
        this.qtyRetrieved = qtyRetrieved;
    }

    protected RetrievalItem(Parcel in) {
        id = in.readString();
        name = in.readString();
        qtyNeeded = in.readString();
        qtyRetrieved = in.readString();
    }

    public static final Creator<RetrievalItem> CREATOR = new Creator<RetrievalItem>() {
        @Override
        public RetrievalItem createFromParcel(Parcel in) {
            return new RetrievalItem(in);
        }

        @Override
        public RetrievalItem[] newArray(int size) {
            return new RetrievalItem[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQtyNeeded() {
        return qtyNeeded;
    }

    public void setQtyNeeded(String qtyNeeded) {
        this.qtyNeeded = qtyNeeded;
    }

    public String getQtyRetrieved() {
        return qtyRetrieved;
    }

    public void setQtyRetrieved(String qtyRetrieved) {
        this.qtyRetrieved = qtyRetrieved;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(qtyNeeded);
        dest.writeString(qtyRetrieved);
    }
}
