package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.adprojectmobile.apiModel.RetrievalCollectionPoint;
import com.adprojectmobile.apiModel.RetrievalItem;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.adapter.*;
import com.adprojectmobile.R;
import com.adprojectmobile.daoApi.retrievalDao;
import com.adprojectmobile.model.Disbursement;

import java.io.Serializable;
import java.util.List;

public class CollectionPoints extends AppCompatActivity  {

    disbursementDao disbursementDao=new disbursementDaoImpl();
    retrievalDao rDao=new retrievalDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retreival_form_activity_collection_points);

        final ListView disbursementList=(ListView)findViewById(R.id.listview_retrival_collectionPoints);

        new AsyncTask<Void,Void,List<RetrievalCollectionPoint>>(){
            @Override
            protected List<RetrievalCollectionPoint> doInBackground(Void...params){
               // return disbursementDao.getAllDisbursement();
                return rDao.getAllCollectionPoint();
            }

            @Override
            protected void onPostExecute(List<RetrievalCollectionPoint> disbursements){
                disbursementList.setAdapter(new disbursementAdapter(CollectionPoints.this,R.layout.row_disbursement,disbursements));

            }
        }.execute();

        disbursementList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RetrievalCollectionPoint retrievalCollectionPoint = (RetrievalCollectionPoint) parent.getAdapter().getItem(position);

                Intent intent = new Intent(CollectionPoints.this, ItemsForCollection.class);

                intent.putExtra("json",retrievalCollectionPoint.getCollectionPointID().toString() );

                startActivity(intent);
            }
        });
    }
}
