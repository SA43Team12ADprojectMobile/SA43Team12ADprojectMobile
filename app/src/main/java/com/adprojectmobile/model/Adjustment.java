package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Adjustment {
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
}
