package com.adprojectmobile.model;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Item {
    private int itemId;
    private Category category;
    private String photoFileName;
    private String description;
    private int reorderLevel;
    private int reorderQuantity;
    private String bin;
    private String unitOfMeasurement;
    private boolean isInInventory;

    public Item(int itemId, Category category, String photoFileName, String description, int reorderLevel, int reorderQuantity, String bin, String unitOfMeasurement, boolean isInInventory) {
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

    public Item(String description, int itemId, Category category) {
        this.description = description;
        this.itemId = itemId;
        this.category = category;
        this.photoFileName = photoFileName;
    }

    public Item() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
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
}