package com.adprojectmobile.activity.inventoryStore.RetrievalForm;

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

import com.adprojectmobile.MainActivity;
import com.adprojectmobile.R;
import com.adprojectmobile.activity.department.ConfirmDisbursement.ConfirmCollection;
import com.adprojectmobile.activity.inventoryStore.AdjustmentVoucher.IssueAdjustment.AdjustItemQty;
import com.adprojectmobile.activity.inventoryStore.StockClerkMainPage;
import com.adprojectmobile.apiModel.EmployeeApi;
import com.adprojectmobile.apiModel.RetrievalCollectionPoint;
import com.adprojectmobile.apiModel.RetrievalItem;
import com.adprojectmobile.dao.Dao.itemTransactionDao;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.dao.Dao.*;
import com.adprojectmobile.dao.DaoImpl.*;
import com.adprojectmobile.daoApi.retrievalDao;
import com.adprojectmobile.model.Item;
import com.adprojectmobile.model.ItemTransaction;
import com.adprojectmobile.model.RequisitionItem;
import com.adprojectmobile.util.JSONPaser;

import java.util.List;

public class ConfirmRetrieval extends AppCompatActivity {
        retrievalDao rDao=new retrievalDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieval_form_activity_confirm_retrieval);
        final String cpId=getIntent().getStringExtra("id");
        final RetrievalCollectionPoint retrievalCollectionPoint=getIntent().getParcelableExtra("collection");
        final EmployeeApi employee=getIntent().getParcelableExtra("role");
        final String colId=retrievalCollectionPoint.getCollectionPointID();
        Log.e("cpId",colId);
        final RetrievalItem retrievalItem = getIntent().getParcelableExtra("data");
        final Boolean isPrepared =getIntent().getBooleanExtra("prepared",false);

        final EditText editTextName = (EditText) findViewById(R.id.editText_itemName_confirmCollection);
        final EditText editTextQtyNeeded = (EditText) findViewById(R.id.editText_itemQtyNeeded_confirmCollection);
        final EditText editTextQtyRetri= (EditText) findViewById(R.id.editText_itemQtyRetrieval_confirmCollection);

        editTextName.setText(retrievalItem.getName());
        editTextQtyNeeded.setText(retrievalItem.getQtyNeeded());
        editTextQtyRetri.setText(retrievalItem.getQtyRetrieved());



        Button btn_save=(Button)findViewById(R.id.btn_save_confirm_retrieval);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String itemID=retrievalItem.getId();
                final String itemName=retrievalItem.getName();
                final String neededQty=retrievalItem.getQtyNeeded();
                final String retriQty= editTextQtyRetri.getText().toString();
                if(isPrepared){
                    Toast.makeText(getApplicationContext(),"Already prepared, can't change",Toast.LENGTH_LONG).show();
                }

                else {
                    new AsyncTask<String, Void, Void>() {
                        @Override
                        protected Void doInBackground(String... params) {
                            rDao.updateRetrievalQty(colId,itemID,itemName,neededQty,retriQty);
                            return null;
                        }
                    }.execute();

                    Intent intent = new Intent(getApplicationContext(), ItemsForCollection.class);

                    intent.putExtra("id",retrievalCollectionPoint.getCollectionPointID().toString() );
                    intent.putExtra("role",employee);
                    intent.putExtra("collection",retrievalCollectionPoint);

                    startActivity(intent);
                }

                }
            }
        );

        TextView title=(TextView)findViewById(R.id.textview_title_retrivalForm_confirmRetrieval);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), StockClerkMainPage.class);
                intent.putExtra("role",employee);
                startActivity(intent);
            }
        });
    }

}
