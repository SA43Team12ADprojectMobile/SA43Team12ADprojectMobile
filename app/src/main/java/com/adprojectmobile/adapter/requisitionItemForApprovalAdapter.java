package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

/**
 * Created by billylzm on 25/1/2017.
 */

public class requisitionItemForApprovalAdapter extends ArrayAdapter {
    private List<RequisitionItem> requisitionItemForApprovalList;
    int resource;

    public requisitionItemForApprovalAdapter(Context context, int resource, List<RequisitionItem> requisitionItems) {
        super(context, resource, requisitionItems);
        this.resource=resource;
        this.requisitionItemForApprovalList = requisitionItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        RequisitionItem requisitionItems= requisitionItemForApprovalList.get(position);
        if (requisitionItems!=null){
            TextView textViewItemName=(TextView)v.findViewById(R.id.textView_requisition_requisition_item_name);
            TextView textViewQtyRequired=(TextView)v.findViewById(R.id.textview_requisition_requisition_quantity_required);
            textViewItemName.setText(requisitionItems.getName());
            textViewQtyRequired.setText(requisitionItems.getNeededQuantity());
        }
        return v;
    }
}







