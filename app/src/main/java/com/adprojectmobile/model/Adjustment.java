package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;

/**
 * Created by EvEr on 2017/1/30.
 */

public class Adjustment implements Parcelable{
    private String AdjustmentID ;
    private String DateIssued ;
    private String IssuedBy ;
    private String ApprovedBy ;
    private JSONArray AdjustmentItems ;

    public Adjustment() {

    }

    public Adjustment(String adjustmentID, String dateIssued, String issuedBy, String approvedBy, JSONArray adjustmentItems) {
        AdjustmentID = adjustmentID;
        DateIssued = dateIssued;
        IssuedBy = issuedBy;
        ApprovedBy = approvedBy;
        AdjustmentItems = adjustmentItems;
    }

    public Adjustment(String adjustmentID, String dateIssued, String issuedBy, String approvedBy) {
        AdjustmentID = adjustmentID;
        DateIssued = dateIssued;
        IssuedBy = issuedBy;
        ApprovedBy = approvedBy;
    }

    protected Adjustment(Parcel in) {
        AdjustmentID = in.readString();
        DateIssued = in.readString();
        IssuedBy = in.readString();
        ApprovedBy = in.readString();
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

    public String getAdjustmentID() {
        return AdjustmentID;
    }

    public void setAdjustmentID(String adjustmentID) {
        AdjustmentID = adjustmentID;
    }

    public String getDateIssued() {
        return DateIssued;
    }

    public void setDateIssued(String dateIssued) {
        DateIssued = dateIssued;
    }

    public String getIssuedBy() {
        return IssuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        IssuedBy = issuedBy;
    }

    public String getApprovedBy() {
        return ApprovedBy;
    }

    public void setApprovedBy(String approvedBy) {
        ApprovedBy = approvedBy;
    }

    public JSONArray getAdjustmentItems() {
        return AdjustmentItems;
    }

    public void setAdjustmentItems(JSONArray adjustmentItems) {
        AdjustmentItems = adjustmentItems;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(AdjustmentID);
        dest.writeString(DateIssued);
        dest.writeString(IssuedBy);
        dest.writeString(ApprovedBy);
    }
}

