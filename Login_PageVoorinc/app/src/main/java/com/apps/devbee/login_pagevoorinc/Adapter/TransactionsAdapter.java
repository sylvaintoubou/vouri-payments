package com.apps.devbee.login_pagevoorinc.Adapter;

import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.Model.Transaction;
import com.apps.devbee.login_pagevoorinc.R;

import java.util.List;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder> {
    Context context;
    List<Transaction> transactionList;

    public TransactionsAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;
    }

    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(i,viewGroup,false);
        return new TransactionViewHolder(v,this);
    }

    @Override
    public void onBindViewHolder(@NonNull final TransactionViewHolder transactionViewHolder, int i) {
        String name=transactionList.get(i).getTransactionRecipientId();
       transactionViewHolder.tv_name_value.setText(name);
       float amount=transactionList.get(i).getTransactionAmount();
       transactionViewHolder.tv_transaction_amount.setText(amount +" ");



    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return R.layout.transaction_current_item;
        else
        return R.layout.transaction_item;
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class  TransactionViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private final TransactionsAdapter mAdapter;
        private TextView tv_name;
        private TextView tv_phone;
        private TextView tv_date_of_transaction;
        private TextView tv_name_value;
        private TextView tv_phone_value;
        private TextView tv_date_of_transaction_value;
        private TextView tv_transaction_amount;
        private View rootView;


        public TransactionViewHolder(@NonNull View itemView,TransactionsAdapter adapter) {
            super(itemView);

            rootView=itemView;
            tv_name=(TextView) itemView.findViewById(R.id.tv_name);
            tv_phone=(TextView) itemView.findViewById(R.id.tv_phone);
            tv_date_of_transaction=(TextView) itemView.findViewById(R.id.tv_date_transaction);
            tv_name_value=(TextView) itemView.findViewById(R.id.tv_name_value);
            tv_phone_value=(TextView) itemView.findViewById(R.id.tv_phone_value);
            tv_date_of_transaction_value=(TextView) itemView.findViewById(R.id.tv_date_transaction_value);
            tv_transaction_amount=(TextView) itemView.findViewById(R.id.tv_transaction_amount);
            this.mAdapter=adapter;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            Toast.makeText(mAdapter.getContext(), tv_transaction_amount.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
