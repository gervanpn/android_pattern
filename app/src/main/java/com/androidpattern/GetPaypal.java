package com.androidpattern;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GetPaypal extends AppCompatActivity {
    Button checkoutButton;
    String st;
    android.widget.TextView emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_paypal);

        checkoutButton = ( Button ) findViewById( com.androidpattern.R.id.checkOutButton );
        emailAddress = findViewById( com.androidpattern.R.id.editTextEmailAddress );

        checkoutButton.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                android.widget.Toast.makeText( com.androidpattern.GetPaypal.this , "PayPal payment successful" , android.widget.Toast.LENGTH_LONG ).show();
                android.content.Intent intent = new android.content.Intent( GetPaypal.this, PaymentCart.class);
                st = emailAddress.getText().toString();
                intent.putExtra("flag", "PP");
                intent.putExtra("value", st);
                startActivity(intent);
                finish();
            }
        });
    }
}
