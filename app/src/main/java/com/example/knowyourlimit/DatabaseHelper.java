package com.example.knowyourlimit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "KYL.db";
    private static final String TABLE_NAME = "users";

    private static final String COLUMN_ID = "user_id";
    private static final String COLUMN_USERNAME = "user_username";
    private static final String COLUMN_EMAIL = "user_email";
    private static final String COLUMN_PASSWORD = "user_password";


    private final static String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    "user_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "user_username VARCHAR(255) UNIQUE," +
                    "user_email VARCHAR(255) UNIQUE," +
                    "user_password VARCHAR(255)" +
                    ");";


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropQuery);
        onCreate(db);
    }


    public void register(String username, String email, String password) {

    }


    public boolean login(String username, String password) {

        return true;
    }

    public String getPassword(String username) {
        return "a";
    }


    public void insertLog(String username, String message, int amount, String category) {

    }

    public void retrieveLogs(String username) {

    }

    public void makeBackup(String username) {

    }


}
