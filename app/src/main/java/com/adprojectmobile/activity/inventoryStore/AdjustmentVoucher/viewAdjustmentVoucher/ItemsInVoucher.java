package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.adjustmentItemAdapter;
import com.adprojectmobile.dao.Dao.adjustmentDao;
import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentItemDaoImpl;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;

import java.util.List;

public class ItemsInVoucher extends AppCompatActivity {
    adjustmentItemDao adjItemDao=new adjustmentItemDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_view_activity_items_in_voucher);

        final Adjustment adjustment=getIntent().getParcelableExtra("data");

        final ListView adjustmentItemView=(ListView)findViewById(R.id.listview_adjustment_voucher_itemlist);

        new AsyncTask<Adjustment,Void,List<AdjustmentItem>>(){
            @Override
            protected List<AdjustmentItem> doInBackground(Adjustment...params){
                //return adjItemDao.getAllAdjustmentItems();
                return adjItemDao.getAdjustmentItemsByAdjustment(adjustment);
            }

            @Override
            protected void onPostExecute(List<AdjustmentItem> adjustmentItems){
                adjustmentItemView.setAdapter(new adjustmentItemAdapter(ItemsInVoucher.this,R.layout.row_adjustment_item,adjustmentItems));
            }
        }.execute();

        adjustmentItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdjustmentItem adjustmentItem=(AdjustmentItem) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),VoucherDetail.class);
                intent.putExtra("data",adjustmentItem);
                intent.putExtra("data1",adjustment);
                startActivity(intent);
            }
        });
    }
}
