package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.disbursementItemAdapter;
import com.adprojectmobile.adapter.requisitionItemForApprovalAdapter;
import com.adprojectmobile.apiModel.DisbursementApi;
import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.daoApi.approveDao;
import com.adprojectmobile.daoApi.confirmDao;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.apiModel.DisbursementItemApi;

import java.util.List;

public class DisbursementItems extends AppCompatActivity {
    approveDao aDao=new approveDao();
    confirmDao cDao=new confirmDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_disbursement_items);

        final DisbursementApi disbursementApi = getIntent().getParcelableExtra("data");

        final ListView requisitionItemView = (ListView) findViewById(R.id.listview_confirm_disbursements_items);
        final String id=disbursementApi.getDisbursementID();


        new AsyncTask<String, Void, List<DisbursementItemApi>>() {
            @Override
            protected List<DisbursementItemApi> doInBackground(String... params) {
                List<DisbursementItemApi> disbursementItemApis = cDao.getDisbursementItem(id);

                return disbursementItemApis;
            }

            @Override
            protected void onPostExecute(List<DisbursementItemApi> disbursementItemApis) {
                //requisitionItemView.setAdapter(new requisitionItemAdapter(ItemsForCollection.this,R.layout.row_retrieval_form_disbursement_items,requisitionItems));
                requisitionItemView.setAdapter(new disbursementItemAdapter(DisbursementItems.this, R.layout.row_confirm_disbursements_items, disbursementItemApis));
            }
        }.execute();

        requisitionItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DisbursementItemApi disbursementItemApi = (DisbursementItemApi) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ConfirmCollection.class);
                intent.putExtra("data",disbursementItemApi);
                startActivity(intent);
            }
        });
    }
}
