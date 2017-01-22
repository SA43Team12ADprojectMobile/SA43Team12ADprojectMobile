package com.adprojectmobile;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;
import com.adprojectmobile.testdata.testAdapter;
import com.adprojectmobile.testdata.testCollectionPoint;
import com.adprojectmobile.testdata.testDao;
import com.adprojectmobile.testdata.testDaoImpl;

public class testCollectionList extends AppCompatActivity {
    testDao testDao=new testDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_list);

        final ListView collectionListView=(ListView) findViewById(R.id.listview_collectionList);

        new AsyncTask<Void,Void,List<testCollectionPoint>>(){
            @Override
            protected List<testCollectionPoint> doInBackground(Void...params){
                return testDao.getAllCollectionPoints();
            }

            @Override
            protected void onPostExecute(List<testCollectionPoint> collections){
                collectionListView.setAdapter(new testAdapter(testCollectionList.this,R.layout.row_collection_point,collections));

            }
        }.execute();
    }
}
