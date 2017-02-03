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
import com.adprojectmobile.apiModel.AdjustmentApi;
import com.adprojectmobile.apiModel.AdjustmentItemApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentItemDaoImpl;
import com.adprojectmobile.daoApi.adjustDao;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;

import java.util.List;

public class ItemsVoucherIssue extends AppCompatActivity {
    adjustDao aDao = new adjustDao();

    adjustmentItemDao adjItemDao=new adjustmentItemDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_items_voucher_issue);

        final AdjustmentApi adjustment=getIntent().getParcelableExtra("data");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        final  String id=getIntent().getStringExtra("id");

        final ListView adjustmentItemView=(ListView)findViewById(R.id.listview_adjustment_voucher_issue_itemlist);

        new AsyncTask<AdjustmentApi,Void,List<AdjustmentItemApi>>(){
            @Override
            protected List<AdjustmentItemApi> doInBackground(AdjustmentApi...params){
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
                adjustmentItemView.setAdapter(new adjustmentItemAdapter(getApplicationContext(),R.layout.row_adjustment_item,adjustmentItems));
            }
        }.execute();

        adjustmentItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdjustmentItemApi adjustmentItem=(AdjustmentItemApi) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),AdjustItemQty.class);
                intent.putExtra("data",adjustmentItem);
                intent.putExtra("data1",adjustment);
                intent.putExtra("isAdd",false);
                intent.putExtra("role",employee);
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
                intent.putExtra("role",employee);
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