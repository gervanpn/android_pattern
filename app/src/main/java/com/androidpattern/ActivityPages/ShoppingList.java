package com.androidpattern.ActivityPages;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.androidpattern.Models.Cart;
import com.androidpattern.Models.Item;
import com.androidpattern.R;

public class ShoppingList extends AppCompatActivity {

    ImageButton addBtn, checkoutBtn;
    TextView txtEmptyCart;
    EditText editName, editPrice, editQuantity;
    LinearLayout layoutCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        //initializing Buttons
        addBtn = findViewById(R.id.btn_add);
        checkoutBtn = findViewById(R.id.btn_checkout);
        //initializing EditView
        editName = findViewById(R.id.et_name);
        editPrice = findViewById(R.id.et_price);
        editQuantity = findViewById(R.id.et_qnty);
        //initializing TextViews
        txtEmptyCart = findViewById(R.id.tv_empty_cart);
        //initializing cart list linear layout
        layoutCartList = findViewById(R.id.ll_cart_list);

        // update empty cart message
        emptyCartMsg();

        //update cart list
        for (int i = 0; i < Cart.getQuantity(); i++) {
            updateCartView(Cart.getItemName(i), Cart.getItems().get(i).getCost(), Cart.getItemId(i));
        }

        //programing add button
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, price, qnty; //declaring variables to store name, price and quantity fields values
                //getting name, price and quantity values of the item to be added
                name = editName.getText().toString();
                price = editPrice.getText().toString();
                qnty = editQuantity.getText().toString();

                if (name.trim().length() == 0 || price.length() == 0 || qnty.length() == 0) { //validating the add item form(all fields should be filled out)
                    Toast.makeText(getApplicationContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                    return;
                } else if (Integer.parseInt(qnty) == 0) { //check if the quantity is not 0
                    Toast.makeText(getApplicationContext(), "Please enter a valid number of items", Toast.LENGTH_SHORT).show();
                    return;
                }

                //creating an item based  the fields values
                Item item = new Item(name, price, qnty);
                Cart.addItem(item); //adding new item to cart list
                Toast.makeText(getApplicationContext(), "Item added: " + item.getName(), Toast.LENGTH_SHORT).show();

                updateCartView(item.getName(), item.getCost(),  item.getId());
                resetForm();  //clearing the form after adding the item successfully
            }

        });

        //programing checkout button
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cart.getQuantity() == 0) { // check if cart has any item to checkout; if not it returns;
                    Toast.makeText(getApplicationContext(), "Your shopping cart is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                checkout();
            }
        });
    }

    private void checkout() {
        //sending the user to the payment page with the total cost
        Intent intent = new Intent(getApplicationContext(), PaymentCart.class);
        intent.putExtra("flag", "shoppingList");
        startActivity(intent);
    }

    private void updateCartView(final String name, double cost, final int id) {
        // update empty cart message
        emptyCartMsg();

        //creating a relative layout to to add show the newly-added item and a button to remove it in case
        LinearLayout cartListLLCh = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 20);
        cartListLLCh.setLayoutParams(params);
        cartListLLCh.setOrientation(LinearLayout.HORIZONTAL);
        layoutCartList.addView(cartListLLCh);

        //adding a new button to the cart list layout to enable user remove an item from the list
        ImageButton removeBtn = new ImageButton(this);
        cartListLLCh.addView(removeBtn);
        LinearLayout.LayoutParams paramsBtn = new LinearLayout.LayoutParams(48, 48);
        paramsBtn.setMarginEnd(20);
        removeBtn.setLayoutParams(paramsBtn);
        removeBtn.setImageResource(R.drawable.ic_baseline_remove);
        removeBtn.setBackgroundColor(getColor(R.color.colorTransparent));

        //adding a new textview to the cart list layout to show the name of the newly-added item
        TextView newItemTV = new TextView(this);
        cartListLLCh.addView(newItemTV);
        newItemTV.setId(id);
        newItemTV.setText(String.format("%s    -   $%.2f", name, cost));

        final TextView finalNewItemTV = newItemTV;
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("remove", "Removed");
                layoutCartList.removeView((View) view.getParent());
                //udpate items in Cart
                Cart.removeItem(id);
                // update empty cart message
                emptyCartMsg();
            }
        });
    }

    private void resetForm() {
        editName.setText(null);
        editPrice.setText(null);
        editQuantity.setText(null);
    }

    private void emptyCartMsg() {
        //check if cart is empty, show empty cart message
        if (Cart.getQuantity() == 0) {
            txtEmptyCart.setVisibility(View.VISIBLE);
        } else {
            txtEmptyCart.setVisibility(View.GONE);
        }
    }
}