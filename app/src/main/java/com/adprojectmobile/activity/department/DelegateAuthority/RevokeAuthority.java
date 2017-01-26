package com.adprojectmobile.activity.department.DelegateAuthority;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.model.Employee;

public class RevokeAuthority extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delegate_authority_activity_revoke_authority);
        final Employee employee=getIntent().getParcelableExtra("data");
        final String startDate=getIntent().getStringExtra("start");
        final String endDate=getIntent().getStringExtra("end");

        EditText editTextName=(EditText)findViewById(R.id.editText_revoke_employeeName);
        EditText editTextStatus=(EditText)findViewById(R.id.editText_revoke_status);
        final EditText editTextStartDate=(EditText)findViewById(R.id.editText_revoke_startDate);
        final EditText editTextEndDate=(EditText)findViewById(R.id.editText_revoke_enDate);
        Button btnConfirmDelegate=(Button) findViewById(R.id.btn_revoke_confirm);


        editTextName.setText(employee.getName());
        editTextStatus.setText("UnAuthorized");
        editTextName.setText(employee.getDelegationStartDate());
        editTextName.setText(employee.getDelegationEndDate());

        btnConfirmDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate=editTextStartDate.getText().toString();
                String endDate=editTextEndDate.getText().toString();

                Intent intent=new Intent(getApplicationContext(),FindEmployee.class);
                intent.putExtra("data",employee);
                startActivity(intent);
            }
        });
    }
}
