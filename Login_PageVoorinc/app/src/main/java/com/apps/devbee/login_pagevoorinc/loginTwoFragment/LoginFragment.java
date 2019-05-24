package com.apps.devbee.login_pagevoorinc.loginTwoFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.LoginActivity;
import com.apps.devbee.login_pagevoorinc.R;
import com.apps.devbee.login_pagevoorinc.VouriincActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    Button login_button_two;
    EditText login_editTextPassword;
    EditText loginEditTextEmail;
    String passwordsize;
    String email;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_login, container, false);
        login_button_two=v.findViewById(R.id.login_button_two);
        login_editTextPassword=v.findViewById(R.id.editText);
        loginEditTextEmail=v.findViewById(R.id.editText2);
         passwordsize = login_editTextPassword.getText().toString();
        email = loginEditTextEmail.getText().toString();

        login_button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*((LoginActivity)getContext()).getLogo_vouriinc().setVisibility(View.INVISIBLE);
                ((LoginActivity)getContext()).getProgressBar().setVisibility(View.VISIBLE);
                if (!email.isEmpty()&&!passwordsize.isEmpty()&&passwordsize.length()<6){
                    Toast.makeText(getActivity(),"erreur de  mots de passe : 6 caracteres minimun",Toast.LENGTH_LONG).show();
                    ((LoginActivity)getContext()).getLogo_vouriinc().setVisibility(View.VISIBLE);
                    ((LoginActivity)getContext()).getProgressBar().setVisibility(View.INVISIBLE);
                }

                if (email.isEmpty()||passwordsize.isEmpty()){
                    Toast.makeText(getActivity(),"remplir tous svp",Toast.LENGTH_LONG).show();
                    ((LoginActivity)getContext()).getLogo_vouriinc().setVisibility(View.VISIBLE);
                    ((LoginActivity)getContext()).getProgressBar().setVisibility(View.INVISIBLE);
                }*/
                passwordsize = login_editTextPassword.getText().toString();
                email = loginEditTextEmail.getText().toString();

                Intent homeIntent = new Intent(getActivity(), VouriincActivity.class);
                homeIntent.putExtra("email",email);
                homeIntent.putExtra("password",passwordsize);
                getActivity().startActivity(homeIntent);
                getActivity().finish();

            }
        });
        return v;
    }

}
