package com.deben.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user_db";
    public static final String TABLE_NAME = "user_tb";

    public static final String COLUMN_ID = "user_id";
    public static final String COLUMN_NAME = "user_name";
    public static final String COLUMN_EMAIL = "user_email";


    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_EMAIL + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public long insertIntoTable(UserData data) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, data.name);
        values.put(COLUMN_EMAIL, data.email);
        return database.insert(TABLE_NAME, null, values);
    }

    public long deleteFromTable(int userId) {
        SQLiteDatabase database = this.getWritableDatabase();
        String whereClause = COLUMN_ID + " = ?";
        String[] whereArgs = {String.valueOf(userId)};
        return database.delete(TABLE_NAME, whereClause, whereArgs);
    }

    public void updateDataInTable(UserData data) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, data.name);
        values.put(COLUMN_EMAIL, data.email);

        String whereClause = COLUMN_ID + " = ?";
        String[] whereArgs = {String.valueOf(data.id)};
        database.update(TABLE_NAME, values, whereClause, whereArgs);
    }

    public ArrayList<UserData> retrieveFromTable() {
        SQLiteDatabase database = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_NAME, COLUMN_EMAIL};
        Cursor cursor = database.query(TABLE_NAME, columns, null, null, null, null, null);
        ArrayList<UserData> userDataList = new ArrayList<>();
        while (cursor.moveToNext()) {
            long userId = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID));
            String userName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL));
            userDataList.add(new UserData((int) userId, userName, userEmail));
        }
        cursor.close();
        return userDataList;
    }
}
