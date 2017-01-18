package com.adprojectmobile.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.adprojectmobile.R;

import java.util.List;
import com.adprojectmobile.testdata.testAdapter;
import com.adprojectmobile.testdata.testCollectionPointModel;
import com.adprojectmobile.testdata.testDao;
import com.adprojectmobile.testdata.testDaoImpl;
import com.adprojectmobile.testdata.testDummyData;

public class CollectionList extends AppCompatActivity {
    testDao testDao=new testDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_list);

        final ListView collectionListView=(ListView) findViewById(R.id.listview_collectionList);

        new AsyncTask<Void,Void,List<testCollectionPointModel>>(){
            @Override
            protected List<testCollectionPointModel> doInBackground(Void...params){
                return testDao.getAllCollectionPoints();
            }

            @Override
            protected void onPostExecute(List<testCollectionPointModel> collections){
                collectionListView.setAdapter(new testAdapter(CollectionList.this,R.layout.row_collection_point,collections));

            }
        }.execute();
    }
}
