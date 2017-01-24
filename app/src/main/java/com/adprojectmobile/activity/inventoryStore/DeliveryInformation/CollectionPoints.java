package com.adprojectmobile.activity.inventoryStore.DeliveryInformation;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.ConfirmDisbursement.ConfirmCollection;
import com.adprojectmobile.adapter.collectionAdapter;
import com.adprojectmobile.dao.Dao.collectionPointDao;
import com.adprojectmobile.dao.DaoImpl.collectionPointDaoImpl;
import com.adprojectmobile.model.CollectionPoint;


import java.util.List;

public class CollectionPoints extends AppCompatActivity {
    collectionPointDao cpDao=new collectionPointDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_collection_points);

        final ListView collectionList=(ListView)findViewById(R.id.listview_delivery_collectionPoints);

        new AsyncTask<Void,Void,List<CollectionPoint>>(){
            @Override
            protected List<CollectionPoint> doInBackground(Void...params){
                return cpDao.getAllCollectionPoints();
            }

            @Override
            protected void onPostExecute(List<CollectionPoint> collections){
                collectionList.setAdapter(new collectionAdapter(CollectionPoints.this,R.layout.row_collection_point,collections));

            }
        }.execute();

        collectionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CollectionPoint collectionPoint=(CollectionPoint)parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),DepartmentsInCollection.class);
                intent.putExtra("data",collectionPoint);
                startActivity(intent);
            }
        });


    }
}

