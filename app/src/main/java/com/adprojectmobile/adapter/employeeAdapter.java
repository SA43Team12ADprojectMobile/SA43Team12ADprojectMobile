package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.model.Employee;

import java.util.List;

/**
 * Created by EvEr on 2017/1/25.
 */

public class employeeAdapter extends ArrayAdapter<EmployeeApi> {
    int resource;
    private List<EmployeeApi> employeeList;

    public employeeAdapter(Context context, int resource, List<EmployeeApi> employees) {
        super(context, resource, employees);
        this.resource = resource;
        this.employeeList = employees;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        EmployeeApi employee = employeeList.get(position);
        if (employee != null) {
            TextView textViewName = (TextView) v.findViewById(R.id.textView_employee_name);

            textViewName.setText(employee.getName());
        }
        return v;
    }
}
