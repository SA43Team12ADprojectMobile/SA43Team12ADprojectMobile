package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.requisitionItemAdapter;
import com.adprojectmobile.apiModel.RetrievalCollectionPoint;
import com.adprojectmobile.apiModel.RetrievalItem;
import com.adprojectmobile.daoApi.retrievalDao;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.testdata.testAdapter;
import com.adprojectmobile.testdata.testCollectionList;
import com.adprojectmobile.testdata.testCollectionPoint;
import com.adprojectmobile.testdata.testDao;
import com.adprojectmobile.testdata.testDaoImpl;
import com.adprojectmobile.util.DummyData;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ItemsForCollection extends AppCompatActivity {
    retrievalDao rDao=new retrievalDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieval_form_activity_collection_items);

        final String id = getIntent().getStringExtra("json");

        final ListView requisitionItemView = (ListView) findViewById(R.id.listview_retrieval_disbursement_items);


        new AsyncTask<RetrievalCollectionPoint, Void, List<RetrievalItem>>() {
            @Override
            protected List<RetrievalItem> doInBackground(RetrievalCollectionPoint... params) {
                List<RetrievalCollectionPoint> collectionPoints = rDao.getAllCollectionPoint();
                RetrievalCollectionPoint retrievalCP = new RetrievalCollectionPoint();
                for (RetrievalCollectionPoint rc :
                        collectionPoints) {
                    if (rc.getCollectionPointID() != null) {
                        if (rc.getCollectionPointID().toString().equals(id)) {
                                retrievalCP = rc;
                        }
                    }

                }

                final List<RetrievalItem> retrievalItems = rDao.getItemsByCollection(retrievalCP);
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
                startActivity(intent);
            }
        });

    }
}