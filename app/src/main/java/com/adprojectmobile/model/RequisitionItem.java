package com.adprojectmobile.model;

/**
 * Created by EvEr on 2017/1/19.
 */

public class RequisitionItem {
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
}
