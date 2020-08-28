package com.androidpattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidpattern.Models.Cart;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentCart extends AppCompatActivity {
    Button creditCard, paypal, home;
    TextView paymentsucess,  total_cost, total_quantity;
    String st, st2;
    double cost = Cart.getTotalCost();
    int quantity = Cart.getQuantity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_cart);

        creditCard = (Button) findViewById(R.id.credit_card);
        paypal = (Button) findViewById(R.id.paypal);
        home = (Button) findViewById(R.id.gotostart);
        paymentsucess= findViewById(R.id.paymentSuccess);
        total_cost =findViewById(R.id.total_cost);
        total_cost.setText( cost + "");
        total_quantity = findViewById(R.id.total_items);
        total_quantity.setText(quantity+"");

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

       home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentCart.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");
        if(checkFlag.equals("A")){
            android.widget.Toast.makeText( com.androidpattern.PaymentCart.this , "Got the items" , android.widget.Toast.LENGTH_LONG ).show();
           }
        if(checkFlag.equals("CC")) {
            creditText();
        }if(checkFlag.equals("PP")){
            paypalText();
        }
    }

    private void paypalText() {
        if(getIntent().getExtras().getString("value") != null) {
            st = getIntent().getExtras().getString("value");
            paymentsucess.setText(st + " paid bill with Paypal");
        } else {
            Toast.makeText( com.androidpattern.PaymentCart.this , "No Data Entered" , Toast.LENGTH_LONG ).show();
        }
    }

    private void creditText() {
        if(getIntent().getExtras().getString("value") != null) {
            st = getIntent().getExtras().getString("value");
            st2 = getIntent().getExtras().getString("value2");
            paymentsucess.setText(st + st2 + " paid bill with Credit Card");
        } else {
           Toast.makeText( PaymentCart.this , "No Data Entered" , Toast.LENGTH_LONG ).show();
        }
    }
}
