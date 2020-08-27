package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidpattern.Models.Item;

public class ShoppingList extends AppCompatActivity {

    ImageButton addBtn, checkoutBtn;
    EditText nameET, priceET, qntyET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        addBtn = findViewById(R.id.btn_add);
        nameET = findViewById(R.id.et_name);
        priceET = findViewById(R.id.et_price);
        qntyET = findViewById(R.id.et_qnty);



        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declaring variables to store name, price and quantity fields values
                String name, price, qnty;
                //getting name, price and quantity values of the item to be added
                name = nameET.getText().toString();
                price = priceET.getText().toString();
                qnty = qntyET.getText().toString();
                //validating the add item form(all fields should be filled out)
                if(name.trim().length() == 0 || price.length()  == 0 || qnty.length() == 0 ) {
                    Toast.makeText(getApplicationContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    //creating an item based on the entry values
                    Item item = new Item(name, price, qnty);
                    Toast.makeText(getApplicationContext(), "Form Submitted", Toast.LENGTH_SHORT).show();
                    //clearing the form after adding the item successfully
                    resetForm();
                }
            }
        });

        checkoutBtn =  findViewById(R.id.btn_checkout);
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PaymentCart.class);
                startActivity(intent);
            }
        });

    }

    private void resetForm() {
        nameET.setText(null);
        priceET.setText(null);
        qntyET.setText(null);
    }
}