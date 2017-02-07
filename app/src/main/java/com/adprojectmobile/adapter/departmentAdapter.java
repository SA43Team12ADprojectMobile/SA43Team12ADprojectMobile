package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.model.Department;

import java.util.List;

/**
 * Created by EvEr on 2017/1/24.
 */

public class departmentAdapter extends ArrayAdapter<Department> {
    int resource;
    private List<Department> departmentList;

    public departmentAdapter(Context context, int resource, List<Department> departments) {
        super(context, resource, departments);
        this.resource = resource;
        this.departmentList = departments;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        Department department = departmentList.get(position);
        if (department != null) {
            TextView textViewName = (TextView) v.findViewById(R.id.textView_department_name);

            textViewName.setText(department.getDepartmentName());
        }
        return v;
    }
}
