package com.adprojectmobile.activity.department;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.ApproveRequisition.Requisitions;
import com.adprojectmobile.activity.department.DelegateAuthority.FindEmployee;
import com.adprojectmobile.apiModel.EmployeeApi;

public class HeadMainPage extends AppCompatActivity {

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
                Intent intent=new Intent(getApplicationContext(), FindEmployee.class);
                intent.putExtra("role",employeeApi);
                startActivity(intent);
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
