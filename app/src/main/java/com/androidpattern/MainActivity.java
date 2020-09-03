package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.androidpattern.Helpers.SingletonClass;
import com.androidpattern.Helpers.SqLiteHelper;

public class MainActivity<intent> extends AppCompatActivity {
    Button loginBtn;
    ImageButton settings_shop;
    
    SqLiteHelper helper;
    SQLiteDatabase db;
    
    //SingletonClass singleton = SingletonClass.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.loginBtn);
        settings_shop = findViewById(R.id.settings_shop);
    
        helper = new SqLiteHelper(getApplicationContext());
        db = SQLiteDatabase.openOrCreateDatabase(getDatabasePath( helper.DATABASE_NAME ),null);
        db.close();
        db = helper.getWritableDatabase();
        
//        singleton.setText("@string/app_name");
//        String test = singleton.getText();
        
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShoppingList.class);
                startActivity(intent);}
        });

        settings_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //db = SQLiteDatabase.openOrCreateDatabase(getDatabasePath( helper.DATABASE_NAME ),null);

                }
        });
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