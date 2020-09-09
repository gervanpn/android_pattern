package com.androidpattern.ActivityPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.os.Handler;
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

import com.androidpattern.Models.City;
import com.androidpattern.Helpers.FirebaseDBHelper;
import com.androidpattern.Helpers.SqLiteHelper;
import com.androidpattern.MenuPages.Profile;
import com.androidpattern.MenuPages.Settings;
import com.androidpattern.R;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import com.androidpattern.Helpers.SingletonClass;
import com.androidpattern.Helpers.FirebaseDBHelper;
//import java.io.UnsupportedEncodingException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.KeyGenerator;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;

public class MainActivity<intent> extends AppCompatActivity {
    Button loginBtn;
    ImageButton settingsShop;
    SqLiteHelper helper;
    SQLiteDatabase db;
    FirebaseDBHelper fbhelper = FirebaseDBHelper.getInstance();
    final Handler delayHandler = new Handler();
    
    City city2;
    
    //Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    //SingletonClass singleton = SingletonClass.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.loginBtn);
        settingsShop = findViewById(R.id.settings_shop);
    
        helper = new SqLiteHelper(getApplicationContext());
        //fbhelper = FirebaseDBHelper();
    
        fbhelper.createAccount(this, "some_email@email.com","password" );
        fbhelper.setCollection( "test" );
        fbhelper.setDocument( "testdoc1" );
        
        fbhelper.signIn(this, "ignite01@hotmail.com","password" );
        
        
        City city = new City("2","1","1",true,200000, Arrays.asList("west_coast", "norcal"));
        fbhelper.createDocument( fbhelper.getCollection(),fbhelper.getDocument(), city );
        //fbhelper.addDocument( "test","testdoc1" );
//        FirebaseDBHelper.Update update = new FirebaseDBHelper.Update() {
//            @Override
//            public void updateUI () {
                city2  = fbhelper.returnDocument(fbhelper.getCollection(),fbhelper.getDocument()  );
                if (city2 == null || fbhelper.returnValue == null)
                {

                } else {
                    System.out.println("line 83 MainActivity - " + city2.getName() );
                }
//            }
//        };
       // City city2 = null;// = new City();
        
        //DocumentReference doc = fbhelper.getDocument( "test" ,"testdoc1");
        //System.out.println("2 - " +  city2.getName());
//        delayHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {

//            }
//        }, 10000);
        
//        delayHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // Do something after 5s = 5000ms
//                //buttons[inew][jnew].setBackgroundColor(Color.BLACK);
//
//

    
//            }
//        }, 10000);
//
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

        settingsShop.setOnClickListener(new View.OnClickListener() {
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