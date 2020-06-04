package com.paysez.customerdemo;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.paysez.library.PaymentLinkHelper;


public class MerchantLoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user_name, pwd;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        PrepareUI();
        btn_login.setOnClickListener(this);

    }


    private void PrepareUI() {
        user_name = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        btn_login = findViewById(R.id.login);
    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.login) {
            Intent intent = new Intent(this, PaymentLinkHelper.class);
            intent.putExtra("request_for", "login");
            intent.putExtra("username", user_name.getText().toString());
            intent.putExtra("password", pwd.getText().toString());
            startActivityForResult(intent, 1);


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1 && requestCode == 1) {
            Intent intent = data;


            String status = intent.getStringExtra("status");
            if (status.equalsIgnoreCase("00")) {
                String mid = intent.getStringExtra("mid");
                String uname = intent.getStringExtra("username");
                Intent intent1 = new Intent(this, PaymentLinksActivity.class);
                intent1.putExtra("mid", mid);
                intent1.putExtra("uname", uname);
                startActivity(intent1);
            } else if (status.equalsIgnoreCase("01")) {


                Toast.makeText(this, status, Toast.LENGTH_SHORT).show();


            }

            if (status.equalsIgnoreCase("02")) {
                String error_msg = intent.getStringExtra("error_msg");

                Toast.makeText(this, error_msg, Toast.LENGTH_SHORT).show();

            }
        }


    }
}
