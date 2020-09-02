package com.androidpattern;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.androidpattern.Settings;
import com.androidpattern.Models.Cart;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentCart extends AppCompatActivity {
    Button creditCard, paypal, home, goShopping;
    TextView paymentsucess,  total_cost, total_quantity, tax, total_with_tax;
    String st, st2;
    Double taxCost, TR, TT;
    double cost = Cart.getTotalCost();
    int quantity = Cart.getQuantity();

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TAXES = "set_taxes";
    public static final String SWITCH1 = "settings_used";
    private String text;
    private boolean switchOnOff;
    float taxRate;
    public static final String RATE = "taxRate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_cart);

        creditCard = (Button) findViewById(R.id.credit_card);
        paypal = (Button) findViewById(R.id.paypal);
        home = (Button) findViewById(R.id.gotostart);
        goShopping=(Button) findViewById(R.id.gotoshopping);
        paymentsucess = findViewById(R.id.paymentSuccess);
        tax= findViewById(R.id.tax);
        total_with_tax= findViewById(R.id.total_with_tax);
        total_cost = findViewById(R.id.total_cost);
        total_cost.setText( String.format("%.2f", cost));
        total_quantity = findViewById(R.id.total_items);
        total_quantity.setText(quantity+"");


        creditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentCart.this, GetCreditCard.class);
                startActivity(intent);
            }
        });

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentCart.this, GetPaypal.class);
                startActivity(intent);
            }
        });

        goShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentCart.this, ShoppingList.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart.clearCart();
                Intent intent = new Intent(PaymentCart.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loadData();
        calculateTax();
        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");
        if(checkFlag.equals("A")){
            android.widget.Toast.makeText( com.androidpattern.PaymentCart.this , "Got the items" , android.widget.Toast.LENGTH_LONG ).show();
           }
        if(checkFlag.equals("CC")) {
            creditText();
        }if(checkFlag.equals("PP")){
            paypalText();
        }

        
    }


    private void paypalText() {
        if(getIntent().getExtras().getString("value") != null) {
            st = getIntent().getExtras().getString("value");
            paymentsucess.setText(st + " paid bill with Paypal");
        } else {
            Toast.makeText( com.androidpattern.PaymentCart.this , "No Data Entered" , Toast.LENGTH_LONG ).show();
        }
    }

    private void creditText() {
        if(getIntent().getExtras().getString("value") != null) {
            st = getIntent().getExtras().getString("value");
            st2 = getIntent().getExtras().getString("value2");
            paymentsucess.setText(st + new Enceypt().encrypt(st2) + " paid bill with Credit Card");

        } else {
           Toast.makeText( PaymentCart.this , "No Data Entered" , Toast.LENGTH_LONG ).show();
        }
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TAXES, "");
        switchOnOff = sharedPreferences.getBoolean(String.valueOf(SWITCH1), false);
        taxRate = sharedPreferences.getFloat(RATE, 0);
    }

    public void calculateTax(){
       TR = (double) taxRate;
        if(switchOnOff){
            taxCost = TR *cost;
            tax.setText(String.format("%.2f", taxCost));
            TT = taxCost+cost;
            total_with_tax.setText( String.format("%.2f", TT));
        }else{
            tax.setText( "0.00" );
            total_with_tax.setText( String.format("%.2f", cost));
        }
    }
}
