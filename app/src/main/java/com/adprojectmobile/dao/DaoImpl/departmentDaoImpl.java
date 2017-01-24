package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.departmentDao;
import com.adprojectmobile.model.CollectionPoint;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/24.
 */

public class departmentDaoImpl implements departmentDao {
    @Override
    public Department getDepartment(int id) {
        return DummyData.departments.get(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return DummyData.departments;
    }

    @Override
    public List<Department> getDepartmentsByPoint(CollectionPoint collectionPoint) {
        List<Department> departments=this.getAllDepartments();
        List<Department> returnList=new ArrayList<>();

        for (Department dep:departments
             ) {
            CollectionPoint c=dep.getCollectionPoint();
            if(c!=null&&collectionPoint!=null){
                boolean compare= c.getCollectionPointId()==collectionPoint.getCollectionPointId();
                if (compare){
                    Department addDepartment=dep;
                    returnList.add(addDepartment);
                }
            }

        }
        return returnList;
    }
}
