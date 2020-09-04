package com.androidpattern.ActivityPages;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.androidpattern.R;

public class GetCreditCard extends AppCompatActivity {
    Button buttonSubmit;
    EditText name, cardNo;
    String strName, strCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_credit_card);

        buttonSubmit = (Button) findViewById( R.id.buttonSubmit );
        name = findViewById(R.id.editTextName);
        cardNo = findViewById(R.id.editTextCardNumber);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetCreditCard.this, PaymentCart.class);
                strName = name.getText().toString();
                strCard = cardNo.getText().toString();
                intent.putExtra("flag", "creditCard");
                intent.putExtra("value",strName);
                intent.putExtra("value2",strCard);
                startActivity(intent);
                finish();
            }
        });
    }
}