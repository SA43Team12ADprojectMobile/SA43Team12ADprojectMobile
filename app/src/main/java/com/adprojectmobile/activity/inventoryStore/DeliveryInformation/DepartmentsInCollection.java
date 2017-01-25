package com.adprojectmobile.activity.inventoryStore.DeliveryInformation;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.collectionAdapter;
import com.adprojectmobile.adapter.departmentAdapter;
import com.adprojectmobile.dao.Dao.departmentDao;
import com.adprojectmobile.dao.DaoImpl.departmentDaoImpl;
import com.adprojectmobile.model.CollectionPoint;
import com.adprojectmobile.model.Department;

import java.util.List;

public class DepartmentsInCollection extends AppCompatActivity {
    departmentDao depDao=new departmentDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_departments_in_collection);
        final CollectionPoint collectionPoint=getIntent().getParcelableExtra("data");

        final ListView departmentView =(ListView)findViewById(R.id.listview_delivery_department);

        new AsyncTask<CollectionPoint,Void,List<Department>>() {
            @Override
            protected List<Department> doInBackground(CollectionPoint...params) {
                return depDao.getDepartmentsByPoint(collectionPoint);
            }

            @Override
            protected void onPostExecute(List<Department> departments){
                departmentView.setAdapter(new departmentAdapter(DepartmentsInCollection.this,R.layout.row_department_delivery,departments));
            }
        }.execute();

        departmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Department department=(Department) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),DepartmentDetail.class);
                intent.putExtra("data",department);
                startActivity(intent);
            }
        });


    }
}
