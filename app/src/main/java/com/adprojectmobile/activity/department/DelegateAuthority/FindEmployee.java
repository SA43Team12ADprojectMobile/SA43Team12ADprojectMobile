package com.adprojectmobile.activity.department.DelegateAuthority;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.employeeAdapter;
import com.adprojectmobile.apiModel.DelegateEmployee;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.dao.Dao.employeeDao;
import com.adprojectmobile.dao.DaoImpl.employeeDaoImpl;
import com.adprojectmobile.daoApi.delegateDao;
import com.adprojectmobile.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class FindEmployee extends AppCompatActivity {

    delegateDao dDao=new delegateDao();
    employeeDao empDao=new employeeDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delegate_authority_activity_find_employee);
        final EmployeeApi employeeApi=getIntent().getParcelableExtra("data");
        final DelegateEmployee delegateEmployee=getIntent().getParcelableExtra("delegate");

        final ListView employeeView=(ListView)findViewById(R.id.listview_delegate_employee_find_list);
        final EditText editTextSearch=(EditText) findViewById(R.id.editText_delegate_search_employee_name);

        new AsyncTask<Void,Void,List<EmployeeApi>>(){
            @Override
            protected List<EmployeeApi> doInBackground(Void...params){
               return  dDao.getEmployeeByDepartment(employeeApi.getDepartmentName());
                //return dDao.getAllEmployee();
            }

            @Override
            protected void onPostExecute(List<EmployeeApi> employees){
                employeeView.setAdapter(new employeeAdapter(getApplicationContext(),R.layout.row_employee,employees));
            }
        }.execute();

        Button btnSearch=(Button) findViewById(R.id.btn_search_employee);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchName=editTextSearch.getText().toString();
                new AsyncTask<Void,Void,List<EmployeeApi>>(){
                    @Override
                    protected List<EmployeeApi> doInBackground(Void...params){

                     //   List<EmployeeApi> tmpEmpList=empDao.getEmployees(searchName);
                        List<EmployeeApi> tmpEmpList=dDao.searchDepEmployeeByName(searchName,employeeApi.getDepartmentName());

                        return  tmpEmpList;
                    }

                    @Override
                    protected void onPostExecute(List<EmployeeApi> items){
                        employeeView.setAdapter(new employeeAdapter(getApplicationContext(),R.layout.row_employee,items));
                    }
                }.execute();

            }
        });
        employeeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final EmployeeApi employee=(EmployeeApi) parent.getAdapter().getItem(position);
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        Intent intent;
                            intent=new Intent(getApplicationContext(),DelegateAuthority.class);
                            intent.putExtra("data",employee);
                            intent.putExtra("delegate",delegateEmployee);
                            startActivity(intent);
                       return  null;
                    }
                }.execute();


            }
        });



    }
}
