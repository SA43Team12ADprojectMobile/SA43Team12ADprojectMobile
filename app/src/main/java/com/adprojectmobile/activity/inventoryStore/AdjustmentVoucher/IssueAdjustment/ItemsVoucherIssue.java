package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.ItemsInVoucher;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.VoucherDetail;
import com.adprojectmobile.adapter.adjustmentItemAdapter;
import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentItemDaoImpl;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;

import java.util.List;

public class ItemsVoucherIssue extends AppCompatActivity {

    adjustmentItemDao adjItemDao=new adjustmentItemDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_items_voucher_issue);

        final Adjustment adjustment=getIntent().getParcelableExtra("data");

        final ListView adjustmentItemView=(ListView)findViewById(R.id.listview_adjustment_voucher_approve_itemlist);

        new AsyncTask<Adjustment,Void,List<AdjustmentItem>>(){
            @Override
            protected List<AdjustmentItem> doInBackground(Adjustment...params){
                //return adjItemDao.getAllAdjustmentItems();
                return adjItemDao.getAdjustmentItemsByAdjustment(adjustment);
            }

            @Override
            protected void onPostExecute(List<AdjustmentItem> adjustmentItems){
                adjustmentItemView.setAdapter(new adjustmentItemAdapter(getApplicationContext(),R.layout.row_adjustment_item,adjustmentItems));
            }
        }.execute();

        adjustmentItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdjustmentItem adjustmentItem=(AdjustmentItem) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),AdjustItemQty.class);
                intent.putExtra("data",adjustmentItem);
                intent.putExtra("data1",adjustment);
                intent.putExtra("isAdd",false);
                startActivity(intent);
            }
        });

        Button btnCreateNew=(Button)findViewById(R.id.btn_add_new_item);
        Button btnDelete=(Button)findViewById(R.id.btn_delete_voucher);

        btnCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AddAdjustmentItem.class);
                intent.putExtra("data",adjustment);
                startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}