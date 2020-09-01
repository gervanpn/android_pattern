package com.androidpattern.Models;

import android.content.SharedPreferences;
import android.widget.Toast;

//public class TaxWork {
//
//    public static final String SHARED_PREFS = "sharedPrefs";
//    public static final String TAXES = "set_taxes";
//    public static final String SWITCH1 = "settings_used";
//    private String text;
//    private boolean switchOnOff;
//
//    public void saveData() {
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putString(TAXES, set_taxes.getText().toString());
//        editor.putBoolean(SWITCH1, settings_used.isChecked());
//
//        editor.apply();
//        Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show();
//    }
//
//    public void loadData() {
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        text = sharedPreferences.getString(TAXES, "");
//        switchOnOff = sharedPreferences.getBoolean(String.valueOf(SWITCH1), false);
//    }
//
//    public void updateViews() {
//        set_taxes.setText(text);
//        settings_used.setChecked(switchOnOff);
//    }
//}
