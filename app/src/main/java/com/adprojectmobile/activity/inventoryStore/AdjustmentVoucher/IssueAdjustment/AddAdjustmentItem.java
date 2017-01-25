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
import com.adprojectmobile.dao.Dao.adjustmentItemDao;
import com.adprojectmobile.dao.Dao.itemDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentItemDaoImpl;
import com.adprojectmobile.dao.DaoImpl.itemDaoImpl;
import com.adprojectmobile.model.Adjustment;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.Item;

import java.util.ArrayList;
import java.util.List;

public class AddAdjustmentItem extends AppCompatActivity {

    adjustmentItemDao adjItemDao=new adjustmentItemDaoImpl();
    itemDao itemDao=new itemDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_add_adjustment_item);

        final Adjustment adjustment=getIntent().getParcelableExtra("data");

        final ListView itemView=(ListView)findViewById(R.id.listview_select_add_item);
        final EditText editTextSearch=(EditText) findViewById(R.id.editText_issue_search_item_code);

        new AsyncTask<Void,Void,List<Item>>(){
            @Override
            protected List<Item> doInBackground(Void...params){
                return itemDao.getAllItem();
            }

            @Override
            protected void onPostExecute(List<Item> items){
                itemView.setAdapter(new itemAdapter(getApplicationContext(),R.layout.row_adjustment_item,items));
            }
        }.execute();

        Button btnSearch=(Button) findViewById(R.id.btn_search_item);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchCode=editTextSearch.getText().toString();
                new AsyncTask<String,Void,List<Item>>(){
                    @Override
                    protected List<Item> doInBackground(String...params){

                        Item tmpItem=itemDao.getItem(searchCode);
                        List<Item> returnItem=new ArrayList<Item>() ;
                        returnItem.add(tmpItem);
                        return  returnItem;
                    }

                    @Override
                    protected void onPostExecute(List<Item> items){
                        itemView.setAdapter(new itemAdapter(getApplicationContext(),R.layout.row_adjustment_item,items));
                    }
                }.execute();

            }
        });
        itemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item=(Item) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),AdjustItemQty.class);
                intent.putExtra("data",item);
                intent.putExtra("data1",adjustment);
                intent.putExtra("isAdd",true);
                startActivity(intent);
            }
        });

    }
}
