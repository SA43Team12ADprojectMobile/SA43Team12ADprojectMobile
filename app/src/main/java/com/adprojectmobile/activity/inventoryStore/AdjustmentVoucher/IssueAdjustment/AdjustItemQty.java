package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.adjustDao;

public class AdjustItemQty extends AppCompatActivity {
    adjustDao aDao = new adjustDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_adjust_item_qty);

        final boolean isAdd = getIntent().getBooleanExtra("isAdd", true);
        final AdjustmentItem adjustmentItem = getIntent().getParcelableExtra("data");
        final Adjustment adjustment = getIntent().getParcelableExtra("data1");
        final Employee employee = getIntent().getParcelableExtra("role");

        final EditText editTextItemCode = (EditText) findViewById(R.id.editText_issue_itemAdjusted_item_code);
        final EditText editTextItemName = (EditText) findViewById(R.id.editText_issue_itemAdjusted_item_name);
        final EditText editTextQty = (EditText) findViewById(R.id.editText_issue_itemAdjusted_qty);
        final EditText editTextReason = (EditText) findViewById(R.id.editText_issue_itemAdjusted_reason);

        if (isAdd) {
            editTextItemCode.setText(adjustmentItem.getItemID());
            editTextItemName.setText(adjustmentItem.getDescription());
        }
        if (!isAdd) {
            if (adjustmentItem != null) {
                editTextItemCode.setText(adjustmentItem.getItemID());
                editTextItemName.setText(adjustmentItem.getDescription());
                editTextQty.setText(adjustmentItem.getActualQuantity());
                editTextReason.setText(adjustmentItem.getReason());
                editTextQty.setEnabled(false);
                editTextReason.setEnabled(false);
            }

        }

        Button btnSave = (Button) findViewById(R.id.btn_save_issue);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String actQty = editTextQty.getText().toString();
                final String reason = editTextReason.getText().toString();
                if (isAdd) {
                    if (!actQty.isEmpty() && actQty != "") {
                        new AsyncTask<String, Void, Void>() {
                            @Override
                            protected Void doInBackground(String... params) {
                                String empId = employee.getEmployeeID();
                                String itemId = adjustmentItem.getItemID();
                                String adjustId = adjustment.getAdjustmentID();

                                aDao.addNewItemIntoVoucher(empId, itemId, actQty, adjustId, reason);

                                Intent intent = new Intent(getApplicationContext(), ItemsVoucherIssue.class);
                                intent.putExtra("data", adjustment);
                                intent.putExtra("role", employee);
                                intent.putExtra("id", adjustment.getAdjustmentID());
                                startActivity(intent);
                                return null;
                            }


                        }.execute();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Qty", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Can not Save for exist Item!", Toast.LENGTH_LONG).show();
                }


            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_delete_issue);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdd) {
                    Toast.makeText(getApplicationContext(), "Can not Delete when you add!", Toast.LENGTH_LONG).show();
                } else {
                    final String adjustItemId = adjustmentItem.getAdjustment_ItemsID();
                    new AsyncTask<String, Void, Void>() {
                        @Override
                        protected Void doInBackground(String... params) {
                            aDao.deleteItemInVoucher(adjustItemId);
                            return null;
                        }
                    }.execute();

                    Intent intent = new Intent(getApplicationContext(), ItemsVoucherIssue.class);
                    intent.putExtra("data", adjustment);
                    intent.putExtra("role", employee);
                    intent.putExtra("id", adjustment.getAdjustmentID());
                    startActivity(intent);
                }
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_issueAdjustment_itemDetails);
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
