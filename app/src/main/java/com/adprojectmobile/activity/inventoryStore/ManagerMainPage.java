package com.adprojectmobile.activity.inventoryStore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.Login;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment.AdjustmentVouchersAuthorize;
import com.adprojectmobile.model.Employee;

public class ManagerMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main_page);

        final Employee employee = getIntent().getParcelableExtra("role");

        TextView textViewWelcome = (TextView) findViewById(R.id.textView_welcome_storemanager);
        textViewWelcome.setText("Welcome " + employee.getName());

        Button btnAuthorize = (Button) findViewById(R.id.btn_manager_authorize_adjustment);

        btnAuthorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdjustmentVouchersAuthorize.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        Button btnLogout = (Button) findViewById(R.id.btn_manager_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
