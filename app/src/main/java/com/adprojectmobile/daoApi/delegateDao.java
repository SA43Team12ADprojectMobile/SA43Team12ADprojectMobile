package com.adprojectmobile.daoApi;

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

    public void deligateAuthority(){

    }

    public void revokeAuthority(){

    }
}
