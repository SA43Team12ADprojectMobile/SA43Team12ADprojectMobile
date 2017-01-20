package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Requisition {
    private String requisitionId;
    private Employee employee;
    private Disbursement disbursement;
    private String requisitionDate;
    private String approvedBy;
    private String approvementStatus;
    private String remarks;
    private String  previousRequisitionId;

    public Requisition(String requisitionId, Employee employee, Disbursement disbursement, String requisitionDate) {
        this.requisitionId = requisitionId;
        this.employee = employee;
        this.disbursement = disbursement;
        this.requisitionDate = requisitionDate;
    }

    public Requisition() {
    }

    public Requisition(String requisitionId, Employee employee, Disbursement disbursement, String requisitionDate, String approvedBy, String approvementStatus, String remarks, String previousRequisitionId) {
        this.requisitionId = requisitionId;
        this.employee = employee;
        this.disbursement = disbursement;
        this.requisitionDate = requisitionDate;
        this.approvedBy = approvedBy;
        this.approvementStatus = approvementStatus;
        this.remarks = remarks;
        this.previousRequisitionId = previousRequisitionId;
    }

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
}
