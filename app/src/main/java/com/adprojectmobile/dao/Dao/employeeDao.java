package com.adprojectmobile.dao.Dao;

import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Employee;

import java.util.List;

/**
 * Created by EvEr on 2017/1/20.
 */

public interface employeeDao {
    public Employee getEmployee(int id);
    public List<Employee> getEmployees(String name);
    public List<Employee> getAllEmployees();
    public List<Employee> getEmployeesByDepartment(Department department);
    public List<Employee> getEmployeeByRole(String role);
}
