package com.adprojectmobile.activity.department;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.ApproveRequisition.Requisitions;
import com.adprojectmobile.activity.department.DelegateAuthority.DelegateAuthority;
import com.adprojectmobile.activity.department.DelegateAuthority.FindEmployee;
import com.adprojectmobile.activity.department.DelegateAuthority.RevokeAuthority;
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
                            startActivity(intent);
                        } else {
                            intent = new Intent(getApplicationContext(), RevokeAuthority.class);
                            intent.putExtra("data", employeeApi);
                            intent.putExtra("auth",authorEmp);
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
                startActivity(intent);
            }
        });
    }
}
