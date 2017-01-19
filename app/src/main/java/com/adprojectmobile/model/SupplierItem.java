package com.adprojectmobile.model;

/**
 * Created by EvEr on 2017/1/19.
 */

public class SupplierItem {
    private int supplierItemId;
    private Supplier supplier;
    private Item item;
    private double tenderPrice;
    private String priority;

    public SupplierItem(int supplierItemId, Supplier supplier, Item item, double tenderPrice, String priority) {
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

    public double getTenderPrice() {
        return tenderPrice;
    }

    public void setTenderPrice(double tenderPrice) {
        this.tenderPrice = tenderPrice;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
