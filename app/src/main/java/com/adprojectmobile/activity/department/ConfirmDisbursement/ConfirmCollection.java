//package com.adprojectmobile.activity.department.ConfirmDisbursement;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import com.adprojectmobile.R;
//import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
//import com.adprojectmobile.model.Requisition;
//import com.adprojectmobile.model.RequisitionItem;
//
//import java.util.List;
//
//public class ConfirmCollection extends AppCompatActivity {
//
//    requisitionDao requisitionDao = new requisitionDaoImpl();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.confirm_disbursement_activity_confirm_collection);
//
//        final RequisitionItem requisitionItem = getIntent().getParcelableExtra("data");
//        final Requisition requisition = getIntent().getParcelableExtra("data1");
//        List<Requisition> requisitionList= requisitionDao.getAllRequisitions();
//
//        final RequisitionItem requisitionItem = getIntent().getParcelableExtra("data");
//        final ItemTransaction itemTransaction=requisitionItem.getItemTransaction();
//        final Item item=itemTransaction.getItem();
//
//        final EditText editTextItemName = (EditText) findViewById(R.id.editText_itemName_confirmCollection);
//        final EditText editTextQuantityRequired = (EditText) findViewById(R.id.editText_itemQtyNeeded_confirmCollection);
//        final EditText editTextQuantityRetrieved= (EditText) findViewById(R.id.editText_itemQtyRetrieval_confirmCollection);
//        if (!requisitionList.isEmpty()){
//        //    Requisition requisition1 =requisitionList.get(0);
//            editTextItemName.setText(requisition.);
//            editTextQuantityRequired.setText(requisiti.getRequisitionQuantitystr().);
//            editTextQuantityRetrieved.setText(requisition1.setRequisitionQuantity());
//
//        }
//
//
//        Button btn_save=(Button)findViewById(R.id.btn_save_reject_requisition);
//        btn_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String rejectedReason=editTextRejectedReason.getText().toString();
//                //String reasonChanged=String.(retrievedQty);
//                requisition.setRemarks(rejectedReason);
//                //     requisitionDao.saveRejectedReason(requisitionItem);
//
//                finish();
//            }
//        });
//    }
