package com.adprojectmobile.dao.DaoImpl;

import com.adprojectmobile.dao.Dao.employeeDao;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.util.DummyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvEr on 2017/1/24.
 */

public class employeeDaoImpl implements employeeDao {
    @Override
    public Employee getEmployee(int id) {
        return DummyData.employees.get(id);
    }

    @Override
    public List<Employee> getEmployees(String name) {
        List<Employee> returnList=new ArrayList<>();
        List<Employee> allEmployees=this.getAllEmployees();
        for (Employee e:
             allEmployees) {
            if(name!=null){
                if(e.getName().contains(name)){
                    returnList.add(e);
                }
            }
        }
        return returnList;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return DummyData.employees;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Department department) {
        List<Employee> returnList=new ArrayList<>();
        List<Employee> employees=DummyData.employees;
        for (Employee emp:employees
                ) {
            if (emp!=null&&department!=null){
                Department depCompare=emp.getDepartment();
                if(depCompare.equals(department)){
                    returnList.add(emp);
                }
            }

        }
        return returnList;
    }

    @Override
    public List<Employee> getEmployeeByRole(String role) {
        return null;
    }
}
