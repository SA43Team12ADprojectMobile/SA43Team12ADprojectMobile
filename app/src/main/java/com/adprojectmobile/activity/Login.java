package com.adprojectmobile.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adprojectmobile.MainActivity;
import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.daoApi.authenticationDao;
import com.adprojectmobile.util.JSONPaser;
import com.adprojectmobile.util.url;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    String host=url.host;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final authenticationDao aDao=new authenticationDao();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin=(Button)findViewById(R.id.btn_login);
        final EditText editTextPassword=(EditText)findViewById(R.id.edittext_password);
        final TextView textViewId=(TextView)findViewById(R.id.textView_employeeId);



        final JSONObject jUser=new JSONObject();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id=textViewId.getText().toString();
                final String password=editTextPassword.getText().toString();
                new AsyncTask<String, Void, EmployeeApi>() {
                    @Override
                    protected EmployeeApi doInBackground(String... params) {
                        EmployeeApi employeeApi=aDao.login(id,password);
                        return employeeApi;
                    }
                    @Override
                    protected void onPostExecute(EmployeeApi employeeApi){
                        Intent intent;
                        if (employeeApi.getIsDelegated().contains("true")||employeeApi.getPosition().equals("Store Manager")){
                            intent=new Intent(getApplicationContext(), EmployeeMainPage.class);
                            intent.putExtra("data",employeeApi);
                            startActivity(intent);
                        }
                        if (employeeApi.getPosition().equals("Representative")){
                            intent=new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("data",employeeApi);
                            startActivity(intent);
                        }
                    }
                }.execute();

            }
        });
    }
}
