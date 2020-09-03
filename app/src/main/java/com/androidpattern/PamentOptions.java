package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidpattern.PaymentOptions.Debit;
import com.androidpattern.PaymentOptions.MasterCard;
import com.androidpattern.PaymentOptions.PaymentFactory;
import com.androidpattern.PaymentOptions.PaymentOP;
import com.androidpattern.PaymentOptions.PaymentType;

public class PamentOptions extends AppCompatActivity implements PaymentFactory {
Debit debit;
MasterCard masterCard;
Button debit_btn , mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pament_options);
      debit_btn = findViewById(R.id.debit_btn);
      mc = findViewById(R.id.masterCard_btn);
      debit_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
                CreatePayment(PaymentType.Debit);
          }
      });


      mc.setOnClickListener(new View.OnClickListener() {
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
                    //
            }


    }
}