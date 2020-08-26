package com.androidpattern;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GetPaypal extends AppCompatActivity {
    Button buttonLogin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_paypal);
    
        buttonLogin = ( Button ) findViewById( com.androidpattern.R.id.buttonLogin );
        buttonLogin.setOnClickListener(new android.view.View.OnClickListener() {
    
            @Override
            public void onClick(android.view.View v) {
                android.widget.Toast.makeText( com.androidpattern.GetPaypal.this , "Signing into PayPal" , android.widget.Toast.LENGTH_LONG ).show();
                android.content.Intent intent = new android.content.Intent( GetPaypal.this, PaymentCart.class);
                startActivity(intent);
                //android.content.Intent intent = new android.content.Intent(LogoActivity.this, LoginActivity.class);
                //startActivity(intent);
                
            }
        });
    }
}