package com.adprojectmobile.dao;

import android.util.Log;

import com.adprojectmobile.model.DelegateEmployee;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.utilize.JSONPaser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.adprojectmobile.utilize.url.host;

/**
 * Created by EvEr on 2017/1/30.
 */

public class delegateDao {
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        //List<RetrievalItem> retrievalItems=new ArrayList<>();
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/deligation");
        Log.e("Json",jsonArray.toString());

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                Employee employee = new Employee();
                employee = new Employee(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));

                //  retrievalItems.add(retrievalItem);
                employees.add(employee);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> getEmployeeByDepartment(String depName){
        List<Employee> employees =new ArrayList<>();
        String depId=new String();
        if (depName!=null){
            if (depName.equals("Commerce Department")){
                depId="COMM";
            }
            else if (depName.equals("Computer Science")){
                depId="CPSC";
            }
            else if (depName.equals("English Department")){
                depId="ENGL";
            }
            else if (depName.equals("Registrar Department")){
                depId="REGR";
            }
            else if (depName.equals("Store")){
                depId="ST";
            }
            else if (depName.equals("Zoology Department")){
                depId="ZOOL";
            }
            else {
                depId=null;
            }
        }

        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/deligation/"+depId);
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                Employee employee = new Employee();
                employee = new Employee(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                if(!employee.getPosition().contains("Head")){
                    employees.add(employee);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return employees;
    }
    public Employee getHaedByDepartment(String depName){
        List<Employee> employees =new ArrayList<>();
        Employee employee=new Employee();
        String depId=new String();
        if (depName!=null){
            if (depName.equals("Commerce Department")){
                depId="COMM";
            }
            else if (depName.equals("Computer Science")){
                depId="CPSC";
            }
            else if (depName.equals("English Department")){
                depId="ENGL";
            }
            else if (depName.equals("Registrar Department")){
                depId="REGR";
            }
            else if (depName.equals("Store")){
                depId="ST";
            }
            else if (depName.equals("Zoology Department")){
                depId="ZOOL";
            }
            else {
                depId=null;
            }
        }

        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/deligation/"+depId);
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                Employee employeeApi = new Employee();
                employeeApi = new Employee(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                if(employeeApi.getPosition().contains("Head")){
                    employees.add(employeeApi);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        employee= employees.get(0);
        return employee;
    }

    public List<Employee> getAuthorizedEmployeeByDepartment(String depName){
        List<Employee> employees =new ArrayList<>();
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/authorization/true");
        Log.e("employee", employees.toString());
        if (jsonArray==null){
            return employees;
        }
        else {
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                    Employee employee = new Employee();
                    employee = new Employee(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                    if (employee.getDepartmentName().equals(depName)){
                        employees.add(employee);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return employees;
        }

    }


    public List<Employee> searchEmployeeByName(String name){
        List<Employee> employees = new ArrayList<>();
        //List<RetrievalItem> retrievalItems=new ArrayList<>();
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/deligation");

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                Employee employee = new Employee();
                employee = new Employee(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                if (employee !=null&& employee.getName().contains(name)){
                    employees.add(employee);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> searchDepEmployeeByName(String name, String depName){
        List<Employee> employees = new ArrayList<>();
        String depId=new String();
        if (depName!=null){
            if (depName.equals("Commerce Department")){
                depId="COMM";
            }
            else if (depName.equals("Computer Science")){
                depId="CPSC";
            }
            else if (depName.equals("English Department")){
                depId="ENGL";
            }
            else if (depName.equals("Registrar Department")){
                depId="REGR";
            }
            else if (depName.equals("Store")){
                depId="ST";
            }
            else if (depName.equals("Zoology Department")){
                depId="ZOOL";
            }
            else {
                depId=null;
            }
        }
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/deligation/"+depId);

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                Employee employee = new Employee();
                employee = new Employee(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                if (employee !=null&& employee.getName().contains(name)){
                    employees.add(employee);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public List<Employee> getAllAuthorizedEmployee(){
        List<Employee> employees = new ArrayList<>();
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/authorization/true");
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                    Employee employee = new Employee();
                    employee = new Employee(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                    employees.add(employee);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return employees;
    }

    public Boolean checkIsRevoke(String depName){
        Boolean isRevoke=false;
        List<Employee> employees =getAllAuthorizedEmployee();
        for (Employee e :
                employees) {
            if (e.getDepartmentName().equals(depName)){
                if(e.getIsDelegated().equals("true")){
                    isRevoke=true;
                }
            }
        }
        return isRevoke;
    }
    public Employee findAuthorizeEmployee(String depName, List<Employee> employees){
        Employee returnEmployee=new Employee();
        for (Employee e :
                employees) {
            if (e.getDepartmentName().equals(depName)){
                if(e.getIsDelegated().equals("true")){
                    returnEmployee=e;
                }
            }
        }
        return returnEmployee;
    }

    public void delegateAuthority(DelegateEmployee employee){
        employee.setIsDelegated("true");
        JSONObject jEmp=new JSONObject();
        try{
            jEmp.put("EmployeeID",employee.getEmployeeID());
            jEmp.put("Password",employee.getPassword());
            jEmp.put("DepartmentId",employee.getDepartmentID());
            jEmp.put("Name",employee.getName());
            jEmp.put("Position",employee.getPosition());
            jEmp.put("Number",employee.getNumber());
            jEmp.put("EmailAddress",employee.getEmailAddress());
            jEmp.put("IsDelegated",employee.getIsDelegated());
            jEmp.put("DelegationStartDate",employee.getDelegationStartDate());
            jEmp.put("DelegationEndDate",employee.getDelegationEndDate());
            Log.e("json",jEmp.toString());
        }catch (Exception e){}

        JSONPaser.postStream(host + "/deligation",jEmp.toString());
    }

    public void revokeAuthority(DelegateEmployee employee){
        employee.setIsDelegated("false");
        employee.setDelegationStartDate("null");
        employee.setDelegationEndDate("null");
        JSONObject jEmp=new JSONObject();
        try{
            jEmp.put("EmployeeID",employee.getEmployeeID());
            jEmp.put("Password",employee.getPassword());
            jEmp.put("DepartmentId",employee.getDepartmentID());
            jEmp.put("Name",employee.getName());
            jEmp.put("Position",employee.getPosition());
            jEmp.put("Number",employee.getNumber());
            jEmp.put("EmailAddress",employee.getEmailAddress());
            jEmp.put("IsDelegated",employee.getIsDelegated());
            Log.e("json",jEmp.toString());
        }catch (Exception e){
            Log.e("revoke","error");
        }

        JSONPaser.postStream(host + "/deligation",jEmp.toString());
    }

    public String convertDepIdFromName(String depName){
        String depId=new String();
        if (depName!=null){
            if (depName.equals("Commerce Department")){
                depId="COMM";
            }
            else if (depName.equals("Computer Science")){
                depId="CPSC";
            }
            else if (depName.equals("English Department")){
                depId="ENGL";
            }
            else if (depName.equals("Registrar Department")){
                depId="REGR";
            }
            else if (depName.equals("Store")){
                depId="ST";
            }
            else if (depName.equals("Zoology Department")){
                depId="ZOOL";
            }
            else {
                depId=null;
            }
        }
        return depId;
    }

    public String dateFormat(int year,int month,int day){
        Integer Year = year;
        String DateYear = Year.toString();

        Integer Month = month+1;
        String DateMonth = Month.toString();

        Integer Day = day;
        String DateDay = Day.toString();

        String date =DateYear+"-"+DateMonth+"-"+DateDay+"    ";
        Log.e("date", date);

        return date;
    }
}
