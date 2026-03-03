package com.example.eventsmanager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "main_db";
    private static final int VERSION = 1;

    public SQLiteDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE events (" +
                "id TEXT PRIMARY KEY, " +
                "event_handler_id TEXT, " +
                "event_name TEXT, " +
                "description TEXT, " +
                "location TEXT, " +
                "start_date DATE, " +
                "end_date DATE, " +
                "category TEXT, " +
                "capacity INTEGER, " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

        db.execSQL("CREATE TABLE attendees (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id TEXT, " +
                "event_id TEXT)");

        db.execSQL("CREATE TABLE users (" +
                "id TEXT PRIMARY KEY, " +
                "first_name TEXT, " +
                "last_name TEXT, " +
                "email TEXT, " +
                "password TEXT, " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop existing tables
        db.execSQL("DROP TABLE IF EXISTS events");
        db.execSQL("DROP TABLE IF EXISTS attendees");
        db.execSQL("DROP TABLE IF EXISTS users");

        // Recreate tables
        onCreate(db);
    }
}
