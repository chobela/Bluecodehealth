package com.bluecodesystems.health.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bluecodesystems.health.models.Children;
import com.bluecodesystems.health.models.Mothers;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "bluecode";
    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create guests table
        db.execSQL(Mothers.CREATE_TABLE);
        // create guests table
        db.execSQL(Children.CREATE_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Mothers.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Children.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


    public void saveMother(String uid, String name, String age, String nrc, String weight, String pressure) {

        ContentValues values = new ContentValues();

        values.put(Mothers.UID, uid);
        values.put(Mothers.NAME, name);
        values.put(Mothers.AGE, age);
        values.put(Mothers.NRC, nrc);
        values.put(Mothers.WEIGHT, weight);
        values.put(Mothers.PRESSURE, pressure);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Mothers.TABLE_NAME, null, values);

        db.close();
    }

    public void saveChild(String mother, String childname) {


        ContentValues values = new ContentValues();

        values.put(Children.MOTHER, mother);
        values.put(Children.CHILDNAME, childname);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Children.TABLE_NAME, null, values);

        db.close();
    }

    //get all Mmothers from db
    public List<Mothers> getAllMothers() {
        List<Mothers> mothers = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + Mothers.TABLE_NAME + " ORDER BY " +
                Mothers.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                Mothers mother = new Mothers();
                mother.setId(cursor.getInt(cursor.getColumnIndex(Mothers.COLUMN_ID)));
                mother.setUid(cursor.getString(cursor.getColumnIndex(Mothers.UID)));
                mother.setName(cursor.getString(cursor.getColumnIndex(Mothers.NAME)));
                mother.setAge(cursor.getString(cursor.getColumnIndex(Mothers.AGE)));
                mother.setNrc(cursor.getString(cursor.getColumnIndex(Mothers.NRC)));
                mother.setWeight(cursor.getString(cursor.getColumnIndex(Mothers.WEIGHT)));
                mother.setPressure(cursor.getString(cursor.getColumnIndex(Mothers.PRESSURE)));

                mothers.add(mother);

            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return mothers;
    }

    //get all Mmothers from db
    public List<Children> getAllChildren(String mother) {
        List<Children> children = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + Children.TABLE_NAME + " WHERE " + Children.MOTHER + " = " + mother + " ORDER BY " +
                Children.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Children child = new Children();
                child.setId(cursor.getInt(cursor.getColumnIndex(Children.COLUMN_ID)));
                child.setMother(cursor.getString(cursor.getColumnIndex(Children.MOTHER)));
                child.getChildname(cursor.getString(cursor.getColumnIndex(Children.CHILDNAME)));

                children.add(child);

            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return children;
    }

}
