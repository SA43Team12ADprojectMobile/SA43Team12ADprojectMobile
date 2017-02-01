package com.adprojectmobile.activity.department.DelegateAuthority;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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

        final DatePicker datePickerStartDate =(DatePicker)findViewById(R.id.datePicker_delegate_startDate);
        final int day = datePickerStartDate.getDayOfMonth();
        final int month = datePickerStartDate.getMonth()+1;
        final int year = datePickerStartDate.getYear();

        final DatePicker datePickerEndDate=(DatePicker) findViewById(R.id.datePicker_delegate_endDate);
        final int day1 = datePickerEndDate.getDayOfMonth();
        final int month1 = datePickerEndDate.getMonth()+1;
        final int year1 = datePickerEndDate.getYear();

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
                Integer intStartDateDay = datePickerStartDate.getDayOfMonth();
                String startDateDay = intStartDateDay.toString();

                Integer intStartDateMonth = datePickerStartDate.getMonth()+1;
                String startDateMonth = intStartDateMonth.toString();

                Integer intStartDateYear = datePickerStartDate.getYear();
                String startDateYear = intStartDateYear.toString();


                Integer intEndDateDay = datePickerEndDate.getDayOfMonth();
                String endDateDay = intEndDateDay.toString();

                Integer intEndDateMonth = datePickerEndDate.getMonth()+1;
                String endDateMonth = intEndDateMonth.toString();

                Integer intEndDateYear = datePickerEndDate.getYear();
                String endDateYear = intEndDateYear.toString();

                String startDate = startDateMonth+" "+startDateDay+" "+startDateYear;
                Log.e("startDate", startDate);
                String endDate = endDateMonth+" "+endDateDay+" "+endDateYear;
                Log.e("endDate", endDate);

                Intent intent=new Intent(getApplicationContext(),FindEmployee.class);
                intent.putExtra("data",employee);
                intent.putExtra("start",startDate);
                intent.putExtra("end",endDate);
                startActivity(intent);
            }
        });
    }
}
