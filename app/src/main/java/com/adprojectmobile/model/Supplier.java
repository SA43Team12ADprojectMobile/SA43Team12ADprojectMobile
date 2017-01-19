package com.adprojectmobile.model;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String contactName;
    private int phoneNumber;
    private int faxNumber;
    private String address;
    private int gstRegistrationNumber;


    public Supplier() {
    }

    public Supplier(int supplierId, String supplierName, String contactName, int phoneNumber) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public Supplier(int supplierId, String supplierName, String contactName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactName = contactName;
    }

    public Supplier(int supplierId, String supplierName, String contactName, int phoneNumber, int faxNumber, String address, int gstRegistrationNumber) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.address = address;
        this.gstRegistrationNumber = gstRegistrationNumber;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(int faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGstRegistrationNumber() {
        return gstRegistrationNumber;
    }

    public void setGstRegistrationNumber(int gstRegistrationNumber) {
        this.gstRegistrationNumber = gstRegistrationNumber;
    }

}
