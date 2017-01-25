package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.requisitionItemAdapter;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.testdata.testAdapter;
import com.adprojectmobile.testdata.testCollectionList;
import com.adprojectmobile.testdata.testCollectionPoint;
import com.adprojectmobile.testdata.testDao;
import com.adprojectmobile.testdata.testDaoImpl;
import com.adprojectmobile.util.DummyData;

import java.util.ArrayList;
import java.util.List;

public class ItemsForCollection extends AppCompatActivity {

    requisitionItemDao reqItemDao=new requisitionItemDaoImpl();
    requisitionDao reqDao=new requisitionDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieval_form_activity_collection_items);

        final Requisition requisition=getIntent().getParcelableExtra("data");
       // Toast.makeText(getApplicationContext(),requisition.getRequisitionDate().toString(),Toast.LENGTH_LONG).show();

        final ListView requisitionItemView=(ListView)findViewById(R.id.listview_retrieval_disbursement_items);


        new AsyncTask<Requisition,Void,List<RequisitionItem>>() {
            @Override
            protected List<RequisitionItem> doInBackground(Requisition...params) {
                //return reqItemDao.getAllRequisitionItems();
                return reqItemDao.getItemsInRequisition(requisition);
            }
            @Override
            protected void onPostExecute(List<RequisitionItem> requisitionItems)
            {
                //requisitionItemView.setAdapter(new requisitionItemAdapter(ItemsForCollection.this,R.layout.row_retrieval_form_disbursement_items,requisitionItems));
                requisitionItemView.setAdapter(new requisitionItemAdapter(ItemsForCollection.this,R.layout.row_retrieval_form_disbursement_items,requisitionItems));
            }
        }.execute();

        requisitionItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RequisitionItem requisitionItem = (RequisitionItem) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ConfirmRetrieval.class);
                intent.putExtra("data", requisitionItem);
                startActivity(intent);
            }
        });





//        Disbursement disbursement=(Disbursement)getIntent().getParcelableExtra("disbursement");
//        List<Requisition> requisitions= reqDao.getDisbursementRequisition(disbursement);
//        List<RequisitionItem> allRequisitionItemsInRequisition = new ArrayList<>();
//
//        List<RequisitionItem> requisitionItems = new ArrayList<>();
//        for (Requisition req : requisitions
//                ) {
//            if (requisitions != null) {
//                requisitionItems = reqItemDao.getItemsInRequisition(req);
//                for (RequisitionItem reqItem : requisitionItems
//                        ) {
//                    if (requisitionItems != null) {
//                        RequisitionItem reqAdd = reqItem;
//                        allRequisitionItemsInRequisition.add(reqAdd);
//                    }
//                }
//            }
//        }
//        final TextView testview=(TextView)findViewById(R.id.textview_test);
//        if (allRequisitionItemsInRequisition!=null){
//            testview.setText(allRequisitionItemsInRequisition.get(0).toString());
//        }
//
//        final ListView requisitionItemList=(ListView)findViewById(R.id.listview_retrieval_disbursement_items);
//
//        requisitionItemList.setAdapter(new requisitionItemAdapter(getApplicationContext(),R.layout.row_retrieval_form_disbursement_items,allRequisitionItemsInRequisition));
//
//        requisitionItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                RequisitionItem requisitionItem = (RequisitionItem) parent.getAdapter().getItem(position);
//
//                Intent intent = new Intent(getApplicationContext(), ConfirmRetrieval.class);
//                intent.putExtra("req", requisitionItem);
//                startActivity(intent);
//            }
//        });

    }
}
