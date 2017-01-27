package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustItemQty;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.itemDaoImpl;
import com.adprojectmobile.dao.Dao.itemDao;
import com.adprojectmobile.dao.DaoImpl.itemTransactionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

public class ConfirmCollection extends AppCompatActivity {

    requisitionItemDao requisitionitemDao = new requisitionItemDaoImpl();
    itemTransactionDao itemTransactionDao=new itemTransactionDaoImpl();
    itemDao itemDao=new itemDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_confirm_collection);

        final RequisitionItem requisitionItem = getIntent().getParcelableExtra("data");
     //   final ItemTransaction itemTransaction=requisitionItem.getItemTransaction();
      //  final Item item=itemTransaction.getItem();




        final EditText editTextItemName = (EditText) findViewById(R.id.editText_itemDescription_confirmCollection);
        final EditText editTextQuantityRequired = (EditText) findViewById(R.id.editText_itemQtyRequired_confirmCollection);
        final EditText editTextQuantityRetrieved= (EditText) findViewById(R.id.editText_itemQtyRetrieval_confirmCollection);
        if (requisitionItem!=null){
        //    Requisition requisition1 =requisitionList.get(0);
          //  editTextItemName.setText(requisitionItem.getItemTransaction().getItem().getDescription());
         //   editTextQuantityRequired.setText(requisitionItem.getNeededQuantityStr().toString());
          //  editTextQuantityRetrieved.setText(requisitionItem.getRetrievedQuantityStr().toString());

        }


        Button btn_save=(Button)findViewById(R.id.btn_save_confirm_disbursement_confirm_collection);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String QuantityRetrieved =editTextQuantityRetrieved.getText().toString();
//                Integer quantityChanged=Integer.parseInt(QuantityRetrieved);
//                requisitionItem.setRetrievedQuantity(quantityChanged);
//                requisitionitemDao.saveRetrievalQty(requisitionItem);
//
//
//                ItemTransaction tmpTransaction=requisitionItem.getItemTransaction();
//                Item dataItem=tmpTransaction.getItem();
//                Intent intent;
                finish();
//                if(editTextQuantityRequired.getText().toString().contains(editTextQuantityRetrieved.getText().toString())){
//                    intent=new Intent(getApplicationContext(), AdjustItemQty.class);
//                    intent.putExtra("data",dataItem);
//                    intent.putExtra("isAdd",true);
//                    startActivity(intent);
//                }
            }
        });


    }
    }
