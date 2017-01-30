package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.requisitionItemForApprovalAdapter;
import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.daoApi.approveDao;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

public class DisbursementItems extends AppCompatActivity {
    requisitionItemDao reqItemDao = new requisitionItemDaoImpl();
    requisitionDao reqDao = new requisitionDaoImpl();
    approveDao aDao=new approveDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_disbursement_items);

        final RequisitionApi requisition = getIntent().getParcelableExtra("requisition");
        final String id=getIntent().getStringExtra("data");
        // Toast.makeText(getApplicationContext(),requisition.getRequisitionDate().toString(),Toast.LENGTH_LONG).show();

        final ListView requisitionItemView = (ListView) findViewById(R.id.listview_confirm_disbursements_items);


        new AsyncTask<RequisitionApi, Void, List<RequisitionItemApi>>() {
            @Override
            protected List<RequisitionItemApi> doInBackground(RequisitionApi... params) {
                //return reqItemDao.getAllRequisitionItems();
                //return reqItemDao.getItemsInRequisition(requisition);
                List<RequisitionApi> requisitionApis = aDao.getAllRequisition();
                RequisitionApi requisitionApi = new RequisitionApi();
                for (RequisitionApi rc :
                        requisitionApis) {
                    if (rc.getId() != null) {
                        if (rc.getId().toString().equals(id)) {
                            requisitionApi = rc;
                        }
                    }

                }

                final List<RequisitionItemApi> retrievalItems = aDao.getItemByRequisition(requisitionApi);
                return retrievalItems;
            }

            @Override
            protected void onPostExecute(List<RequisitionItemApi> requisitionItems) {
                //requisitionItemView.setAdapter(new requisitionItemAdapter(ItemsForCollection.this,R.layout.row_retrieval_form_disbursement_items,requisitionItems));
                requisitionItemView.setAdapter(new requisitionItemForApprovalAdapter(DisbursementItems.this, R.layout.row_confirm_disbursements_items, requisitionItems));
            }
        }.execute();

        requisitionItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RequisitionItemApi requisitionItem = (RequisitionItemApi) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ConfirmCollection.class);
                intent.putExtra("data", requisitionItem);
                intent.putExtra("requisition", requisition);
                startActivity(intent);
            }
        });
    }
}
