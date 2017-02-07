package com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.AuthorizeAdjustment.AdjustmentVouchersAuthorize;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustmentVouchersForCRUD;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.viewAdjustmentVoucher.AdjustmentVouchers;

import java.util.ArrayList;
import java.util.List;

public class AdjustmentMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_voucher_activity_adjustment_main_page);
        List<String> choices=new ArrayList<>();
        String authorize="Authorize Adjustment";
        String issue="Issue Item Adjustment";
        String viewVoucher="View Adjustment Voucher";
        choices.add(viewVoucher);
        choices.add(issue);
        choices.add(authorize);

        final ListView listViewSelect=(ListView)findViewById(R.id.listview_voucher_main);

        listViewSelect.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.row_department_delivery,R.id.textView_department_name,choices));

        listViewSelect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=null;

                switch (position){
                    case 0:intent=new Intent(getApplicationContext(), AdjustmentVouchers.class);break;
                    case 1:intent=new Intent(getApplicationContext(), AdjustmentVouchersForCRUD.class);break;
                    case 2:intent=new Intent(getApplicationContext(), AdjustmentVouchersAuthorize.class);break;
                }
                startActivity(intent);
            }
        });
    }

}
