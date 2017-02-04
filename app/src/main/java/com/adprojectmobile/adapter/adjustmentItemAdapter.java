package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.AdjustmentItemApi;
import com.adprojectmobile.model.AdjustmentItem;
import com.adprojectmobile.model.RequisitionItem;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by EvEr on 2017/1/24.
 */

public class adjustmentItemAdapter extends ArrayAdapter<AdjustmentItemApi> {

    private List<AdjustmentItemApi> adjustmentItemList;
    int resource;

    public adjustmentItemAdapter(Context context, int resource, List<AdjustmentItemApi> adjustmentItems) {
        super(context, resource, adjustmentItems);
        this.resource = resource;
        this.adjustmentItemList = adjustmentItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        AdjustmentItemApi adjustmentItem = adjustmentItemList.get(position);
        if (adjustmentItem != null) {
            TextView textViewCode = (TextView) v.findViewById(R.id.textview_adjustment_item_code);
            TextView textViewName = (TextView) v.findViewById(R.id.textview_adjustment_item_name);
            TextView textViewPrice=(TextView) v.findViewById(R.id.textview_adjustment_item_price);
            textViewCode.setText(adjustmentItem.getItemID());
            textViewName.setText(adjustmentItem.getDescription());

            Double qty=Double.parseDouble( adjustmentItem.getActualQuantity());
            Double price=Double.parseDouble(adjustmentItem.getTenderPrice());
            Double totalPrice=qty*price;
            DecimalFormat df=new DecimalFormat("0.00");

            String tprice=df.format(totalPrice);


            textViewPrice.setText("$"+tprice);
        }
        return v;
    }
}