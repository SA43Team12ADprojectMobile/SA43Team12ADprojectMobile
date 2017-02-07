package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/31.
 */

public class Disbursement implements Parcelable{
    public String DisbursementID ;
    public String CollectionPointName ;
    public String RetrievalDate ;
    public String DeliveryStatus ;
    public String RepName ;
    public String RepChecked ;
    public String ClerkChecked ;

    public Disbursement() {
    }

    public Disbursement(String disbursementID, String collectionPointName, String retrievalDate, String deliveryStatus, String repName, String repChecked, String clerkChecked) {
        DisbursementID = disbursementID;
        CollectionPointName = collectionPointName;
        RetrievalDate = retrievalDate;
        DeliveryStatus = deliveryStatus;
        RepName = repName;
        RepChecked = repChecked;
        ClerkChecked = clerkChecked;
    }

    protected Disbursement(Parcel in) {
        DisbursementID = in.readString();
        CollectionPointName = in.readString();
        RetrievalDate = in.readString();
        DeliveryStatus = in.readString();
        RepName = in.readString();
        RepChecked = in.readString();
        ClerkChecked = in.readString();
    }

    public static final Creator<Disbursement> CREATOR = new Creator<Disbursement>() {
        @Override
        public Disbursement createFromParcel(Parcel in) {
            return new Disbursement(in);
        }

        @Override
        public Disbursement[] newArray(int size) {
            return new Disbursement[size];
        }
    };

    public String getDisbursementID() {
        return DisbursementID;
    }

    public void setDisbursementID(String disbursementID) {
        DisbursementID = disbursementID;
    }

    public String getCollectionPointName() {
        return CollectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        CollectionPointName = collectionPointName;
    }

    public String getRetrievalDate() {
        return RetrievalDate;
    }

    public void setRetrievalDate(String retrievalDate) {
        RetrievalDate = retrievalDate;
    }

    public String getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        DeliveryStatus = deliveryStatus;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(DisbursementID);
        dest.writeString(CollectionPointName);
        dest.writeString(RetrievalDate);
        dest.writeString(DeliveryStatus);
        dest.writeString(RepName);
        dest.writeString(RepChecked);
        dest.writeString(ClerkChecked);
    }
}
