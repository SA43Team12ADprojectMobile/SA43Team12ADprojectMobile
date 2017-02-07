package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.EmployeeMainPage;
import com.adprojectmobile.activity.department.RepresentativeMainPage;
import com.adprojectmobile.adapter.disbursementItemAdapter;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.confirmDao;

import com.adprojectmobile.model.DisbursementItem;

import java.util.List;

public class DisbursementItems extends AppCompatActivity {
    confirmDao cDao = new confirmDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_disbursement_items);

        final Disbursement disbursement = getIntent().getParcelableExtra("data");
        final Employee employee = getIntent().getParcelableExtra("role");

        final ListView requisitionItemView = (ListView) findViewById(R.id.listview_confirm_disbursements_items);
        final String id = disbursement.getDisbursementID();

        new AsyncTask<String, Void, List<DisbursementItem>>() {
            @Override
            protected List<DisbursementItem> doInBackground(String... params) {
                List<DisbursementItem> disbursementItems = cDao.getDisbursementItem(employee, disbursement.getDisbursementID());

                return disbursementItems;
            }

            @Override
            protected void onPostExecute(List<DisbursementItem> disbursementItems) {
                requisitionItemView.setAdapter(new disbursementItemAdapter(DisbursementItems.this, R.layout.row_confirm_disbursements_items, disbursementItems));
            }
        }.execute();

        requisitionItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DisbursementItem disbursementItem = (DisbursementItem) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(), ConfirmCollection.class);
                intent.putExtra("dis", disbursement);
                intent.putExtra("data", disbursementItem);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        Button btnConfirmDis = (Button) findViewById(R.id.btn_confirm_disbursements_disbursement);
        btnConfirmDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    @Override
                    protected Void doInBackground(String... params) {
                        cDao.confirmDisbursement(disbursement.getDisbursementID());
                        return null;
                    }
                }.execute();
                Toast.makeText(getApplicationContext(), "Confirm Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Disbursements.class);
                intent.putExtra("role", employee);
                startActivity(intent);

            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_confirm_disbursementItems);
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
