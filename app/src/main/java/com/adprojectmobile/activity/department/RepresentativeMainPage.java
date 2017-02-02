package com.adprojectmobile.activity.department;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.ConfirmDisbursement.Disbursements;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.model.Disbursement;

public class RepresentativeMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representative_main_page);
        final EmployeeApi employee=getIntent().getParcelableExtra("role");

        Button btnConfirm=(Button)findViewById(R.id.btn_representative_confirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Disbursements.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });
    }
}
