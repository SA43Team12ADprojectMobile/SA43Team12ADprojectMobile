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
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class requisitionItemAdapter extends ArrayAdapter<RequisitionItem> {

    private  List<RequisitionItem> requisitionItemList;
    int resource;

    public requisitionItemAdapter(Context context, int resource, List<RequisitionItem> requisitionItems) {
        super(context, resource, requisitionItems);
        this.resource=resource;
        this.requisitionItemList=requisitionItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        RequisitionItem requisitionItems =requisitionItemList.get(position);
        if (requisitionItems!=null){
            TextView textViewItemName=(TextView)v.findViewById(R.id.textView_retrieval_disbursement_item_name);
            TextView textViewItemCode=(TextView)v.findViewById(R.id.textView_retrieval_disbursement_item_code);
            TextView textViewQtyNeeded=(TextView)v.findViewById(R.id.textView_retrieval_disbursement_item_qty_needed);
            textViewItemName.setText(requisitionItems.getItemTransaction().getItem().getDescription());
            textViewItemCode.setText(requisitionItems.getItemTransaction().getItem().getItemId());
            textViewQtyNeeded.setText(requisitionItems.getNeededQuantityStr().toString());
        }
        return v;
    }
}