package com.androidpattern.ActivityPages;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.androidpattern.MenuPages.Profile;
import com.androidpattern.MenuPages.Settings;
import com.androidpattern.Models.Cart;
import com.androidpattern.Models.Encrypt;
import com.androidpattern.Models.TaxWork;
import com.androidpattern.PaymentFactory.PaymentOptions;
import com.androidpattern.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

public class PaymentCart extends AppCompatActivity {
    Button creditCard, paypal, home, goShopping ;
    ImageButton paymentSample;
    TextView paymentSuccess,  totalCost, totalQuantity, tax, totalWithTax;
    String strName, strCard, strEmail;
    Double taxCost, totalTaxRate, totalTaxTotal;
    double cost = Cart.getTotalCost();
    int quantity = Cart.getQuantity();

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TAXES = "set_taxes";
    public static final String SWITCH1 = "settings_used";
    private boolean _switchOnOff;
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
        paymentSuccess = findViewById(R.id.paymentSuccess);
        tax= findViewById(R.id.tax);
        totalWithTax= findViewById(R.id.total_with_tax);
        totalCost = findViewById(R.id.total_cost);
        totalCost.setText( String.format("%.2f", cost));
        totalQuantity = findViewById(R.id.total_items);
        totalQuantity.setText(quantity+"");
        paymentSample  = findViewById(R.id.paymentOption_btn);

        paymentSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentCart.this, PaymentOptions.class);
                startActivity(intent);
            }
        });
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
        if(checkFlag.equals("shoppingList")){
            android.widget.Toast.makeText( PaymentCart.this , "Got the items" , android.widget.Toast.LENGTH_LONG ).show();
           }
        if(checkFlag.equals("creditCard")) {
            creditText();
        }if(checkFlag.equals("payPal")){
            paypalText();
        }
    }

    private void paypalText() {
        if(getIntent().getExtras().getString("value") != null) {
            strEmail = getIntent().getExtras().getString("value");
            paymentSuccess.setText(String.format("%s paid bill with Paypal", strEmail));
        } else {
            Toast.makeText( PaymentCart.this , "No Data Entered" , Toast.LENGTH_LONG ).show();
        }
    }

    private void creditText() {
        if(getIntent().getExtras().getString("value") != null) {
            strName = getIntent().getExtras().getString("value");
            strCard = getIntent().getExtras().getString("value2");
            paymentSuccess.setText(String.format("%s paid bill with Credit Card",
                    (strName + " Card# " + new Encrypt().encrypt(strCard)) ));

        } else {
           Toast.makeText( PaymentCart.this , "No Data Entered" , Toast.LENGTH_LONG ).show();
        }
    }

    public void setData() {
        _switchOnOff = taxes.getChecked();
        taxRate = (float)taxes.getTaxRate();
    }

    public void calculateTax(){
       totalTaxRate = (double) taxRate;
        if(_switchOnOff){
            taxCost = totalTaxRate *cost;
            tax.setText(String.format("%.2f", taxCost));
            totalTaxTotal = taxCost + cost;
            totalWithTax.setText( String.format("%.2f", totalTaxTotal));
        }else{
            tax.setText( "0.00" );
            totalWithTax.setText( String.format("%.2f", cost));
        }
    }

    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, Settings.class));
                return true;
            case R.id.userInfo:
                startActivity(new Intent(this, Profile.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
