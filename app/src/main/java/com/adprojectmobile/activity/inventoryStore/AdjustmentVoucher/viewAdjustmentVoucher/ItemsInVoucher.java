package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.adjustmentItemAdapter;
import com.adprojectmobile.apiModel.AdjustmentApi;
import com.adprojectmobile.apiModel.AdjustmentItemApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.dao.Dao.adjustmentDao;
import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentItemDaoImpl;
import com.adprojectmobile.daoApi.adjustDao;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;

import java.util.List;

public class ItemsInVoucher extends AppCompatActivity {
    adjustmentItemDao adjItemDao=new adjustmentItemDaoImpl();
    adjustDao  aDao=new adjustDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_view_activity_items_in_voucher);

        final AdjustmentApi adjustment=getIntent().getParcelableExtra("data");
       // Log.e("items",adjustment.getAdjustmentItems().toString());
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        final String id=getIntent().getStringExtra("id");

        final ListView adjustmentItemView=(ListView)findViewById(R.id.listview_adjustment_voucher_itemlist);

        new AsyncTask<AdjustmentApi,Void,List<AdjustmentItemApi>>(){
            @Override
            protected List<AdjustmentItemApi> doInBackground(AdjustmentApi...params){
                //return adjItemDao.getAllAdjustmentItems();
                List<AdjustmentApi> adjustmentApis = aDao.getAllAdjustment(employee.getEmployeeID());
                AdjustmentApi adjustmentApi = new AdjustmentApi();
                for (AdjustmentApi rc :
                        adjustmentApis) {
                    if (rc.getAdjustmentID() != null) {
                        if (rc.getAdjustmentID().toString().equals(id)) {
                            adjustmentApi = rc;
                        }
                    }

                }
                return aDao.getAllAdjustItem(adjustmentApi);
            }

            @Override
            protected void onPostExecute(List<AdjustmentItemApi> adjustmentItems){
                adjustmentItemView.setAdapter(new adjustmentItemAdapter(ItemsInVoucher.this,R.layout.row_adjustment_item,adjustmentItems));
            }
        }.execute();

        adjustmentItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdjustmentItemApi adjustmentItem=(AdjustmentItemApi) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),VoucherDetail.class);
                intent.putExtra("data",adjustmentItem);
                intent.putExtra("data1",adjustment);
                startActivity(intent);
            }
        });
    }
}
