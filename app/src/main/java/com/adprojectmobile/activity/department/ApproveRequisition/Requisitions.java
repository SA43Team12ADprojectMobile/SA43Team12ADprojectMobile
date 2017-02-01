package com.adprojectmobile.activity.department.ApproveRequisition;

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
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.dao.Dao.disbursementDao;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.daoApi.approveDao;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.Requisition;

import java.util.List;

public class Requisitions extends AppCompatActivity {
    requisitionDao requisitionDao = new requisitionDaoImpl();
    approveDao aDao=new approveDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.approve_req_activity_requisitions);
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        final String empId=employee.getEmployeeID();

        final ListView requisitionList =(ListView)findViewById(R.id.listview_approve_requisitions);

        new AsyncTask<Void,Void,List<RequisitionApi>>(){
            @Override
            protected List<RequisitionApi> doInBackground(Void...params){
                return aDao.getAllRequisition(empId);
            }

            @Override
            protected void onPostExecute(List<RequisitionApi> requisitionses){
                requisitionList.setAdapter(new requisitionAdapter(Requisitions.this,R.layout.row_approve_requisition_list, requisitionses));

            }
        }.execute();

        requisitionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RequisitionApi requisition = (RequisitionApi) parent.getAdapter().getItem(position);

                Intent intent = new Intent(Requisitions.this, RequisitionItemsforApprove.class);

                intent.putExtra("requisition", requisition);
                intent.putExtra("data",requisition.getId());
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });
    }
}

