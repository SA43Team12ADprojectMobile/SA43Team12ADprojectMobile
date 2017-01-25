package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class ItemTransaction implements Parcelable{
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

    protected ItemTransaction(Parcel in) {
        itemTransactionId = in.readInt();
        date = in.readString();
        actualQuantity = in.readInt();
    }

    public static final Creator<ItemTransaction> CREATOR = new Creator<ItemTransaction>() {
        @Override
        public ItemTransaction createFromParcel(Parcel in) {
            return new ItemTransaction(in);
        }

        @Override
        public ItemTransaction[] newArray(int size) {
            return new ItemTransaction[size];
        }
    };

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
    public String getActualQuantityStr() {
        Integer integer=actualQuantity;
        String str=integer.toString();
        return str;
    }

    public void setActualQuantity(int actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemTransactionId);
        dest.writeString(date);
        dest.writeInt(actualQuantity);
    }
}
