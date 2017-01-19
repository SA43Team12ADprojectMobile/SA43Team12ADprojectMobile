package com.adprojectmobile.model;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Department {
    private int departmentId;
    private String departmentName;
    private String contactName;
    private int telephoneNumber;
    private int faxNumber;
    private CollectionPoint collectionPoint;

    public Department() {
    }

    public Department(int departmentId, String departmentName, String contactName, int telephoneNumber, int faxNumber, CollectionPoint collectionPoint) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.contactName = contactName;
        this.telephoneNumber = telephoneNumber;
        this.faxNumber = faxNumber;
        this.collectionPoint = collectionPoint;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(int faxNumber) {
        this.faxNumber = faxNumber;
    }

    public CollectionPoint getCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(CollectionPoint collectionPoint) {
        this.collectionPoint = collectionPoint;
    }
}
