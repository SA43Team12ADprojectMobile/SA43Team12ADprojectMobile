package com.adprojectmobile.activity.inventoryStore.AcknowledgeDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.adapter.collectionAdapter;
import com.adprojectmobile.model.DeliveryDisbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.deliveryDao;

import java.util.List;

public class CollectionPoints extends AppCompatActivity {
    deliveryDao dDao = new deliveryDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_collection_points);

        final Employee employee = getIntent().getParcelableExtra("role");

        final ListView collectionList = (ListView) findViewById(R.id.listview_delivery_collectionPoints);

        new AsyncTask<Void, Void, List<DeliveryDisbursement>>() {
            @Override
            protected List<DeliveryDisbursement> doInBackground(Void... params) {
                return dDao.getAllDeliveryDisbursements();
            }

            @Override
            protected void onPostExecute(List<DeliveryDisbursement> collections) {
                collectionList.setAdapter(new collectionAdapter(CollectionPoints.this, R.layout.row_collection_point, collections));

            }
        }.execute();

        collectionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DeliveryDisbursement deliveryDisbursement = (DeliveryDisbursement) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), DepartmentsInCollection.class);
                intent.putExtra("data", deliveryDisbursement);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_acknowledgeDisbursements_collectionPoints);
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

