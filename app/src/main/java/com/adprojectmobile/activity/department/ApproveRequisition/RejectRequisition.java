package com.adprojectmobile.activity.department.ApproveRequisition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.dao.Dao.itemTransactionDao;
import com.adprojectmobile.dao.Dao.requisitionDao;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

public class RejectRequisition extends AppCompatActivity {
    requisitionDao requisitionDao = new requisitionDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.approve_req_activity_reject_requisition);

        final RequisitionItem requisitionItem = getIntent().getParcelableExtra("data");
        final Requisition requisition = getIntent().getParcelableExtra("data1");
        List<Requisition> requisitionList= requisitionDao.getAllRequisitions();


        final EditText editTextEmployeeName = (EditText) findViewById(R.id.editText_EmployeeName_rejectRequisition);
        final EditText editTextCollectionTime = (EditText) findViewById(R.id.editText_CollectionTime_rejectRequisition);
        final EditText editTextItemNumber = (EditText) findViewById(R.id.editText_ItemNumber_rejectRequisition);
        final EditText editTextRejectedReason= (EditText) findViewById(R.id.editText_RejectionReason_rejectRequisition);
        if (!requisitionList.isEmpty()){
            Requisition requisition1 =requisitionList.get(0);
            editTextEmployeeName.setText(requisition1.getEmployee().getName());
            editTextCollectionTime.setText(requisition1.getRequisitionDate());

            //  editTextItemNumber.setText(requisitionItem.());
        }


        Button btn_save=(Button)findViewById(R.id.btn_save_reject_requisition);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 //               String rejectedReason=editTextRejectedReason.getText().toString();
                //String reasonChanged=String.(retrievedQty);
//                requisition.setRemarks(rejectedReason);
                //     requisitionDao.saveRejectedReason(requisitionItem);

                finish();
            }
        });
    }

}

