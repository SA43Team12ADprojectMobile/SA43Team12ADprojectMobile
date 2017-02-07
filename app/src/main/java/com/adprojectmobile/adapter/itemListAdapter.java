package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.model.AdjustmentItem;

import java.util.List;

/**
 * Created by EvEr on 2017/2/4.
 */

public class itemListAdapter extends ArrayAdapter<AdjustmentItem> {
    private List<AdjustmentItem> adjustmentItemList;
    int resource;

    public itemListAdapter(Context context, int resource, List<AdjustmentItem> adjustmentItems) {
        super(context, resource, adjustmentItems);
        this.resource = resource;
        this.adjustmentItemList = adjustmentItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        AdjustmentItem adjustmentItem = adjustmentItemList.get(position);
        if (adjustmentItem != null) {
            TextView textViewCode = (TextView) v.findViewById(R.id.textview_adjustment_item_code);
            TextView textViewName = (TextView) v.findViewById(R.id.textview_adjustment_item_name);
            TextView textViewPrice = (TextView) v.findViewById(R.id.textview_adjustment_item_price);

            textViewCode.setText(adjustmentItem.getItemID());
            textViewName.setText(adjustmentItem.getDescription());
            textViewPrice.setText("$" + adjustmentItem.getTenderPrice());
        }
        return v;
    }
}
