package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.model.Disbursement;

import java.util.List;

/**
 * Created by EvEr on 2017/1/31.
 */

public class disbursementApiAdapter extends ArrayAdapter<Disbursement> {
    private List<Disbursement> requisitionList;
    int resource;

    public disbursementApiAdapter(Context context, int resource, List<Disbursement> requisitions) {
        super(context, resource, requisitions);

        this.resource = resource;
        this.requisitionList = requisitions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        Disbursement requisition = requisitionList.get(position);
        if (requisition != null) {
            TextView textViewEmployeeName = (TextView) v.findViewById(R.id.textView_requisition_employee_name);
            TextView textViewDate = (TextView) v.findViewById(R.id.textView_requisition_requisition_date);
            TextView textViewQuantitiy = (TextView) v.findViewById(R.id.textview_requisition_requisition_quantity);
            textViewEmployeeName.setText(requisition.getCollectionPointName());
//            String date=requisition.getRetrievalDate().substring(0,10);
//            String time=requisition.getRetrievalDate().substring(11,16);
//            String dateTime=date+" "+time;
            textViewDate.setText(requisition.getDeliveryStatus());
            //textViewQuantitiy.setText(requisition.getDeliveryStatus());
        }
        return v;
    }
}
