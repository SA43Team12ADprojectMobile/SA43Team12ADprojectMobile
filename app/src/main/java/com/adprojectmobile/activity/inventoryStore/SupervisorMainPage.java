package com.adprojectmobile.activity.inventoryStore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment.AdjustmentVouchersAuthorize;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.AdjustmentVouchers;
import com.adprojectmobile.apiModel.EmployeeApi;

public class SupervisorMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_main_page);
        EmployeeApi employeeApi=getIntent().getParcelableExtra("role");

        TextView textViewWelcome=(TextView)findViewById(R.id.textView_welcome_storesupervisor);
        textViewWelcome.setText("Welcome "+employeeApi.getName());


        Button btnApprove=(Button)findViewById(R.id.btn_supervisor_supervisor_authorize_adjustment);

        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AdjustmentVouchersAuthorize.class);
                startActivity(intent);
            }
        });
    }
}
