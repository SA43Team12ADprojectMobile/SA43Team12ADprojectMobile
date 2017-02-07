package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class RequisitionItem implements Parcelable{
    public String ItemCode ;
    public String ItemName ;
    public String Quantity ;
    public String NeededQuantity ;
    public String RetrieveQuantity;


    public RequisitionItem() {
    }

    public RequisitionItem(String itemCode, String itemName, String quantity, String neededQuantity, String retrieveQuantity) {
        ItemCode = itemCode;
        ItemName = itemName;
        Quantity = quantity;
        NeededQuantity = neededQuantity;
        RetrieveQuantity = retrieveQuantity;
    }

    protected RequisitionItem(Parcel in) {
        ItemCode = in.readString();
        ItemName = in.readString();
        Quantity = in.readString();
        NeededQuantity = in.readString();
        RetrieveQuantity = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ItemCode);
        dest.writeString(ItemName);
        dest.writeString(Quantity);
        dest.writeString(NeededQuantity);
        dest.writeString(RetrieveQuantity);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getNeededQuantity() {
        return NeededQuantity;
    }

    public void setNeededQuantity(String neededQuantity) {
        NeededQuantity = neededQuantity;
    }

    public String getRetrieveQuantity() {
        return RetrieveQuantity;
    }

    public void setRetrieveQuantity(String retrieveQuantity) {
        RetrieveQuantity = retrieveQuantity;
    }
}
