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
import com.adprojectmobile.adapter.adjustmentItemAdapter;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.adjustDao;

import java.util.List;

public class ItemsVoucherIssue extends AppCompatActivity {
    adjustDao aDao = new adjustDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_items_voucher_issue);

        final Adjustment adjustment=getIntent().getParcelableExtra("data");
        final Employee employee=getIntent().getParcelableExtra("role");
        final  String id=getIntent().getStringExtra("id");

        final ListView adjustmentItemView=(ListView)findViewById(R.id.listview_adjustment_voucher_issue_itemlist);

        new AsyncTask<Adjustment,Void,List<AdjustmentItem>>(){
            @Override
            protected List<AdjustmentItem> doInBackground(Adjustment...params){
                List<Adjustment> adjustments = aDao.getAllAdjustment(employee.getEmployeeID());
                Adjustment adjustment = new Adjustment();
                for (Adjustment rc :
                        adjustments) {
                    if (rc.getAdjustmentID() != null) {
                        if (rc.getAdjustmentID().toString().equals(id)) {
                            adjustment = rc;
                        }
                    }

                }
                return aDao.getAllAdjustItem(adjustment);
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
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

        Button btnCreateNew=(Button)findViewById(R.id.btn_add_new_item);
        Button btnDelete=(Button)findViewById(R.id.btn_delete_voucher);
        Button btnSubmit=(Button)findViewById(R.id.btn_submit_voucher);

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
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        aDao.deleteVoucher(adjustment.getAdjustmentID());
                        return null;
                    }
                }.execute();
                Toast.makeText(getApplicationContext(),"Delete Success",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),AdjustmentVouchersForCRUD.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Submit Successfully",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(), AdjustmentVouchersForCRUD.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

        TextView title=(TextView)findViewById(R.id.textView_title_issueAdjustment_adjustmentItems);
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