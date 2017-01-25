package com.adprojectmobile.model;

import java.util.Date;

/**
 * Created by EvEr on 2017/1/19.
 */

public class PurchaseOrder {
    private String purchaseOrderId;
    private Supplier supplier;
    private String expectedDate;
    private String orderBy;
    private String orderDate;
    private String approveStatus;
    private String approvedBy;
    private String ApproveDate;
    private String remarks;
    private String clerkChecked;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String purchaseOrderId, Supplier supplier, String expectedDate, String orderBy, String orderDate, String approveStatus, String approvedBy, String approveDate, String remarks, String clerkChecked) {
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

    public PurchaseOrder(String orderDate, String purchaseOrderId, Supplier supplier, String expectedDate, String orderBy) {
        this.orderDate = orderDate;
        this.purchaseOrderId = purchaseOrderId;
        this.supplier = supplier;
        this.expectedDate = expectedDate;
        this.orderBy = orderBy;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
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

    public String getApproveDate() {
        return ApproveDate;
    }

    public void setApproveDate(String approveDate) {
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
