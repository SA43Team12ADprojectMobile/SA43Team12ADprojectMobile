package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.dao.Dao.itemTransactionDao;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

public class ConfirmRetrieval extends AppCompatActivity {
    itemTransactionDao itemTransactionDao=new itemTransactionDaoImpl();
   // itemDao itemDao=new
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieval_form_activity_confirm_retrieval);

        RequisitionItem requisitionItem = getIntent().getParcelableExtra("data");
        List<ItemTransaction> itemTransactionList= itemTransactionDao.getItemTransationsByRequisitionItem(requisitionItem);
        ItemTransaction itemTransaction=itemTransactionList.get(0);

        final EditText editTextItemCode = (EditText) findViewById(R.id.editText_itemCode_confirmCollection);
        final EditText editTextName = (EditText) findViewById(R.id.editText_itemName_confirmCollection);
        final EditText editTextQtyNeeded = (EditText) findViewById(R.id.editText_itemQtyNeeded_confirmCollection);
        final EditText editTextQtyRetri= (EditText) findViewById(R.id.editText_itemQtyRetrieval_confirmCollection);

    //    editTextItemCode.setText(requisitionItem.getItemTransaction().getDate());
//        editTextName.setText(requisitionItem.getItemTransaction().getItem().getDescription().toString());

        editTextQtyNeeded.setText(requisitionItem.getNeededQuantityStr().toString());
        editTextQtyRetri.setText(requisitionItem.getRetrievedQuantityStr().toString());
    }
}
