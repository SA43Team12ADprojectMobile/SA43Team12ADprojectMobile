package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.DisbursementItemApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;

import java.util.List;

/**
 * Created by EvEr on 2017/1/31.
 */

public class disbursementItemAdapter extends ArrayAdapter<DisbursementItemApi> {
    private List<DisbursementItemApi> requisitionItemForApprovalList;
    int resource;

    public disbursementItemAdapter(Context context, int resource, List<DisbursementItemApi> requisitionItems) {
        super(context, resource, requisitionItems);
        this.resource=resource;
        this.requisitionItemForApprovalList = requisitionItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        DisbursementItemApi requisitionItems= requisitionItemForApprovalList.get(position);
        if (requisitionItems!=null){
            TextView textViewItemName=(TextView)v.findViewById(R.id.textView_requisition_requisition_item_name);
            TextView textViewQtyRequired=(TextView)v.findViewById(R.id.textview_requisition_requisition_quantity_required);
            TextView textViewQtyActual=(TextView)v.findViewById(R.id.textview_requisition_requisition_quantity_retrieved) ;
            textViewItemName.setText(requisitionItems.getDescription());
            textViewQtyRequired.setText(requisitionItems.getRetrievedQuantity());
            textViewQtyActual.setText(requisitionItems.getActualQuantity());
        }
        return v;
    }
}
