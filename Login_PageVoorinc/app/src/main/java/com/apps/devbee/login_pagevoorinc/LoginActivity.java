package com.apps.devbee.login_pagevoorinc;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.apps.devbee.login_pagevoorinc.loginTwoFragment.LoginFragment;
import com.apps.devbee.login_pagevoorinc.loginTwoFragment.Sign_upFragment;

public class LoginActivity extends AppCompatActivity {
    ViewPager login_two_viewpager;
    TabLayout tabLayout;
    ImageView logo_vouriinc;
    ProgressBar progressBar;
    int a=1,b=3,sum=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_two);
        login_two_viewpager=findViewById(R.id.login_two_viewpager);
        setupViewPager(login_two_viewpager);
        tabLayout=findViewById(R.id.tabLayout);
        setupViewPager(login_two_viewpager);
        tabLayout.setupWithViewPager(login_two_viewpager);
        logo_vouriinc=findViewById(R.id.logo_vouriinc);
        progressBar=findViewById(R.id.login_progressBar);
        ConstraintLayout constraintLayout=findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        logo_vouriinc.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade));
        sum=a+b;
        Log.d("wouri","OnCreate"+" sum is "+sum);
    }

    public void setupViewPager(ViewPager viewPager){
        Bundle bundle = new Bundle();
        TabsAdapter tabsAdapter=new TabsAdapter(getSupportFragmentManager());
        tabsAdapter.addFragment(new LoginFragment(),"Login");
        tabsAdapter.addFragment(new Sign_upFragment(),"Sign up");
        viewPager.setAdapter(tabsAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("wouri","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("wouri","OnResume"+" sum is "+sum++);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("wouri","OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("wouri","OnRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("key",sum);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sum=savedInstanceState.getInt("key");
    }

    public ImageView getLogo_vouriinc() {
        return logo_vouriinc;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
