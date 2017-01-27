package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.departmentDao;
import com.adprojectmobile.dao.Dao.employeeDao;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.util.DummyData;
import com.adprojectmobile.util.JSONPaser;
import com.adprojectmobile.util.url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class requisitionItemDaoImpl implements requisitionItemDao {
    final String host= url.host;
    @Override
    public RequisitionItem getRequisitionItem(int id) {
        return DummyData.requisitionItems.get(id);
    }

    @Override
    public List<RequisitionItem> getAllRequisitionItems() {
        return DummyData.requisitionItems;
    }


    @Override
    public List<RequisitionItem> getItemsInRequisition(Requisition requisition) {
//        List<RequisitionItem> requisitionItemList=DummyData.requisitionItems;
//        List<RequisitionItem> requisitionsItemInReq = new ArrayList<RequisitionItem>();
//        for (RequisitionItem req : requisitionItemList) {
//
//                Requisition comparereq=req.getRequisition();
//            if(req!=null&&requisition!=null){
//                if (comparereq.getRequisitionId().equals(requisition.getRequisitionId())) {
//                    RequisitionItem requisitionItem = req;
//                    requisitionsItemInReq.add(requisitionItem);
//                }
//            }
//
//        }
//        return requisitionsItemInReq;
        return null;
    }

    @Override
    public List<RequisitionItem> getItemsInDepartment(Department department) {
        departmentDao depDao=new departmentDaoImpl();
        employeeDao empDao=new employeeDaoImpl();
        requisitionDao reqDao=new requisitionDaoImpl();
        List<Requisition> requisitionInDepartment=new ArrayList<>();
        List<Requisition> tmpRequisitionList;

        //TODO:get all requisition in department
        List<Employee> employeesInDep=empDao.getEmployeesByDepartment(department);
        for (Employee emp:employeesInDep
             ) {
            if(emp!=null&&department!=null){
                tmpRequisitionList= reqDao.getRequisitionByEmployee(emp);
                if(tmpRequisitionList!=null){
                    requisitionInDepartment.addAll(tmpRequisitionList);
                }
            }
        }

        // TODO:get all Items in department
        List<RequisitionItem> returnList=new ArrayList<>();
        List<RequisitionItem> tmpReqItemList;
        for (Requisition req :
                requisitionInDepartment) {
            if(req!=null&&department!=null){
                tmpReqItemList=this.getItemsInRequisition(req);
                if (tmpReqItemList!=null){
                    returnList.addAll(tmpReqItemList);
                }
            }
        }

        return returnList;
    }

    @Override
    public List<RequisitionItem> getItemsByDisbursementID(String id) {
        JSONArray jsonArray= JSONPaser.getJSONArrayFromUrl(host+"/disbursement/"+id);
        List<RequisitionItem> requisitionItemList=new ArrayList<>();
        try {
            for(int i =0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(0);
                RequisitionItem requisitionItem=new RequisitionItem(jsonObject.getString("TransactionID"),jsonObject.getString("Description"),jsonObject.getString("NeededQuantity"),jsonObject.getString("ActualQuantity"));
                requisitionItemList.add(requisitionItem);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return requisitionItemList;
    }

    @Override
    public void saveRetrievalQty(RequisitionItem requisitionItem) {



//        if(DummyData.requisitionItems.contains(requisitionItem)){
//            DummyData.requisitionItems.remove(requisitionItem);
//        }
//        //DummyData.requisitionItems.add(requisitionItem.getRequisitionItemId(),requisitionItem);
//
//    }

    }
}
