package com.adprojectmobile.activity.inventoryStore.AcknowledgeDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.AdjustmentVouchers;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.adapter.reqItemForDepAdapter;
import com.adprojectmobile.model.DeliveryDisbursement;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.RequisitionItem;

import com.adprojectmobile.dao.deliveryDao;

import org.json.JSONArray;

import java.util.List;

public class RequisitionItems extends AppCompatActivity {
    deliveryDao dDao = new deliveryDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_requisition_items);
        final Department department = getIntent().getParcelableExtra("data");
        final String id = getIntent().getStringExtra("id");
        final DeliveryDisbursement deliveryDisbursement = getIntent().getParcelableExtra("dis");
        final Employee employee = getIntent().getParcelableExtra("role");
        Log.e("id2", id);

        final ListView itemList = (ListView) findViewById(R.id.listview_delivery_itemList);

        new AsyncTask<JSONArray, Void, List<RequisitionItem>>() {
            @Override
            protected List<RequisitionItem> doInBackground(JSONArray... params) {
                List<Department> departments = dDao.getDepartmentByCollectionPoint(deliveryDisbursement);
                Department department = new Department();
                for (Department rc :
                        departments) {
                    if (rc.getDepartmentID() != null) {
                        if (rc.getDepartmentID().toString().equals(id)) {
                            department = rc;
                        }
                    }
                }
                return dDao.getRequisitionItemByDisbursement(department.getItems());
            }

            @Override
            protected void onPostExecute(List<RequisitionItem> requisitionItems) {
                itemList.setAdapter(new reqItemForDepAdapter(getApplicationContext(), R.layout.row_delivery_department_item, requisitionItems));
            }
        }.execute();

        Button btnAcknowledge = (Button) findViewById(R.id.btn_item_delivery_acknowledge);
        Button btnReject = (Button) findViewById(R.id.btn_item_delivery_reject);

        btnAcknowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        String result = dDao.acknowledgeDelivery(deliveryDisbursement);
                        return result;
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        Log.e("result", result);
                        if (result.contains("t")) {

                            Intent intent = new Intent(getApplicationContext(), AdjustmentVouchers.class);
                            intent.putExtra("role", employee);
                            startActivity(intent);

                        } else {

                            Intent intent = new Intent(getApplicationContext(), com.adprojectmobile.activity.inventoryStore.AcknowledgeDisbursement.CollectionPoints.class);
                            intent.putExtra("role", employee);
                            startActivity(intent);
                        }
                    }
                }.execute();

                Toast.makeText(getApplicationContext(), "Acknowledge Success", Toast.LENGTH_LONG).show();

            }
        });

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        dDao.rejectDelivery(deliveryDisbursement);
                        return null;
                    }
                }.execute();

                Toast.makeText(getApplicationContext(), "Rejected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), com.adprojectmobile.activity.inventoryStore.AcknowledgeDisbursement.CollectionPoints.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_acknowledgeDisbursements_items);
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
