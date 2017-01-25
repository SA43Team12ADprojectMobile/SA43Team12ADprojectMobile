package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.model.Disbursement;

import java.util.List;

/**
 * Created by EvEr on 2017/1/22.
 */

public class disbursementAdapter extends ArrayAdapter<Disbursement> {
    private List<Disbursement> disbursements;
    int resource;

    public disbursementAdapter(Context context, int resource, List<Disbursement> disbursements) {
        super(context, resource, disbursements);
        this.resource = resource;
        this.disbursements = disbursements;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        Disbursement disbursement=disbursements.get(position);

        if (disbursement!=null){
            TextView textViewDisbursementCollectionName=(TextView)v.findViewById(R.id.textView_bisburse_collection_name);
            TextView textViewDisbursementDate=(TextView)v.findViewById(R.id.textView_disburse_collection_date);
            TextView textViewDisbursementStatus=(TextView)v.findViewById(R.id.textView_disburse_status);

            textViewDisbursementCollectionName.setText(disbursement.getCollectonPoint());
            textViewDisbursementDate.setText(disbursement.getRetrievalTime());
            textViewDisbursementStatus.setText(disbursement.getDeliveryStatus());
        }
        return v;
    }
}
