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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by EvEr on 2017/1/19.
 */

public class DummyData {
    public static List<Category> categories = new ArrayList<Category>();
    static {
        categories.add(0,new Category(1, "File"));
        categories.add(1,new Category(2, "Pen"));
        categories.add(2,new Category(3, "Ruler"));
        categories.add(3,new Category(4, "Scissors"));
        categories.add(4,new Category(5, "Tape"));
        categories.add(5,new Category(6, "Stapler"));
        categories.add(6,new Category(7, "Pad"));
        categories.add(7,new Category(8, "Paper"));
        categories.add(8,new Category(9, "Tray"));
        categories.add(9,new Category(10, "Tacks"));
        categories.add(10,new Category(11, "Tparency"));
        categories.add(11,new Category(12, "Clip"));
        categories.add(12,new Category(13, "Puncher"));

    }

    public static List<Item> items = new ArrayList<Item>();
    static {
        items.add(0,new Item("C001",categories.get(11),"Clip Double 1","Dozen"));
        items.add(1,new Item("C002",categories.get(11),"Clip Double 2","Dozen"));
        items.add(2,new Item("C003",categories.get(11),"Clip Double 3/4","Dozen"));
        items.add(3,new Item("F020",categories.get(0),"File Separator","Set"));
        items.add(4,new Item("F021",categories.get(0),"File Blue Plain","Each"));
        items.add(5,new Item("F022",categories.get(0),"File Blue with LOGO","Each"));
        items.add(6,new Item("H011",categories.get(12),"Highlighter Blue","Box"));
        items.add(7,new Item("H012",categories.get(12),"Highlighter Red","Box"));
        items.add(8,new Item("H013",categories.get(12),"Highlighter Yellow","Box"));
        items.add(9,new Item("P010",categories.get(6),"Pad Postit Memo 1","Packet"));
        items.add(10,new Item("P011",categories.get(6),"Pad Postit Memo 2","Packet"));
        items.add(11,new Item("S020",categories.get(5),"Stapler No.28","Each"));
        items.add(12,new Item("S021",categories.get(5),"Stapler No.36","Each"));
        items.add(13,new Item("P020",categories.get(7),"Paper Photostat A3","Packet"));
        items.add(14,new Item("P021",categories.get(7),"Paper Photostat A4","Packet"));
        items.add(15,new Item("P030",categories.get(1),"Pen Ballpoint Black","Dozen"));
        items.add(16,new Item("P031",categories.get(1),"Pen Ballpoint Blue","Dozen"));
        items.add(17,new Item("R001",categories.get(2),"Ruler 6","Dozen"));
        items.add(18,new Item("R002",categories.get(2),"Ruler 12","Dozen"));
    }

    public static List<ItemTransaction> itemTransactions = new ArrayList<ItemTransaction>();
    static {
        itemTransactions.add(0,new ItemTransaction(0,items.get(0),"01/01/2017",100));
        itemTransactions.add(1,new ItemTransaction(1,items.get(1),"02/01/2017",50));
        itemTransactions.add(2,new ItemTransaction(2,items.get(2),"02/01/2017",120));
        itemTransactions.add(3,new ItemTransaction(3,items.get(3),"02/01/2017",110));
        itemTransactions.add(4,new ItemTransaction(4,items.get(4),"03/01/2017",110));
        itemTransactions.add(5,new ItemTransaction(5,items.get(5),"03/01/2017",130));
        itemTransactions.add(6,new ItemTransaction(6,items.get(6),"03/01/2017",120));
        itemTransactions.add(7,new ItemTransaction(7,items.get(7),"04/01/2017",140));
        itemTransactions.add(8,new ItemTransaction(8,items.get(8),"05/01/2017",150));
        itemTransactions.add(9,new ItemTransaction(9,items.get(9),"06/01/2017",120));
        itemTransactions.add(10,new ItemTransaction(10,items.get(10),"06/01/2017",100));
        itemTransactions.add(11,new ItemTransaction(11,items.get(11),"06/01/2017",100));
        itemTransactions.add(12,new ItemTransaction(12,items.get(12),"06/01/2017",100));
        itemTransactions.add(13,new ItemTransaction(13,items.get(13),"07/01/2017",100));
        itemTransactions.add(14,new ItemTransaction(14,items.get(14),"07/01/2017",100));
        itemTransactions.add(15,new ItemTransaction(15,items.get(15),"07/01/2017",100));

    }

