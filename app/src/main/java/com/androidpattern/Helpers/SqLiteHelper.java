package com.androidpattern.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SqLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shopping.db";
    private static final String TABLE_USER = "user_info";
    private static final String TABLE_CART = "cart_data";
    private static final String TABLE_ITEM = "item_data";
    private static final String USERKEY = "user_id";
    private static final String USERNAME = "user_name";
    private static final String CARTKEY = "cart_id";
    private static final String CARTNAME = "cart_name";
    private static final String ITEMKEY = "item_db_id";
    private static final String ITEMCART = "item_cart";
    private static final String ITEMID = "item_id";
    private static final String ITEMNAME = "item_name";
    private static final String ITEMPRICE = "item_price";
    private static final String ITEMQUANTITY = "item_quantity";

    private static final int DATABASE_VERSION = 1;
    private static Context _context;
    
    static SqLiteHelper sqLiteHelper;// = new SqLiteHelper( context );
    
    public SqLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this._context = context;
        Message.message(context, "Started....");
    }
    public static SqLiteHelper getInstance(Context _context){
        if (sqLiteHelper == null ){
            //sqLiteHelper = new SqLiteHelper( _context );
            
        }
        return sqLiteHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_USER_TABLE =
                "CREATE TABLE " + TABLE_USER + " (" +
                        USERKEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        USERNAME + " TEXT NOT NULL );";
        final String SQL_CREATE_CART_TABLE =
                "CREATE TABLE " + TABLE_CART + " (" +
                        CARTKEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        CARTNAME + " TEXT NOT NULL );";
        final String SQL_CREATE_ITEM_TABLE =
                "CREATE TABLE " + TABLE_ITEM + " (" +
                        ITEMKEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ITEMCART + " INTEGER, " +
                        ITEMID + " INTEGER, " +
                        ITEMNAME + " TEXT, " +
                        ITEMPRICE + " INTEGER, " +
                        ITEMQUANTITY + " INTEGER );";
        try {
            db.execSQL(SQL_CREATE_USER_TABLE);
            db.execSQL(SQL_CREATE_CART_TABLE);
            db.execSQL(SQL_CREATE_ITEM_TABLE);
            Message.message(_context, "Tables Created");
        } catch(Exception e) {
            Message.message(_context, e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
