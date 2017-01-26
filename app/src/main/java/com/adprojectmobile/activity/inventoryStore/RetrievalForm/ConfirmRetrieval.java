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
import com.adprojectmobile.dao.Dao.itemTransactionDao;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

public class ConfirmRetrieval extends AppCompatActivity {
    itemTransactionDao itemTransactionDao=new itemTransactionDaoImpl();
    itemDao itemDao=new itemDaoImpl();
    requisitionItemDao reqDao=new requisitionItemDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieval_form_activity_confirm_retrieval);

        final RequisitionItem requisitionItem = getIntent().getParcelableExtra("data");
        final ItemTransaction itemTransaction=requisitionItem.getItemTransaction();
        final Item item=itemTransaction.getItem();

        final EditText editTextItemCode = (EditText) findViewById(R.id.editText_itemCode_confirmCollection);
        final EditText editTextName = (EditText) findViewById(R.id.editText_itemName_confirmCollection);
        final EditText editTextQtyNeeded = (EditText) findViewById(R.id.editText_itemQtyNeeded_confirmCollection);
        final EditText editTextQtyRetri= (EditText) findViewById(R.id.editText_itemQtyRetrieval_confirmCollection);
        if (item!=null ){
            editTextItemCode.setText(item.getItemId());
            editTextName.setText(item.getDescription());

            editTextQtyNeeded.setText(requisitionItem.getNeededQuantityStr().toString());
            editTextQtyRetri.setText(requisitionItem.getRetrievedQuantityStr().toString());
        }


        Button btn_save=(Button)findViewById(R.id.btn_save_confirm_retrieval);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String retrievedQty=editTextQtyRetri.getText().toString();
                Integer qtyChanged=Integer.parseInt(retrievedQty);
                requisitionItem.setRetrievedQuantity(qtyChanged);
                reqDao.saveRetrievalQty(requisitionItem);

                ItemTransaction tmpTransaction=requisitionItem.getItemTransaction();
                Item dataItem=tmpTransaction.getItem();
                Intent intent;
                finish();
                if(editTextQtyNeeded.getText().toString().contains(editTextQtyRetri.getText().toString())){
                    intent=new Intent(getApplicationContext(), AdjustItemQty.class);
                    intent.putExtra("data",dataItem);
                    intent.putExtra("isAdd",true);
                    startActivity(intent);
                }
            }
        });
    }

}
