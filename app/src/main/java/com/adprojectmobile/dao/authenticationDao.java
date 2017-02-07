package com.adprojectmobile.dao;

import android.util.Log;

import com.adprojectmobile.model.Employee;
import com.adprojectmobile.utilize.JSONPaser;
import com.adprojectmobile.utilize.url;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by EvEr on 2017/1/31.
 */

public class authenticationDao {
    String host=url.host;
    public Employee login(String id, String password){
        JSONObject jUser=new JSONObject();
        Employee employee =new Employee();
        try{
            jUser.put("UserId",id);
            jUser.put("Password",password);
            Log.e("json",jUser.toString());
            String returnJson = JSONPaser.postStream(host+"/user",jUser.toString());
            Gson gson=new Gson();
            employee =gson.fromJson(returnJson,Employee.class);
            Log.e("employee", employee.toString());
            return employee;
        }catch (Exception e){

            employee =null;
            return employee;
        }
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

    public Date parseDate(String d){
        SimpleDateFormat sft=new SimpleDateFormat("yyyy-MM-dd");
        d.substring(0,10);
        Date date=new Date();
        try {
            date=sft.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String parseDate(Date d){
        SimpleDateFormat sft=new SimpleDateFormat("yyyy-MM-dd");
        String date=sft.format(d);
        return date;
    }

    public Boolean checkDate(String startDate,String endDate){
        Date s=parseDate(startDate);
        Date e=parseDate(endDate);
        Date today=new Date();
        if(s.before(today)&&e.after(today)){
            return true;
        }
        else {
            return false;
        }
    }

    public String formatJsonDate(String d){
        String date=d.substring(0,10);
        return date;
    }
}
