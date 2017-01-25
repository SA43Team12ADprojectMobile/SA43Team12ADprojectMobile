package com.adprojectmobile.model;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Supplier {
    private String supplierId;
    private String supplierName;
    private String contactName;
    private String phoneNumber;
    private String faxNumber;
    private String address;
    private String gstRegistrationNumber;


    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, String contactName, String phoneNumber) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public Supplier(String supplierId, String supplierName, String contactName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactName = contactName;
    }

    public Supplier(String supplierId, String supplierName, String contactName, String phoneNumber, String faxNumber, String address, String gstRegistrationNumber) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.address = address;
        this.gstRegistrationNumber = gstRegistrationNumber;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGstRegistrationNumber() {
        return gstRegistrationNumber;
    }

    public void setGstRegistrationNumber(String gstRegistrationNumber) {
        this.gstRegistrationNumber = gstRegistrationNumber;
    }

}
