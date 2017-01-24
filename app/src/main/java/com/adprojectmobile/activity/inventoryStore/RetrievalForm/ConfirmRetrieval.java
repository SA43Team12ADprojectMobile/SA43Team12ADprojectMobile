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
        List<ItemTransaction> itemTransactionList= itemTransactionDao.getItemTransationsByRequisitionItem(requisitionItem);
        ItemTransaction itemTransaction=itemTransactionList.get(0);
        List<Item> itemList=itemDao.getItemByItemTransaction(itemTransaction);


        final EditText editTextItemCode = (EditText) findViewById(R.id.editText_itemCode_confirmCollection);
        final EditText editTextName = (EditText) findViewById(R.id.editText_itemName_confirmCollection);
        final EditText editTextQtyNeeded = (EditText) findViewById(R.id.editText_itemQtyNeeded_confirmCollection);
        final EditText editTextQtyRetri= (EditText) findViewById(R.id.editText_itemQtyRetrieval_confirmCollection);
        if (!itemList.isEmpty()){
            Item itemGot =itemList.get(0);
            editTextItemCode.setText(itemGot.getItemId());
            editTextName.setText(itemGot.getDescription());

            editTextQtyNeeded.setText(requisitionItem.getNeededQuantityStr().toString());
            editTextQtyRetri.setText(requisitionItem.getRetrievedQuantityStr().toString());
        }


        Button btn_save=(Button)findViewById(R.id.btn_save_confirm_collection);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String retrievedQty=editTextQtyRetri.getText().toString();
                Integer qtyChanged=Integer.parseInt(retrievedQty);
                requisitionItem.setRetrievedQuantity(qtyChanged);
                reqDao.saveRetrievalQty(requisitionItem);

                finish();
            }
        });
    }

}
