package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.EmployeeMainPage;
import com.adprojectmobile.activity.department.RepresentativeMainPage;
import com.adprojectmobile.adapter.disbursementApiAdapter;
import com.adprojectmobile.model.Disbursement;
import com.adprojectmobile.model.Employee;
import com.adprojectmobile.dao.confirmDao;

import java.util.List;

public class Disbursements extends AppCompatActivity {
    confirmDao cDao = new confirmDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_disbursements);
        final Employee employee = getIntent().getParcelableExtra("role");
        Log.e("role", employee.getName());

        final ListView requisitionList = (ListView) findViewById(R.id.listview_confirm_disbursements);

        new AsyncTask<Void, Void, List<Disbursement>>() {
            @Override
            protected List<Disbursement> doInBackground(Void... params) {
                return cDao.getPreparedDisbursement(employee);
            }

            @Override
            protected void onPostExecute(List<Disbursement> disbursements) {
                requisitionList.setAdapter(new disbursementApiAdapter(Disbursements.this, R.layout.row_confirm_disbursements, disbursements));

            }
        }.execute();

        requisitionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Disbursement disbursement = (Disbursement) parent.getAdapter().getItem(position);

                Intent intent = new Intent(Disbursements.this, DisbursementItems.class);

                intent.putExtra("data", disbursement);
                intent.putExtra("role", employee);
                startActivity(intent);
            }
        });

        TextView title = (TextView) findViewById(R.id.textView_title_confirm_disbursements);
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

