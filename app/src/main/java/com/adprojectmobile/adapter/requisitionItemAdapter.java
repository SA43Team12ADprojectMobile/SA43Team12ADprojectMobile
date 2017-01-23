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
 * Created by EvEr on 2017/1/22.
 */

public class requisitionItemAdapter extends ArrayAdapter<RequisitionItem> {
    private List<RequisitionItem> requisitionItemList;
    int resource;

    public requisitionItemAdapter(Context context, int resource, List<RequisitionItem> requisitionItemList) {
        super(context, resource);
        this.resource = resource;
        this.requisitionItemList = requisitionItemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        RequisitionItem requisitionItem=requisitionItemList.get(position);
        if (requisitionItem!=null) {
            TextView textViewRequisitionItemCode = (TextView) v.findViewById(R.id.textView_retrieval_disbursement_item_code);
            TextView textViewRequisitionItemName = (TextView) v.findViewById(R.id.textView_retrieval_disbursement_item_name);
            TextView textViewRequisitionItemQtyNeeded = (TextView) v.findViewById(R.id.textView_retrieval_disbursement_item_qty_needed);

            textViewRequisitionItemCode.setText(requisitionItem.getItemTransaction().getItem().getItemId());
            textViewRequisitionItemName.setText(requisitionItem.getItemTransaction().getItem().getDescription());
            textViewRequisitionItemQtyNeeded.setText(requisitionItem.getNeededQuantity());
        }
        return v;

    }
}