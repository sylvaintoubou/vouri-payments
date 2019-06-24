package com.apps.devbee.login_pagevoorinc.fragment_navigation;


import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.apps.devbee.login_pagevoorinc.Adapter.TransactionsAdapter;
import com.apps.devbee.login_pagevoorinc.Model.Transaction;
import com.apps.devbee.login_pagevoorinc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashbordFragment extends Fragment {
  String msg1="Amount";
  String msg2 ="100 USD";
  RecyclerView mRecyclerView;
  TransactionsAdapter mAdapter;

    public DashbordFragment() {

        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v=inflater.inflate(R.layout.fragment_dashbord, container, false);
      mRecyclerView=(RecyclerView) v.findViewById(R.id.recyclerview1);
      List<Transaction> mTransactionList =new ArrayList<Transaction>();
      mTransactionList.add(new Transaction("001", 2,150.0f,"USD","USD",(short)1,"Akah Larry","TOUBOU"));
      mTransactionList.add(new Transaction("002", 3,160.0f,"USD","USD",(short)1,"Akah Larry","TOUBOU"));
      mTransactionList.add(new Transaction("003", 4,200.0f,"USD","USD",(short)1,"Larry","Sylvain"));
      mTransactionList.add(new Transaction("004", 5,600.0f,"USD","USD",(short)1,"NDEME","IVAN"));

      mAdapter= new TransactionsAdapter(getActivity(),mTransactionList);
      mRecyclerView.setAdapter(mAdapter);
      mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

}
