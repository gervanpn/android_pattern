package com.androidpattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.androidpattern.Models.Cart;
import com.androidpattern.Models.TaxWork;
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
    private boolean switchOnOff;
    float taxRate;
    public static final String RATE = "taxRate";
    TaxWork taxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_cart);
        
        taxes = new TaxWork(getApplicationContext());
        
        creditCard = findViewById(R.id.credit_card);
        paypal = findViewById(R.id.paypal);
        home = findViewById(R.id.gotostart);
        goShopping = findViewById(R.id.gotoshopping);
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

        taxes.loadData();
        setData();
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
            paymentsucess.setText(String.format("%s paid bill with Paypal", st));
        } else {
            Toast.makeText( com.androidpattern.PaymentCart.this , "No Data Entered" , Toast.LENGTH_LONG ).show();
        }
    }

    private void creditText() {
        if(getIntent().getExtras().getString("value") != null) {
            st = getIntent().getExtras().getString("value");
            st2 = getIntent().getExtras().getString("value2");
            paymentsucess.setText(String.format("%s paid bill with Credit Card", (st + new Encrypt().encrypt(st2)) ));

        } else {
           Toast.makeText( PaymentCart.this , "No Data Entered" , Toast.LENGTH_LONG ).show();
        }
    }

    public void setData() {
        switchOnOff = taxes.getChecked();
        taxRate = (float)taxes.getTaxRate();
    }

    public void calculateTax(){
       TR = (double) taxRate;
        if(switchOnOff){
            taxCost = TR *cost;
            tax.setText(String.format("%.2f", taxCost));
            TT = taxCost + cost;
            total_with_tax.setText( String.format("%.2f", TT));
        }else{
            tax.setText( "0.00" );
            total_with_tax.setText( String.format("%.2f", cost));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, Settings.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
