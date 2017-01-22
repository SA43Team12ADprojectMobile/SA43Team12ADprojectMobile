package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.adapter.*;
import com.adprojectmobile.R;
import com.adprojectmobile.model.Disbursement;

import java.util.List;

public class CollectionPoints extends AppCompatActivity implements AdapterView.OnItemClickListener{

    disbursementDao disbursementDao=new disbursementDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retreival_form_activity_collection_points);

        final ListView disbursementList=(ListView)findViewById(R.id.listview_retrival_collectionPoints);

        new AsyncTask<Void,Void,List<Disbursement>>(){
            @Override
            protected List<Disbursement> doInBackground(Void...params){
                return disbursementDao.getAllDisbursement();
            }

            @Override
            protected void onPostExecute(List<Disbursement> disbursements){
                disbursementList.setAdapter(new disbursementAdapter(CollectionPoints.this,R.layout.row_disbursement,disbursements));

            }
        }.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View v, int position,long id){
//        Disbursement disbursement=(Disbursement)adapterView.getAdapter().getItem(position);
//        Intent intent=new Intent(CollectionPoints.this,ItemsForCollection.class);
//        intent.putExtra("disbursement",disbursement);
    }
}
