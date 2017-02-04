package com.adprojectmobile.activity.department;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.Login;
import com.adprojectmobile.activity.department.ApproveRequisition.Requisitions;
import com.adprojectmobile.activity.department.DelegateAuthority.DelegateAuthority;
import com.adprojectmobile.activity.department.DelegateAuthority.FindEmployee;
import com.adprojectmobile.activity.department.DelegateAuthority.RevokeAuthority;
import com.adprojectmobile.apiModel.DelegateEmployee;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.daoApi.delegateDao;

import java.util.List;

public class HeadMainPage extends AppCompatActivity {
    delegateDao dDao=new delegateDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_main_page);
        final EmployeeApi employeeApi=getIntent().getParcelableExtra("role");
        final String password=getIntent().getStringExtra("password");
        String depId=dDao.convertDepIdFromName(employeeApi.getDepartmentName());
        final DelegateEmployee delegateEmployee=new DelegateEmployee(employeeApi.getEmployeeID(),password,depId,employeeApi.getName(),employeeApi.getPosition(),employeeApi.getIsDelegated(),employeeApi.getDelegationStartDate(),employeeApi.getDelegationEndDate(),employeeApi.getNumber(),employeeApi.getEmailAddress());

        TextView textViewHello=(TextView) findViewById(R.id.textView_welcome_departmentHead);
        textViewHello.setText("Welcome "+employeeApi.getName());

        Button btnDelegate=(Button)findViewById(R.id.btn_head_delegation);
        Button btnApprove=(Button)findViewById(R.id.btn_head_approve);

        btnDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<Void,Void,Void>(){

                    @Override
                    protected Void doInBackground(Void... params) {
                        List<EmployeeApi> employeeApiList= dDao.getAllAuthorizedEmployee();
                        EmployeeApi authorEmp=dDao.findAuthorizeEmployee(employeeApi.getDepartmentName(),employeeApiList);
                        Intent intent;
                        if (!dDao.checkIsRevoke(employeeApi.getDepartmentName())) {
                            intent = new Intent(getApplicationContext(), FindEmployee.class);
                            intent.putExtra("data", employeeApi);
                            intent.putExtra("delegate",delegateEmployee);
                            startActivity(intent);
                        } else {
                            intent = new Intent(getApplicationContext(), RevokeAuthority.class);
                            intent.putExtra("data", employeeApi);
                            intent.putExtra("auth",authorEmp);
                            intent.putExtra("delegate",delegateEmployee);
                            startActivity(intent);
                        }
                        return null;
                    }
                }.execute();
            }
        });
        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Requisitions.class);
                intent.putExtra("role",employeeApi);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });

        Button btnLogout=(Button)findViewById(R.id.btn_head_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
