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
import com.adprojectmobile.activity.department.ConfirmDisbursement.Disbursements;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.delegateDao;

public class EmployeeMainPage extends AppCompatActivity {

    delegateDao dDao = new delegateDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_activity_main_page);

        final Employee employee = getIntent().getParcelableExtra("role");

        Button btnComfirmDisburse = (Button) findViewById(R.id.btn_employee_confirm);
        Button btnApprove = (Button) findViewById(R.id.btn_employee_approve);
        if (employee.getPosition().equals("Employee")) {
            btnComfirmDisburse.setEnabled(false);
        }

        TextView textViewWelcome = (TextView) findViewById(R.id.textView_welcome_employee);
        textViewWelcome.setText("Welcome " + employee.getName());

        btnComfirmDisburse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Disbursements.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        Employee e = dDao.getHaedByDepartment(employee.getDepartmentName());
                        String eid = e.getEmployeeID();
                        return eid;
                    }

                    protected void onPostExecute(String eid) {
                        Intent intent = new Intent(getApplicationContext(), Requisitions.class);
                        intent.putExtra("role", employee);
                        intent.putExtra("eid", eid);
                        Log.e("id", eid);
                        startActivity(intent);
                    }
                }.execute();

            }
        });

        Button btnLogout = (Button) findViewById(R.id.btn_employee_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });


    }
}
