package com.adprojectmobile.activity.department.ApproveRequisition;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.requisitionItemAdapter;
import com.adprojectmobile.adapter.requisitionItemForApprovalAdapter;
import com.adprojectmobile.apiModel.EmployeeApi;
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

public class RequisitionItemsforApprove extends AppCompatActivity {

    approveDao aDao=new approveDao();
    requisitionItemDao reqItemDao = new requisitionItemDaoImpl();
    requisitionDao reqDao = new requisitionDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.approve_req_activity_requisition_itemsfor_approve);

        final RequisitionApi requisition = getIntent().getParcelableExtra("requisition");
        final String id=getIntent().getStringExtra("data");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        final String reqId=requisition.getId();

        final String eid=getIntent().getStringExtra("eid");
        String employeeId=new String();
        if (employee.getPosition().equals("Employee")||employee.getPosition().equals("Representative")){
            employeeId=eid;
        }
        else {
            employeeId=employee.getEmployeeID();
        }
        final String empId=employeeId;
        // Toast.makeText(getApplicationContext(),requisition.getRequisitionDate().toString(),Toast.LENGTH_LONG).show();

        final ListView requisitionItemView = (ListView) findViewById(R.id.listview_approve_requisitions_items);


        new AsyncTask<RequisitionApi, Void, List<RequisitionItemApi>>() {
            @Override
            protected List<RequisitionItemApi> doInBackground(RequisitionApi... params) {
              //  return reqItemDao.getAllRequisitionItems();
                List<RequisitionApi> requisitionApis = aDao.getAllRequisition(empId);
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
                requisitionItemView.setAdapter(new requisitionItemForApprovalAdapter(RequisitionItemsforApprove.this, R.layout.row_approve_requisition_items, requisitionItems));
            }
        }.execute();

//        requisitionItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                RequisitionItem requisitionItem = (RequisitionItem) parent.getAdapter().getItem(position);
//
//                Intent intent = new Intent(getApplicationContext(), RejectRequisition.class);
//                intent.putExtra("data", requisitionItem);
//                intent.putExtra("data1", requisition);
//                startActivity(intent);
        Button btnApproveRequisition=(Button)findViewById(R.id.btn_approve_requisition);
        btnApproveRequisition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        aDao.approveRequisition(reqId,empId);
                        return null;
                    }
                }.execute();

                Toast.makeText(getApplicationContext(),"Approved",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),Requisitions.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

        Button btnRejectRequisition =(Button)findViewById(R.id.btn_reject_requisition);
        btnRejectRequisition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RequisitionItemsforApprove.this, RejectRequisition.class);
                intent.putExtra("data",requisition);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });
    }
}