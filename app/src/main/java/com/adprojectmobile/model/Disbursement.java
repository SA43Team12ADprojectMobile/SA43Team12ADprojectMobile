package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Disbursement implements Parcelable {
    private String disbursementId;
    private String retrievalTime;
    private String deliveryStatus;
    private String collectonPoint;
    private String repName;
    private boolean repChecked;
    private boolean clerkChecked;

    public Disbursement() {
    }

    public Disbursement(String disbursementId, String retrievalTime, String deliveryStatus, String collectonPoint, String repName) {
        this.disbursementId = disbursementId;
        this.retrievalTime = retrievalTime;
        this.deliveryStatus = deliveryStatus;
        this.collectonPoint = collectonPoint;
        this.repName = repName;
    }

    public Disbursement(String disbursementId, String retrievalTime, String deliveryStatus, String collectonPoint, String repName, boolean repChecked, boolean clerkChecked) {
        this.disbursementId = disbursementId;
        this.retrievalTime = retrievalTime;
        this.deliveryStatus = deliveryStatus;
        this.collectonPoint = collectonPoint;
        this.repName = repName;
        this.repChecked = repChecked;
        this.clerkChecked = clerkChecked;
    }

    protected Disbursement(Parcel in) {
        disbursementId = in.readString();
        retrievalTime = in.readString();
        deliveryStatus = in.readString();
        collectonPoint = in.readString();
        repName = in.readString();
        repChecked = in.readByte() != 0;
        clerkChecked = in.readByte() != 0;
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

    public String getDisbursementId() {
        return disbursementId;
    }

    public void setDisbursementId(String disbursementId) {
        this.disbursementId = disbursementId;
    }

    public String getRetrievalTime() {
        return retrievalTime;
    }

    public void setRetrievalTime(String retrievalTime) {
        this.retrievalTime = retrievalTime;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getCollectonPoint() {
        return collectonPoint;
    }

    public void setCollectonPoint(String collectonPoint) {
        this.collectonPoint = collectonPoint;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public boolean getRepChecked() {
        return repChecked;
    }

    public void setRepChecked(boolean repChecked) {
        this.repChecked = repChecked;
    }

    public boolean getClerkChecked() {
        return clerkChecked;
    }

    public void setClerkChecked(boolean clerkChecked) {
        this.clerkChecked = clerkChecked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(disbursementId);
        dest.writeString(retrievalTime);
        dest.writeString(deliveryStatus);
        dest.writeString(collectonPoint);
        dest.writeString(repName);
        dest.writeByte((byte) (repChecked ? 1 : 0));
        dest.writeByte((byte) (clerkChecked ? 1 : 0));
    }
}
