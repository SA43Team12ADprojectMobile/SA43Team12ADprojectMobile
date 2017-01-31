package com.adprojectmobile.daoApi;

import android.util.Log;

import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.util.JSONPaser;
import com.adprojectmobile.util.url;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by EvEr on 2017/1/31.
 */

public class authenticationDao {
    String host=url.host;
    public EmployeeApi login(String id,String password){
        JSONObject jUser=new JSONObject();
        try{
            jUser.put("UserId",id);
            jUser.put("Password",password);
        }catch (Exception e){}
        Log.e("json",jUser.toString());
        String returnJson = JSONPaser.postStream(host+"/user",jUser.toString());
        Gson gson=new Gson();
        EmployeeApi employeeApi=gson.fromJson(returnJson,EmployeeApi.class);
        Log.e("employee",employeeApi.toString());
        return employeeApi;
    }

    public String testPost(String id,String password){
        JSONObject jUser=new JSONObject();
        if(id!=null&&password!=null) {
            try {
                jUser.put("UserId", id);
                jUser.put("Password", password);
            } catch (Exception e) {
            }
        }
        Log.e("json",jUser.toString());
        String returnJson = JSONPaser.postStream(host+"/user",jUser.toString());
        Log.i("postback",returnJson.toString());
        return returnJson;
    }
}
