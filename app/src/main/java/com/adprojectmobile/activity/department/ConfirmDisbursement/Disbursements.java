package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.DeliveryInformation.RequisitionItems;
import com.adprojectmobile.adapter.disbursementAdapter;
import com.adprojectmobile.adapter.disbursementApiAdapter;
import com.adprojectmobile.adapter.requisitionAdapter;
import com.adprojectmobile.apiModel.DisbursementApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.dao.Dao.disbursementDao;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.daoApi.approveDao;
import com.adprojectmobile.daoApi.confirmDao;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.Requisition;

import java.util.List;

public class Disbursements extends AppCompatActivity {
    confirmDao cDao=new confirmDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_disbursements);
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        Log.e("role",employee.getName());

        final ListView requisitionList =(ListView)findViewById(R.id.listview_confirm_disbursements);

        new AsyncTask<Void,Void,List<DisbursementApi>>(){
            @Override
            protected List<DisbursementApi> doInBackground(Void...params){
                //return requisitionDao.getAllRequisitions();
                return cDao.getPreparedDisbursement(employee);
            }

            @Override
            protected void onPostExecute(List<DisbursementApi> disbursementApis){
                requisitionList.setAdapter(new disbursementApiAdapter(Disbursements.this,R.layout.row_confirm_disbursements, disbursementApis));

            }
        }.execute();

        requisitionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DisbursementApi disbursementApi = (DisbursementApi) parent.getAdapter().getItem(position);

                Intent intent = new Intent(Disbursements.this, DisbursementItems.class);

                intent.putExtra("data",disbursementApi);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });
    }
}

