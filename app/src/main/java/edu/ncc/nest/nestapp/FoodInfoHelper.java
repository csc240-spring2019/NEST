package edu.ncc.nest.nestapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodInfoHelper extends SQLiteOpenHelper {

    // table name
    public static final String TABLE_NAME = "foodpantry";

    // columns in the table
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String METRIC = "metric";

    // database version and name
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "foodInformation.db";

    public FoodInfoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " +
                MIN + " TEXT, " + MAX + " TEXT, " + METRIC + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
