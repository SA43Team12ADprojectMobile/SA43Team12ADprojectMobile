package com.adprojectmobile.activity.department;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.ApproveRequisition.Requisitions;
import com.adprojectmobile.activity.department.ConfirmDisbursement.Disbursements;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.daoApi.delegateDao;

import java.util.List;

public class EmployeeMainPage extends AppCompatActivity {

    delegateDao dDao=new delegateDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_activity_main_page);

        final EmployeeApi employeeApi=getIntent().getParcelableExtra("role");

        Button btnComfirmDisburse =(Button) findViewById(R.id.btn_employee_confirm);
        Button btnApprove=(Button)findViewById(R.id.btn_employee_approve);
        if (employeeApi.getPosition().equals("Employee")){
            btnComfirmDisburse.setEnabled(false);
        }

        TextView textViewWelcome=(TextView)findViewById(R.id.textView_welcome_employee) ;
        textViewWelcome.setText("Welcome "+employeeApi.getName());

        btnComfirmDisburse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Disbursements.class);
                intent.putExtra("role",employeeApi);
                startActivity(intent);
            }
        });

        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        EmployeeApi e=dDao.getHaedByDepartment(employeeApi.getDepartmentName());
                        String eid=e.getEmployeeID();
                        return eid;
                    }
                    protected void onPostExecute(String eid){
                        Intent intent=new Intent(getApplicationContext(), Requisitions.class);
                        intent.putExtra("role",employeeApi);
                        intent.putExtra("eid",eid);
                        Log.e("id",eid);
                        startActivity(intent);
                    }
                }.execute();

            }
        });




    }
}
