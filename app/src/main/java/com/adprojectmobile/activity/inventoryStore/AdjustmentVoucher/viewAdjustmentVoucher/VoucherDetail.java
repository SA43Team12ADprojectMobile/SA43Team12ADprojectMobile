package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class VoucherDetail extends AppCompatActivity {

    itemTransactionDao itDao=new itemTransactionDaoImpl();
    itemDao itemDao=new itemDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_view_activity_voucher_detail);

        AdjustmentItem adjustmentItem=getIntent().getParcelableExtra("data");
        Adjustment adjustment=getIntent().getParcelableExtra("data1");

        final EditText editTextItemCode=(EditText) findViewById(R.id.editText_itemAdjusted_item_code);
        final EditText editTextItemName=(EditText) findViewById(R.id.editText_itemAdjusted_item_name);
        final EditText editTextItemQty=(EditText) findViewById(R.id.editText_itemAdjusted_qty);
        final EditText editTextItemIssueBy=(EditText) findViewById(R.id.editText_itemAdjusted_issued_by_employee_name);
        final EditText editTextItemAuthorizedBy=(EditText) findViewById(R.id.editText_itemAdjusted_authorized_by_employee_name);
        final EditText editTextReason=(EditText) findViewById(R.id.editText_itemAdjusted_reason);

        ItemTransaction itemTransaction=itDao.getItemTransactionByAdjustmentItem(adjustmentItem);
        Item item=itemDao.getItemByItemTrans(itemTransaction);

           editTextItemCode.setText(item.getItemId());
//            editTextItemName.setText(item.getDescription());
//
            editTextItemQty.setText(itemTransaction.getActualQuantityStr());
            editTextItemIssueBy.setText(adjustment.getIssuedBy());
            editTextItemAuthorizedBy.setText(adjustment.getApprovedBy());
            editTextItemAuthorizedBy.setText(adjustmentItem.getReason());



    }
}
