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
        TextView unique_id,amount,purchase_purpose,trans_status,link_expiry_status,paylink_url;
        TextView expiry;
        public DataObjectHolder(View itemView) {
            super(itemView);
            unique_id = itemView.findViewById(R.id.unique_id);
            amount = itemView.findViewById(R.id.amount);
            purchase_purpose = itemView.findViewById(R.id.purchase_purpose);
            trans_status = itemView.findViewById(R.id.trans_status);
            link_expiry_status = itemView.findViewById(R.id.link_expiry_status);
            paylink_url = itemView.findViewById(R.id.paylink_url);


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
        holder.unique_id.setText("unique_id "+mDataset.get(position).getUniqueId());
        holder.amount.setText("amount "+mDataset.get(position).getAmount());
//
        if((mDataset.get(position).getPurchasePurpose() == null))
        {
            holder.purchase_purpose.setText("purchase_purpose "+"null");

        }


        if((mDataset.get(position).getTransStatus() == null))
        {
            holder.trans_status.setText("trans_status "+"null");

        }


        holder.link_expiry_status.setText("link_expiry_status "+mDataset.get(position).getLinkCreationDate());
        holder.paylink_url.setText("paylink_url "+mDataset.get(position).getPaylinkUrl());
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