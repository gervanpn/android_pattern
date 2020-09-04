package com.androidpattern.PaymentFactory;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.androidpattern.Interfaces.IPaymentFactory;
import com.androidpattern.R;

public class PaymentOptions extends AppCompatActivity implements IPaymentFactory {
    Debit debit;
    MasterCard masterCard;
    Button btnDebit , btnMasterCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pament_options);
        btnDebit = findViewById(R.id.debit_btn);
        btnMasterCard = findViewById(R.id.masterCard_btn);
        btnDebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreatePayment(PaymentType.Debit);
            }
        });

        btnMasterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            CreatePayment(PaymentType.MasterCard);
            }
        });
    }

    @Override
    public void CreatePayment(PaymentType type) {
        switch (type){
            case Debit:
                new  Debit().pay();
                break;
            case MasterCard:
                new MasterCard().pay();
                break;
            default:
        }
    }
}
