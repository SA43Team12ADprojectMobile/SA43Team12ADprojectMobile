package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;

/**
 * Created by EvEr on 2017/1/30.
 */

public class Requisition implements Parcelable{
    public String Id ;
    public String CreatedBy ;
    public String IssuedDate ;
    public String ApprovedBy ;
    public String ApprovementStatus ;
    public String Remarks ;
    public JSONArray Items ;
    public String NumberOfItem ;

    public Requisition() {
    }

    public Requisition(String id, String createdBy, String issuedDate, String approvedBy, String approvementStatus, String remarks, JSONArray items, String numberOfItem) {
        Id = id;
        CreatedBy = createdBy;
        IssuedDate = issuedDate;
        ApprovedBy = approvedBy;
        ApprovementStatus = approvementStatus;
        Remarks = remarks;
        Items = items;
        NumberOfItem = numberOfItem;
    }

    public Requisition(String id, String createdBy, String issuedDate, String approvedBy, String approvementStatus, String remarks, String numberOfItem) {
        Id = id;
        CreatedBy = createdBy;
        IssuedDate = issuedDate;
        ApprovedBy = approvedBy;
        ApprovementStatus = approvementStatus;
        Remarks = remarks;
        NumberOfItem = numberOfItem;
    }

    protected Requisition(Parcel in) {
        Id = in.readString();
        CreatedBy = in.readString();
        IssuedDate = in.readString();
        ApprovedBy = in.readString();
        ApprovementStatus = in.readString();
        Remarks = in.readString();
        NumberOfItem = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Id);
        dest.writeString(CreatedBy);
        dest.writeString(IssuedDate);
        dest.writeString(ApprovedBy);
        dest.writeString(ApprovementStatus);
        dest.writeString(Remarks);
        dest.writeString(NumberOfItem);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Requisition> CREATOR = new Creator<Requisition>() {
        @Override
        public Requisition createFromParcel(Parcel in) {
            return new Requisition(in);
        }

        @Override
        public Requisition[] newArray(int size) {
            return new Requisition[size];
        }
    };

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getIssuedDate() {
        return IssuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        IssuedDate = issuedDate;
    }

    public String getApprovedBy() {
        return ApprovedBy;
    }

    public void setApprovedBy(String approvedBy) {
        ApprovedBy = approvedBy;
    }

    public String getApprovementStatus() {
        return ApprovementStatus;
    }

    public void setApprovementStatus(String approvementStatus) {
        ApprovementStatus = approvementStatus;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public JSONArray getItems() {
        return Items;
    }

    public void setItems(JSONArray items) {
        Items = items;
    }

    public String getNumberOfItem() {
        return NumberOfItem;
    }

    public void setNumberOfItem(String numberOfItem) {
        NumberOfItem = numberOfItem;
    }
}
