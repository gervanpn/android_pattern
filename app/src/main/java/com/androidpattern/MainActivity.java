package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//import com.androidpattern.Helpers.SingletonClass;
import com.androidpattern.Helpers.SqLiteHelper;

//import java.io.UnsupportedEncodingException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;

public class MainActivity<intent> extends AppCompatActivity {
    Button loginBtn;
    ImageButton settings_shop;
    
    SqLiteHelper helper;
    SQLiteDatabase db;
    
    //Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    
   
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
        // testing of cipher encrypting
//        try {
//            SecretKey key = KeyGenerator.getInstance( "AES" ).generateKey();
//            System.out.println(key);
//            cipher.init( Cipher.ENCRYPT_MODE, key);
//            byte[] plainText  = "abcdefghijklmnopqrstuvwxyz".getBytes("UTF-8");
//            byte[] cipherText = cipher.doFinal(plainText);
//            System.out.println(plainText);
//            System.out.println(cipherText);
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            plainText = cipher.doFinal(cipherText);
//            System.out.println(plainText);
//        } catch ( NoSuchAlgorithmException | InvalidKeyException e ) {
//            e.printStackTrace();
//        } catch ( BadPaddingException e ) {
//            e.printStackTrace();
//        } catch ( UnsupportedEncodingException e ) {
//            e.printStackTrace();
//        } catch ( IllegalBlockSizeException e ) {
//            e.printStackTrace();
//        }

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

    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.options_menu, menu);
            if(menu instanceof MenuBuilder) {
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