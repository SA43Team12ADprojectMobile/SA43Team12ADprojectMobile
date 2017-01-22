package com.adprojectmobile.activity.inventoryStore.DeliveryInformation;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.adprojectmobile.R;
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
    }
}

