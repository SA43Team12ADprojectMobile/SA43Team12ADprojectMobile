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
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

public class DisbursementItems extends AppCompatActivity {
    requisitionItemDao reqItemDao = new requisitionItemDaoImpl();
    requisitionDao reqDao = new requisitionDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_disbursement_items);

        final Requisition requisition = getIntent().getParcelableExtra("data");
        // Toast.makeText(getApplicationContext(),requisition.getRequisitionDate().toString(),Toast.LENGTH_LONG).show();

        final ListView requisitionItemView = (ListView) findViewById(R.id.listview_confirm_disbursements_items);


        new AsyncTask<Requisition, Void, List<RequisitionItem>>() {
            @Override
            protected List<RequisitionItem> doInBackground(Requisition... params) {
                return reqItemDao.getAllRequisitionItems();
                //return reqItemDao.getItemsInRequisition(requisition);
            }

            @Override
            protected void onPostExecute(List<RequisitionItem> requisitionItems) {
                //requisitionItemView.setAdapter(new requisitionItemAdapter(ItemsForCollection.this,R.layout.row_retrieval_form_disbursement_items,requisitionItems));
                requisitionItemView.setAdapter(new requisitionItemForApprovalAdapter(DisbursementItems.this, R.layout.row_confirm_disbursements_items, requisitionItems));
            }
        }.execute();

        requisitionItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RequisitionItem requisitionItem = (RequisitionItem) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ConfirmCollection.class);
                intent.putExtra("data", requisitionItem);
                intent.putExtra("data1", requisition);
                startActivity(intent);
            }
        });
    }
}
