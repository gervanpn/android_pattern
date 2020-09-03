package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidpattern.PaymentOptions.Debit;
import com.androidpattern.PaymentOptions.MasterCard;
import com.androidpattern.Interfaces.IpaymentFactory;
import com.androidpattern.PaymentOptions.EpaymentType;

public class PamentOptions extends AppCompatActivity implements IpaymentFactory {
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
                CreatePayment(EpaymentType.Debit);
          }
      });


      mc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            CreatePayment(EpaymentType.MasterCard);
          }
      });
    }



    @Override
    public void CreatePayment(EpaymentType type) {
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