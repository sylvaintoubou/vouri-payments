package com.apps.devbee.login_pagevoorinc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class TransactionDetailActivity extends AppCompatActivity {
Toolbar trans_tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);
        trans_tb=findViewById(R.id.toolbar3);
        setSupportActionBar(trans_tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    
}
