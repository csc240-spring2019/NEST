package edu.ncc.nest.nestapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FoodInfoSource {

    private SQLiteDatabase database;
    private FoodInfoHelper foodHelper;

    private String[] allColumns = {FoodInfoHelper._ID, FoodInfoHelper.NAME, FoodInfoHelper.MIN,
            FoodInfoHelper.MAX, FoodInfoHelper.METRIC};

    public FoodInfoSource(Context context) {
        foodHelper = new FoodInfoHelper(context);
    }

    public void open() throws SQLException {
        database = foodHelper.getWritableDatabase();
    }

    public void close() { foodHelper.close(); }

    public void addFood(String name, int min, int max, String metric){
        ContentValues values = new ContentValues();

        values.put(FoodInfoHelper.NAME,name);
        values.put(FoodInfoHelper.MIN,min);
        values.put(FoodInfoHelper.MAX,max);
        values.put(FoodInfoHelper.METRIC,metric);

        long insertId = database.insert(FoodInfoHelper.TABLE_NAME,null, values);
    }

    public List<FoodEntry> getAllFoods() {
        List<FoodEntry> foods = new ArrayList<>();
        FoodEntry entry;
        Cursor cursor = database.query(FoodInfoHelper.TABLE_NAME, allColumns,
                null, null, null, null,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            entry = cursorToEntry(cursor);
            foods.add(entry);
            cursor.moveToNext();
        }
        cursor.close();

        return foods;
    }

    public List<FoodEntry> findFoods() {
        List<FoodEntry> foods = new ArrayList<>();
        FoodEntry entry;
        Cursor cursor = database.query(FoodInfoHelper.TABLE_NAME, allColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            entry = cursorToEntry(cursor);
            foods.add(entry);
            cursor.moveToNext();
        }
        cursor.close();

        return foods;
    }

    private FoodEntry cursorToEntry(Cursor cursor) {
        FoodEntry entry = new FoodEntry();
        entry.setId(cursor.getLong(0));
        entry.setName(cursor.getString(1));
        entry.setMin(cursor.getInt(2));
        entry.setMax(cursor.getInt(3));
        entry.setMetric(cursor.getString(4));
        return entry;
    }
}
