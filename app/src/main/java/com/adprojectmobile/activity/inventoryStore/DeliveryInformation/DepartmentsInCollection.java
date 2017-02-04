package com.adprojectmobile.activity.inventoryStore.DeliveryInformation;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.adapter.collectionAdapter;
import com.adprojectmobile.adapter.departmentAdapter;
import com.adprojectmobile.apiModel.DeliveryDisbursement;
import com.adprojectmobile.apiModel.DepartmentApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;
import com.adprojectmobile.dao.Dao.departmentDao;
import com.adprojectmobile.dao.DaoImpl.departmentDaoImpl;
import com.adprojectmobile.daoApi.deliveryDao;
import com.adprojectmobile.model.CollectionPoint;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Employee;

import java.util.List;

public class DepartmentsInCollection extends AppCompatActivity {
    deliveryDao dDao=new deliveryDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_departments_in_collection);
        //final CollectionPoint collectionPoint=getIntent().getParcelableExtra("data");
          final DeliveryDisbursement deliveryDisbursement=getIntent().getParcelableExtra("data");
          final EmployeeApi employee=getIntent().getParcelableExtra("role");
        Log.e("delivery",deliveryDisbursement.getCollectionPointName());

        final ListView departmentView =(ListView)findViewById(R.id.listview_delivery_department);

        new AsyncTask<DeliveryDisbursement,Void,List<DepartmentApi>>() {
            @Override
            protected List<DepartmentApi> doInBackground(DeliveryDisbursement...params) {
               // return depDao.getDepartmentsByPoint(collectionPoint);
                return  dDao.getDepartmentByCollectionPoint(deliveryDisbursement);
            }

            @Override
            protected void onPostExecute(List<DepartmentApi> departments){
                departmentView.setAdapter(new departmentAdapter(DepartmentsInCollection.this,R.layout.row_department_delivery,departments));
            }
        }.execute();

        departmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DepartmentApi department=(DepartmentApi) parent.getAdapter().getItem(position);


                Intent intent=new Intent(getApplicationContext(),DepartmentDetail.class);
                intent.putExtra("data",department);
                intent.putExtra("id",department.getDepartmentID());
                intent.putExtra("dis",deliveryDisbursement);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });

        TextView title=(TextView)findViewById(R.id.textView_title_acknowledgeDisbursements_departments);
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
