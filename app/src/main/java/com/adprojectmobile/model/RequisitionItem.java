package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/19.
 */

public class RequisitionItem implements Parcelable{
    private String requisitionItemId;
    private String transactionID;
    private String name;
    private String neededQuantity;
    private String retrievedQuantity;

    public RequisitionItem(String transactionID, String name, String neededQuantity, String retrievedQuantity) {
        this.transactionID = transactionID;
        this.name = name;
        this.neededQuantity = neededQuantity;
        this.retrievedQuantity = retrievedQuantity;

    }

    protected RequisitionItem(Parcel in) {
        requisitionItemId = in.readString();
        transactionID = in.readString();
        name = in.readString();
        neededQuantity = in.readString();
        retrievedQuantity = in.readString();
    }

    public static final Creator<RequisitionItem> CREATOR = new Creator<RequisitionItem>() {
        @Override
        public RequisitionItem createFromParcel(Parcel in) {
            return new RequisitionItem(in);
        }

        @Override
        public RequisitionItem[] newArray(int size) {
            return new RequisitionItem[size];
        }
    };

    public String getRequisitionItemId() {
        return requisitionItemId;
    }

    public void setRequisitionItemId(String requisitionItemId) {
        this.requisitionItemId = requisitionItemId;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeededQuantity() {
        return neededQuantity;
    }

    public void setNeededQuantity(String neededQuantity) {
        this.neededQuantity = neededQuantity;
    }

    public String getRetrievedQuantity() {
        return retrievedQuantity;
    }

    public void setRetrievedQuantity(String retrievedQuantity) {
        this.retrievedQuantity = retrievedQuantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(requisitionItemId);
        dest.writeString(transactionID);
        dest.writeString(name);
        dest.writeString(neededQuantity);
        dest.writeString(retrievedQuantity);
    }
}
