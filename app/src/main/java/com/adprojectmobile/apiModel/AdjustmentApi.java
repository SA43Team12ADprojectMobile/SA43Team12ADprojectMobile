package com.adprojectmobile.apiModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by EvEr on 2017/1/30.
 */

public class AdjustmentApi implements Parcelable{
    public String AdjustmentID;


    public String DateIssued;


    public String IssuedBy;


    public String ApprovedBy;

    public String ApprovementStatus;
    public String Remarks;
    public String Description;
    public String ActualQuantity;
    public String TenderPrice;
    public String ItemID;
    public String Priority;

    public AdjustmentApi() {
    }

    public AdjustmentApi(String adjustmentID, String dateIssued, String issuedBy, String approvedBy, String approvementStatus, String remarks, String description, String actualQuantity, String tenderPrice, String itemID, String priority) {
        AdjustmentID = adjustmentID;
        DateIssued = dateIssued;
        IssuedBy = issuedBy;
        ApprovedBy = approvedBy;
        ApprovementStatus = approvementStatus;
        Remarks = remarks;
        Description = description;
        ActualQuantity = actualQuantity;
        TenderPrice = tenderPrice;
        ItemID = itemID;
        Priority = priority;
    }

    public AdjustmentApi(String adjustmentID, String dateIssued, String issuedBy, String approvedBy, String approvementStatus, String remarks) {
        AdjustmentID = adjustmentID;
        DateIssued = dateIssued;
        IssuedBy = issuedBy;
        ApprovedBy = approvedBy;
        ApprovementStatus = approvementStatus;
        Remarks = remarks;
    }

    protected AdjustmentApi(Parcel in) {
        AdjustmentID = in.readString();
        DateIssued = in.readString();
        IssuedBy = in.readString();
        ApprovedBy = in.readString();
        ApprovementStatus = in.readString();
        Remarks = in.readString();
        Description = in.readString();
        ActualQuantity = in.readString();
        TenderPrice = in.readString();
        ItemID = in.readString();
        Priority = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(AdjustmentID);
        dest.writeString(DateIssued);
        dest.writeString(IssuedBy);
        dest.writeString(ApprovedBy);
        dest.writeString(ApprovementStatus);
        dest.writeString(Remarks);
        dest.writeString(Description);
        dest.writeString(ActualQuantity);
        dest.writeString(TenderPrice);
        dest.writeString(ItemID);
        dest.writeString(Priority);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AdjustmentApi> CREATOR = new Creator<AdjustmentApi>() {
        @Override
        public AdjustmentApi createFromParcel(Parcel in) {
            return new AdjustmentApi(in);
        }

        @Override
        public AdjustmentApi[] newArray(int size) {
            return new AdjustmentApi[size];
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getActualQuantity() {
        return ActualQuantity;
    }

    public void setActualQuantity(String actualQuantity) {
        ActualQuantity = actualQuantity;
    }

    public String getTenderPrice() {
        return TenderPrice;
    }

    public void setTenderPrice(String tenderPrice) {
        TenderPrice = tenderPrice;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }
}

