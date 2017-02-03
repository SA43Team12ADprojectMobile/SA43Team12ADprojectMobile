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
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.CreateNewVoucher;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.ItemsVoucherIssue;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.ItemsInVoucher;
import com.adprojectmobile.adapter.adjustmentAdapter;
import com.adprojectmobile.apiModel.AdjustmentApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.dao.Dao.adjustmentDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentDaoImpl;
import com.adprojectmobile.daoApi.adjustDao;
import com.adprojectmobile.model.Adjustment;

import java.util.List;

public class AdjustmentVouchersAuthorize extends AppCompatActivity {
    adjustDao aDao=new adjustDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_authorize_activity_adjustment_vouchers_authorize);
        final EmployeeApi employee=getIntent().getParcelableExtra("role");

        final ListView adjustmentView=(ListView)findViewById(R.id.listview_adjustment_voucher_for_approve);

        new AsyncTask<Void,Void,List<AdjustmentApi>>(){
            @Override
            protected List<AdjustmentApi> doInBackground(Void...params){
                return aDao.getAuthorizeVoucher(employee.getEmployeeID());
            }

            @Override
            protected void onPostExecute(List<AdjustmentApi> adjustments){
                adjustmentView.setAdapter(new adjustmentAdapter(getApplicationContext(),R.layout.row_adjustment_voucher,adjustments));
            }
        }.execute();

        adjustmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdjustmentApi adjustment=(AdjustmentApi) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(), ItemsInVoucherAuthorize.class);
                intent.putExtra("data",adjustment);
                intent.putExtra("role",employee);
                intent.putExtra("id",adjustment.getAdjustmentID());
                startActivity(intent);
            }
        });

    }
}
