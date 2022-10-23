package com.example.squrriels;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "miledb";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME_MILE = "miles";
    public static final String TABLE_NAME_USER = "user";

    public static class MileEntry implements BaseColumns {

        public static final String DATE_COL = "date";
        public static final String GAS_COL = "gas";
    }

    public static class UserEntry implements BaseColumns {
        public static final String USERNAME_COL = "username";
        public static final String PASSWORD_COL = "password";
    }

    private static final String SQL_CREATE_MILES_ENTRIES =
            "CREATE TABLE " + TABLE_NAME_MILE + " (" + MileEntry._ID + "INTEGER PRIMARY KEY," +
                MileEntry.DATE_COL + " INTEGER," +
                MileEntry.GAS_COL + " INTEGER)";

    private static final String SQL_CREATE_USER_ENTRIES =
            "CREATE TABLE " + TABLE_NAME_USER + " (" + UserEntry._ID + "INTEGER PRIMARY KEY," +
                    UserEntry.USERNAME_COL + " TEXT," +
                    UserEntry.PASSWORD_COL + " TEXT)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ";

    public DBHelper(Context context){
        super(context, DB_Name, null, DB_VERSION);
    }

    public void deleteTable(String tableName){
        String deleteTableName = SQL_DELETE_ENTRIES + tableName;
        getWritableDatabase().execSQL(deleteTableName);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_MILES_ENTRIES);
        db.execSQL(SQL_CREATE_USER_ENTRIES);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        deleteTable(SQL_CREATE_MILES_ENTRIES);
        deleteTable(SQL_CREATE_USER_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }


}
