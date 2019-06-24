package com.apps.devbee.login_pagevoorinc.loginTwoFragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sign_upFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    public Sign_upFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sign_up, container, false);
        Button sign_up =(Button) view.findViewById(R.id.sign_up_button_two);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog(v);
            }
        });
        view.findViewById(R.id.editText).requestFocus();
        Spinner spinner=(Spinner)view.findViewById(R.id.spinner);
        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinner_item=parent.getItemAtPosition(position).toString();
        Toast.makeText(getActivity(),spinner_item,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void onCreateDialog(View v) {
            // Use the Builder class for convenient dialog construction
            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Dialog Alert");
            builder.setMessage("The sign up fragment");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(getContext(),"enter user exist",Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getContext(), "enter a user doest not exist", Toast.LENGTH_LONG).show();
                        }
                        });
         builder.create().show();

        }


}
