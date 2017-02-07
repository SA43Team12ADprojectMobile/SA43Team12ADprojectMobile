package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.ManagerMainPage;
import com.adprojectmobile.activity.inventoryStore.SupervisorMainPage;
import com.adprojectmobile.adapter.adjustmentAdapter;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.adjustDao;

import java.util.List;

public class AdjustmentVouchersAuthorize extends AppCompatActivity {
    adjustDao aDao = new adjustDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_authorize_activity_adjustment_vouchers_authorize);

        final Employee employee = getIntent().getParcelableExtra("role");

        final ListView adjustmentView = (ListView) findViewById(R.id.listview_adjustment_voucher_for_approve);

        new AsyncTask<Void, Void, List<Adjustment>>() {
            @Override
            protected List<Adjustment> doInBackground(Void... params) {
                return aDao.getAuthorizeVoucher(employee.getEmployeeID());
            }

            @Override
            protected void onPostExecute(List<Adjustment> adjustments) {
                adjustmentView.setAdapter(new adjustmentAdapter(getApplicationContext(), R.layout.row_adjustment_voucher, adjustments));
            }
        }.execute();

        adjustmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Adjustment adjustment = (Adjustment) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ItemsInVoucherAuthorize.class);
                intent.putExtra("data", adjustment);
                intent.putExtra("role", employee);
                intent.putExtra("id", adjustment.getAdjustmentID());
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_authorizeAdjustment_vouchers);
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
