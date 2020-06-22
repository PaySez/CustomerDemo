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
    private List<Datum> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView merchant_name, unique_id, amount, purchase_purpose, trans_id, trans_status, link_creation_date, link_expiry_date, paylink_url, link_expiry_status, pay_status_code;


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

    public MyRecyclerViewAdapter(List<Datum> myDataset) {
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
    }

    public void addItem(Datum dataObj, int index) {
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