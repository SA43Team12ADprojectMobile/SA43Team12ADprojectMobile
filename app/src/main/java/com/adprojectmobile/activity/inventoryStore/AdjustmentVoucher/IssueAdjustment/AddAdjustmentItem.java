package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.adjustmentItemAdapter;
import com.adprojectmobile.adapter.itemAdapter;
import com.adprojectmobile.apiModel.AdjustmentApi;
import com.adprojectmobile.apiModel.AdjustmentItemApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.Dao.itemDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentItemDaoImpl;
import com.adprojectmobile.dao.DaoImpl.itemDaoImpl;
import com.adprojectmobile.daoApi.adjustDao;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Item;

import java.util.ArrayList;
import java.util.List;

public class AddAdjustmentItem extends AppCompatActivity {
    adjustDao aDao=new adjustDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_add_adjustment_item);

        final AdjustmentApi adjustment=getIntent().getParcelableExtra("data");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");

        final ListView itemView=(ListView)findViewById(R.id.listview_select_add_item);
        final EditText editTextSearch=(EditText) findViewById(R.id.editText_issue_search_item_code);

        new AsyncTask<Void,Void,List<AdjustmentItemApi>>(){
            @Override
            protected List<AdjustmentItemApi> doInBackground(Void...params){

                return aDao.getAllItemsForAdd();
            }

            @Override
            protected void onPostExecute(List<AdjustmentItemApi> items){
                itemView.setAdapter(new adjustmentItemAdapter(getApplicationContext(),R.layout.row_adjustment_item,items));
            }
        }.execute();

        Button btnSearch=(Button) findViewById(R.id.btn_search_item);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchCode=editTextSearch.getText().toString();
                new AsyncTask<String,Void,List<AdjustmentItemApi>>(){
                    @Override
                    protected List<AdjustmentItemApi> doInBackground(String...params){

                        List<AdjustmentItemApi> searchItems=aDao.searchItems(searchCode);
                        return  searchItems;
                    }

                    @Override
                    protected void onPostExecute(List<AdjustmentItemApi> items){
                        itemView.setAdapter(new adjustmentItemAdapter(getApplicationContext(),R.layout.row_adjustment_item,items));
                    }
                }.execute();

            }
        });
        itemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdjustmentItemApi item=(AdjustmentItemApi) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),AdjustItemQty.class);
                intent.putExtra("data",item);
                intent.putExtra("data1",adjustment);
                intent.putExtra("isAdd",true);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

    }
}
