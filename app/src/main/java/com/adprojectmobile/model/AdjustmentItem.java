package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class AdjustmentItem{
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
}
