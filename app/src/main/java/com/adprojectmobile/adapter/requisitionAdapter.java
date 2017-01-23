package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.model.Requisition;

import java.util.List;

/**
 * Created by EvEr on 2017/1/23.
 */

public class requisitionAdapter extends ArrayAdapter<Requisition> {
    private List<Requisition> requisitionList;
    int resource;

    public requisitionAdapter(Context context, int resource, List<Requisition> requisitions) {
        super(context, resource, requisitions);

        this.resource=resource;
        this.requisitionList=requisitions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        Requisition requisition=requisitionList.get(position);
        if (requisition!=null){
            TextView textViewEmployeeName=(TextView)v.findViewById(R.id.textView_requisition_employee_name);
            TextView textViewDate=(TextView)v.findViewById(R.id.textView_requisition_requisition_date);

            textViewEmployeeName.setText(requisition.getEmployee().getName());
            textViewDate.setText(requisition.getRequisitionDate());

        }
        return v;
    }
}
