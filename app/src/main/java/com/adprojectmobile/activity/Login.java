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
import android.widget.Toast;

import com.adprojectmobile.MainActivity;
import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.EmployeeMainPage;
import com.adprojectmobile.activity.department.HeadMainPage;
import com.adprojectmobile.activity.department.RepresentativeMainPage;
import com.adprojectmobile.activity.inventoryStore.ManagerMainPage;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.activity.inventoryStore.SupervisorMainPage;
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
                        if(employeeApi==null){
                            Toast.makeText(getApplicationContext(),"Invalid UserId or Password",Toast.LENGTH_LONG);
                        }
                        else {
                            if (employeeApi.getPosition().equals("Head")){
                                intent=new Intent(getApplicationContext(), HeadMainPage.class);
                                intent.putExtra("role",employeeApi);
                                startActivity(intent);
                            }
                            else if (employeeApi.getPosition().equals("Representative")){
                                intent=new Intent(getApplicationContext(), RepresentativeMainPage.class);
                                intent.putExtra("role",employeeApi);
                                startActivity(intent);
                            }
                            else if (employeeApi.getIsDelegated().contains("true")&&employeeApi.getPosition().equals("Employee")){
                                intent=new Intent(getApplicationContext(), HeadMainPage.class);
                                intent.putExtra("role",employeeApi);
                                startActivity(intent);
                            }
                            else if (employeeApi.getPosition().equals("Store Manager")){
                                intent=new Intent(getApplicationContext(), ManagerMainPage.class);
                                intent.putExtra("role",employeeApi);
                                startActivity(intent);
                            }
                            else if (employeeApi.getPosition().equals("Store Supervisor")){
                                intent=new Intent(getApplicationContext(), SupervisorMainPage.class);
                                intent.putExtra("role",employeeApi);
                                startActivity(intent);
                            }
                            else if (employeeApi.getPosition().equals("Clerk")){
                                intent=new Intent(getApplicationContext(), StockClerkMainPage.class);
                                intent.putExtra("role",employeeApi);
                                startActivity(intent);
                            }
                        }
                    }
                }.execute();

            }
        });
    }
}
