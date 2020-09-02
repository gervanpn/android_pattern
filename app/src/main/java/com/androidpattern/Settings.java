package com.androidpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    private Button settings_save;
    private EditText set_taxes;
    private SwitchCompat settings_used;

    float taxRate;
    boolean taxState;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TAXES = "set_taxes";
    public static final String SWITCH1 = "settings_used";
    public static final String RATE = "taxRate";
    private String text;
    private boolean switchOnOff;
    private float rate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings_save = findViewById(R.id.settings_save);
        set_taxes = findViewById(R.id.set_taxes);
        settings_used = findViewById(R.id.settings_used);
        loadData();
        updateViews();
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
                if (set_taxes.getText().toString().equals("")) { // check if tax amount set; if not it returns;
                    Toast.makeText(getApplicationContext(), "NO Tax Value Set", Toast.LENGTH_SHORT).show();
                    return;
                }
                convertTax();
                saveData();
                saveSettings();
            }
        });

        loadData();
        updateViews();
    }

    private void convertTax() {
        taxRate = (float) Double.parseDouble(set_taxes.getText().toString());
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TAXES, set_taxes.getText().toString());
        editor.putBoolean(SWITCH1, settings_used.isChecked());
        editor.putFloat(RATE, taxRate);

        editor.apply();
        Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TAXES, "");
        switchOnOff = sharedPreferences.getBoolean(String.valueOf(SWITCH1), false);
        taxRate = sharedPreferences.getFloat(RATE, 0);
    }

    public void updateViews() {
        set_taxes.setText(text);
        settings_used.setChecked(switchOnOff);
    }

    private void saveSettings() {
        //sending the user back to the main screen
        saveData();
        Intent intent = new Intent(Settings.this, MainActivity.class);
        startActivity(intent);
    }

}