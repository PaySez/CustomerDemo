package com.paysez.customerdemo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.paysez.library.PaymentLinkHelper;

public class EmailSmsActivity extends AppCompatActivity {

    TextView url_textview;
    Button SMS, email;
    String mid, merchant_name, url, mobile, whatsapp, email_val, amt, nm, uid, prps,cust_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        url_textview = findViewById(R.id.url_textview);

        mid = getIntent().getStringExtra("mid");
        cust_name = getIntent().getStringExtra("cust_name");
        merchant_name = getIntent().getStringExtra("merchant_name");
        url = getIntent().getStringExtra("paylink");
        mobile = getIntent().getStringExtra("mobile");
        //   whatsapp = getIntent().getStringExtra("whatsapp");
        email_val = getIntent().getStringExtra("email");
        amt = getIntent().getStringExtra("amt");
        nm = getIntent().getStringExtra("nm");
        uid = getIntent().getStringExtra("uid");
        prps = getIntent().getStringExtra("prps");

        url_textview.setText(url);
        SMS = findViewById(R.id.SMS);
        email = findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                mail:thiyagu@paysez.net
//                amt:1
//                nm:trans
//                mid:5345345
//                uid:3423dff
//                prps:ddgdg
//                request_for:MAIL

                Log.v("valval", email_val);
                Log.v("valval", amt);
                Log.v("valval", nm);
                Log.v("valval", mid);
                Log.v("valval", uid);
                Log.v("valval", prps);
                Log.v("valval", "MAIL");


                Intent intent = new Intent(EmailSmsActivity.this, PaymentLinkHelper.class);
                intent.putExtra("amt", amt);
                intent.putExtra("nm", nm);
                intent.putExtra("cust_name",cust_name);
                intent.putExtra("mid", mid);
                intent.putExtra("uid", uid);
                intent.putExtra("email", email_val);
                intent.putExtra("prps", prps);
                intent.putExtra("request_for", "MAIL"); // 3

                startActivityForResult(intent, 3);
            }
        });


        SMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("valval", mobile);
                Log.v("valval", amt);
                Log.v("valval", nm);
                Log.v("valval", mid);
                Log.v("valval", uid);
                Log.v("valval", prps);
                Log.v("valval", "SMS");

                Intent intent = new Intent(EmailSmsActivity.this, PaymentLinkHelper.class);
                intent.putExtra("amt", amt);
                intent.putExtra("nm", nm);
                intent.putExtra("mid", mid);
                intent.putExtra("uid", uid);
                intent.putExtra("prps", prps);
                intent.putExtra("cust_name",cust_name);
                intent.putExtra("mobile", mobile);
                intent.putExtra("request_for", "SMS"); // 4
                startActivityForResult(intent, 4);
            }
        });

        Toast.makeText(getApplicationContext(), "Link Generated", Toast.LENGTH_LONG).show();
        url_textview = findViewById(R.id.url_textview);
        url_textview.setText(url);
        url_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", url_textview.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Link Coppied", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4 && resultCode == 4) {
            String sms_status = data.getStringExtra("sms_status");
            String unique_id = data.getStringExtra("unique_id");
            String mid = data.getStringExtra("mid");
            String merchant_name = data.getStringExtra("merchant_name");
            if (sms_status.equalsIgnoreCase("00")) {
                Toast.makeText(getApplicationContext(), "SMS sent Successfull", Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == 3 && resultCode == 3) {
            String sms_status = data.getStringExtra("mail_status");
            String unique_id = data.getStringExtra("unique_id");
            String mid = data.getStringExtra("mid");
            String merchant_name = data.getStringExtra("merchant_name");
            if (sms_status.equalsIgnoreCase("00")) {
                Toast.makeText(getApplicationContext(), "Mail sent Successfull", Toast.LENGTH_LONG).show();
            }
        }
    }
}
