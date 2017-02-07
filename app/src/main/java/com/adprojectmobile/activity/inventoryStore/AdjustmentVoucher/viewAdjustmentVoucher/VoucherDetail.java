package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Employee;

public class VoucherDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_view_activity_voucher_detail);

        AdjustmentItem adjustmentItem = getIntent().getParcelableExtra("data");
        Adjustment adjustment = getIntent().getParcelableExtra("data1");
        final Employee employee = getIntent().getParcelableExtra("role");

        final EditText editTextItemCode = (EditText) findViewById(R.id.editText_itemAdjusted_item_code);
        final EditText editTextItemName = (EditText) findViewById(R.id.editText_itemAdjusted_item_name);
        final EditText editTextItemQty = (EditText) findViewById(R.id.editText_itemAdjusted_qty);
        final EditText editTextItemIssueBy = (EditText) findViewById(R.id.editText_itemAdjusted_issued_by_employee_name);
        final EditText editTextItemAuthorizedBy = (EditText) findViewById(R.id.editText_itemAdjusted_authorized_by_employee_name);
        final EditText editTextReason = (EditText) findViewById(R.id.editText_itemAdjusted_reason);

        editTextItemCode.setText(adjustmentItem.getItemID());
        editTextItemName.setText(adjustmentItem.getDescription());
        editTextItemQty.setText(adjustmentItem.getActualQuantity());
        editTextItemIssueBy.setText(adjustment.getIssuedBy());
        if (adjustment.getApprovedBy() != null) {
            editTextItemAuthorizedBy.setText(" ");
        } else {
            editTextItemAuthorizedBy.setText(adjustment.getApprovedBy());
        }

        editTextItemAuthorizedBy.setText(adjustmentItem.getReason());


        TextView title = (TextView) findViewById(R.id.textview_title_view_voucherDetails);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StockClerkMainPage.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

    }
}
