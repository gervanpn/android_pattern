package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.androidpattern.Models.CreditCardStrategy;

public class GetCreditCard extends AppCompatActivity {
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_credit_card);

        buttonSubmit = (Button) findViewById( com.androidpattern.R.id.buttonSubmit );
        buttonSubmit.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                android.widget.Toast.makeText( com.androidpattern.GetCreditCard.this , "Signing into PayPal" , android.widget.Toast.LENGTH_LONG ).show();
            }
        });
    }
}