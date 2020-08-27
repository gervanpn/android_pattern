package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androidpattern.Models.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShoppingList extends AppCompatActivity {

    ImageButton addBtn, checkoutBtn;
    EditText nameET, priceET, qntyET;

    //declaring an array of items added to shopping cart
    final ArrayList<Item> cart = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        addBtn = findViewById(R.id.btn_add);
        checkoutBtn =  findViewById(R.id.btn_checkout);
        nameET = findViewById(R.id.et_name);
        priceET = findViewById(R.id.et_price);
        qntyET = findViewById(R.id.et_qnty);

        //programing add button
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name, price, qnty; //declaring variables to store name, price and quantity fields values
                //getting name, price and quantity values of the item to be added
                name = nameET.getText().toString();
                price = priceET.getText().toString();
                qnty = qntyET.getText().toString();

                if(name.trim().length() == 0 || price.length()  == 0 || qnty.length() == 0 ) { //validating the add item form(all fields should be filled out)
                    Toast.makeText(getApplicationContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                    return;
                } else if (Integer.valueOf(qnty) == 0) { //check if the quantity is not 0
                    Toast.makeText(getApplicationContext(), "Please enter a valid number of items", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    double cost = Integer.valueOf(price) * Integer.valueOf(qnty); //calculating the total cost of an item (price x qnty)
                    Item item = new Item(name, price, qnty, cost); //creating an item based  the fields values
                    cart.add(item); //adding new item to cart list
                    Toast.makeText(getApplicationContext(), "Item added: " + cart.get(cart.size()-1).getName(), Toast.LENGTH_SHORT).show();

                    updateCartView();

                    resetForm();  //clearing the form after adding the item successfully
                }
            }

        });



        //programing checkout button
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cart.size() == 0) { // check if cart has any item to checkout; if not it returns;
                    Toast.makeText(getApplicationContext(), "Your shopping cart is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), PaymentCart.class);
                startActivity(intent);
            }
        });

    }
    private void updateCartView() {



    }

    private void resetForm() {
        nameET.setText(null);
        priceET.setText(null);
        qntyET.setText(null);
    }
}