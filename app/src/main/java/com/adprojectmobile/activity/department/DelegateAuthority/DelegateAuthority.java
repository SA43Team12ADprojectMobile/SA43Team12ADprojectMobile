package com.adprojectmobile.activity.department.DelegateAuthority;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.HeadMainPage;
import com.adprojectmobile.apiModel.DelegateEmployee;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.daoApi.authenticationDao;
import com.adprojectmobile.daoApi.delegateDao;
import com.adprojectmobile.model.Employee;

import java.util.Date;

public class DelegateAuthority extends AppCompatActivity {
    delegateDao dDao=new delegateDao();
    authenticationDao aDao=new authenticationDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delegate_authority_activity_delegate_authority);

        final EmployeeApi employee=getIntent().getParcelableExtra("data");
        final DelegateEmployee delegateEmployee=getIntent().getParcelableExtra("delegate");
        final EmployeeApi head=getIntent().getParcelableExtra("role");

        EditText editTextName=(EditText)findViewById(R.id.editText_delegate_employeeName);
        EditText editTextStatus=(EditText)findViewById(R.id.editText_delegate_status);

        final DatePicker datePickerStartDate =(DatePicker)findViewById(R.id.datePicker_delegate_startDate);

        final DatePicker datePickerEndDate=(DatePicker) findViewById(R.id.datePicker_delegate_endDate);

        Button btnConfirmDelegate=(Button) findViewById(R.id.btn_delegate_confirm);

        editTextName.setText(employee.getName());
            editTextStatus.setText("UnAuthorized");

        btnConfirmDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int dayS = datePickerStartDate.getDayOfMonth();
                final int monthS = datePickerStartDate.getMonth();
                final int yearS = datePickerStartDate.getYear();
                final int dayE = datePickerEndDate.getDayOfMonth();
                final int monthE = datePickerEndDate.getMonth();
                final int yearE = datePickerEndDate.getYear();

                String startDate=dDao.dateFormat(yearS,monthS,dayS);
                String endDate=dDao.dateFormat(yearE,monthE,dayE);

                delegateEmployee.setEmployeeID(employee.getEmployeeID());
                delegateEmployee.setName(employee.getName());
                delegateEmployee.setPosition(employee.getPosition());
                delegateEmployee.setDelegationStartDate(startDate);
                delegateEmployee.setDelegationEndDate(endDate);
                delegateEmployee.setNumber(employee.getNumber());
                delegateEmployee.setEmailAddress(employee.getEmailAddress());

                Date start =aDao.parseDate(startDate);
                Date end = aDao.parseDate(endDate);

                if(start.before(end)){
                    new AsyncTask<DelegateEmployee, Void, Void>() {
                        @Override
                        protected Void doInBackground(DelegateEmployee... params) {
                            dDao.delegateAuthority(delegateEmployee);
                            return null;
                        }
                    }.execute();
                    Toast.makeText(getApplicationContext(),"Delegate Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),HeadMainPage.class);
                    intent.putExtra("role",head.getName());
                    Log.e("HeadName",employee.getName());
                    intent.putExtra("password",delegateEmployee.getPassword());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Start date must later than End Date!",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
