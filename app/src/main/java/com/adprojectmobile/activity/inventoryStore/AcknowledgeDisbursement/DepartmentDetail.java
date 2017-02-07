package com.adprojectmobile.activity.inventoryStore.AcknowledgeDisbursement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.model.DeliveryDisbursement;
import com.adprojectmobile.model.Department;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.dao.deliveryDao;

import java.util.List;

public class DepartmentDetail extends AppCompatActivity {
    deliveryDao dDao = new deliveryDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_information_activity_department_detail);

        final Department department = getIntent().getParcelableExtra("data");
        final String id = getIntent().getStringExtra("id");
        final DeliveryDisbursement deliveryDisbursement = getIntent().getParcelableExtra("dis");
        final Employee employee = getIntent().getParcelableExtra("role");

        List<RequisitionItem> t = dDao.getRequisitionItemByDisbursement(department.getItems());

        EditText textViewDepName = (EditText) findViewById(R.id.editText_delivery_departmentName);
        EditText textViewConName = (EditText) findViewById(R.id.editText_delivery_contactName);
        EditText textViewPhone = (EditText) findViewById(R.id.editText_delivery_phoneNumber);

        textViewDepName.setText(department.getDepartmentName());
        textViewConName.setText(department.getContactName());
        textViewPhone.setText(department.getTelephoneNumber());

        Button btnViewReq = (Button) findViewById(R.id.btn_save_delivery_viewRequisition);
        btnViewReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RequisitionItems.class);
                intent.putExtra("data", department);
                intent.putExtra("id", id);
                intent.putExtra("dis", deliveryDisbursement);
                intent.putExtra("role", employee);
                Log.e("id", id);
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_acknowledgeDisbursements_departments_details);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StockClerkMainPage.class);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });
    }
}
