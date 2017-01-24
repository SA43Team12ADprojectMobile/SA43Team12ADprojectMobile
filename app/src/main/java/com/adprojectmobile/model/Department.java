package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Department implements Parcelable {
    private String departmentId;
    private String departmentName;
    private String contactName;
    private int telephoneNumber;
    private int faxNumber;
    private CollectionPoint collectionPoint;

    public Department() {
    }

    public Department(String departmentId, String departmentName, String contactName, int telephoneNumber, int faxNumber, CollectionPoint collectionPoint) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.contactName = contactName;
        this.telephoneNumber = telephoneNumber;
        this.faxNumber = faxNumber;
        this.collectionPoint = collectionPoint;
    }

    protected Department(Parcel in) {
        departmentId = in.readString();
        departmentName = in.readString();
        contactName = in.readString();
        telephoneNumber = in.readInt();
        faxNumber = in.readInt();
        collectionPoint = in.readParcelable(CollectionPoint.class.getClassLoader());
    }

    public static final Creator<Department> CREATOR = new Creator<Department>() {
        @Override
        public Department createFromParcel(Parcel in) {
            return new Department(in);
        }

        @Override
        public Department[] newArray(int size) {
            return new Department[size];
        }
    };

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
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
    public String getTelephoneNumberStr() {
        Integer integer=telephoneNumber;
        String str=integer.toString();
        return str;
    }
    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getFaxNumber() {
        return faxNumber;
    }
    public String getFaxNumberStr() {
        Integer integer=faxNumber;
        String str=integer.toString();
        return str;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departmentId);
        dest.writeString(departmentName);
        dest.writeString(contactName);
        dest.writeInt(telephoneNumber);
        dest.writeInt(faxNumber);
        dest.writeParcelable(collectionPoint, flags);
    }
}
