package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/27.
 */

public class DeliveryDisbursement implements Parcelable{
    public String disbursementID;
    public String collectionPointName;
    public String retrievalDate;
    public String deliveryStatus;

    public String repName;

    public String cepChecked ;

    public String clerkChecked;

    public DeliveryDisbursement(String disbursementID, String collectionPointName, String retrievalDate, String deliveryStatus, String repName, String cepChecked, String clerkChecked) {
        this.disbursementID = disbursementID;
        this.collectionPointName = collectionPointName;
        this.retrievalDate = retrievalDate;
        this.deliveryStatus = deliveryStatus;
        this.repName = repName;
        this.cepChecked = cepChecked;
        this.clerkChecked = clerkChecked;
    }

    public DeliveryDisbursement() {
    }

    public DeliveryDisbursement(String disbursementID, String collectionPointName, String retrievalDate, String deliveryStatus) {
        this.disbursementID = disbursementID;
        this.collectionPointName = collectionPointName;
        this.retrievalDate = retrievalDate;
        this.deliveryStatus = deliveryStatus;
    }

    protected DeliveryDisbursement(Parcel in) {
        disbursementID = in.readString();
        collectionPointName = in.readString();
        retrievalDate = in.readString();
        deliveryStatus = in.readString();
        repName = in.readString();
        cepChecked = in.readString();
        clerkChecked = in.readString();
    }

    public static final Creator<DeliveryDisbursement> CREATOR = new Creator<DeliveryDisbursement>() {
        @Override
        public DeliveryDisbursement createFromParcel(Parcel in) {
            return new DeliveryDisbursement(in);
        }

        @Override
        public DeliveryDisbursement[] newArray(int size) {
            return new DeliveryDisbursement[size];
        }
    };

    public String getDisbursementID() {
        return disbursementID;
    }

    public void setDisbursementID(String disbursementID) {
        this.disbursementID = disbursementID;
    }

    public String getCollectionPointName() {
        return collectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        this.collectionPointName = collectionPointName;
    }

    public String getRetrievalDate() {
        return retrievalDate;
    }

    public void setRetrievalDate(String retrievalDate) {
        this.retrievalDate = retrievalDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getCepChecked() {
        return cepChecked;
    }

    public void setCepChecked(String cepChecked) {
        this.cepChecked = cepChecked;
    }

    public String getClerkChecked() {
        return clerkChecked;
    }

    public void setClerkChecked(String clerkChecked) {
        this.clerkChecked = clerkChecked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(disbursementID);
        dest.writeString(collectionPointName);
        dest.writeString(retrievalDate);
        dest.writeString(deliveryStatus);
        dest.writeString(repName);
        dest.writeString(cepChecked);
        dest.writeString(clerkChecked);
    }
}
