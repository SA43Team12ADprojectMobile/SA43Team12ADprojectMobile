package com.adprojectmobile.testdata;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.adprojectmobile.R;

public class testCollectionList extends AppCompatActivity {
    testDao testDao=new testDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_list);

        final ListView collectionListView=(ListView) findViewById(R.id.listview_collectionList);

        List<testCollectionPoint> col=testDao.getAllCollectionPoints();

        collectionListView.setAdapter(new testAdapter(testCollectionList.this,R.layout.row_collection_point,col));

        collectionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"123",Toast.LENGTH_LONG).show();
            }
        });
    }

//        new AsyncTask<Void,Void,List<testCollectionPoint>>(){
//                @Override
//            protected List<testCollectionPoint> doInBackground(Void...params){
//                return testDao.getAllCollectionPoints();
//            }
//
//            @Override
//            protected void onPostExecute(List<testCollectionPoint> collections){
//                collectionListView.setAdapter(new testAdapter(testCollectionList.this,R.layout.row_collection_point,collections));
//            }
//        }.execute();
//    }


}
