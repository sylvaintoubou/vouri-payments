package com.apps.devbee.login_pagevoorinc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.fragment_navigation.DashbordFragment;
import com.apps.devbee.login_pagevoorinc.fragment_navigation.ProfileFragment;
import com.apps.devbee.login_pagevoorinc.fragment_navigation.Send_ReceiveFragment;

public class VouriincActivity extends AppCompatActivity {
    private TextView mTextMessage;
    final static int TEXT_REQUEST=10;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                   /* Uri uri= Uri.parse("https://www.google.com");
                    Intent it=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(it);
                    return true;*/
                    selectedFragment=new DashbordFragment();
                    break;
                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    /*Uri uri1=Uri.parse("tel:690034961");
                    Intent it1=new Intent(Intent.ACTION_DIAL,uri1);
                    startActivity(it1);
                    return true;*/
                    selectedFragment=new Send_ReceiveFragment();
                    break;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                   /* Intent i=new Intent(Intent.ACTION_GET_CONTENT);
                    i.setType("image/*");
                    startActivityForResult(i,TEXT_REQUEST);

                    return true;*/
                   selectedFragment=new ProfileFragment();
                   break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,selectedFragment).commit();
            return true;
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
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new ProfileFragment()).commit();
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
