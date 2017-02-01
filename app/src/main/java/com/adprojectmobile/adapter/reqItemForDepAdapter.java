package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.DepartmentApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

/**
 * Created by EvEr on 2017/1/24.
 */

public class reqItemForDepAdapter extends ArrayAdapter<RequisitionItemApi> {
    private List<RequisitionItemApi> requisitionItemList;
    int resource;

    public reqItemForDepAdapter(Context context, int resource, List<RequisitionItemApi> requisitionItems) {
        super(context, resource, requisitionItems);
        this.resource=resource;
        this.requisitionItemList=requisitionItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        RequisitionItemApi requisitionItem=requisitionItemList.get(position);
        if (requisitionItem!=null){
            TextView textViewItemName=(TextView)v.findViewById(R.id.textView_delivery_department_item_name);
            TextView textViewItemCode=(TextView)v.findViewById(R.id.textView_delivery_department_item_code);
            TextView textViewQtyNeeded=(TextView)v.findViewById(R.id.textView_delivery_department_item_qty_needed);
            TextView textViewQtyActual=(TextView)v.findViewById(R.id.textView_delivery_department_item_qty_actual);
//            textViewItemName.setText(requisitionItem.ItemID);
            textViewItemCode.setText(requisitionItem.getItemCode());
            textViewItemName.setText(requisitionItem.getItemName());
            textViewQtyNeeded.setText(requisitionItem.getQuantity());
            String rQty=requisitionItem.getRetrieveQuantity().substring(0,3);
            textViewQtyActual.setText(rQty);
        }
        return v;
    }
}
