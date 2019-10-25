package com.example.knowyourlimit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

/* all SQL is written in CAPITALIZED LETTERING
 variables are written in camelCase for java readability
 if it becomes hard to read then _ is user
 everything in user log table has user_log_ in front of the variable and everything in user table has user_ in front of it
 variables used in from java to put into sql are written in snake_case
 */

/*these are documentation comments*/

//    these are code comments



public class DatabaseHelper extends SQLiteOpenHelper {
    /*whole database*/
    private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "KYL.db";

    /*everything in USER_TABLE is here*/
    private static final String USERS_TABLE = "users";
    private static final String USERS_COLUMN_ID = "user_id";
    private static final String USERS_COLUMN_USERNAME = "user_username";
    private static final String USERS_COLUMN_EMAIL = "user_email";
    private static final String USERS_COLUMN_PASSWORD = "user_password";

    /*everything in user_logs table is here*/
    private static final String USER_LOGS_TABLE = "user_log";
    private static final String USER_LOGS_COLUMN_ID = "user_log_id";
    private static final String USER_LOGS_COLUMN_MESSAGE = "user_log_message";
    private static final String USER_LOGS_COLUMN_TIMESTAMP = "user_log_timestamp";
    private static final String USER_LOGS_COLUMN_MONEY_AMOUNT = "user_log_money_amount";
    private static final String USER_LOGS_COLUMN_CATEGORY = "user_log_money_category";
    //    private static final String USER_LOGS_FOREIGN_KEY = "user_log_user_id";
    private static final String USER_LOGS_FOREIGN_KEY = "user_log_user_username";

    /*    //    private static final String USER_LOGS_COLUMN_*/
    /*sql query to create the user_table*/
    private final static String CREATE_USERS_TABLE =
            "CREATE TABLE IF NOT EXISTS " + USERS_TABLE + " (" +
                    USERS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    USERS_COLUMN_USERNAME + " VARCHAR(255) UNIQUE," +
                    USERS_COLUMN_EMAIL + " VARCHAR(255) UNIQUE," +
                    USERS_COLUMN_PASSWORD + " VARCHAR(255)," +
                    "PRIMARY KEY( " + USERS_COLUMN_ID + " ) " +
                    ");";

    /*sql query to create user_logs table*/
    private final static String CREATE_USER_LOGS_TABLE =
            "CREATE TABLE IF NOT EXISTS " + USER_LOGS_TABLE + "(" +
                    USER_LOGS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    USER_LOGS_COLUMN_MESSAGE + " TEXT," +
                    USER_LOGS_COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    USER_LOGS_COLUMN_MONEY_AMOUNT + " INTEGER," +
                    USER_LOGS_COLUMN_CATEGORY + " varchar(255)," +
                    USER_LOGS_FOREIGN_KEY + " INTEGER NOT NULL," +
                    "PRIMARY KEY( " + USER_LOGS_COLUMN_ID + " ), " +
                    "FOREIGN KEY (" + USER_LOGS_FOREIGN_KEY + " ) REFERENCES " + USERS_TABLE + "(" + USERS_COLUMN_ID + ")" +
                    ");";


    /*constructor and things that it needed
    for context i believe we pass in "this" from the main activity */

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db = getWritableDatabase();
    }

//    had to be overridden
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);
        sqLiteDatabase.execSQL(CREATE_USER_LOGS_TABLE);
        this.db = sqLiteDatabase;
    }

    // had to be overridden
/*    i believe on upgrade that table is deleted and a new table made
    because SQLITE cannot alter the table it removes and creates it again
        so everything in that table is lost
    should be called rarely*/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropQuery = "DROP TABLE IF EXISTS " + USERS_TABLE;
        sqLiteDatabase.execSQL(dropQuery);
        onCreate(sqLiteDatabase);
    }


