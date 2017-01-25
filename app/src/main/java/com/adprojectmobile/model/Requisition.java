package com.adprojectmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Requisition implements Parcelable {
    private String requisitionId;
    private Employee employee;
    private Disbursement disbursement;
    private String requisitionDate;
    private String approvedBy;
    private String approvementStatus;
    private String remarks;
    private String  previousRequisitionId;
    private int requisitionQuantity;

    public Requisition(String requisitionId, Employee employee, Disbursement disbursement, String requisitionDate) {
        this.requisitionId = requisitionId;
        this.employee = employee;
        this.disbursement = disbursement;
        this.requisitionDate = requisitionDate;
    }

    public Requisition() {
    }

    public Requisition(String requisitionId, Employee employee, Disbursement disbursement, String requisitionDate, String approvedBy, String approvementStatus, String remarks, String previousRequisitionId, int requisitionQuantity) {
        this.requisitionId = requisitionId;
        this.employee = employee;
        this.disbursement = disbursement;
        this.requisitionDate = requisitionDate;
        this.approvedBy = approvedBy;
        this.approvementStatus = approvementStatus;
        this.remarks = remarks;
        this.previousRequisitionId = previousRequisitionId;
        this.requisitionQuantity = requisitionQuantity;
    }

    protected Requisition(Parcel in) {
        requisitionId = in.readString();
        disbursement = in.readParcelable(Disbursement.class.getClassLoader());
        requisitionDate = in.readString();
        approvedBy = in.readString();
        approvementStatus = in.readString();
        remarks = in.readString();
        previousRequisitionId = in.readString();
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

    public String getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Disbursement getDisbursement() {
        return disbursement;
    }

    public void setDisbursement(Disbursement disbursement) {
        this.disbursement = disbursement;
    }

    public String getRequisitionDate() {
        return requisitionDate;
    }

    public void setRequisitionDate(String requisitionDate) {
        this.requisitionDate = requisitionDate;
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

    public String getPreviousRequisitionId() {
        return previousRequisitionId;
    }

    public void setPreviousRequisitionId(String previousRequisitionId) {
        this.previousRequisitionId = previousRequisitionId;
    }
    public int getRequisitionQuantity(){
        return requisitionQuantity;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    public void setRequisitionQuantity(int requisitionQuantity) {
        this.requisitionQuantity = requisitionQuantity;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(requisitionId);
        dest.writeParcelable(disbursement, flags);
        dest.writeString(requisitionDate);
        dest.writeString(approvedBy);
        dest.writeString(approvementStatus);

        dest.writeString(remarks);
        dest.writeString(previousRequisitionId);
        dest.writeInt(requisitionQuantity);
    }
}
