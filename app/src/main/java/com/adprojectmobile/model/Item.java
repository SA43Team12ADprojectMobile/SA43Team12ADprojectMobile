package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Item implements Parcelable{
    private String itemId;
    private Category category;
    private String photoFileName;
    private String description;
    private int reorderLevel;
    private int reorderQuantity;
    private String bin;
    private String unitOfMeasurement;
    private boolean isInInventory;

    public Item(String itemId, Category category, String photoFileName, String description, int reorderLevel, int reorderQuantity, String bin, String unitOfMeasurement, boolean isInInventory) {
        this.itemId = itemId;
        this.category = category;
        this.photoFileName = photoFileName;
        this.description = description;
        this.reorderLevel = reorderLevel;
        this.reorderQuantity = reorderQuantity;
        this.bin = bin;
        this.unitOfMeasurement = unitOfMeasurement;
        this.isInInventory = isInInventory;
    }

    public Item( String itemId, Category category,String description,String unitOfMeasurement) {
        this.description = description;
        this.itemId = itemId;
        this.category = category;
        this.unitOfMeasurement=unitOfMeasurement;

    }

    public Item() {
    }

    protected Item(Parcel in) {
        itemId = in.readString();
        photoFileName = in.readString();
        description = in.readString();
        reorderLevel = in.readInt();
        reorderQuantity = in.readInt();
        bin = in.readString();
        unitOfMeasurement = in.readString();
        isInInventory = in.readByte() != 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public int getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(int reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemId);
        dest.writeString(photoFileName);
        dest.writeString(description);
        dest.writeInt(reorderLevel);
        dest.writeInt(reorderQuantity);
        dest.writeString(bin);
        dest.writeString(unitOfMeasurement);
        dest.writeByte((byte) (isInInventory ? 1 : 0));
    }
}