package com.arose.phonepee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arose.phonepee.R;
import com.arose.phonepee.model.TransactionModel;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TransactionModel> txnList;

    public TransactionAdapter(Context context, ArrayList<TransactionModel> txnList) {
        this.context = context;
        this.txnList = txnList;
    }

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {

        holder.txnImg.setImageResource(txnList.get(position).getImg_tnx_way());
        holder.txnDate.setText(txnList.get(position).getTxn_date());
        holder.txnTxtView.setText(txnList.get(position).getTnx_med());
        holder.txnDealer.setText(txnList.get(position).getTnx_dealer());
        holder.txnAmt.setText(txnList.get(position).getTnx_amt());
        holder.txnAmtDebCred.setText(txnList.get(position).getTnx_amt_cd());

    }

    @Override
    public int getItemCount() {
        return txnList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView txnImg;
        private TextView txnDate,txnTxtView,txnDealer,txnAmt,txnAmtDebCred;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txnImg = itemView.findViewById(R.id.imv_transaction_type);
            txnDate = itemView.findViewById(R.id.txt_transaction_date);
            txnTxtView = itemView.findViewById(R.id.txt_transaction_type);
            txnDealer = itemView.findViewById(R.id.txt_transaction_merchant);
            txnAmt = itemView.findViewById(R.id.txn_transaction_amount);
            txnAmtDebCred = itemView.findViewById(R.id.txn_transaction_cred_deb);

        }
    }
}
