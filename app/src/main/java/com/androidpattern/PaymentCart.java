package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidpattern.Models.Cart;

public class PaymentCart extends AppCompatActivity {
    Button creditCard, paypal;
    TextView paymentsucess,  total_cost;
    String st, st2;
    double cost = Cart.getTotal();
    int quantity = Cart.getQuantity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_cart);

        creditCard = (Button) findViewById(R.id.credit_card);
        paypal = (Button) findViewById(R.id.paypal);
        paymentsucess= findViewById(R.id.paymentSuccess);
        total_cost =findViewById(R.id.total_cost);
        total_cost.setText( cost + "");
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
            total(); }
        if(checkFlag.equals("CC")) {
            creditText();
        }if(checkFlag.equals("PP")){
            paypalText();
        }
    }

    private void total() {
//            cost= getIntent().getDoubleExtra("Total",0);
//            total_cost.setText( cost + "");
    }

    private void paypalText() {
        if(getIntent().getExtras().getString("value")!=null) {
            st= getIntent().getExtras().getString("value");
            paymentsucess.setText(st + " paid bill with Paypal");
        }
        else{
            android.widget.Toast.makeText( com.androidpattern.PaymentCart.this , "No Data Entered" , android.widget.Toast.LENGTH_LONG ).show();
        }
    }

    private void creditText() {
        if(getIntent().getExtras().getString("value")!=null) {
            st= getIntent().getExtras().getString("value");
            st2= getIntent().getExtras().getString("value2");
            paymentsucess.setText(st + st2 + " paid bill with Credit Card");
        }
        else{
            android.widget.Toast.makeText( com.androidpattern.PaymentCart.this , "No Data Entered" , android.widget.Toast.LENGTH_LONG ).show();
        }
    }
}
