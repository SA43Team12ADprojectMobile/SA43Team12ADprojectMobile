package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.AdjustmentVouchers;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.adapter.requisitionItemAdapter;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.RetrievalCollectionPoint;
import com.adprojectmobile.model.RetrievalItem;
import com.adprojectmobile.dao.retrievalDao;

import java.util.List;

public class ItemsForCollection extends AppCompatActivity {
    retrievalDao rDao = new retrievalDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieval_form_activity_collection_items);

        final Employee employee = getIntent().getParcelableExtra("role");
        final String id = getIntent().getStringExtra("id");
        final RetrievalCollectionPoint retrievalCollectionPoint = getIntent().getParcelableExtra("collection");

        final ListView requisitionItemView = (ListView) findViewById(R.id.listview_retrieval_disbursement_items);
        final CheckBox checkBoxPrepared = (CheckBox) findViewById(R.id.checkBox_prepared);
        checkBoxPrepared.setChecked(retrievalCollectionPoint.getPrepared().contains("true"));
        final Boolean isPrepared = checkBoxPrepared.isChecked();
        if (isPrepared) {
            checkBoxPrepared.setEnabled(false);
        }

        new AsyncTask<RetrievalCollectionPoint, Void, List<RetrievalItem>>() {
            @Override
            protected List<RetrievalItem> doInBackground(RetrievalCollectionPoint... params) {
                List<RetrievalCollectionPoint> collectionPoints = rDao.getAllCollectionPoint(employee.getEmployeeID());
                RetrievalCollectionPoint retrievalCP = new RetrievalCollectionPoint();
                for (RetrievalCollectionPoint rc :
                        collectionPoints) {
                    if (rc.getCollectionPointID().equals(id) && rc.getDate().equals(retrievalCollectionPoint.getDate())) {
                        retrievalCP = rc;
                        Log.e("rc", rc.getCollectionPointID());
                    }
                }

                final List<RetrievalItem> retrievalItems = rDao.getItemsByCollection(retrievalCP.getItemJson());
                return retrievalItems;
            }

            @Override
            protected void onPostExecute(List<RetrievalItem> requisitionItems) {
                requisitionItemView.setAdapter(new requisitionItemAdapter(ItemsForCollection.this, R.layout.row_retrieval_form_disbursement_items, requisitionItems));
            }
        }.execute();

        requisitionItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RetrievalItem retrievalItem = (RetrievalItem) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ConfirmRetrieval.class);
                intent.putExtra("data", retrievalItem);
                intent.putExtra("id", id);
                intent.putExtra("collection", retrievalCollectionPoint);
                intent.putExtra("role", employee);
                intent.putExtra("prepared", isPrepared);
                startActivity(intent);
            }
        });

        Button btnSave = (Button) findViewById(R.id.btn_save_retrieval_info);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPrepared) {
                    Toast.makeText(getApplicationContext(), "Already Prepared", Toast.LENGTH_LONG).show();
                } else if (checkBoxPrepared.isChecked()) {
                    new AsyncTask<String, Void, String>() {
                        @Override
                        protected String doInBackground(String... params) {
                            String re = rDao.savePrepared(retrievalCollectionPoint.getCollectionPointID());
                            Log.e("result", re);
                            return re;
                        }

                        @Override
                        protected void onPostExecute(String result) {
                            if (result.contains("t")) {
                                Intent intent = new Intent(getApplicationContext(), AdjustmentVouchers.class);
                                intent.putExtra("role", employee);
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(getApplicationContext(), com.adprojectmobile.activity.inventoryStore.RetrievalForm.CollectionPoints.class);
                                intent.putExtra("data", employee);
                                startActivity(intent);
                            }
                        }
                    }.execute();
                } else {
                    Toast.makeText(getApplicationContext(), "Sure to Save? Enable Check Box", Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_retrieval_disbursement_item_name);
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