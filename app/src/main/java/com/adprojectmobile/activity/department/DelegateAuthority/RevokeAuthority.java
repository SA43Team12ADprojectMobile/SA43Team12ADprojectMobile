package com.adprojectmobile.activity.department.DelegateAuthority;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.DelegateEmployee;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.daoApi.delegateDao;
import com.adprojectmobile.model.Employee;

import java.util.List;

public class RevokeAuthority extends AppCompatActivity {
    delegateDao dDao=new delegateDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delegate_authority_activity_revoke_authority);
        final EmployeeApi employee=getIntent().getParcelableExtra("data");
        final EmployeeApi authorEmp=getIntent().getParcelableExtra("auth");
        final DelegateEmployee delegateEmployee=getIntent().getParcelableExtra("delegate");
        Log.e("emp",employee.getDepartmentName());
        Log.e("authEmp",authorEmp.getName());

        final EditText editTextName=(EditText)findViewById(R.id.editText_revoke_employeeName);
        final EditText editTextStatus=(EditText)findViewById(R.id.editText_revoke_status);
        final EditText editTextStartDate=(EditText)findViewById(R.id.editText_revoke_startDate);
        final EditText editTextEndDate=(EditText)findViewById(R.id.editText_revoke_enDate);

        editTextName.setText(authorEmp.getName());
        editTextStatus.setText("Authorized");
        String date=authorEmp.DelegationStartDate.substring(0,10);
        String time=authorEmp.DelegationStartDate.substring(11,16);
        String dateTime=date+" "+time;
        editTextStartDate.setText(dateTime);
        if (authorEmp.DelegationEndDate!="null"){
            editTextEndDate.setText(authorEmp.DelegationEndDate);
        }

        Button btnConfirmDelegate=(Button) findViewById(R.id.btn_revoke_confirm);

        btnConfirmDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AsyncTask<DelegateEmployee, Void, Void>() {
                    @Override
                    protected Void doInBackground(DelegateEmployee... params) {
                        dDao.delegateAuthority(delegateEmployee);
                        return null;
                    }
                }.execute();
            }
        });
    }
}
