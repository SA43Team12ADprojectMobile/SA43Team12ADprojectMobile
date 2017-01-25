package com.adprojectmobile.activity.department.DelegateAuthority;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.adprojectmobile.R;
import com.adprojectmobile.adapter.employeeAdapter;
import com.adprojectmobile.dao.Dao.employeeDao;
import com.adprojectmobile.dao.DaoImpl.employeeDaoImpl;
import com.adprojectmobile.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class FindEmployee extends AppCompatActivity {

    employeeDao empDao=new employeeDaoImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delegate_authority_activity_find_employee);

        final ListView employeeView=(ListView)findViewById(R.id.listview_delegate_employee_find_list);
        final EditText editTextSearch=(EditText) findViewById(R.id.editText_delegate_search_employee_name);

        new AsyncTask<Void,Void,List<Employee>>(){
            @Override
            protected List<Employee> doInBackground(Void...params){
                return empDao.getAllEmployees();
            }

            @Override
            protected void onPostExecute(List<Employee> employees){
                employeeView.setAdapter(new employeeAdapter(getApplicationContext(),R.layout.row_employee,employees));
            }
        }.execute();

        Button btnSearch=(Button) findViewById(R.id.btn_search_employee);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchName=editTextSearch.getText().toString();
                new AsyncTask<Void,Void,List<Employee>>(){
                    @Override
                    protected List<Employee> doInBackground(Void...params){

                        List<Employee> tmpEmpList=empDao.getEmployees(searchName);

                        return  tmpEmpList;
                    }

                    @Override
                    protected void onPostExecute(List<Employee> items){
                        employeeView.setAdapter(new employeeAdapter(getApplicationContext(),R.layout.row_employee,items));
                    }
                }.execute();

            }
        });
        employeeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employee employee=(Employee) parent.getAdapter().getItem(position);

                Intent intent=new Intent(getApplicationContext(),DelegateAuthority.class);
                intent.putExtra("data",employee);
                intent.putExtra("isDelegate",true);
                startActivity(intent);
            }
        });



    }
}
