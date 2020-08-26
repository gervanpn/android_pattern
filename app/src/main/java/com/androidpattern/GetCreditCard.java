package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidpattern.Models.CreditCardStrategy;

public class GetCreditCard extends AppCompatActivity {
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_credit_card);

        buttonSubmit = (Button) findViewById( com.androidpattern.R.id.buttonSubmit );
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PaymentCart.class);
                startActivity(intent);
            }
        });
    }
}