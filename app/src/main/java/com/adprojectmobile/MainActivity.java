package com.adprojectmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adprojectmobile.activity.CollectionList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToCollectionPoint=(Button)findViewById(R.id.btn_toCollectionList);
        btnToCollectionPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.adprojectmobile.activity.CollectionList.class);
                startActivity(intent);
            }
        });
    }
}
