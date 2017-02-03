package com.adprojectmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.apiModel.AdjustmentApi;
import com.adprojectmobile.daoApi.adjustDao;
import com.adprojectmobile.model.Adjustment;

import java.util.List;

/**
 * Created by EvEr on 2017/1/24.
 */

public class adjustmentAdapter extends ArrayAdapter<AdjustmentApi> {
    adjustDao aDao=new adjustDao();
    private List<AdjustmentApi> adjustmentList;
    int resource;

    public adjustmentAdapter(Context context, int resource, List<AdjustmentApi> adjustments) {
        super(context, resource, adjustments);
        this.resource = resource;
        this.adjustmentList = adjustments;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        AdjustmentApi adjustment=adjustmentList.get(position);
        if (adjustment!=null){
            TextView textViewDate=(TextView)v.findViewById(R.id.textView_adjustment_date);
            TextView textViewIssueBy=(TextView)v.findViewById(R.id.textView_adjustment_employeeName);

            textViewDate.setText(aDao.formatJsonDate(adjustment.getDateIssued()));
            textViewIssueBy.setText("Issued By "+ adjustment.getIssuedBy());
        }
        return v;

    }
}
