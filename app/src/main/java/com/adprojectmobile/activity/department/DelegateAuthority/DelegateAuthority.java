package com.adprojectmobile.activity.department.DelegateAuthority;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.model.Employee;

public class DelegateAuthority extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delegate_authority_activity_delegate_authority);

        final EmployeeApi employee=getIntent().getParcelableExtra("data");

        EditText editTextName=(EditText)findViewById(R.id.editText_delegate_employeeName);
        EditText editTextStatus=(EditText)findViewById(R.id.editText_delegate_status);
        final EditText editTextStartDate=(EditText)findViewById(R.id.editText_delegate_startDate);
        final EditText editTextEndDate=(EditText)findViewById(R.id.editText_delegate_enDate);
        Button btnConfirmDelegate=(Button) findViewById(R.id.btn_delegate_confirm);

        editTextName.setText(employee.getName());
        if(!Boolean.parseBoolean(employee.getIsDelegated())){
            editTextStatus.setText("UnAuthorized");
        }
        else {
            editTextStatus.setText("Authorized");
        }

        btnConfirmDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate=editTextStartDate.getText().toString();
                String endDate=editTextEndDate.getText().toString();

                Intent intent=new Intent(getApplicationContext(),FindEmployee.class);
                intent.putExtra("data",employee);
                intent.putExtra("start",startDate);
                intent.putExtra("end",endDate);
                startActivity(intent);
            }
        });
    }
}
