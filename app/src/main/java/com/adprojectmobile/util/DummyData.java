package com.adprojectmobile.util;

import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Category;
import com.adprojectmobile.model.CollectionPoint;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.PurchaseOrder;
import com.adprojectmobile.model.PurchaseOrderItem;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.model.Supplier;
import com.adprojectmobile.model.SupplierItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/19.
 */

public class DummyData {

    public static List<Adjustment> adjustments=new ArrayList<Adjustment>();
    static {

    }

    public static List<AdjustmentItem> adjustmentItems=new ArrayList<AdjustmentItem>();
    public static List<Category> categories=new ArrayList<Category>();

    public static List<CollectionPoint> collectionPoints=new ArrayList<CollectionPoint>();
    static {
        collectionPoints.add(new CollectionPoint(1,"Collection Point 1","Han"));
        collectionPoints.add(new CollectionPoint(2,"Collection Point 2","Apple"));
        collectionPoints.add(new CollectionPoint(3,"Collection Point 3","Beta"));
        collectionPoints.add(new CollectionPoint(4,"Collection Point 4","Charly"));
        collectionPoints.add(new CollectionPoint(5,"Collection Point 5","Dave"));
        collectionPoints.add(new CollectionPoint(6,"Collection Point 6","Emma"));
    }
    public static List<Department> departments=new ArrayList<Department>();
    static {
        departments.add(new Department(1,"English Dept","Mrs Pamela Kow",8742234,8921456,collectionPoints.get(0)));
        departments.add(new Department(2,"Computer Science","Mr Wee Kian Fatt",8901235,8921457,collectionPoints.get(0)));
        departments.add(new Department(3,"Commerce Dept","Mr Mohd.Azman",8741284,8921256,collectionPoints.get(0)));
        departments.add(new Department(4,"Register Dept","Ms Helen Ho",8901266,8921465,collectionPoints.get(1)));
        departments.add(new Department(5,"Zoology Dept","Mr.Peter Tan Ah Meng",8901266,8921456,collectionPoints.get(2)));

    }
    public static List<Disbursement> disbursements=new ArrayList<Disbursement>();
    public static List<Employee> employees=new ArrayList<Employee>();
    public static List<Item> items=new ArrayList<Item>();
    public static List<ItemTransaction> itemTransactions=new ArrayList<ItemTransaction>();
    public static List<PurchaseOrder> purchaseOrders=new ArrayList<PurchaseOrder>();
    public static List<PurchaseOrderItem> purchaseOrderItems=new ArrayList<PurchaseOrderItem>();
    public static List<Requisition> requisitions=new ArrayList<Requisition>();
    public static List<RequisitionItem> requisitionItems=new ArrayList<RequisitionItem>();
    public static List<Supplier> suppliers=new ArrayList<Supplier>();
    public static List<SupplierItem> supplierItems=new ArrayList<SupplierItem>();
}
