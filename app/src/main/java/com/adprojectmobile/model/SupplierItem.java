package com.adprojectmobile.model;

/**
 * Created by EvEr on 2017/1/19.
 */

public class SupplierItem {
    private int supplierItemId;
    private Supplier supplier;
    private Item item;
    private float tenderPrice;
    private int priority;

    public SupplierItem(int supplierItemId, Supplier supplier, Item item, float tenderPrice, int priority) {
        this.supplierItemId = supplierItemId;
        this.supplier = supplier;
        this.item = item;
        this.tenderPrice = tenderPrice;
        this.priority = priority;
    }


    public SupplierItem() {


    }

    public int getSupplierItemId() {
        return supplierItemId;
    }

    public void setSupplierItemId(int supplierItemId) {
        this.supplierItemId = supplierItemId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getTenderPrice() {
        return tenderPrice;
    }

    public void setTenderPrice(float tenderPrice) {
        this.tenderPrice = tenderPrice;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
