package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.MainActivity;
import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.ConfirmDisbursement.ConfirmCollection;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustItemQty;
import com.adprojectmobile.apiModel.RetrievalItem;
import com.adprojectmobile.dao.Dao.itemTransactionDao;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.daoApi.retrievalDao;
import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.util.JSONPaser;

import java.util.List;

public class ConfirmRetrieval extends AppCompatActivity {
        retrievalDao rDao=new retrievalDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieval_form_activity_confirm_retrieval);

        final RetrievalItem retrievalItem = getIntent().getParcelableExtra("data");
        //final ItemTransaction itemTransaction=requisitionItem.getItemTransaction();
//        final Item item=itemTransaction.getItem();

        final EditText editTextItemCode = (EditText) findViewById(R.id.editText_itemCode_confirmCollection);
        final EditText editTextName = (EditText) findViewById(R.id.editText_itemName_confirmCollection);
        final EditText editTextQtyNeeded = (EditText) findViewById(R.id.editText_itemQtyNeeded_confirmCollection);
        final EditText editTextQtyRetri= (EditText) findViewById(R.id.editText_itemQtyRetrieval_confirmCollection);

        editTextName.setText(retrievalItem.getName());
        editTextQtyNeeded.setText(retrievalItem.getQtyNeeded());
        editTextQtyRetri.setText(retrievalItem.getQtyRetrieved());



        Button btn_save=(Button)findViewById(R.id.btn_save_confirm_retrieval);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String retriQty= editTextQtyRetri.getText().toString();

                rDao.updateRetrievalQty(retrievalItem);

                finish();
                }
            }
        );
    }

}
