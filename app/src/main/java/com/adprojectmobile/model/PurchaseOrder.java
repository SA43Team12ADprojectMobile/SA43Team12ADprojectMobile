package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class PurchaseOrder {
    private int purchaseOrderId;
    private Supplier supplier;
    private Date expectedDate;
    private String orderBy;
    private Date orderDate;
    private String approveStatus;
    private String approvedBy;
    private Date ApproveDate;
    private String remarks;
    private String clerkChecked;

    public PurchaseOrder() {
    }

    public PurchaseOrder(int purchaseOrderId, Supplier supplier, Date expectedDate, String orderBy, Date orderDate, String approveStatus, String approvedBy, Date approveDate, String remarks, String clerkChecked) {
        this.purchaseOrderId = purchaseOrderId;
        this.supplier = supplier;
        this.expectedDate = expectedDate;
        this.orderBy = orderBy;
        this.orderDate = orderDate;
        this.approveStatus = approveStatus;
        this.approvedBy = approvedBy;
        ApproveDate = approveDate;
        this.remarks = remarks;
        this.clerkChecked = clerkChecked;
    }

    public PurchaseOrder(Date orderDate, int purchaseOrderId, Supplier supplier, Date expectedDate, String orderBy) {
        this.orderDate = orderDate;
        this.purchaseOrderId = purchaseOrderId;
        this.supplier = supplier;
        this.expectedDate = expectedDate;
        this.orderBy = orderBy;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApproveDate() {
        return ApproveDate;
    }

    public void setApproveDate(Date approveDate) {
        ApproveDate = approveDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getClerkChecked() {
        return clerkChecked;
    }

    public void setClerkChecked(String clerkChecked) {
        this.clerkChecked = clerkChecked;
    }
}
