package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;

/**
 * Created by EvEr on 2017/1/30.
 */

public class DepartmentApi implements Parcelable {
    public String DepartmentID ;
    public String DepartmentName ;
    public String ContactName ;
    public String TelephoneNumber ;
    public String FaxNumber ;
    public String CollectionPointID ;
    public String CollectionPointName ;
    public JSONArray Items;

    public DepartmentApi() {
    }

    public DepartmentApi(String departmentID, String departmentName, String contactName, String telephoneNumber, String faxNumber, String collectionPointID, String collectionPointName) {
        DepartmentID = departmentID;
        DepartmentName = departmentName;
        ContactName = contactName;
        TelephoneNumber = telephoneNumber;
        FaxNumber = faxNumber;
        CollectionPointID = collectionPointID;
        CollectionPointName = collectionPointName;
    }

    public DepartmentApi(String departmentID, String departmentName, String contactName, String telephoneNumber, String faxNumber, String collectionPointID, String collectionPointName, JSONArray items) {
        DepartmentID = departmentID;
        DepartmentName = departmentName;
        ContactName = contactName;
        TelephoneNumber = telephoneNumber;
        FaxNumber = faxNumber;
        CollectionPointID = collectionPointID;
        CollectionPointName = collectionPointName;
        Items = items;
    }

    protected DepartmentApi(Parcel in) {
        DepartmentID = in.readString();
        DepartmentName = in.readString();
        ContactName = in.readString();
        TelephoneNumber = in.readString();
        FaxNumber = in.readString();
        CollectionPointID = in.readString();
        CollectionPointName = in.readString();
    }

    public static final Creator<DepartmentApi> CREATOR = new Creator<DepartmentApi>() {
        @Override
        public DepartmentApi createFromParcel(Parcel in) {
            return new DepartmentApi(in);
        }

        @Override
        public DepartmentApi[] newArray(int size) {
            return new DepartmentApi[size];
        }
    };

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }

    public String getFaxNumber() {
        return FaxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        FaxNumber = faxNumber;
    }

    public String getCollectionPointID() {
        return CollectionPointID;
    }

    public void setCollectionPointID(String collectionPointID) {
        CollectionPointID = collectionPointID;
    }

    public String getCollectionPointName() {
        return CollectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        CollectionPointName = collectionPointName;
    }

    public JSONArray getItems() {
        return Items;
    }

    public void setItems(JSONArray items) {
        Items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(DepartmentID);
        dest.writeString(DepartmentName);
        dest.writeString(ContactName);
        dest.writeString(TelephoneNumber);
        dest.writeString(FaxNumber);
        dest.writeString(CollectionPointID);
        dest.writeString(CollectionPointName);
    }
}
