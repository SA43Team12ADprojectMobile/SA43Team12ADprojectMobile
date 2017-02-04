package com.adprojectmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adprojectmobile.activity.Login;
import com.adprojectmobile.activity.department.ApproveRequisition.RequisitionItemsforApprove;
import com.adprojectmobile.activity.department.ApproveRequisition.Requisitions;
import com.adprojectmobile.activity.department.ConfirmDisbursement.Disbursements;
import com.adprojectmobile.activity.department.DelegateAuthority.FindEmployee;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AdjustmentMainPage;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustmentVouchersForCRUD;
import com.adprojectmobile.activity.inventoryStore.RetrievalForm.CollectionPoints;
import com.adprojectmobile.activity.inventoryStore.RetrievalForm.ConfirmRetrieval;
import com.adprojectmobile.activity.inventoryStore.RetrievalForm.ItemsForCollection;
import com.adprojectmobile.testdata.testCollectionList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);



        Button btnLogin=(Button)findViewById(R.id.btn_toLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

    }
}
