package com.adprojectmobile.testdata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;

import java.util.List;

/**
 * Created by EvEr on 2017/1/18.
 */

public class testAdapter extends ArrayAdapter<testCollectionPoint> {
    private List<testCollectionPoint> collectionPoints;
    int resource;

    public testAdapter(Context context, int resource, List<testCollectionPoint> collectionPoints) {
        super(context, resource, collectionPoints);
        this.resource = resource;
        this.collectionPoints = collectionPoints;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        testCollectionPoint collectionPoint=collectionPoints.get(position);
        if (collectionPoint!=null){
            TextView textViewCollectionName=(TextView)v.findViewById(R.id.textView_collectionpoint_name);
//            TextView textViewCollectionDate=(TextView)v.findViewById(R.id.textView_collectionpoint_date);

            textViewCollectionName.setText(collectionPoint.getCollectionPointName());
//            textViewCollectionDate.setText(collectionPoint.getDeliverDate());
        }
        return v;

    }


}
