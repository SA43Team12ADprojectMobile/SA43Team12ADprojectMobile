package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.adapter.adjustmentAdapter;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.adjustDao;

import java.util.List;

public class AdjustmentVouchers extends AppCompatActivity {
    adjustDao aDao = new adjustDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_view_activity_adjustment_vouchers);
        final Employee employee = getIntent().getParcelableExtra("role");
        Log.e("role", employee.getName());

        final ListView adjustmentView = (ListView) findViewById(R.id.listview_adjustment_voucher);

        new AsyncTask<String, Void, List<Adjustment>>() {
            @Override
            protected List<Adjustment> doInBackground(String... params) {
                return aDao.getAllAdjustment(employee.getEmployeeID());
            }
            @Override
            protected void onPostExecute(List<Adjustment> adjustments) {
                adjustmentView.setAdapter(new adjustmentAdapter(AdjustmentVouchers.this, R.layout.row_adjustment_voucher, adjustments));

            }
        }.execute();

        adjustmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Adjustment adjustment = (Adjustment) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ItemsInVoucher.class);
                intent.putExtra("data", adjustment);
                intent.putExtra("role", employee);
                intent.putExtra("id", adjustment.getAdjustmentID());
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textview_title_view_adjustmentVouchers);
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
