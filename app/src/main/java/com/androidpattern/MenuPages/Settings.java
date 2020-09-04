package com.androidpattern.MenuPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androidpattern.ActivityPages.MainActivity;
import com.androidpattern.Models.TaxWork;
import com.androidpattern.R;
import com.androidpattern.ActivityPages.ShoppingList;

public class Settings extends AppCompatActivity {

    private Button settings_save;
    private ImageButton ib_home, ib_basket;
    private EditText set_taxes;
    private SwitchCompat settings_used;

    float taxRate;
    boolean taxState;

    TaxWork taxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        taxes = new TaxWork(getApplicationContext());

        settings_save = findViewById(R.id.settings_save);
        set_taxes = findViewById(R.id.set_taxes);
        settings_used = findViewById(R.id.settings_used);
        ib_basket = findViewById(R.id.ib_basket);
        ib_home = findViewById(R.id.ib_home);
        taxes.loadData();
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
                taxes.setTaxRate( taxRate );
                taxes.setChecked( settings_used.isChecked() );
                taxes.saveData();
                saveSettings();
            }
        });

        ib_home.setOnClickListener(new View.OnClickListener() {
            @Override
            //sending the user back to the main screen
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ib_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            //sending the user back to the main screen
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, ShoppingList.class);
                startActivity(intent);
            }
        });

        taxes.loadData();
        updateViews();
    }

    private void convertTax() {
        taxRate = (float) Double.parseDouble(set_taxes.getText().toString());
    }

    public void updateViews() {

        set_taxes.setText(String.format("%.2f", taxes.getTaxRate()));
        settings_used.setChecked(taxes.getChecked());

    }

    private void saveSettings() {
        //saveData();
        taxes.saveData();
    }

}
