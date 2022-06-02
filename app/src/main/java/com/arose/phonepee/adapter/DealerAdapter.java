package com.arose.phonepee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arose.phonepee.R;
import com.arose.phonepee.model.DealerModel;

import java.util.ArrayList;

public class DealerAdapter extends RecyclerView.Adapter<DealerAdapter.viewHolder> {
    public DealerAdapter(Context context, ArrayList<DealerModel> dealerModelArrayList) {
        this.context = context;
        this.dealerModelArrayList = dealerModelArrayList;
    }

    private Context context;
    private ArrayList<DealerModel> dealerModelArrayList;

    @NonNull
    @Override
    public DealerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_dealers,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealerAdapter.viewHolder holder, int position) {

        holder.dealerName.setText(dealerModelArrayList.get(position).getDealer_name());
        holder.discountOffer.setText(dealerModelArrayList.get(position).getDiscount_offer());
        holder.discountAmt.setText(dealerModelArrayList.get(position).getDiscount_amt());
        holder.discountVc.setText(dealerModelArrayList.get(position).getDiscount_way());
        holder.discountDetails.setText(dealerModelArrayList.get(position).getDiscount_detail());

    }

    @Override
    public int getItemCount() {
        return dealerModelArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView dealerName,discountOffer,discountAmt,discountVc,discountDetails;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            dealerName = itemView.findViewById(R.id.dealer_txt);
            discountAmt = itemView.findViewById(R.id.dealer_off_price);
            discountDetails = itemView.findViewById(R.id.discount_info);
            discountOffer = itemView.findViewById(R.id.dealer_off);
            discountVc = itemView.findViewById(R.id.dealer_off_bw);
        }
    }
}
