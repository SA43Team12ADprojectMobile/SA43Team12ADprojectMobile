package com.adprojectmobile.activity.inventoryStore.AcknowledgeDisbursement;

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
import com.adprojectmobile.adapter.departmentAdapter;
import com.adprojectmobile.model.DeliveryDisbursement;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.deliveryDao;

import java.util.List;

public class DepartmentsInCollection extends AppCompatActivity {
    deliveryDao dDao = new deliveryDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_departments_in_collection);
        final DeliveryDisbursement deliveryDisbursement = getIntent().getParcelableExtra("data");
        final Employee employee = getIntent().getParcelableExtra("role");
        Log.e("delivery", deliveryDisbursement.getCollectionPointName());

        final ListView departmentView = (ListView) findViewById(R.id.listview_delivery_department);

        new AsyncTask<DeliveryDisbursement, Void, List<Department>>() {
            @Override
            protected List<Department> doInBackground(DeliveryDisbursement... params) {
                return dDao.getDepartmentByCollectionPoint(deliveryDisbursement);
            }

            @Override
            protected void onPostExecute(List<Department> departments) {
                departmentView.setAdapter(new departmentAdapter(DepartmentsInCollection.this, R.layout.row_department_delivery, departments));
            }
        }.execute();

        departmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Department department = (Department) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), DepartmentDetail.class);
                intent.putExtra("data", department);
                intent.putExtra("id", department.getDepartmentID());
                intent.putExtra("dis", deliveryDisbursement);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_acknowledgeDisbursements_departments);
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
