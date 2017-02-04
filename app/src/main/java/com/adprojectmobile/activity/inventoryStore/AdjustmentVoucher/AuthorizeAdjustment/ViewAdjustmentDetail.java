package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.ManagerMainPage;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.activity.inventoryStore.SupervisorMainPage;
import com.adprojectmobile.apiModel.AdjustmentApi;
import com.adprojectmobile.apiModel.AdjustmentItemApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;

public class ViewAdjustmentDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_authorize_activity_view_adjustment_detail);

        final AdjustmentItemApi adjustmentItem=getIntent().getParcelableExtra("data");
        final AdjustmentApi adjustment=getIntent().getParcelableExtra("data1");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");

        EditText editTextItemCode=(EditText) findViewById(R.id.editText_itemAdjusted_authorize_item_code);
        EditText editTextItemName=(EditText) findViewById(R.id.editText_itemAdjusted_authorize_item_name);
        EditText editTextItemQty=(EditText) findViewById(R.id.editText_itemAdjusted_authorize_qty);
        EditText editTextItemIssueBy=(EditText) findViewById(R.id.editText_itemAdjusted_issued_by_authorize_employee_name);
        EditText editTextItemReason=(EditText) findViewById(R.id.editText_itemAdjusted_authorize_reason);

        editTextItemCode.setText(adjustmentItem.getItemID());
        editTextItemName.setText(adjustmentItem.getDescription());
        editTextItemQty.setText(adjustmentItem.getActualQuantity());
        editTextItemIssueBy.setText(adjustment.getIssuedBy());
        editTextItemReason.setText(adjustmentItem.getReason());


        TextView title=(TextView)findViewById(R.id.textView_title_authorizeAdjustment_itemDetails);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(employee.getPosition().equals("Store Supervisor")){
                    intent=new Intent(getApplicationContext(), SupervisorMainPage.class);
                    intent.putExtra("role",employee);
                    startActivity(intent);
                }
                else  if(employee.getPosition().equals("Store Manager")){
                    intent=new Intent(getApplicationContext(), ManagerMainPage.class);
                    intent.putExtra("role",employee);
                    startActivity(intent);
                }
                else{

                }
            }
        });
    }
}
