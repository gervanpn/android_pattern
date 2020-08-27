package com.androidpattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentCart extends AppCompatActivity {
    Button creditCard, paypal;
    TextView paymentsucess;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_cart);

        creditCard = (Button) findViewById(R.id.credit_card);
        paypal = (Button) findViewById(R.id.paypal);
        paymentsucess= findViewById(R.id.paymentSuccess);

        creditCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentCart.this, GetCreditCard.class);
                startActivity(intent);
            }
        });

        paypal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentCart.this, GetPaypal.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");
        if(checkFlag.equals("A")){
            //android.widget.Toast.makeText( com.androidpattern.PaymentCart.this , "there is no success msg" , android.widget.Toast.LENGTH_LONG ).show();
            forText("PayPal");
        }if(checkFlag.equals("B")) {
            forText("Credit Card");
        }
    }

    private void forText(String method) {
        if(getIntent().getExtras().getString("value")!=null) {
            st= getIntent().getExtras().getString("value");
            paymentsucess.setText(String.format("%s paid bill with %s", st, method));
        }
        else{
            android.widget.Toast.makeText( com.androidpattern.PaymentCart.this , "there is no success msg" , android.widget.Toast.LENGTH_LONG ).show();
        }
    }
}