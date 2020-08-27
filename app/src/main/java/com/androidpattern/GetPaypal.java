package com.androidpattern;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GetPaypal extends AppCompatActivity {
    Button buttonLogin;
    String st;
    TextView email;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_paypal);
    
        buttonLogin = ( Button ) findViewById( com.androidpattern.R.id.buttonLogin );
        email = findViewById(R.id.editTextEmailAddress);
        buttonLogin.setOnClickListener(new android.view.View.OnClickListener() {
    
            @Override
            public void onClick(android.view.View v) {
                android.widget.Toast.makeText( com.androidpattern.GetPaypal.this , "Signing into PayPal" , android.widget.Toast.LENGTH_LONG ).show();
                Intent intent = new Intent(GetPaypal.this, PaymentCart.class);
                st = email.getText().toString();
                intent.putExtra("flag", "PP");
                intent.putExtra("value",st);
                startActivity(intent);
                finish();
                //android.content.Intent intent = new android.content.Intent(LogoActivity.this, LoginActivity.class);
                //startActivity(intent);
                
            }
        });
    }
}