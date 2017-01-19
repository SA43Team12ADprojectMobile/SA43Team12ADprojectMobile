package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class Requisition {
    private int requisitionId;
    private Employee employee;
    private Disbursement disbursement;

    public Requisition(int requisitionId, Employee employee, Disbursement disbursement, Date requisitionDate) {
        this.requisitionId = requisitionId;
        this.employee = employee;
        this.disbursement = disbursement;
        this.requisitionDate = requisitionDate;
    }

    private Date requisitionDate;
    private String approvedBy;
    private String approvementStatus;
    private String remarks;
    private int previousRequisitionId;

    public Requisition() {
    }

    public Requisition(int requisitionId, Employee employee, Disbursement disbursement, Date requisitionDate, String approvedBy, String approvementStatus, String remarks, int previousRequisitionId) {
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
