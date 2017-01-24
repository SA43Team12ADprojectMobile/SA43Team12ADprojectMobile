package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class AdjustmentItem implements Parcelable{
    private int adjustmentItemsId;
    private Adjustment adjustment;
    private ItemTransaction itemTransaction;
    private String reason;

    public AdjustmentItem() {
    }

    public AdjustmentItem(int adjustmentItemsId,Adjustment adjustment, ItemTransaction itemTransaction, String reason) {
        this.adjustmentItemsId=adjustmentItemsId;
        this.adjustment = adjustment;
        this.itemTransaction = itemTransaction;
        this.reason = reason;
    }

    public AdjustmentItem(int adjustmentItemsId,Adjustment adjustment, ItemTransaction itemTransaction) {
        this.adjustmentItemsId=adjustmentItemsId;
        this.adjustment = adjustment;
        this.itemTransaction = itemTransaction;
    }

    protected AdjustmentItem(Parcel in) {
        adjustmentItemsId = in.readInt();
        adjustment = in.readParcelable(Adjustment.class.getClassLoader());
        itemTransaction = in.readParcelable(ItemTransaction.class.getClassLoader());
        reason = in.readString();
    }

    public static final Creator<AdjustmentItem> CREATOR = new Creator<AdjustmentItem>() {
        @Override
        public AdjustmentItem createFromParcel(Parcel in) {
            return new AdjustmentItem(in);
        }

        @Override
        public AdjustmentItem[] newArray(int size) {
            return new AdjustmentItem[size];
        }
    };

    public Adjustment getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Adjustment adjustment) {
        this.adjustment = adjustment;
    }

    public ItemTransaction getItemTransaction() {
        return itemTransaction;
    }

    public void setItemTransaction(ItemTransaction itemTransaction) {
        this.itemTransaction = itemTransaction;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(adjustmentItemsId);
        dest.writeParcelable(adjustment, flags);
        dest.writeParcelable(itemTransaction, flags);
        dest.writeString(reason);
    }
}
