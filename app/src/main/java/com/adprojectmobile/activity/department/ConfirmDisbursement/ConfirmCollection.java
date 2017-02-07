package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.EmployeeMainPage;
import com.adprojectmobile.activity.department.RepresentativeMainPage;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.DisbursementItem;
import com.adprojectmobile.model.Employee;

import com.adprojectmobile.dao.confirmDao;

public class ConfirmCollection extends AppCompatActivity {


    confirmDao cDao = new confirmDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_confirm_collection);

        final DisbursementItem disbursementItem = getIntent().getParcelableExtra("data");
        final Disbursement disbursement = getIntent().getParcelableExtra("dis");
        final Employee employee = getIntent().getParcelableExtra("role");


        final EditText editTextItemName = (EditText) findViewById(R.id.editText_itemDescription_confirmCollection);
        final EditText editTextQuantityRetrieved = (EditText) findViewById(R.id.editText_itemQtyRetrieve_confirmCollection);
        final EditText editTextQuantityActual = (EditText) findViewById(R.id.editText_itemQtyActual_confirmCollection);

        editTextItemName.setText(disbursementItem.getDescription());
        editTextQuantityRetrieved.setText(disbursementItem.getRetrievedQuantity());
        editTextQuantityActual.setText(disbursementItem.getActualQuantity());


        Button btn_save = (Button) findViewById(R.id.btn_save_confirm_disbursement_confirm_collection);
        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    String actualQty = editTextQuantityActual.getText().toString();

                    @Override
                    protected Void doInBackground(String... params) {
                        cDao.saveActualQty(disbursement.getDisbursementID(), disbursementItem.getDescription(), disbursementItem.getUnitMeasured(), disbursementItem.getRetrievedQuantity(), actualQty, disbursementItem.getNeededQuantity(), disbursementItem.getTransactionID(), disbursementItem.getItemID());
                        return null;
                    }
                }.execute();
                Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), DisbursementItems.class);
                intent.putExtra("role", employee);
                intent.putExtra("data", disbursement);
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_confirmCollection);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (employee.getIsDelegated().equals("true")) {
                    Intent intent = new Intent(getApplicationContext(), EmployeeMainPage.class);
                    intent.putExtra("role", employee);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), RepresentativeMainPage.class);
                    intent.putExtra("role", employee);
                    startActivity(intent);
                }

            }
        });
    }
}
