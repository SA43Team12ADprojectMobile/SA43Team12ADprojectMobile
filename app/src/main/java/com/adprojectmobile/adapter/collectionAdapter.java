package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.DeliveryDisbursement;
import com.adprojectmobile.model.CollectionPoint;


import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class collectionAdapter extends ArrayAdapter<DeliveryDisbursement> {
    private List<DeliveryDisbursement> collectionPoints;
    int resource;

    public collectionAdapter(Context context, int resource, List<DeliveryDisbursement> collectionPoints) {
        super(context, resource, collectionPoints);
        this.resource = resource;
        this.collectionPoints = collectionPoints;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        DeliveryDisbursement collectionPoint=collectionPoints.get(position);
        if (collectionPoint!=null){
            TextView textViewCollectionName=(TextView)v.findViewById(R.id.textView_collectionpoint_name);
            //TextView textViewCollectionDate=(TextView)v.findViewById(R.id.textView_collectionpoint_date);
            TextView textViewCollectionDeliverBy=(TextView)v.findViewById(R.id.textView_collectionpoint_date);

            textViewCollectionName.setText(collectionPoint.getCollectionPointName());
            textViewCollectionDeliverBy.setText(collectionPoint.getRetrievalDate());
        }
        return v;

    }
}
