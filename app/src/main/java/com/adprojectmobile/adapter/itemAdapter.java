package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.model.Item;

import java.util.List;

/**
 * Created by EvEr on 2017/1/25.
 */

public class itemAdapter extends ArrayAdapter<Item> {
    private List<Item> itemList;
    int resource;

    public itemAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.resource = resource;
        this.itemList = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        Item item = itemList.get(position);
        if (item != null) {
            TextView textViewCode = (TextView) v.findViewById(R.id.textview_adjustment_item_code);
            TextView textViewName = (TextView) v.findViewById(R.id.textview_adjustment_item_name);
            //TextView textViewPrice=(TextView)v.findViewById(R.id.textview_adjustment_item_price);
            textViewCode.setText(item.getItemId());
            textViewName.setText(item.getDescription());
            // textViewPrice.setText(adjustmentItem.getAdjustme);
        }
        return v;
    }
}
