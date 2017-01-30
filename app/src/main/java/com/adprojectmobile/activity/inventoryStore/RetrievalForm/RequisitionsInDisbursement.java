package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.requisitionAdapter;
import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.model.CollectionPoint;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Requisition;

import java.util.List;

public class RequisitionsInDisbursement extends Activity {

    requisitionDao reqDao=new requisitionDaoImpl();
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieval_form_activity_requisitions_in_disbursement);

        final Disbursement disbursement=getIntent().getParcelableExtra("disbursement");

        final ListView requisitionView=(ListView)findViewById(R.id.listview_retrival_requisitions);

        new AsyncTask<Disbursement,Void,List<RequisitionApi>>() {
            @Override
            protected List<RequisitionApi> doInBackground(Disbursement...params) {
              // return reqDao.getDisbursementRequisition(disbursement);
                return null;
            }

            @Override
            protected void onPostExecute(List<RequisitionApi> requisitions){
                requisitionView.setAdapter(new requisitionAdapter(RequisitionsInDisbursement.this,R.layout.row_requisitions_retrieval,requisitions));
            }
        }.execute();


        requisitionView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Requisition requisition=(Requisition) parent.getAdapter().getItem(position);

                Intent intent=new Intent(RequisitionsInDisbursement.this,ItemsForCollection.class);
                intent.putExtra("data",requisition);
                startActivity(intent);
            }
        });

    }
}
