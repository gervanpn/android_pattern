package com.androidpattern.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SqLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shopping.db";
    private static final String TABLE_USER = "UserInfo";
    private static final String TABLE_CART = "CartData";
    private static final String TABLE_ITEM = "ItemData";
    private static final String UserInfoId = "user_id";
    private static final String UserName = "user_name";
    private static final String CartInfoId = "cart_id";
    private static final String CartName = "cart_name";
    private static final String ItemInfoId = "item_id";
    private static final String ItemId = "Id";
    private static final String ItemName = "Name";
    private static final String ItemPrice = "Price";
    private static final String ItemQnty = "Qnty";

    private static final int DATABASE_VERSION = 1;
    private static Context context;
    
    static SqLiteHelper sqLiteHelper;// = new SqLiteHelper( context );
    
    public SqLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
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
                        UserInfoId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        UserName + " TEXT NOT NULL );";
        final String SQL_CREATE_CART_TABLE =
                "CREATE TABLE " + TABLE_CART + " (" +
                        CartInfoId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        CartName + " TEXT NOT NULL );";
        final String SQL_CREATE_ITEM_TABLE =
                "CREATE TABLE " + TABLE_ITEM + " (" +
                        ItemInfoId + " INTEGER, " +
                        ItemId + " INTEGER, " +
                        ItemName + " TEXT, " +
                        ItemPrice + " INTEGER, " +
                        ItemQnty + " INTEGER, PRIMARY KEY (ItemInfoId, ItemId) );";
        try {
            db.execSQL(SQL_CREATE_USER_TABLE);
            db.execSQL(SQL_CREATE_CART_TABLE);
            db.execSQL(SQL_CREATE_ITEM_TABLE);
            Message.message(context, "Tables Created");
        } catch(Exception e) {
            Message.message(context, e.getMessage());
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
