package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class DepartmentApi implements Parcelable {
    public String DisbursementID;

    public String RetrievalTime;
    public String DeliveryStatus;
    public String CollectionPointName;
    public String RepName ;

    public String RepChecked ;
    public String ClerkChecked;

    public String DepartmentName ;
    public String ContactName ;
    public String TelephoneNumber ;
    public String Description ;
    public String ItemID ;
    public String ActualQty;
    public String NeededQty;

    public DepartmentApi() {
    }

    public DepartmentApi(String disbursementID, String retrievalTime, String deliveryStatus, String collectionPointName, String repName, String repChecked, String clerkChecked, String departmentName, String contactName, String telephoneNumber, String description, String itemID, String actualQty, String neededQty) {
        DisbursementID = disbursementID;
        RetrievalTime = retrievalTime;
        DeliveryStatus = deliveryStatus;
        CollectionPointName = collectionPointName;
        RepName = repName;
        RepChecked = repChecked;
        ClerkChecked = clerkChecked;
        DepartmentName = departmentName;
        ContactName = contactName;
        TelephoneNumber = telephoneNumber;
        Description = description;
        ItemID = itemID;
        ActualQty = actualQty;
        NeededQty = neededQty;
    }


    protected DepartmentApi(Parcel in) {
        DisbursementID = in.readString();
        RetrievalTime = in.readString();
        DeliveryStatus = in.readString();
        CollectionPointName = in.readString();
        RepName = in.readString();
        RepChecked = in.readString();
        ClerkChecked = in.readString();
        DepartmentName = in.readString();
        ContactName = in.readString();
        TelephoneNumber = in.readString();
        Description = in.readString();
        ItemID = in.readString();
        ActualQty = in.readString();
        NeededQty = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(DisbursementID);
        dest.writeString(RetrievalTime);
        dest.writeString(DeliveryStatus);
        dest.writeString(CollectionPointName);
        dest.writeString(RepName);
        dest.writeString(RepChecked);
        dest.writeString(ClerkChecked);
        dest.writeString(DepartmentName);
        dest.writeString(ContactName);
        dest.writeString(TelephoneNumber);
        dest.writeString(Description);
        dest.writeString(ItemID);
        dest.writeString(ActualQty);
        dest.writeString(NeededQty);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getDisbursementID() {
        return DisbursementID;
    }

    public void setDisbursementID(String disbursementID) {
        DisbursementID = disbursementID;
    }

    public String getRetrievalTime() {
        return RetrievalTime;
    }

    public void setRetrievalTime(String retrievalTime) {
        RetrievalTime = retrievalTime;
    }

    public String getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        DeliveryStatus = deliveryStatus;
    }

    public String getCollectionPointName() {
        return CollectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        CollectionPointName = collectionPointName;
    }

    public String getRepName() {
        return RepName;
    }

    public void setRepName(String repName) {
        RepName = repName;
    }

    public String getRepChecked() {
        return RepChecked;
    }

    public void setRepChecked(String repChecked) {
        RepChecked = repChecked;
    }

    public String getClerkChecked() {
        return ClerkChecked;
    }

    public void setClerkChecked(String clerkChecked) {
        ClerkChecked = clerkChecked;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getActualQty() {
        return ActualQty;
    }

    public void setActualQty(String actualQty) {
        ActualQty = actualQty;
    }

    public String getNeededQty() {
        return NeededQty;
    }

    public void setNeededQty(String neededQty) {
        NeededQty = neededQty;
    }
}
