package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adprojectmobile.R;
import com.adprojectmobile.dao.Dao.adjustmentDao;
import com.adprojectmobile.dao.DaoImpl.adjustmentDaoImpl;
import com.adprojectmobile.model.Adjustment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateNewVoucher extends AppCompatActivity {
    adjustmentDao adjDao=new adjustmentDaoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_issue_activity_create_new_voucher);

        final EditText editTextId=(EditText)findViewById(R.id.editText_create_new_voucherID);
        final EditText editTextDate=(EditText)findViewById(R.id.editText_create_new_voucher_date);


        List<Adjustment> tmpList=adjDao.getAllAdjustments();

//        if (!tmpList.isEmpty()) {
//        Integer intAutoId=tmpList.size()+2;
//        String autoId=intAutoId.toString();
//
//        Date now=new Date();
//
//            editTextId.setText(autoId.toString());
//            editTextDate.setText(now.toString());
//        }

        Button btnCreate=(Button)findViewById(R.id.btn_create_new_voucher);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
