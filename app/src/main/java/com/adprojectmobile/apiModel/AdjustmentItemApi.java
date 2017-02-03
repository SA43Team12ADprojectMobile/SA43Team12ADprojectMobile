package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class AdjustmentItemApi implements Parcelable{
    private String Adjustment_ItemsID ;
    private String AdjustmentID ;
    private String ItemTransactionID ;
    private String ItemID ;
    private String Description ;
    private String TenderPrice ;
    private String ActualQuantity ;
    private String Reason ;
    public AdjustmentItemApi() {
    }

    public AdjustmentItemApi(String itemID, String description, String tenderPrice) {
        ItemID = itemID;
        Description = description;
        TenderPrice = tenderPrice;
    }

    public AdjustmentItemApi(String adjustment_ItemsID, String adjustmentID, String itemTransactionID, String itemID, String description, String tenderPrice, String actualQuantity, String reason) {
        Adjustment_ItemsID = adjustment_ItemsID;
        AdjustmentID = adjustmentID;
        ItemTransactionID = itemTransactionID;
        ItemID = itemID;
        Description = description;
        TenderPrice = tenderPrice;
        ActualQuantity = actualQuantity;
        Reason = reason;
    }

    protected AdjustmentItemApi(Parcel in) {
        Adjustment_ItemsID = in.readString();
        AdjustmentID = in.readString();
        ItemTransactionID = in.readString();
        ItemID = in.readString();
        Description = in.readString();
        TenderPrice = in.readString();
        ActualQuantity = in.readString();
        Reason = in.readString();
    }

    public static final Creator<AdjustmentItemApi> CREATOR = new Creator<AdjustmentItemApi>() {
        @Override
        public AdjustmentItemApi createFromParcel(Parcel in) {
            return new AdjustmentItemApi(in);
        }

        @Override
        public AdjustmentItemApi[] newArray(int size) {
            return new AdjustmentItemApi[size];
        }
    };

    public String getAdjustment_ItemsID() {
        return Adjustment_ItemsID;
    }

    public void setAdjustment_ItemsID(String adjustment_ItemsID) {
        Adjustment_ItemsID = adjustment_ItemsID;
    }

    public String getAdjustmentID() {
        return AdjustmentID;
    }

    public void setAdjustmentID(String adjustmentID) {
        AdjustmentID = adjustmentID;
    }

    public String getItemTransactionID() {
        return ItemTransactionID;
    }

    public void setItemTransactionID(String itemTransactionID) {
        ItemTransactionID = itemTransactionID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTenderPrice() {
        return TenderPrice;
    }

    public void setTenderPrice(String tenderPrice) {
        TenderPrice = tenderPrice;
    }

    public String getActualQuantity() {
        return ActualQuantity;
    }

    public void setActualQuantity(String actualQuantity) {
        ActualQuantity = actualQuantity;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Adjustment_ItemsID);
        dest.writeString(AdjustmentID);
        dest.writeString(ItemTransactionID);
        dest.writeString(ItemID);
        dest.writeString(Description);
        dest.writeString(TenderPrice);
        dest.writeString(ActualQuantity);
        dest.writeString(Reason);
    }
}
