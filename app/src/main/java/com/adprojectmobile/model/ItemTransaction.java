package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class ItemTransaction{
    private int itemTransactionId;
    private Item item;
    private String date;
    private int actualQuantity;

    public ItemTransaction() {
    }

    public ItemTransaction(int itemTransactionId, Item item, String date, int actualQuantity) {
        this.itemTransactionId = itemTransactionId;
        this.item = item;
        this.date = date;
        this.actualQuantity = actualQuantity;
    }

    public int getItemTransactionId() {
        return itemTransactionId;
    }

    public void setItemTransactionId(int itemTransactionId) {
        this.itemTransactionId = itemTransactionId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(int actualQuantity) {
        this.actualQuantity = actualQuantity;
    }
}
