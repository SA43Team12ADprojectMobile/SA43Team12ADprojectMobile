package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/19.
 */

public class RequisitionItem implements Parcelable{
    private int requisitionItemId;
    private Requisition requisition;
    private ItemTransaction itemTransaction;
    private int neededQuantity;
    private int retrievedQuantity;

    public RequisitionItem() {
    }

    public RequisitionItem(int requisitionItemId, Requisition requisition, ItemTransaction itemTransaction, int neededQuantity, int retrievedQuantity) {
        this.requisitionItemId = requisitionItemId;
        this.requisition = requisition;
        this.itemTransaction = itemTransaction;
        this.neededQuantity = neededQuantity;
        this.retrievedQuantity = retrievedQuantity;
    }

    public RequisitionItem(int requisitionItemId, Requisition requisition, ItemTransaction itemTransaction, int neededQuantity) {
        this.requisitionItemId = requisitionItemId;
        this.requisition = requisition;
        this.itemTransaction = itemTransaction;
        this.neededQuantity = neededQuantity;
    }

    protected RequisitionItem(Parcel in) {
        requisitionItemId = in.readInt();
        neededQuantity = in.readInt();
        retrievedQuantity = in.readInt();
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

    public int getRequisitionItemId() {
        return requisitionItemId;
    }

    public void setRequisitionItemId(int requisitionItemId) {
        this.requisitionItemId = requisitionItemId;
    }

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
    }

    public ItemTransaction getItemTransaction() {
        return itemTransaction;
    }

    public void setItemTransaction(ItemTransaction itemTransaction) {
        this.itemTransaction = itemTransaction;
    }

    public int getNeededQuantity() {
        return neededQuantity;
    }

    public void setNeededQuantity(int neededQuantity) {
        this.neededQuantity = neededQuantity;
    }

    public int getRetrievedQuantity() {
        return retrievedQuantity;
    }

    public void setRetrievedQuantity(int retrievedQuantity) {
        this.retrievedQuantity = retrievedQuantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(requisitionItemId);
        dest.writeInt(neededQuantity);
        dest.writeInt(retrievedQuantity);
    }
}
