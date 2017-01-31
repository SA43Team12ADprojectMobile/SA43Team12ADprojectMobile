package com.adprojectmobile.activity.inventoryStore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment.AdjustmentVouchersAuthorize;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.AdjustmentVouchers;

public class SupervisorMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_main_page);

        Button btnView=(Button)findViewById(R.id.btn_supervisor_view_adjustment_voucher);
        Button btnApprove=(Button)findViewById(R.id.btn_supervisor_supervisor_authorize_adjustment);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AdjustmentVouchers.class);
                startActivity(intent);
            }
        });
        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AdjustmentVouchersAuthorize.class);
                startActivity(intent);
            }
        });
    }
}
