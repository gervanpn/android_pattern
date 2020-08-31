package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import com.androidpattern.Models.Cart;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.androidpattern.Models.Cart;

public class Settings extends AppCompatActivity {

    Button settings_save;
    EditText set_taxes;
    SwitchCompat settings_used;
    boolean switchState = Cart.getTaxSetting();
    double taxRate = Cart.getTaxRate();

    public static boolean setTaxes() {
        boolean switchState = Cart.getTaxSetting();
        return switchState;
    }

    public static double taxAmount() {
        double taxRate = Cart.getTaxRate();
        return taxRate;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings_save = findViewById(R.id.settings_save);
        set_taxes = findViewById(R.id.set_taxes);
        settings_used = findViewById(R.id.settings_used);

        settings_used.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    switchState = true;
                    settings_used.setText("Taxes are On");
                } else {
                    switchState = false;
                    settings_used.setText("Taxes are Off");
                }
            }
        });

        settings_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (set_taxes.getText() == null) { // check if tax amount set; if not it returns;
                    Toast.makeText(getApplicationContext(), "no tax set", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveSettings();
            }
        });
    }

    private void saveSettings() {
        //sending the user back to the main screen
        Intent intent = new Intent(Settings.this, MainActivity.class);
        setTaxes();
        taxAmount();
        startActivity(intent);
    }

}