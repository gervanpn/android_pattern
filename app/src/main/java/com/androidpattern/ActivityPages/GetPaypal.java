package com.androidpattern.ActivityPages;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.androidpattern.R;

public class GetPaypal extends AppCompatActivity {
    Button checkoutButton;
    String strEmail;
    TextView emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_paypal);

        checkoutButton = ( Button ) findViewById( R.id.checkOutButton );
        emailAddress = findViewById( R.id.editTextEmailAddress );

        checkoutButton.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                Toast.makeText( GetPaypal.this , "PayPal payment successful" , Toast.LENGTH_LONG ).show();
                Intent intent = new Intent( GetPaypal.this, PaymentCart.class);
                strEmail = emailAddress.getText().toString();
                intent.putExtra("flag", "payPal");
                intent.putExtra("value", strEmail);
                startActivity(intent);
                finish();
            }
        });
    }
}
