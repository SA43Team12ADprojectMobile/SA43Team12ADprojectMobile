package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.CollectionPoint;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Disbursement;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface departmentDao {
    public Department getDepartment(int id);
    public List<Department> getAllDepartments();
    public List<Department> getDepartmentsByPoint(CollectionPoint collectionPoint);

}
