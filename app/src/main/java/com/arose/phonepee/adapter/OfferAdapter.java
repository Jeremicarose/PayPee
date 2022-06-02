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
import com.arose.phonepee.model.OfferModel;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.viewHolder> {
    private Context context;
    private ArrayList<OfferModel> offerModelArrayList;

    public OfferAdapter(Context context, ArrayList<OfferModel> offerModelArrayList) {
        this.context = context;
        this.offerModelArrayList = offerModelArrayList;
    }

    @NonNull
    @Override
    public OfferAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offers,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.viewHolder holder, int position) {
        holder.offerDescription.setText(offerModelArrayList.get(position).getOffer_details());
        holder.offerItem.setText(offerModelArrayList.get(position).getOffer_on());
        holder.offerImgView.setImageResource(offerModelArrayList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return offerModelArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private ImageView offerImgView;
        private TextView offerItem, offerDescription;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            offerImgView = itemView.findViewById(R.id.offer_img);
            offerItem = itemView.findViewById(R.id.offer_txt);
            offerDescription = itemView.findViewById(R.id.offer_info);
        }
    }
}
