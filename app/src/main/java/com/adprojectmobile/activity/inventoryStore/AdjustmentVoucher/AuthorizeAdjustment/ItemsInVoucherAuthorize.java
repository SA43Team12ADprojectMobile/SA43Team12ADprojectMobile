package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustItemQty;
import com.adprojectmobile.adapter.adjustmentItemAdapter;
import com.adprojectmobile.apiModel.AdjustmentApi;
import com.adprojectmobile.apiModel.AdjustmentItemApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentItemDaoImpl;
import com.adprojectmobile.daoApi.adjustDao;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Employee;

import java.util.List;

public class ItemsInVoucherAuthorize extends AppCompatActivity {
    adjustDao aDao=new adjustDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_authorize_activity_items_in_voucher_authorize);
        final AdjustmentApi adjustment=getIntent().getParcelableExtra("data");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        final String id=getIntent().getStringExtra("id");

        final ListView adjustmentItemView=(ListView)findViewById(R.id.listview_adjustment_voucher_approve_itemlist);

        new AsyncTask<AdjustmentApi,Void,List<AdjustmentItemApi>>(){
            @Override
            protected List<AdjustmentItemApi> doInBackground(AdjustmentApi...params){
                List<AdjustmentApi> adjustmentApis = aDao.getAuthorizeVoucher(employee.getEmployeeID());
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

                Intent intent=new Intent(getApplicationContext(),ViewAdjustmentDetail.class);
                intent.putExtra("data",adjustmentItem);
                intent.putExtra("data1",adjustment);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

        Button btnApprove=(Button)findViewById(R.id.btn_voucher_authorize);
        btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        aDao.approveVoucher(employee.getEmployeeID(),adjustment.getAdjustmentID());
                        return null;
                    }
                }.execute();
                Intent intent=new Intent(getApplicationContext(),AdjustmentVouchersAuthorize.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });
        Button btnReject=(Button)findViewById(R.id.btn_voucher_reject);
        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        aDao.rejectVoucher(employee.getEmployeeID(),adjustment.getAdjustmentID());
                        return null;
                    }
                }.execute();
                Intent intent=new Intent(getApplicationContext(),AdjustmentVouchersAuthorize.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

    }
}
