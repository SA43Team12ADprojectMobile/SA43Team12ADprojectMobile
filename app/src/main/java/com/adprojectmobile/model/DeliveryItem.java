package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/27.
 */

public class DeliveryItem implements Parcelable{
    public String Description;
    public String ActualQuantity;
    public String NeededQuantity ;
    public String TransactionID ;
    public String ItemID ;

    public DeliveryItem() {
    }

    public DeliveryItem(String description, String actualQuantity, String neededQuantity, String transactionID, String itemID) {
        Description = description;
        ActualQuantity = actualQuantity;
        NeededQuantity = neededQuantity;
        TransactionID = transactionID;
        ItemID = itemID;
    }

    protected DeliveryItem(Parcel in) {
        Description = in.readString();
        ActualQuantity = in.readString();
        NeededQuantity = in.readString();
        TransactionID = in.readString();
        ItemID = in.readString();
    }

    public static final Creator<DeliveryItem> CREATOR = new Creator<DeliveryItem>() {
        @Override
        public DeliveryItem createFromParcel(Parcel in) {
            return new DeliveryItem(in);
        }

        @Override
        public DeliveryItem[] newArray(int size) {
            return new DeliveryItem[size];
        }
    };

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Description);
        dest.writeString(ActualQuantity);
        dest.writeString(NeededQuantity);
        dest.writeString(TransactionID);
        dest.writeString(ItemID);
    }
}
