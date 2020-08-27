package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidpattern.Models.CreditCardStrategy;

public class GetCreditCard extends AppCompatActivity {
    Button buttonSubmit;
    EditText name;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_credit_card);

        buttonSubmit = (Button) findViewById( com.androidpattern.R.id.buttonSubmit );
        name = findViewById(R.id.editTextName);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetCreditCard.this, PaymentCart.class);
                st=name.getText().toString();
                intent.putExtra("flag", "B");
                intent.putExtra("value",st);
                startActivity(intent);
                finish();
            }
        });
    }
}