package com.example.squrriels;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "miledb";
    public static final int DB_VERSION = 1;

    public static class MileEntry implements BaseColumns {
        public static final String TABLE_NAME = "miles";
        public static final String DATE_COL = "date";
        public static final String MILES_COL = "miles";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MileEntry.TABLE_NAME + " (" + MileEntry._ID + "INTEGER PRIMARY KEY," +
                MileEntry.DATE_COL + " INTEGER," +
                MileEntry.MILES_COL + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MileEntry.TABLE_NAME;

    public DBHelper(Context context){
        super(context, DB_Name, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }


}
