package com.apps.devbee.login_pagevoorinc.loginTwoFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.apps.devbee.login_pagevoorinc.LoginActivityTwo;
import com.apps.devbee.login_pagevoorinc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    Button login_button_two;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_login, container, false);
        login_button_two=v.findViewById(R.id.login_button_two);
        login_button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivityTwo)getContext()).getLogo_vouriinc().setVisibility(View.INVISIBLE);
                ((LoginActivityTwo)getContext()).getProgressBar().setVisibility(View.VISIBLE);
            }
        });
        return v;
    }

}
