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
    EditText name, card_no;
    String st, st1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_credit_card);

        buttonSubmit = (Button) findViewById( com.androidpattern.R.id.buttonSubmit );
        name = findViewById(R.id.editTextName);
        card_no = findViewById(R.id.editTextCardNumber);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetCreditCard.this, PaymentCart.class);
                st=name.getText().toString();
                st1 = card_no.getText().toString();
                intent.putExtra("flag", "CC");
                intent.putExtra("value",st);
                intent.putExtra("value2",st1);
                startActivity(intent);
                finish();
            }
        });
    }
}