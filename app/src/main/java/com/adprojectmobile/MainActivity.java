package com.adprojectmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.adprojectmobile.activity.inventoryStore.RetrievalForm.CollectionPoints;
import com.adprojectmobile.activity.inventoryStore.RetrievalForm.ConfirmRetrieval;
import com.adprojectmobile.activity.inventoryStore.RetrievalForm.ItemsForCollection;
import com.adprojectmobile.testdata.testCollectionList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToTestCollectionPoint=(Button)findViewById(R.id.btn_toTestCollectionList);
        btnToTestCollectionPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,testCollectionList.class);
                startActivity(intent);
            }
        });

        Button btnToCollectionPoint=(Button)findViewById(R.id.btn_toRetrieval_firstPage);
        btnToCollectionPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CollectionPoints.class);
                startActivity(intent);
            }
        });

        Button btnToRequisitionItems=(Button)findViewById(R.id.btn_toRetrievalthirdPage);
        btnToRequisitionItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ConfirmRetrieval.class);
                startActivity(intent);
            }
        });

        Button btnToDelivery=(Button)findViewById(R.id.btn_toDelivery_firstPage);
        btnToDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.adprojectmobile.activity.inventoryStore.DeliveryInformation.CollectionPoints.class);
                startActivity(intent);
            }
        });
    }
}
