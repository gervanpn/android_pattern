package com.androidpattern.MenuPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androidpattern.ActivityPages.MainActivity;
import com.androidpattern.R;
import com.androidpattern.ActivityPages.ShoppingList;

public class Profile extends AppCompatActivity {

    private Button settings_save2;
    private ImageButton ib_home2, ib_basket2;
    private EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        settings_save2 = findViewById(R.id.settings_save2);
        userName = findViewById(R.id.userName);
        ib_basket2 = findViewById(R.id.ib_basket2);
        ib_home2 = findViewById(R.id.ib_home2);

        ib_home2.setOnClickListener(new View.OnClickListener() {
        @Override
        //sending the user back to the main screen
        public void onClick(View view) {
            Intent intent = new Intent(Profile.this, MainActivity.class);
            startActivity(intent);
        }
        });

        ib_basket2.setOnClickListener(new View.OnClickListener() {
        @Override
        //sending the user back to the main screen
        public void onClick(View view) {
            Intent intent = new Intent(Profile.this, ShoppingList.class);
            startActivity(intent);
        }
        });

        settings_save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName.getText().toString().equals("")) { // check if tax amount set; if not it returns;
                    Toast.makeText(getApplicationContext(), "NO Name Set", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveProfile();
            }
        });
    }

    private void saveProfile() {
        //saveData();
    }
}