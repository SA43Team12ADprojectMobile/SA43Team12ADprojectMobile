package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/31.
 */

public class DisbursementItem implements Parcelable{
    public String Description ;
    public String UnitMeasured ;
    public String RetrievedQuantity ;
    public String ActualQuantity ;
    public String NeededQuantity ;
    public String TransactionID ;
    public String ItemID ;
    public String DisburseID ;

    public DisbursementItem() {
    }

    public DisbursementItem(String description, String unitMeasured, String retrievedQuantity, String actualQuantity, String neededQuantity, String transactionID, String itemID, String disburseID) {
        Description = description;
        UnitMeasured = unitMeasured;
        RetrievedQuantity = retrievedQuantity;
        ActualQuantity = actualQuantity;
        NeededQuantity = neededQuantity;
        TransactionID = transactionID;
        ItemID = itemID;
        DisburseID = disburseID;
    }

    protected DisbursementItem(Parcel in) {
        Description = in.readString();
        UnitMeasured = in.readString();
        RetrievedQuantity = in.readString();
        ActualQuantity = in.readString();
        NeededQuantity = in.readString();
        TransactionID = in.readString();
        ItemID = in.readString();
        DisburseID = in.readString();
    }

    public static final Creator<DisbursementItem> CREATOR = new Creator<DisbursementItem>() {
        @Override
        public DisbursementItem createFromParcel(Parcel in) {
            return new DisbursementItem(in);
        }

        @Override
        public DisbursementItem[] newArray(int size) {
            return new DisbursementItem[size];
        }
    };

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUnitMeasured() {
        return UnitMeasured;
    }

    public void setUnitMeasured(String unitMeasured) {
        UnitMeasured = unitMeasured;
    }

    public String getRetrievedQuantity() {
        return RetrievedQuantity;
    }

    public void setRetrievedQuantity(String retrievedQuantity) {
        RetrievedQuantity = retrievedQuantity;
    }

    public String getActualQuantity() {
        return ActualQuantity;
    }

    public void setActualQuantity(String actualQuantity) {
        ActualQuantity = actualQuantity;
    }

    public String getNeededQuantity() {
        return NeededQuantity;
    }

    public void setNeededQuantity(String neededQuantity) {
        NeededQuantity = neededQuantity;
    }

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String transactionID) {
        TransactionID = transactionID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getDisburseID() {
        return DisburseID;
    }

    public void setDisburseID(String disburseID) {
        DisburseID = disburseID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Description);
        dest.writeString(UnitMeasured);
        dest.writeString(RetrievedQuantity);
        dest.writeString(ActualQuantity);
        dest.writeString(NeededQuantity);
        dest.writeString(TransactionID);
        dest.writeString(ItemID);
        dest.writeString(DisburseID);
    }
}