/*
    acts as a registration
    it inserts the user into the database and checks that the username and email is unique
    if the username or email already exist in database for any other user then or at all then it will throw error
    if it returns true then it was successful in putting the user into the database
        if false then it was not successful in inserting the user into the database
*/
    public boolean insertTheUser(String user_username, String user_email, String user_password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_COLUMN_USERNAME, user_username);
        contentValues.put(USERS_COLUMN_EMAIL, user_email);
        contentValues.put(USERS_COLUMN_PASSWORD, user_password);
        long results = db.insert(USERS_TABLE, null, contentValues);

        if (results == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*acts as login feature*/
/*    checks if the user with that username or email and password is in the database or not
    currently can login with either username or email and password
        might simplify later to just username
    if you want to login with username you can do userIsInDatabase("username", null, "Pa55WorD"
        that will let me know to use the username and not the email
    if you want to login with email then you can do userIsInDatabase(null, "email@AOL.com", ""PA33w00RD"
        that will let me know to user the email instead and of the username*/
    public boolean userIsInDatabase(String user_username, String user_email, String user_password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectUser;
        if (user_username.isEmpty() && user_username == null) {
            selectUser = "SELECT * FROM " + USERS_TABLE + " WHERE " + USERS_COLUMN_USERNAME + " IS " + user_username + " AND password IS " + user_password;
        } else {
            selectUser = "SELECT * FROM " + USERS_TABLE + " WHERE " + USERS_COLUMN_EMAIL + " IS " + user_email + " AND password IS " + user_password;
        }

        Cursor result = db.rawQuery(selectUser, null);
        /*todo fix this when you know*/
        if (result != null) {
            return true;
        } else {
            return false;
        }
    }

    /*can give you the whole user by username
    * useful for cases when you need the user and only have the username*/
    public Cursor getUserObject_ByUsername(String user_username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectUser_ByUsername = "SELECT * FROM " + USERS_TABLE + " WHERE " + USERS_COLUMN_USERNAME + " IS " + user_username;
        return db.rawQuery(selectUser_ByUsername, null);
    }

    /*getUserID_ByUsername gets the alone by username
    * useful for when you only want the userId and have user_username*/
    public Cursor getUserID_ByUsername(String user_username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectUserID_ByUsername = "SELECT " + USERS_COLUMN_ID + " FROM " + USERS_TABLE + " WHERE " + USERS_COLUMN_USERNAME + " IS " + user_username;
        return db.rawQuery(selectUserID_ByUsername, null);
    }

    /*getUserPasswordByUsername can get the users password by username
    * useful for when making a backup of the users logs and need the users password to put on the zip file*/
    public Cursor getUserPasswordByUsername(String user_username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectUser_ByPassword = "SELECT password FROM " + USERS_TABLE + " WHERE username IS " + user_username;
        return db.rawQuery(selectUser_ByPassword, null);
    }


    /*insertLog takes the users username, the message they want to put, the amount of money spent, and category that they spent it on
    * it simply takes everything and inserts it into the database
    * it does not check for the categories so they must be passed in as Strings & get stored in same way
    * if it was successful in inserting you get true otherwise, false
    * Time Stamp automatic*/
    public boolean insertLog(String user_log_username, String user_log_message, int user_log_money, String user_log_category) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_LOGS_COLUMN_MESSAGE, user_log_message);
        contentValues.put(USER_LOGS_COLUMN_MONEY_AMOUNT, user_log_money);
        contentValues.put(USER_LOGS_COLUMN_CATEGORY, user_log_category);
//        contentValues.put(USER_LOGS_FOREIGN_KEY, id);
        contentValues.put(USER_LOGS_FOREIGN_KEY, user_log_username);
        long results = db.insert(USER_LOGS_TABLE, null, contentValues);

        if (results == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*retrieveLogs gives you back all the logs, that the user made
    * give username and get all the logs*/
    public Cursor retrieveLogs(String user_username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectLogs = "SELECT * FROM " + USER_LOGS_TABLE + " WHERE " + USER_LOGS_FOREIGN_KEY + " IS " + user_username;
        return db.rawQuery(selectLogs, null);
    }


    /*gives you back all the logs that the user made but not the whole log, just the message, money, category, timestamp
    * give username and get back the log with message, money, categoryyy, and timestamp*/
    public Cursor makeBackup(String user_username) {
        SQLiteDatabase db = this.getWritableDatabase();
        /*returns the user logs message, logs money cost, logs category, logs timestamp*/
        String selectLogs = "SELECT " +
                USER_LOGS_COLUMN_MESSAGE + ", " +
                USER_LOGS_COLUMN_MONEY_AMOUNT + ", " +
                USER_LOGS_COLUMN_CATEGORY + ", " +
                USER_LOGS_COLUMN_TIMESTAMP +
                " FROM " + USER_LOGS_TABLE + " WHERE " + USER_LOGS_FOREIGN_KEY + " IS " + user_username;

//        make this later into a dump csv of all the things and give back a file instead of a object
//        sqlite3 testDB.db .dump > testDB.sql



        return db.rawQuery(selectLogs, null);
    }

    /*gets you back the log with that category from that user
    * give me the username and which category and i can give you every log where that user spent money on that category
     */
    public Cursor getLogsByCategory(String user_log_category, String user_username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + USER_LOGS_TABLE + " WHERE " + USER_LOGS_FOREIGN_KEY + " IS " + user_username + " AND " + USER_LOGS_COLUMN_CATEGORY + " IS " + user_log_category;
        return db.rawQuery(selectQuery, null);
    }
}
