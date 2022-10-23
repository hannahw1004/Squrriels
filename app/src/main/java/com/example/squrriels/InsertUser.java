package com.example.squrriels;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class InsertUser {
    private final DBHelper mDbHelper;
    private final SQLiteDatabase mDb;
    private final String LOG_CLASS_NAME = "InsertUser";

    public InsertUser(DBHelper dbHelper){
        mDbHelper = dbHelper;
        mDb = dbHelper.getWritableDatabase();
    }

    public void addUser(User user){
        ContentValues values = new ContentValues();

        values.put(DBHelper.UserEntry.USERNAME_COL, user.username);
        values.put(DBHelper.UserEntry.PASSWORD_COL, user.password);

       long newRowId = mDb.insert(mDbHelper.TABLE_NAME_USER, null, values);
       mDb.close();
    }


}
