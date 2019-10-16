package com.example.knowyourlimit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "KYL.db";
    private static final String USERS_TABLE = "users";

    private static final String USERS_COLUMN_ID = "user_id";
    private static final String USERS_COLUMN_USERNAME = "user_username";
    private static final String USERS_COLUMN_EMAIL = "user_email";
    private static final String USERS_COLUMN_PASSWORD = "user_password";

    private static final String USER_LOGS_TABLE = "user_log";
    private static final String USER_LOGS_COLUMN_ID = "user_log_id";
    private static final String USER_LOGS_COLUMN_MESSAGE = "user_log_message";
    private static final String USER_LOGS_COLUMN_TIMESTAMP = "user_log_timestamp";
    private static final String USER_LOGS_COLUMN_MONEY_AMOUNT = "user_log_money_amount";
    private static final String USER_LOGS_COLUMN_CATEGORY = "user_log_money_category";

//    private static final String USER_LOGS_COLUMN_
    private final static String CREATE_USERS_TABLE =
            "CREATE TABLE IF NOT EXISTS " + USERS_TABLE + " (" +
                    USERS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    USERS_COLUMN_USERNAME + " VARCHAR(255) UNIQUE," +
                    USERS_COLUMN_EMAIL + " VARCHAR(255) UNIQUE," +
                    USERS_COLUMN_PASSWORD + " VARCHAR(255)" +
                    ");";

    private final static String CREATE_USER_LOGS_TABLE =
            "CREATE TABLE IF NOT EXISTS " + USER_LOGS_TABLE + "(" +
                    USER_LOGS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    USER_LOGS_COLUMN_MESSAGE +" VARCHAR(255)," +
                    USER_LOGS_COLUMN_TIMESTAMP +" DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    USER_LOGS_COLUMN_MONEY_AMOUNT + " INTEGER(255)," +
                    "user_id INTEGER," +
                    "category varchar(255)," +
                    USER_LOGS_COLUMN_CATEGORY + " VARCHAR(255)," +
                    "FOREIGN KEY (user_id) REFERENCES users(id)" +
                    ");";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//
//        SQLiteDatabase db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);
        sqLiteDatabase.execSQL(CREATE_USER_LOGS_TABLE);
        this.db = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropQuery = "DROP TABLE IF EXISTS " + USERS_TABLE;
        sqLiteDatabase.execSQL(dropQuery);
        onCreate(sqLiteDatabase);
    }


    public boolean insertUser(String username, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_COLUMN_USERNAME, username);
        contentValues.put(USERS_COLUMN_EMAIL, email);
        contentValues.put(USERS_COLUMN_PASSWORD, password);
        long results = db.insert(USERS_TABLE, null, contentValues);

        if (results == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean userIsInDatabase(String username, String password) {
        SQLiteDatabase db  = this.getWritableDatabase();
        String selectUser = "SELECT * FROM" + USERS_TABLE + "WHERE username IS" + username + "AND password IS" + password;
        Cursor res = db.rawQuery(selectUser, null);
        return true;
    }

    public Cursor getPassword(String username) {
        SQLiteDatabase db  = this.getWritableDatabase();
        String selectUser = "SELECT password FROM" + USERS_TABLE + "WHERE username IS" + username;
        return db.rawQuery(selectUser, null);
    }


    public void insertLog(String username, String message, int amount, String category) {

    }

    public void retrieveLogs(String username) {

    }

    public void makeBackup(String username) {

    }

}
