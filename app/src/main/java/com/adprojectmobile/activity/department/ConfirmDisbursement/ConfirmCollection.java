package com.adprojectmobile.activity.department.ConfirmDisbursement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.EmployeeMainPage;
import com.adprojectmobile.activity.department.RepresentativeMainPage;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustItemQty;
import com.adprojectmobile.apiModel.DisbursementApi;
import com.adprojectmobile.apiModel.DisbursementItemApi;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.apiModel.RequisitionApi;
import com.adprojectmobile.apiModel.RequisitionItemApi;
import com.adprojectmobile.dao.Dao.requisitionItemDao;
import com.adprojectmobile.dao.DaoImpl.itemDaoImpl;
import com.adprojectmobile.dao.Dao.itemDao;
import com.adprojectmobile.dao.DaoImpl.itemTransactionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionDaoImpl;
import com.adprojectmobile.dao.DaoImpl.requisitionItemDaoImpl;
import com.adprojectmobile.daoApi.confirmDao;
import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.model.Requisition;
import com.adprojectmobile.model.RequisitionItem;

import java.util.List;

public class ConfirmCollection extends AppCompatActivity {


    confirmDao cDao=new confirmDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_disbursement_activity_confirm_collection);

        final DisbursementItemApi disbursementItemApi=getIntent().getParcelableExtra("data");
        final DisbursementApi disbursementApi=getIntent().getParcelableExtra("dis");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");


        final EditText editTextItemName = (EditText) findViewById(R.id.editText_itemDescription_confirmCollection);
        final EditText editTextQuantityRetrieved = (EditText) findViewById(R.id.editText_itemQtyRetrieve_confirmCollection);
        final EditText editTextQuantityActual= (EditText) findViewById(R.id.editText_itemQtyActual_confirmCollection);

        editTextItemName.setText(disbursementItemApi.getDescription());
        editTextQuantityRetrieved.setText(disbursementItemApi.getRetrievedQuantity());
        editTextQuantityActual.setText(disbursementItemApi.getActualQuantity());


        Button btn_save=(Button)findViewById(R.id.btn_save_confirm_disbursement_confirm_collection);
        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new AsyncTask<String, Void, Void>() {
                    String actualQty=editTextQuantityActual.getText().toString();
                    @Override
                    protected Void doInBackground(String... params) {
                        cDao.saveActualQty(disbursementApi.getDisbursementID(),disbursementItemApi.getDescription(),disbursementItemApi.getUnitMeasured(),disbursementItemApi.getRetrievedQuantity(),actualQty,disbursementItemApi.getNeededQuantity(),disbursementItemApi.getTransactionID(),disbursementItemApi.getItemID());
                        return null;
                    }
                }.execute();
                Toast.makeText(getApplicationContext(),"Save",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),DisbursementItems.class);
                intent.putExtra("role",employee);
                intent.putExtra("data",disbursementApi);
                startActivity(intent);
            }
        });

        TextView title=(TextView)findViewById(R.id.textView_title_confirmCollection);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (employee.getIsDelegated().equals("true")){
                    Intent intent=new Intent(getApplicationContext(), EmployeeMainPage.class);
                    intent.putExtra("role",employee);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(getApplicationContext(), RepresentativeMainPage.class);
                    intent.putExtra("role",employee);
                    startActivity(intent);
                }

            }
        });
    }
    }
