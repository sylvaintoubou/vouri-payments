package com.apps.devbee.login_pagevoorinc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class VouriincActivity extends AppCompatActivity {
    private TextView mTextMessage;
    final static int TEXT_REQUEST=10;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    Uri uri= Uri.parse("https://www.google.com");
                    Intent it=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(it);
                    return true;
                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    Uri uri1=Uri.parse("tel:690034961");
                    Intent it1=new Intent(Intent.ACTION_DIAL,uri1);
                    startActivity(it1);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    Intent i=new Intent(Intent.ACTION_GET_CONTENT);
                    i.setType("image/*");
                    startActivityForResult(i,TEXT_REQUEST);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vouriinc);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        String testlogin=getIntent().getStringExtra("email");
        String testpass=getIntent().getStringExtra("password");
        Toast.makeText(this,testlogin+' '+testpass,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){
                Uri reply=data.getData();
                Toast.makeText(this, "Data reply " +reply,Toast.LENGTH_LONG).show();
            }else
                Toast.makeText(this, " No Data to reply " ,Toast.LENGTH_LONG).show();
        }

    }
}
