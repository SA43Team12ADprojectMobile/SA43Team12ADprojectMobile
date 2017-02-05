package com.adprojectmobile.activity.department.ApproveRequisition;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.dao.Dao.itemTransactionDao;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.daoApi.approveDao;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

public class RejectRequisition extends AppCompatActivity {
    approveDao aDao=new approveDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.approve_req_activity_reject_requisition);

        final RequisitionApi requisition = getIntent().getParcelableExtra("data");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        final String eid=getIntent().getStringExtra("eid");
        String employeeId=new String();
        if (employee.getPosition().equals("Employee")||employee.getPosition().equals("Representative")){
            employeeId=eid;
        }
        else {
            employeeId=employee.getEmployeeID();
        }
        final String emId=employeeId;



        final EditText editTextEmployeeName = (EditText) findViewById(R.id.editText_EmployeeName_rejectRequisition);
        final EditText editTextCollectionTime = (EditText) findViewById(R.id.editText_CollectionTime_rejectRequisition);
        final EditText editTextItemNumber = (EditText) findViewById(R.id.editText_ItemNumber_rejectRequisition);
        final EditText editTextRejectedReason= (EditText) findViewById(R.id.editText_RejectionReason_rejectRequisition);

            editTextEmployeeName.setText(requisition.getCreatedBy());
            editTextCollectionTime.setText(requisition.getIssuedDate());
            editTextItemNumber.setText(requisition.getNumberOfItem());
            //editTextRejectedReason.setText(requisition.getRemarks());
        final String empId=employee.getEmployeeID();
        final String reqId=requisition.getId();




        Button btn_save=(Button)findViewById(R.id.btn_save_reject_requisition);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String remarks=editTextRejectedReason.getText().toString();
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        aDao.rejectRequisition(reqId,employee.getEmployeeID(),remarks);
                        return null;
                    }
                }.execute();

                Toast.makeText(getApplicationContext(),"Rejected",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),Requisitions.class);
                intent.putExtra("role",employee);
                intent.putExtra("eid",eid);
                startActivity(intent);
            }
        });
    }

}

