package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.ManagerMainPage;
import com.adprojectmobile.activity.inventoryStore.SupervisorMainPage;
import com.adprojectmobile.adapter.adjustmentItemAdapter;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.adjustDao;

import java.util.List;

public class ItemsInVoucherAuthorize extends AppCompatActivity {
    adjustDao aDao = new adjustDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_authorize_activity_items_in_voucher_authorize);

        final Adjustment adjustment = getIntent().getParcelableExtra("data");
        final Employee employee = getIntent().getParcelableExtra("role");
        final String id = getIntent().getStringExtra("id");

        final ListView adjustmentItemView = (ListView) findViewById(R.id.listview_adjustment_voucher_approve_itemlist);

        new AsyncTask<Adjustment, Void, List<AdjustmentItem>>() {
            @Override
            protected List<AdjustmentItem> doInBackground(Adjustment... params) {
                List<Adjustment> adjustments = aDao.getAuthorizeVoucher(employee.getEmployeeID());
                Adjustment adjustment = new Adjustment();
                for (Adjustment rc :
                        adjustments) {
                    if (rc.getAdjustmentID() != null) {
                        if (rc.getAdjustmentID().toString().equals(id)) {
                            adjustment = rc;
                        }
                    }
                }
                return aDao.getAllAdjustItem(adjustment);
            }

            @Override
            protected void onPostExecute(List<AdjustmentItem> adjustmentItems) {
                adjustmentItemView.setAdapter(new adjustmentItemAdapter(getApplicationContext(), R.layout.row_adjustment_item, adjustmentItems));
            }
        }.execute();

        adjustmentItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdjustmentItem adjustmentItem = (AdjustmentItem) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ViewAdjustmentDetail.class);
                intent.putExtra("data", adjustmentItem);
                intent.putExtra("data1", adjustment);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        Button btnApprove = (Button) findViewById(R.id.btn_voucher_authorize);
        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        aDao.approveVoucher(employee.getEmployeeID(), adjustment.getAdjustmentID());
                        return null;
                    }
                }.execute();
                Intent intent = new Intent(getApplicationContext(), AdjustmentVouchersAuthorize.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        Button btnReject = (Button) findViewById(R.id.btn_voucher_reject);
        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        aDao.rejectVoucher(employee.getEmployeeID(), adjustment.getAdjustmentID());
                        return null;
                    }
                }.execute();
                Intent intent = new Intent(getApplicationContext(), AdjustmentVouchersAuthorize.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_authorizeAdjustment_adjustmentItems);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (employee.getPosition().equals("Store Supervisor")) {
                    intent = new Intent(getApplicationContext(), SupervisorMainPage.class);
                    intent.putExtra("role", employee);
                    startActivity(intent);
                } else if (employee.getPosition().equals("Store Manager")) {
                    intent = new Intent(getApplicationContext(), ManagerMainPage.class);
                    intent.putExtra("role", employee);
                    startActivity(intent);
                } else {

                }
            }
        });

    }
}
