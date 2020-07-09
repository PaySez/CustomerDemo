package com.paysez.customerdemo;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.paysez.library.Responses.Datum;

import java.util.List;


public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private List<LocalData> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView merchant_name, unique_id, amount, purchase_purpose, trans_id, trans_status, link_creation_date, link_expiry_date, paylink_url, link_expiry_status, pay_status_code;
        TextView rrn_no, trans_type, masked_card;

        public DataObjectHolder(View itemView) {
            super(itemView);
            merchant_name = itemView.findViewById(R.id.merchant_name);
            unique_id = itemView.findViewById(R.id.unique_id);
            amount = itemView.findViewById(R.id.amount);
            purchase_purpose = itemView.findViewById(R.id.purchase_purpose);
            trans_status = itemView.findViewById(R.id.trans_status);
            link_expiry_status = itemView.findViewById(R.id.link_expiry_status);
            paylink_url = itemView.findViewById(R.id.paylink_url);
            trans_id = itemView.findViewById(R.id.trans_id);
            link_creation_date = itemView.findViewById(R.id.link_creation_date);
            link_expiry_date = itemView.findViewById(R.id.link_expiry_date);
            pay_status_code = itemView.findViewById(R.id.pay_status_code);
            rrn_no = itemView.findViewById(R.id.rrn_no);
            trans_type = itemView.findViewById(R.id.trans_type);
            masked_card = itemView.findViewById(R.id.masked_card);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(List<LocalData> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.merchant_name.setText("Merchant name :" + mDataset.get(position).getMerchantName());
        holder.unique_id.setText("unique_id " + mDataset.get(position).getUniqueId());
        holder.amount.setText("amount " + mDataset.get(position).getAmount());
//
        if ((mDataset.get(position).getPurchasePurpose() == null)) {

            holder.purchase_purpose.setText("purchase_purpose " + "null");
        } else {

            holder.purchase_purpose.setText("purchase_purpose " + mDataset.get(position).getPurchasePurpose());

        }
        if (mDataset.get(position).getTransId() == null) {

            holder.trans_id.setText("TransID : Not found");

        } else {
            holder.trans_id.setText("TransID :" + mDataset.get(position).getTransId());

        }

        if ((mDataset.get(position).getTransStatus() == null)) {
            holder.trans_status.setText("trans_status " + "Not Success");

        } else {

            holder.trans_status.setText("trans_status " + mDataset.get(position).getTransStatus());

        }


        holder.link_creation_date.setText("link_creation_date " + mDataset.get(position).getLinkCreationDate());

        holder.link_expiry_date.setText("link_expiry_date " + mDataset.get(position).getLinkExpiryDate());
        holder.paylink_url.setText("paylink_url " + mDataset.get(position).getPaylinkUrl());

        holder.link_expiry_status.setText("link_expiry_status " + mDataset.get(position).getLinkExpiryStatus());
        holder.pay_status_code.setText("pay_status_code " + mDataset.get(position).getPayStatusCode());


        if ((mDataset.get(position).getRrnNo() == null)) {
            holder.rrn_no.setText("RRN No " + "Not Found");

        } else {

            holder.rrn_no.setText("RRN No " + mDataset.get(position).getRrnNo());

        }


        if ((mDataset.get(position).getTransType() == null)) {
            holder.trans_type.setText("Trans Type " + "Not Found");

        } else {

            holder.trans_type.setText("Trans Type " + mDataset.get(position).getTransType());

        }

        if ((mDataset.get(position).getMaskedCard() == null)) {
            holder.masked_card.setText("Masked Card " + "Not Found");

        } else {

            holder.masked_card.setText("Masked Card " + mDataset.get(position).getMaskedCard());

        }
//Log.e("masked", mDataset.get(position).getRrnNo());
    }

    public void addItem(LocalData dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}