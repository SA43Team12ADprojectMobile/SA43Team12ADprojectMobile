package com.adprojectmobile.activity.inventoryStore.DeliveryInformation;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.AdjustmentVouchers;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.adapter.reqItemForDepAdapter;
import com.adprojectmobile.adapter.requisitionItemAdapter;
import com.adprojectmobile.apiModel.DeliveryDisbursement;
import com.adprojectmobile.apiModel.DepartmentApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.daoApi.deliveryDao;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.RequisitionItem;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class RequisitionItems extends AppCompatActivity {
    deliveryDao dDao=new deliveryDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_requisition_items);
        final DepartmentApi department=getIntent().getParcelableExtra("data");
        final String id=getIntent().getStringExtra("id");
        final DeliveryDisbursement deliveryDisbursement=getIntent().getParcelableExtra("dis");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        Log.e("id2",id);

        final ListView itemList=(ListView)findViewById(R.id.listview_delivery_itemList);

        new AsyncTask<JSONArray,Void,List<RequisitionItemApi>>(){
            @Override
            protected List<RequisitionItemApi> doInBackground(JSONArray...params){
                List<DepartmentApi> departmentApis = dDao.getDepartmentByCollectionPoint(deliveryDisbursement);
                DepartmentApi departmentApi = new DepartmentApi();
                for (DepartmentApi rc :
                        departmentApis) {
                    if (rc.getDepartmentID() != null) {
                        if (rc.getDepartmentID().toString().equals(id)) {
                            departmentApi = rc;
                        }
                    }

                }

                return  dDao.getRequisitionItemByDisbursement(departmentApi.getItems());
            }

            @Override
            protected void onPostExecute(List<RequisitionItemApi> requisitionItems){
                itemList.setAdapter(new reqItemForDepAdapter(getApplicationContext(),R.layout.row_delivery_department_item,requisitionItems));
            }
        }.execute();

        Button btnAcknowledge =(Button) findViewById(R.id.btn_item_delivery_acknowledge);
        Button btnReject =(Button) findViewById(R.id.btn_item_delivery_reject);

        btnAcknowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isAdjustExist=true;

                new AsyncTask<String, Void, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        String result=dDao.acknowledgeDelivery(deliveryDisbursement);

                        return result;
                    }
                    @Override
                    protected void onPostExecute(String result){
                        Log.e("result",result);
                        if(result.contains("t")){

                            Intent intent=new Intent(getApplicationContext(),AdjustmentVouchers.class);
                            intent.putExtra("role",employee);
                            startActivity(intent);

                        }else {

                            Intent intent=new Intent(getApplicationContext(),com.adprojectmobile.activity.inventoryStore.DeliveryInformation.CollectionPoints.class);
                            intent.putExtra("role",employee);
                            startActivity(intent);
                        }
                    }
                }.execute();

                Toast.makeText(getApplicationContext(),"Acknowledge Success",Toast.LENGTH_LONG).show();

            }
        });

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        dDao.rejectDelivery(deliveryDisbursement);
                        return null;
                    }
                }.execute();

                Toast.makeText(getApplicationContext(),"Rejected",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),com.adprojectmobile.activity.inventoryStore.DeliveryInformation.CollectionPoints.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

        TextView title=(TextView)findViewById(R.id.textView_title_acknowledgeDisbursements_items);
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
