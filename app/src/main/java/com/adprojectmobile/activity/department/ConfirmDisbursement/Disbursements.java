package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.DeliveryInformation.RequisitionItems;
import com.adprojectmobile.adapter.disbursementAdapter;
import com.adprojectmobile.adapter.requisitionAdapter;
import com.adprojectmobile.dao.Dao.disbursementDao;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.Requisition;

import java.util.List;

public class Disbursements extends AppCompatActivity {
    requisitionDao requisitionDao = new requisitionDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_disbursements);

        final ListView requisitionList =(ListView)findViewById(R.id.listview_confirm_disbursements);

        new AsyncTask<Void,Void,List<Requisition>>(){
            @Override
            protected List<Requisition> doInBackground(Void...params){
                return requisitionDao.getAllRequisitions();
            }

            @Override
            protected void onPostExecute(List<Requisition> requisitionses){
                requisitionList.setAdapter(new requisitionAdapter(Disbursements.this,R.layout.row_confirm_disbursements, requisitionses));

            }
        }.execute();

        requisitionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Requisition requisition = (Requisition) parent.getAdapter().getItem(position);

                Intent intent = new Intent(Disbursements.this, DisbursementItems.class);

                intent.putExtra("data", requisition);
                startActivity(intent);
            }
        });
    }
}

