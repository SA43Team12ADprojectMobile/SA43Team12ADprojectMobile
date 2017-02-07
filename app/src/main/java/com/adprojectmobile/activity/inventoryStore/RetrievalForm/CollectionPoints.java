package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.RetrievalCollectionPoint;

import com.adprojectmobile.adapter.*;
import com.adprojectmobile.R;
import com.adprojectmobile.dao.retrievalDao;

import java.util.List;

public class CollectionPoints extends AppCompatActivity {
    retrievalDao rDao = new retrievalDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retreival_form_activity_collection_points);

        final Employee employee = getIntent().getParcelableExtra("data");

        final ListView disbursementList = (ListView) findViewById(R.id.listview_retrival_collectionPoints);

        new AsyncTask<Void, Void, List<RetrievalCollectionPoint>>() {
            @Override
            protected List<RetrievalCollectionPoint> doInBackground(Void... params) {
                return rDao.getAllCollectionPoint(employee.getEmployeeID());
            }
            @Override
            protected void onPostExecute(List<RetrievalCollectionPoint> disbursements) {
                disbursementList.setAdapter(new disbursementAdapter(CollectionPoints.this, R.layout.row_disbursement, disbursements));
            }
        }.execute();

        disbursementList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RetrievalCollectionPoint retrievalCollectionPoint = (RetrievalCollectionPoint) parent.getAdapter().getItem(position);

                Intent intent = new Intent(CollectionPoints.this, ItemsForCollection.class);
                intent.putExtra("id", retrievalCollectionPoint.getCollectionPointID());
                intent.putExtra("role", employee);
                intent.putExtra("collection", retrievalCollectionPoint);
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textview_title_retrivalForm_disbursements);
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
