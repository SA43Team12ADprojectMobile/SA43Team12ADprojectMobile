package com.adprojectmobile.activity.inventoryStore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.Login;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustmentVouchersForCRUD;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.AdjustmentVouchers;
import com.adprojectmobile.model.Employee;

public class StockClerkMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_clerk_activity_main_page);
        final Employee employee = getIntent().getParcelableExtra("role");

        TextView textViewWelcome = (TextView) findViewById(R.id.textView_welcome_storeclerk);
        if (employee.getName() != null) {
            textViewWelcome.setText("Welcome " + employee.getName());
        }


        Button btnView = (Button) findViewById(R.id.btn_clerk_view_adjustment_voucher);
        Button btnIssue = (Button) findViewById(R.id.btn_clerk_issue_adjustment_voucher);
        Button btnRetrieval = (Button) findViewById(R.id.btn_clerk_retrieval_form);
        Button btnDelivery = (Button) findViewById(R.id.btn_clerk_delivery_info);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdjustmentVouchers.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });
        btnIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdjustmentVouchersForCRUD.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });
        btnRetrieval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.adprojectmobile.activity.inventoryStore.RetrievalForm.CollectionPoints.class);
                intent.putExtra("data", employee);
                startActivity(intent);
            }
        });
        btnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.adprojectmobile.activity.inventoryStore.AcknowledgeDisbursement.CollectionPoints.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        Button btnLogout = (Button) findViewById(R.id.btn_clerk_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
