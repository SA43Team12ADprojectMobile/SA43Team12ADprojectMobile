package com.adprojectmobile.daoApi;

import android.util.Log;

import com.adprojectmobile.apiModel.DepartmentApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.util.JSONPaser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.adprojectmobile.util.url.host;

/**
 * Created by EvEr on 2017/1/30.
 */

public class delegateDao {
    public List<EmployeeApi> getAllEmployee() {
        List<EmployeeApi> employeeApis = new ArrayList<>();
        //List<RetrievalItem> retrievalItems=new ArrayList<>();
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/deligation");

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonEmployee = jsonArray.getJSONObject(i);

                EmployeeApi employeeApi = new EmployeeApi();


                employeeApi = new EmployeeApi(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));

                //  retrievalItems.add(retrievalItem);
                employeeApis.add(employeeApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employeeApis;
    }

    public List<EmployeeApi> getEmployeeByDepartment(String depName){
        List<EmployeeApi> employeeApis=new ArrayList<>();
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
                EmployeeApi employeeApi = new EmployeeApi();
                employeeApi = new EmployeeApi(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                employeeApis.add(employeeApi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return employeeApis;
    }

    public List<EmployeeApi> getAuthorizedEmployeeByDepartment(String depName){
        List<EmployeeApi> employeeApis=new ArrayList<>();
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/authorization/true");
        Log.e("employee",employeeApis.toString());
        if (jsonArray==null){
            return employeeApis;
        }
        else {
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                    EmployeeApi employeeApi = new EmployeeApi();
                    employeeApi = new EmployeeApi(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                    if (employeeApi.getDepartmentName().equals(depName)){
                        employeeApis.add(employeeApi);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return employeeApis;
        }

    }


    public List<EmployeeApi> searchEmployeeByName(String name){
        List<EmployeeApi> employeeApis = new ArrayList<>();
        //List<RetrievalItem> retrievalItems=new ArrayList<>();
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/deligation");

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                EmployeeApi employeeApi = new EmployeeApi();
                employeeApi = new EmployeeApi(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                if (employeeApi!=null&&employeeApi.getName().contains(name)){
                    employeeApis.add(employeeApi);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employeeApis;
    }

    public List<EmployeeApi> searchDepEmployeeByName(String name,String depName){
        List<EmployeeApi> employeeApis = new ArrayList<>();
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
                EmployeeApi employeeApi = new EmployeeApi();
                employeeApi = new EmployeeApi(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                if (employeeApi!=null&&employeeApi.getName().contains(name)){
                    employeeApis.add(employeeApi);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employeeApis;
    }
    public List<EmployeeApi> getAllAuthorizedEmployee(){
        List<EmployeeApi> employeeApis = new ArrayList<>();
        JSONArray jsonArray = JSONPaser.getJSONArrayFromUrl(host + "/authorization/true");
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonEmployee = jsonArray.getJSONObject(i);
                    EmployeeApi employeeApi = new EmployeeApi();
                    employeeApi = new EmployeeApi(jsonEmployee.getString("EmployeeID"), jsonEmployee.getString("DepartmentName"), jsonEmployee.getString("Name"), jsonEmployee.getString("Position"), jsonEmployee.getString("Number"), jsonEmployee.getString("EmailAddress"), jsonEmployee.getString("IsDelegated"), jsonEmployee.getString("DelegationStartDate"), jsonEmployee.getString("DelegationEndDate"));
                    employeeApis.add(employeeApi);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return employeeApis;
    }

    public Boolean checkIsRevoke(String depName){
        Boolean isRevoke=false;
        List<EmployeeApi> employeeApis=getAllAuthorizedEmployee();
        for (EmployeeApi e :
                employeeApis) {
            if (e.getDepartmentName().equals(depName)){
                if(e.getIsDelegated().equals("true")){
                    isRevoke=true;
                }
            }
        }
        return isRevoke;
    }
    public EmployeeApi findAuthorizeEmployee(String depName,List<EmployeeApi> employeeApis){
        EmployeeApi returnEmployee=new EmployeeApi();
        for (EmployeeApi e :
                employeeApis) {
            if (e.getDepartmentName().equals(depName)){
                if(e.getIsDelegated().equals("true")){
                    returnEmployee=e;
                }
            }
        }
        return returnEmployee;
    }

    public void deligateAuthority(){

    }

    public void revokeAuthority(){

    }
}
