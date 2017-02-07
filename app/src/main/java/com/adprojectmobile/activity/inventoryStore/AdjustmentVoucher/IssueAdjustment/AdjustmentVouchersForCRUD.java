package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.adapter.adjustmentAdapter;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.adjustDao;

import java.util.List;

public class AdjustmentVouchersForCRUD extends AppCompatActivity {
    adjustDao aDao=new adjustDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_adjustment_vouchers);
        final Employee employee=getIntent().getParcelableExtra("role");

            final ListView adjustmentView=(ListView)findViewById(R.id.listview_adjustment_voucher_for_CRUD);

            new AsyncTask<Void,Void,List<Adjustment>>(){
                @Override
                protected List<Adjustment> doInBackground(Void...params){
                    return aDao.getAllAdjustment(employee.getEmployeeID());

                    //return null;
                }

                @Override
                protected void onPostExecute(List<Adjustment> adjustments){
                    adjustmentView.setAdapter(new adjustmentAdapter(getApplicationContext(),R.layout.row_adjustment_voucher,adjustments));
                }
            }.execute();

            adjustmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Adjustment adjustment=(Adjustment) parent.getAdapter().getItem(position);

                    Intent intent=new Intent(getApplicationContext(),ItemsVoucherIssue.class);
                    intent.putExtra("data",adjustment);
                    intent.putExtra("role",employee);
                    intent.putExtra("id",adjustment.getAdjustmentID());
                    startActivity(intent);
                }
            });

        Button btnCreateVoucher=(Button)findViewById(R.id.btn_create_new_voucher);
        btnCreateVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        aDao.createNewVoucher(employee.EmployeeID);
                        return null;
                    }
                }.execute();

                Toast.makeText(getApplicationContext(),"Creating Voucher, Please wait",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),AdjustmentVouchersForCRUD.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

        TextView title=(TextView)findViewById(R.id.textView_title_issueAdjustment_vouchers);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), StockClerkMainPage.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

    }
}
