package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.activity.department.ApproveRequisition.Requisitions;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class requisitionDaoImpl implements requisitionDao {

    @Override
    public Requisition getRequisition(int id) {
        return DummyData.requisitions.get(id);
    }

    @Override
    public List<Requisition> getAllRequisitions() {
        return DummyData.requisitions;
    }

    @Override
    public List<Requisition> getDisbursementRequisition(Disbursement disbursement) {
        List<Requisition> requisitionList=DummyData.requisitions;
        List<Requisition> requisitionsInDisbursement=new ArrayList<Requisition>() ;
        for (Requisition req:requisitionList) {
            if (req.getDisbursement().getDisbursementId()==disbursement.getDisbursementId()){
                Requisition requisition=req;
                requisitionsInDisbursement.add(requisition);
            }
        }
        return requisitionsInDisbursement;
    }

    @Override
    public List<Requisition> getRequisitionByEmployee(Employee employee) {
        List<Requisition> returnList=new ArrayList<>();
        List<Requisition> requisitions=DummyData.requisitions;
        for (Requisition req:requisitions
                ) {
            if (req!=null&&employee!=null){
                Employee employeeCompare=req.getEmployee();
                if(employeeCompare.equals(employee)){
                    returnList.add(req);
                }
            }

        }
        return returnList;
    }
}
