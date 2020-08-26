package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentCart extends AppCompatActivity {
    Button creditCard, paypal;
    TextView totalCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_cart);
        totalCost = findViewById(R.id.Total_textView);

        creditCard = (Button) findViewById(R.id.credit_card);
        paypal = (Button) findViewById(R.id.paypal);

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
    }
}