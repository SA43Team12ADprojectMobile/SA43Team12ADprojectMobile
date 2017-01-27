package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.RetrievalCollectionPoint;
import com.adprojectmobile.model.Disbursement;

import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class disbursementAdapter extends ArrayAdapter<RetrievalCollectionPoint> {
    private List<RetrievalCollectionPoint> retrievalCollectionPointList;
    int resource;

    public disbursementAdapter(Context context, int resource, List<RetrievalCollectionPoint> retrievalCollectionPoints) {
        super(context, resource, retrievalCollectionPoints);
        this.resource = resource;
        this.retrievalCollectionPointList = retrievalCollectionPoints;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
       // Disbursement disbursement=disbursements.get(position);
        RetrievalCollectionPoint retrievalCollectionPoint=retrievalCollectionPointList.get(position);

        if (retrievalCollectionPoint!=null){
            TextView textViewDisbursementCollectionName=(TextView)v.findViewById(R.id.textView_bisburse_collection_name);
           // TextView textViewDisbursementDate=(TextView)v.findViewById(R.id.textView_disburse_collection_date);
            TextView textViewDisbursementStatus=(TextView)v.findViewById(R.id.textView_disburse_status);

            textViewDisbursementCollectionName.setText(retrievalCollectionPoint.getCollectionPointName());
           // textViewDisbursementDate.setText(retrievalCollectionPoint.get.getRetrievalTime());
            if(retrievalCollectionPoint.getPrepared()!="null"){
                textViewDisbursementStatus.setText(retrievalCollectionPoint.getPrepared());
            }else {
                textViewDisbursementStatus.setText("false");
            }

        }
        return v;
    }
}