    public static List<CollectionPoint> collectionPoints = new ArrayList<CollectionPoint>();
    static {
        collectionPoints.add(new CollectionPoint(1, "Collection Point 1", "Han"));
        collectionPoints.add(new CollectionPoint(2, "Collection Point 2", "Apple"));
        collectionPoints.add(new CollectionPoint(3, "Collection Point 3", "Beta"));
        collectionPoints.add(new CollectionPoint(4, "Collection Point 4", "Charly"));
        collectionPoints.add(new CollectionPoint(5, "Collection Point 5", "Dave"));
        collectionPoints.add(new CollectionPoint(6, "Collection Point 6", "Emma"));
    }

    public static List<Department> departments = new ArrayList<Department>();
    static {
        departments.add(0, new Department("1", "English Dept", "Mrs Pamela Kow", 8742234, 8921456, collectionPoints.get(0)));
        departments.add(1, new Department("2", "Computer Science", "Mr Wee Kian Fatt", 8901235, 8921457, collectionPoints.get(0)));
        departments.add(2, new Department("3", "Commerce Dept", "Mr Mohd.Azman", 8741284, 8921256, collectionPoints.get(0)));
        departments.add(3, new Department("4", "Register Dept", "Ms Helen Ho", 8901266, 8921465, collectionPoints.get(1)));
        departments.add(4, new Department("5", "Zoology Dept", "Mr.Peter Tan Ah Meng", 8901266, 8921456, collectionPoints.get(2)));
        departments.add(5, new Department("6", "Inventory Store", "Ester", 0000000, 0000000, null));

    }

    public static List<Disbursement> disbursements = new ArrayList<Disbursement>();
    static {
        disbursements.add(new Disbursement(1, "01/01/2017 9am", "Prepared", collectionPoints.get(0).getCollectionPointName(), null));
        disbursements.add(new Disbursement(2, "01/01/2017 11am", "Prepared", collectionPoints.get(2).getCollectionPointName(), null));
        disbursements.add(new Disbursement(3, "02/01/2017 9am", "Prepared", collectionPoints.get(1).getCollectionPointName(), null));
        disbursements.add(new Disbursement(4, "02/01/2017 11am", "Prepared", collectionPoints.get(0).getCollectionPointName(), null));
        disbursements.add(new Disbursement(5, "03/01/2017 9am", "Unprepared", collectionPoints.get(3).getCollectionPointName(), null));
        disbursements.add(new Disbursement(6, "03/01/2017 11am", "Unprepared", collectionPoints.get(1).getCollectionPointName(), null));
        disbursements.add(new Disbursement(7, "04/01/2017 9am", "Unprepared", collectionPoints.get(1).getCollectionPointName(), null));
        disbursements.add(new Disbursement(8, "04/01/2017 11am", "Unprepared", collectionPoints.get(2).getCollectionPointName(), null));
    }

    public static List<Employee> employees = new ArrayList<Employee>();
    static {
        employees.add(0,new Employee("billy", departments.get(0), "admin", "billy", "Head", "80123456", "billy@gmail.com", false));
        employees.add(1,new Employee("zhang", departments.get(1), "admin", "zhang", "Employee", "80123456", "zhang@gmail.com", false));
        employees.add(2,new Employee("nivedha", departments.get(2), "admin", "nivedha", "Employee", "80123456", "nivedha@gmail.com", false));
        employees.add(3,new Employee("kyle", departments.get(3), "admin", "kyle", "DR", "80123456", "kyle@gmail.com", false));
        employees.add(4,new Employee("sooyoun", departments.get(4), "admin", "sooyoun", "DR", "80123456", "sooyoun@gmail.com", false));
        employees.add(5,new Employee("mark", departments.get(5), "admin", "mark", "Clerk", "80123456", "mark@gmail.com", false));
        employees.add(6,new Employee("han", departments.get(5), "admin", "han", "Manager", "80123456", "han@gmail.com", false));
        employees.add(7,new Employee("kyi", departments.get(5), "admin", "kyi", "Supervisor", "80123456", "kyi@gmail.com", false));
    }

    public static List<Supplier> suppliers = new ArrayList<Supplier>();

