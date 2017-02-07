package com.adprojectmobile.activity.department;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.Login;
import com.adprojectmobile.activity.department.ApproveRequisition.Requisitions;
import com.adprojectmobile.activity.department.DelegateAuthority.FindEmployee;
import com.adprojectmobile.activity.department.DelegateAuthority.RevokeAuthority;
import com.adprojectmobile.model.DelegateEmployee;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.delegateDao;

import java.util.List;

public class HeadMainPage extends AppCompatActivity {
    delegateDao dDao = new delegateDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_main_page);

        final Employee employee = getIntent().getParcelableExtra("role");
        final String password = getIntent().getStringExtra("password");

        String depId = dDao.convertDepIdFromName(employee.getDepartmentName());
        final DelegateEmployee delegateEmployee = new DelegateEmployee(employee.getEmployeeID(), password, depId, employee.getName(), employee.getPosition(), employee.getIsDelegated(), employee.getDelegationStartDate(), employee.getDelegationEndDate(), employee.getNumber(), employee.getEmailAddress());

        TextView textViewHello = (TextView) findViewById(R.id.textView_welcome_departmentHead);
        textViewHello.setText("Welcome " + employee.getName());

        Button btnDelegate = (Button) findViewById(R.id.btn_head_delegation);
        Button btnApprove = (Button) findViewById(R.id.btn_head_approve);

        btnDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {
                        List<Employee> employeeList = dDao.getAllAuthorizedEmployee();
                        Employee authorEmp = dDao.findAuthorizeEmployee(employee.getDepartmentName(), employeeList);
                        Intent intent;
                        if (!dDao.checkIsRevoke(employee.getDepartmentName())) {
                            intent = new Intent(getApplicationContext(), FindEmployee.class);
                            intent.putExtra("data", employee);
                            intent.putExtra("delegate", delegateEmployee);
                            startActivity(intent);
                        } else {
                            intent = new Intent(getApplicationContext(), RevokeAuthority.class);
                            intent.putExtra("data", employee);
                            intent.putExtra("auth", authorEmp);
                            intent.putExtra("delegate", delegateEmployee);
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
                Intent intent = new Intent(getApplicationContext(), Requisitions.class);
                intent.putExtra("role", employee);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });

        Button btnLogout = (Button) findViewById(R.id.btn_head_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
