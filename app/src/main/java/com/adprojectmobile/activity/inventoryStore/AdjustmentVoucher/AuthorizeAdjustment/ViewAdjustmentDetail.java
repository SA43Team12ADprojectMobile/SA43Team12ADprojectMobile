package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;

public class ViewAdjustmentDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_authorize_activity_view_adjustment_detail);

        final AdjustmentItem adjustmentItem=getIntent().getParcelableExtra("data");
        final Adjustment adjustment=getIntent().getParcelableExtra("data1");

        EditText editTextItemCode=(EditText) findViewById(R.id.editText_itemAdjusted_authorize_item_code);
        EditText editTextItemName=(EditText) findViewById(R.id.editText_itemAdjusted_authorize_item_name);
        EditText editTextItemQty=(EditText) findViewById(R.id.editText_itemAdjusted_authorize_qty);
        EditText editTextItemIssueBy=(EditText) findViewById(R.id.editText_itemAdjusted_issued_by_authorize_employee_name);
        EditText editTextItemReason=(EditText) findViewById(R.id.editText_itemAdjusted_authorize_reason);

        editTextItemCode.setText("test");
        editTextItemName.setText("test");
        editTextItemQty.setText("123");
        editTextItemIssueBy.setText("apple");
        editTextItemReason.setText("no reason");

        Button btnAuthorize=(Button)findViewById(R.id.btn_voucher_authorize);
        btnAuthorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
