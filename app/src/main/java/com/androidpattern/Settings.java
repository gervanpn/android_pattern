package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    Button settings_save;
    EditText set_taxes;
    SwitchCompat settings_used;

    String taxRate;
    boolean taxState;



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
                    taxState = true;
                    settings_used.setText("Taxes are On");
                } else {
                    taxState = false;
                    settings_used.setText("Taxes are Off");
                }
            }
        });

        settings_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTax();
                if (taxRate == null) { // check if tax amount set; if not it returns;
                    Toast.makeText(getApplicationContext(), "no tax set", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveSettings();
            }
        });
    }

    private void convertTax() {
        taxRate = set_taxes.getText().toString();
    }

    private void saveSettings() {
        //sending the user back to the main screen
        Intent intent = new Intent(Settings.this, MainActivity.class);

        startActivity(intent);
    }

}