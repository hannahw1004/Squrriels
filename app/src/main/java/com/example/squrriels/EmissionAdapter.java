package com.example.squrriels;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class EmissionAdapter {
    private final DBHelper mDbHelper;
    private final SQLiteDatabase mDb;
    private final String LOG_CLASS_NAME = "CarAdapter";

    public EmissionAdapter(DBHelper dbHelper){
        mDbHelper = dbHelper;
        mDb = dbHelper.getWritableDatabase();
    }

    public void addEmission(Emission emission){
        ContentValues values = new ContentValues();

        values.put(DBHelper.MileEntry.GAS_COL, emission.greenHouseGas);
        values.put(DBHelper.MileEntry.DATE_COL, emission.date);

        long newRowId = mDb.insert(mDbHelper.TABLE_NAME_MILE, null, values);
        mDb.close();
    }


}
