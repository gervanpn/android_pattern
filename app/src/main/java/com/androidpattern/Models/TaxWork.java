package com.androidpattern.Models;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class TaxWork {
private double _taxRate = 0.0;
private boolean _isChecked = false;

	public static final String SHARED_PREFS = "sharedPrefs";
	public static final String TAXES = "set_taxes";
	public static final String SWITCH1 = "settings_used";
	public static final String RATE = "taxRate";

	Context context;

	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;

public TaxWork(Context _context){
	this.context = _context;
}

public void setTaxRate(double _rate){
	this._taxRate = _rate;
}

public double getTaxRate(){
	return this._taxRate;
}

public void setChecked(boolean _checked){
	this._isChecked = _checked;
}

public boolean getChecked(){
	return this._isChecked;
}

    public void saveData() {
        sharedPreferences = this.context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        editor = sharedPreferences.edit();
//
        //editor.putString(TAXES, String.format("%.2f", this._taxRate));
        editor.putBoolean(SWITCH1, this._isChecked);
		editor.putFloat(RATE, (float)_taxRate);
        System.out.println(this._isChecked);
        System.out.println(this._taxRate);
//
        editor.apply();
        Toast.makeText(context, "Settings Saved", Toast.LENGTH_SHORT).show();
    }
//
    public void loadData() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        //_taxRate = tryParseDouble(sharedPreferences.getString(TAXES, ""));
        _isChecked = sharedPreferences.getBoolean(String.valueOf(SWITCH1), false);
		_taxRate = sharedPreferences.getFloat(RATE, 0);
    }
//
public static double tryParseDouble(final String number){

	double result;
	try {
		result = Double.parseDouble(number);
	}
	catch (NumberFormatException e) {
		result = 0.0;
	}
	return result;
}
//    public void updateViews() {
//        set_taxes.setText(text);
//        settings_used.setChecked(switchOnOff);
//    }
}
