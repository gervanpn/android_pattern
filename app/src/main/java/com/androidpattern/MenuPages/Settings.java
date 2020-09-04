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

    private Button _btnSaveSettings;
    private ImageButton _imgBtnHomeSettings, _imgBtnBasketSettings;
    private EditText _setTaxes;
    private SwitchCompat _settingsUsed;

    float taxRate;
    boolean taxState;

    TaxWork taxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        taxes = new TaxWork(getApplicationContext());

        _btnSaveSettings = findViewById(R.id.settings_save);
        _setTaxes = findViewById(R.id.set_taxes);
        _settingsUsed = findViewById(R.id.settings_used);
        _imgBtnBasketSettings = findViewById(R.id.ib_basket);
        _imgBtnHomeSettings = findViewById(R.id.ib_home);
        taxes.loadData();
        updateViews();

        _settingsUsed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    taxState = true;
                    _settingsUsed.setText("Taxes are On");
                } else {
                    taxState = false;
                    _settingsUsed.setText("Taxes are Off");
                }
            }
        });

        _btnSaveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_setTaxes.getText().toString().equals("")) { // check if tax amount set; if not it returns;
                    Toast.makeText(getApplicationContext(), "NO Tax Value Set", Toast.LENGTH_SHORT).show();
                    return;
                }
                convertTax();
                taxes.setTaxRate( taxRate );
                taxes.setChecked( _settingsUsed.isChecked() );
                taxes.saveData();
                saveSettings();
            }
        });

        _imgBtnHomeSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            //sending the user back to the main screen
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });

        _imgBtnBasketSettings.setOnClickListener(new View.OnClickListener() {
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
        taxRate = (float) Double.parseDouble(_setTaxes.getText().toString());
    }

    public void updateViews() {
        _setTaxes.setText(String.format("%.2f", taxes.getTaxRate()));
        _settingsUsed.setChecked(taxes.getChecked());
    }

    private void saveSettings() {
        //saveData();
        taxes.saveData();
    }
}
