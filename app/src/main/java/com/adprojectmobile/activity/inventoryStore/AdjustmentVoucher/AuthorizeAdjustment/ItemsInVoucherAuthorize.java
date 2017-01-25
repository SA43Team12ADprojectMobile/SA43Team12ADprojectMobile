package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustItemQty;
import com.adprojectmobile.adapter.adjustmentItemAdapter;
import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentItemDaoImpl;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;

import java.util.List;

public class ItemsInVoucherAuthorize extends AppCompatActivity {
    adjustmentItemDao adjItemDao=new adjustmentItemDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_authorize_activity_items_in_voucher_authorize);
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

                Intent intent=new Intent(getApplicationContext(),ViewAdjustmentDetail.class);
                intent.putExtra("data",adjustmentItem);
                intent.putExtra("data1",adjustment);
                //intent.putExtra("isAdd",false);
                startActivity(intent);
            }
        });

    }
}
