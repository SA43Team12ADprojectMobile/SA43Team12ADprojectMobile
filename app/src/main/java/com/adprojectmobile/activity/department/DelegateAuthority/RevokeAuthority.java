package com.adprojectmobile.activity.department.DelegateAuthority;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.HeadMainPage;
import com.adprojectmobile.model.DelegateEmployee;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.delegateDao;

public class RevokeAuthority extends AppCompatActivity {
    delegateDao dDao = new delegateDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delegate_authority_activity_revoke_authority);
        final Employee employee = getIntent().getParcelableExtra("data");
        final Employee authorEmp = getIntent().getParcelableExtra("auth");
        final DelegateEmployee delegateEmployee = getIntent().getParcelableExtra("delegate");
        Log.e("emp", employee.getDepartmentName());
        Log.e("authEmp", authorEmp.getName());

        final EditText editTextName = (EditText) findViewById(R.id.editText_revoke_employeeName);
        final EditText editTextStatus = (EditText) findViewById(R.id.editText_revoke_status);
        final EditText editTextStartDate = (EditText) findViewById(R.id.editText_revoke_startDate);
        final EditText editTextEndDate = (EditText) findViewById(R.id.editText_revoke_enDate);

        editTextName.setText(authorEmp.getName());
        editTextStatus.setText("Authorized");
        String date = authorEmp.DelegationStartDate.substring(0, 10);
        String time = authorEmp.DelegationStartDate.substring(11, 16);
        String dateTime = date + " " + time;
        editTextStartDate.setText(dateTime);
        if (authorEmp.DelegationEndDate != "null") {
            String dateEnd = authorEmp.DelegationEndDate.substring(0, 10);
            String timeEnd = authorEmp.DelegationEndDate.substring(11, 16);
            String dateTimeEnd = dateEnd + " " + timeEnd;
            editTextEndDate.setText(dateTimeEnd);
        }

        Button btnConfirmDelegate = (Button) findViewById(R.id.btn_revoke_confirm);

        btnConfirmDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegateEmployee.setEmployeeID(authorEmp.getEmployeeID());
                delegateEmployee.setName(authorEmp.getName());
                delegateEmployee.setPosition(authorEmp.getPosition());
                delegateEmployee.setNumber(authorEmp.getNumber());
                delegateEmployee.setEmailAddress(authorEmp.getEmailAddress());

                new AsyncTask<DelegateEmployee, Void, Void>() {
                    @Override
                    protected Void doInBackground(DelegateEmployee... params) {
                        dDao.revokeAuthority(delegateEmployee);
                        return null;
                    }
                }.execute();

                Toast.makeText(getApplicationContext(), "Revoke Successfully", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), HeadMainPage.class);
                intent.putExtra("role", employee);
                intent.putExtra("password", delegateEmployee.getPassword());
                startActivity(intent);
            }
        });
    }
}
