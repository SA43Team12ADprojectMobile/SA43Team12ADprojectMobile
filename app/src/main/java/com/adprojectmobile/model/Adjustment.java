package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Adjustment implements Parcelable {
    private String adjustmentId;
    private String dateIssued;
    private String issuedBy;
    private String approvedBy;
    private String approvementStatus;
    private String remarks;

    public Adjustment() {
    }

    public Adjustment(String adjustmentId, String dateIssued, String issuedBy, String approvedBy, String approvementStatus, String remarks) {
        this.adjustmentId = adjustmentId;
        this.dateIssued = dateIssued;
        this.issuedBy = issuedBy;
        this.approvedBy = approvedBy;
        this.approvementStatus = approvementStatus;
        this.remarks = remarks;
    }

    public Adjustment(String adjustmentId, String dateIssued, String issuedBy, String approvedBy, String approvementStatus) {
        this.adjustmentId = adjustmentId;
        this.dateIssued = dateIssued;
        this.issuedBy = issuedBy;
        this.approvedBy = approvedBy;
        this.approvementStatus = approvementStatus;
    }

    protected Adjustment(Parcel in) {
        adjustmentId = in.readString();
        dateIssued = in.readString();
        issuedBy = in.readString();
        approvedBy = in.readString();
        approvementStatus = in.readString();
        remarks = in.readString();
    }

    public static final Creator<Adjustment> CREATOR = new Creator<Adjustment>() {
        @Override
        public Adjustment createFromParcel(Parcel in) {
            return new Adjustment(in);
        }

        @Override
        public Adjustment[] newArray(int size) {
            return new Adjustment[size];
        }
    };

    public String getAdjustmentId() {
        return adjustmentId;
    }

    public void setAdjustmentId(String adjustmentId) {
        this.adjustmentId = adjustmentId;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApprovementStatus() {
        return approvementStatus;
    }

    public void setApprovementStatus(String approvementStatus) {
        this.approvementStatus = approvementStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adjustmentId);
        dest.writeString(dateIssued);
        dest.writeString(issuedBy);
        dest.writeString(approvedBy);
        dest.writeString(approvementStatus);
        dest.writeString(remarks);
    }
}
