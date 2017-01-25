package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.dao.Dao.itemDao;
import com.adprojectmobile.dao.Dao.itemTransactionDao;
import com.adprojectmobile.dao.DaoImpl.itemDaoImpl;
import com.adprojectmobile.dao.DaoImpl.itemTransactionDaoImpl;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;

public class AdjustItemQty extends AppCompatActivity {

    itemTransactionDao itDao=new itemTransactionDaoImpl();
    itemDao itemDao=new itemDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_adjust_item_qty);

        final boolean isAdd=getIntent().getBooleanExtra("isAdd",true);
        Item item=new Item();
        AdjustmentItem adjustmentItem=new AdjustmentItem();
        if(isAdd){
            item=getIntent().getParcelableExtra("data");
        }
        if(!isAdd){
            adjustmentItem=getIntent().getParcelableExtra("data");
        }

        final Adjustment adjustment=getIntent().getParcelableExtra("data1");


        EditText editTextItemCode=(EditText) findViewById(R.id.editText_issue_itemAdjusted_item_code);
        EditText editTextItemName=(EditText) findViewById(R.id.editText_issue_itemAdjusted_item_name);
        EditText editTextQty=(EditText) findViewById(R.id.editText_issue_itemAdjusted_qty);
        EditText editTextReason=(EditText) findViewById(R.id.editText_issue_itemAdjusted_reason);

        if(isAdd){
            editTextItemCode.setText(item.getItemId());
            editTextItemName.setText(item.getDescription());
        }

        if (!isAdd){
            ItemTransaction itemTransaction=adjustmentItem.getItemTransaction();
            Item tmp= itemTransaction.getItem();
//
//                editTextItemCode.setText(tmp.getItemId());
//                editTextItemName.setText(tmp.getDescription());


            //editTextQty.setText();
            if(adjustmentItem!=null){
                editTextReason.setText(adjustmentItem.getReason());
            }

        }

        Button btnSave=(Button) findViewById(R.id.btn_save_issue);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnDelete=(Button) findViewById(R.id.btn_delete_issue);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
