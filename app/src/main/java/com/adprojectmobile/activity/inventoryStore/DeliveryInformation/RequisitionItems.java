package com.adprojectmobile.activity.inventoryStore.DeliveryInformation;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.reqItemForDepAdapter;
import com.adprojectmobile.adapter.requisitionItemAdapter;
import com.adprojectmobile.apiModel.DepartmentApi;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.daoApi.deliveryDao;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.RequisitionItem;

import java.util.ArrayList;
import java.util.List;

public class RequisitionItems extends AppCompatActivity {
    requisitionItemDao riDao=new requisitionItemDaoImpl();
    deliveryDao dDao=new deliveryDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_requisition_items);
        final DepartmentApi department=getIntent().getParcelableExtra("data");

        final ListView itemList=(ListView)findViewById(R.id.listview_delivery_itemList);
        final List<DepartmentApi> apis=new ArrayList<>();

        new AsyncTask<Void,Void,List<DepartmentApi>>(){
            @Override
            //protected List<DepartmentApi> doInBackground(Department...params){
            protected List<DepartmentApi> doInBackground(Void...params){
               // return riDao.getItemsInDepartment(department);
                apis.add(department);
               return apis;
            }

            @Override
            protected void onPostExecute(List<DepartmentApi> requisitionItems){
                itemList.setAdapter(new reqItemForDepAdapter(getApplicationContext(),R.layout.row_delivery_department_item,requisitionItems));

            }
        }.execute();

        Button btnAcknowledge =(Button) findViewById(R.id.btn_item_delivery_acknowledge);
        Button btnReject =(Button) findViewById(R.id.btn_item_delivery_reject);

        btnAcknowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
