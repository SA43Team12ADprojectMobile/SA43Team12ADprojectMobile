package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class PurchaseOrderItem{

    private int purchaseOrderItemId;
    private PurchaseOrder purchaseOrder;
    private ItemTransaction itemTransaction;
    private int neededQuantity;

    public PurchaseOrderItem() {
    }

    public PurchaseOrderItem(int purchaseOrderItemId, PurchaseOrder purchaseOrder, ItemTransaction itemTransaction, int neededQuantity) {
        this.purchaseOrderItemId = purchaseOrderItemId;
        this.purchaseOrder = purchaseOrder;
        this.itemTransaction = itemTransaction;
        this.neededQuantity = neededQuantity;
    }

    public int getPurchaseOrderItemId() {
        return purchaseOrderItemId;
    }

    public void setPurchaseOrderItemId(int purchaseOrderItemId) {
        this.purchaseOrderItemId = purchaseOrderItemId;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
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
}