    static {
        suppliers.add(0,new Supplier("1", "Alpha Office Supplies", "Ms Irene Tan", "4619928"));
        suppliers.add(1,new Supplier("2", "Cheap Stationer", "Ms Soh Kway Koh", "3543234"));
        suppliers.add(2,new Supplier("3", "BANES Shop", "Mr Loh Ah Pek", "4781234"));
        suppliers.add(3,new Supplier("4", "OMEGA Stationery Supplier", "Mr Ronnie Ho", "7671233"));
    }

    public static List<SupplierItem> supplierItems = new ArrayList<SupplierItem>();
    static {
        supplierItems.add(0,new SupplierItem(0,suppliers.get(0),items.get(0),20,1));
        supplierItems.add(1,new SupplierItem(1,suppliers.get(1),items.get(0),22,2));
        supplierItems.add(2,new SupplierItem(2,suppliers.get(0),items.get(1),20,1));
        supplierItems.add(3,new SupplierItem(3,suppliers.get(2),items.get(1),24,2));
        supplierItems.add(4,new SupplierItem(4,suppliers.get(0),items.get(2),20,1));
        supplierItems.add(5,new SupplierItem(5,suppliers.get(1),items.get(2),22,2));
        supplierItems.add(6,new SupplierItem(6,suppliers.get(0),items.get(3),20,1));
        supplierItems.add(7,new SupplierItem(7,suppliers.get(2),items.get(3),21,2));
        supplierItems.add(8,new SupplierItem(8,suppliers.get(0),items.get(4),20,1));
        supplierItems.add(9,new SupplierItem(9,suppliers.get(1),items.get(4),23,2));
        supplierItems.add(10,new SupplierItem(10,suppliers.get(0),items.get(5),20,1));
        supplierItems.add(11,new SupplierItem(11,suppliers.get(2),items.get(5),24,2));
        supplierItems.add(12,new SupplierItem(12,suppliers.get(0),items.get(6),20,1));
        supplierItems.add(13,new SupplierItem(13,suppliers.get(3),items.get(6),23,2));
        supplierItems.add(14,new SupplierItem(14,suppliers.get(2),items.get(7),20,1));
        supplierItems.add(15,new SupplierItem(15,suppliers.get(3),items.get(7),25,2));
        supplierItems.add(16,new SupplierItem(16,suppliers.get(2),items.get(8),20,1));
        supplierItems.add(17,new SupplierItem(17,suppliers.get(1),items.get(8),22,2));
        supplierItems.add(18,new SupplierItem(18,suppliers.get(3),items.get(9),20,1));

    }

    public static List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
    static {
        purchaseOrders.add(new PurchaseOrder("28/12/2016", "1", suppliers.get(2), "02/01/2017", "Inventory Store"));
        purchaseOrders.add(new PurchaseOrder("29/12/2016", "2", suppliers.get(1), "03/01/2017", "Inventory Store"));
        purchaseOrders.add(new PurchaseOrder("29/12/2016", "3", suppliers.get(3), "03/01/2017", "Inventory Store"));
        purchaseOrders.add(new PurchaseOrder("30/12/2016", "4", suppliers.get(0), "04/01/2017", "Inventory Store"));
        purchaseOrders.add(new PurchaseOrder("30/12/2016", "5", suppliers.get(2), "04/01/2017", "Inventory Store"));
        purchaseOrders.add(new PurchaseOrder("31/12/2016", "6", suppliers.get(1), "05/01/2017", "Inventory Store"));
    }

    public static List<PurchaseOrderItem> purchaseOrderItems = new ArrayList<PurchaseOrderItem>();
    static {
        purchaseOrderItems.add(0,new PurchaseOrderItem(0,purchaseOrders.get(0),itemTransactions.get(0),150));
        purchaseOrderItems.add(1,new PurchaseOrderItem(1,purchaseOrders.get(3),itemTransactions.get(1),150));
    }

