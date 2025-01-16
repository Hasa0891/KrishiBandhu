package com.example.krishibandhu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database and Table Information
    private static final String DATABASE_NAME = "krishibandhu.db";
    private static final int DATABASE_VERSION = 2; // Incremented version for schema changes
    private static final String USERS_TABLE_NAME = "users";
    private static final String SPECIES_TABLE_NAME = "species";

    // Users Table Columns
    public static final String COL_ID = "ID"; // Changed to public
    public static final String COL_USERNAME = "username"; // Changed to public
    public static final String COL_EMAIL = "email"; // Changed to public
    public static final String COL_PASSWORD = "password"; // Changed to public

    // Species Table Columns
    public static final String COL_SPECIES_ID = "species_id";
    public static final String COL_SPECIES_NAME = "species_name";
    public static final String COL_SPECIES_DESCRIPTION = "species_description";
    public static final String COL_SPECIES_IMAGE = "species_image";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create users table
        String createUsersTable = "CREATE TABLE " + USERS_TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT, " +
                COL_EMAIL + " TEXT, " +
                COL_PASSWORD + " TEXT)";
        db.execSQL(createUsersTable);
        Log.d("DatabaseHelper", "Users table created");

        // Create species table
        String createSpeciesTable = "CREATE TABLE " + SPECIES_TABLE_NAME + " (" +
                COL_SPECIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_SPECIES_NAME + " TEXT, " +
                COL_SPECIES_DESCRIPTION + " TEXT, " +
                COL_SPECIES_IMAGE + " TEXT)";
        db.execSQL(createSpeciesTable);
        Log.d("DatabaseHelper", "Species table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if exist
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SPECIES_TABLE_NAME);
        onCreate(db);
    }

    // Method to insert user data
    public boolean insertUser(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);

        long result = db.insert(USERS_TABLE_NAME, null, contentValues);
        db.close();
        return result != -1; // Return true if insertion is successful
    }

    // Method to check if email already exists
    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(USERS_TABLE_NAME, null, COL_EMAIL + " = ?", new String[]{email}, null, null, null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return exists;
    }

    // Method to get user by email
    public Cursor getUserByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(USERS_TABLE_NAME, null, COL_EMAIL + " = ?", new String[]{email}, null, null, null);
    }

    // Method to insert species data
    public boolean insertSpecies(String name, String description, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_SPECIES_NAME, name);
        contentValues.put(COL_SPECIES_DESCRIPTION, description);
        contentValues.put(COL_SPECIES_IMAGE, image);

        long result = db.insert(SPECIES_TABLE_NAME, null, contentValues);
        db.close();
        return result != -1; // Return true if insertion is successful
    }

    // Method to get all species
    public Cursor getAllSpecies() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + SPECIES_TABLE_NAME, null);
        return cursor; // Caller should close this cursor
    }

    // Check for table existence (optional)
    private boolean doesTableExist(SQLiteDatabase db, String tableName) {
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{tableName});
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }
}
