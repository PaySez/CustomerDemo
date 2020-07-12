package com.paysez.customerdemo;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.gson.Gson;
import com.paysez.library.Responses.Datum;
import com.paysez.library.Responses.ExpiredLinksResponse;

import java.util.List;
public class RecyclerViewActivity extends Activity {
    private static String LOG_TAG = "RecyclerViewActivity";
    String data;
    Database db;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button sort_date,amount,decs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        sort_date = findViewById(R.id.sort_date);
        amount = findViewById(R.id.amount);
        decs = findViewById(R.id.decs);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        db = Room.databaseBuilder(getApplicationContext(),
                Database.class, "database-name").allowMainThreadQueries().build();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        data = getIntent().getStringExtra("data");
        mAdapter = new MyRecyclerViewAdapter(getPrimaryData(data));
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        sort_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sortByDate();
            }
        });

        amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sortByAmount();
            }
        });

        decs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortByDateDESC();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(
                new MyRecyclerViewAdapter.MyClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        Log.i(LOG_TAG, " Clicked on Item " + position);
                    }
                });
    }
    private List<LocalData> getPrimaryData(String data) {
        db.getListDao().deleteAll();
        ExpiredLinksResponse expiredLinksResponse = new Gson().fromJson(data, ExpiredLinksResponse.class);
        List<Datum> MainList = expiredLinksResponse.getData();
        for (int i = 0; i < MainList.size(); i++) {
            String status = MainList.get(i).getStatus();
            String linkExpiryStatus = MainList.get(i).getLinkExpiryStatus();
            String payStatusCode = MainList.get(i).getPayStatusCode();
            String amount = MainList.get(i).getAmount();
            String linkCreationDate = MainList.get(i).getLinkCreationDate();
            String expiryDate = MainList.get(i).getLinkExpiryDate();
            String maskedCard = MainList.get(i).getMaskedCard();
            String merchantName = MainList.get(i).getMerchantName();
            String paylinkUrl = MainList.get(i).getPaylinkUrl();
            String purchasePurpose = MainList.get(i).getPurchasePurpose();
            String rrnNo = MainList.get(i).getRrnNo();
            String transId = MainList.get(i).getTransId();
            String transType = MainList.get(i).getTransType();
            String uniqueId = MainList.get(i).getUniqueId();
            String transStatus = MainList.get(i).getTransStatus();
            String trans_data_time = MainList.get(i).getTransDatetime();
            if (status == null)
                status = "null";
            if (linkExpiryStatus == null)
                linkExpiryStatus = "null";
            if (payStatusCode == null)
                payStatusCode = "null";
            if (amount == null)
                amount = "null";
            if (linkCreationDate == null)
                linkCreationDate = "null";
            if (expiryDate == null)
                expiryDate = "null";
            if (maskedCard == null)
                maskedCard = "null";
            if (merchantName == null)
                merchantName = "null";
            if (paylinkUrl == null)
                paylinkUrl = "null";
            if (purchasePurpose == null)
                purchasePurpose = "null";
            if (rrnNo == null)
                rrnNo = "null";
            if (transId == null)
                transId = "null";
            if (transType == null)
                transType = "null";
            if (uniqueId == null)
                uniqueId = "null";
            if (transStatus == null)
                transStatus = "null";
            if (trans_data_time == null)
                trans_data_time = "null";
            LocalData localData = new LocalData();
            localData.setAmount(amount);
            localData.setLinkCreationDate(linkCreationDate);
            localData.setLinkExpiryDate(expiryDate);
            localData.setLinkExpiryStatus(linkExpiryStatus);
            localData.setMaskedCard(maskedCard);
            localData.setMerchantName(merchantName);
            localData.setPaylinkUrl(paylinkUrl);
            localData.setPayStatusCode(payStatusCode);
            localData.setPurchasePurpose(purchasePurpose);
            localData.setRrnNo(rrnNo);
            localData.setStatus(status);
            localData.setTransId(transId);
            localData.setTransStatus(transStatus);
            localData.setTransType(transType);
            localData.setUniqueId(uniqueId);
            localData.setTransDatetime(trans_data_time);
            ListDAO listDAO = db.getListDao();
            listDAO.insertAll(localData);
        }
        //  ExpiredLinksResponse expiredLinksResponse = new Gson().fromJson(data, ExpiredLinksResponse.class);
        // List<Datum> MainList = expiredLinksResponse.getData();
        List<LocalData> localDataList = db.getListDao().getAll();
        return localDataList;
    }

    private List<LocalData> sortByDate() {

        mRecyclerView.setAdapter(null);


        List<LocalData> localDataList = db.getListDao().sortByDate();

        mAdapter = new MyRecyclerViewAdapter(localDataList);
        mRecyclerView.setAdapter(mAdapter);
        return localDataList;
    }



    private List<LocalData> sortByDateDESC() {

        mRecyclerView.setAdapter(null);


        List<LocalData> localDataList = db.getListDao().sortByDateDescending();

        mAdapter = new MyRecyclerViewAdapter(localDataList);
        mRecyclerView.setAdapter(mAdapter);
        return localDataList;
    }


    private List<LocalData> sortByAmount() {

        mRecyclerView.setAdapter(null);


        List<LocalData> localDataList = db.getListDao().sortByDateAmount();

        mAdapter = new MyRecyclerViewAdapter(localDataList);
        mRecyclerView.setAdapter(mAdapter);
        return localDataList;
    }
}