    public static List<Requisition> requisitions=new ArrayList<Requisition>();
    static {
        requisitions.add(0,new Requisition("0",employees.get(0),disbursements.get(0),"01/01/2017"));
        requisitions.add(1,new Requisition("1",employees.get(0),disbursements.get(0),"01/01/2017"));
        requisitions.add(2,new Requisition("2",employees.get(1),disbursements.get(0),"01/01/2017"));
        requisitions.add(3,new Requisition("3",employees.get(2),disbursements.get(1),"02/01/2017"));
        requisitions.add(4,new Requisition("4",employees.get(2),disbursements.get(1),"02/01/2017"));
        requisitions.add(5,new Requisition("5",employees.get(3),disbursements.get(2),"02/01/2017"));
        requisitions.add(6,new Requisition("6",employees.get(4),disbursements.get(2),"02/01/2017"));
        requisitions.add(7,new Requisition("7",employees.get(3),disbursements.get(3),"03/01/2017"));
        requisitions.add(8,new Requisition("8",employees.get(1),disbursements.get(3),"03/01/2017"));
        requisitions.add(9,new Requisition("9",employees.get(4),disbursements.get(3),"03/01/2017"));
        requisitions.add(10,new Requisition("10",employees.get(0),disbursements.get(3),"03/01/2017"));

    }

    public static List<RequisitionItem> requisitionItems = new ArrayList<RequisitionItem>();
    static {
        requisitionItems.add(0,new RequisitionItem(0,requisitions.get(0),itemTransactions.get(1),100,100));
        requisitionItems.add(1,new RequisitionItem(1,requisitions.get(0),itemTransactions.get(2),100,100));
        requisitionItems.add(2,new RequisitionItem(2,requisitions.get(0),itemTransactions.get(6),120,100));
        requisitionItems.add(3,new RequisitionItem(3,requisitions.get(1),itemTransactions.get(3),120,100));
        requisitionItems.add(4,new RequisitionItem(4,requisitions.get(1),itemTransactions.get(5),100,100));
        requisitionItems.add(5,new RequisitionItem(5,requisitions.get(1),itemTransactions.get(7),100,100));
        requisitionItems.add(6,new RequisitionItem(6,requisitions.get(1),itemTransactions.get(2),100,100));
        requisitionItems.add(7,new RequisitionItem(7,requisitions.get(2),itemTransactions.get(2),100,100));
        requisitionItems.add(8,new RequisitionItem(8,requisitions.get(2),itemTransactions.get(4),100,100));
        requisitionItems.add(9,new RequisitionItem(9,requisitions.get(2),itemTransactions.get(6),100,100));
        requisitionItems.add(10,new RequisitionItem(10,requisitions.get(5),itemTransactions.get(1),100,100));
        requisitionItems.add(11,new RequisitionItem(11,requisitions.get(3),itemTransactions.get(0),100,100));
        requisitionItems.add(12,new RequisitionItem(12,requisitions.get(3),itemTransactions.get(8),100,100));
        requisitionItems.add(13,new RequisitionItem(13,requisitions.get(4),itemTransactions.get(7),100,100));

    }

    public static List<Adjustment> adjustments = new ArrayList<Adjustment>();

    static {
        adjustments.add(0,new Adjustment("0","11/11/2016",employees.get(5).getName(),employees.get(6).getName(),"Approved",null));
        adjustments.add(1,new Adjustment("1","21/11/2016",employees.get(5).getName(),employees.get(6).getName(),"Approved",null));
        adjustments.add(2,new Adjustment("2","30/11/2016",employees.get(5).getName(),null,null,null));
        adjustments.add(3,new Adjustment("3","5/12/2016",employees.get(5).getName(),null,null,null));

    }

    public static List<AdjustmentItem> adjustmentItems = new ArrayList<AdjustmentItem>();
    static {
        adjustmentItems.add(0,new AdjustmentItem(0,adjustments.get(0),itemTransactions.get(8),"broken"));
        adjustmentItems.add(1,new AdjustmentItem(1,adjustments.get(0),itemTransactions.get(9),"broken"));
        adjustmentItems.add(2,new AdjustmentItem(2,adjustments.get(0),itemTransactions.get(10),"broken"));
        adjustmentItems.add(3,new AdjustmentItem(3,adjustments.get(1),itemTransactions.get(11),"broken"));
        adjustmentItems.add(4,new AdjustmentItem(4,adjustments.get(1),itemTransactions.get(12),"broken"));
        adjustmentItems.add(5,new AdjustmentItem(5,adjustments.get(2),itemTransactions.get(13),"broken"));
        adjustmentItems.add(6,new AdjustmentItem(6,adjustments.get(3),itemTransactions.get(14),"broken"));
        adjustmentItems.add(7,new AdjustmentItem(7,adjustments.get(3),itemTransactions.get(15),"broken"));
    }
}
