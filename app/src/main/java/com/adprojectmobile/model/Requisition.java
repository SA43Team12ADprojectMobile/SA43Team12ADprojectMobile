package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Requisition {
    private int requisitionId;
    private Employee employee;
    private Disbursement disbursement;
    private String requisitionDate;
    private String approvedBy;
    private String approvementStatus;
    private String remarks;
    private int previousRequisitionId;

    public Requisition(int requisitionId, Employee employee, Disbursement disbursement, String requisitionDate) {
        this.requisitionId = requisitionId;
        this.employee = employee;
        this.disbursement = disbursement;
        this.requisitionDate = requisitionDate;
    }

    public Requisition() {
    }

    public Requisition(int requisitionId, Employee employee, Disbursement disbursement, String requisitionDate, String approvedBy, String approvementStatus, String remarks, int previousRequisitionId) {
        this.requisitionId = requisitionId;
        this.employee = employee;
        this.disbursement = disbursement;
        this.requisitionDate = requisitionDate;
        this.approvedBy = approvedBy;
        this.approvementStatus = approvementStatus;
        this.remarks = remarks;
        this.previousRequisitionId = previousRequisitionId;
    }



}
