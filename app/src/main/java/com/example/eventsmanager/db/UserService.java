package com.example.eventsmanager.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.eventsmanager.models.UserModel;

public class UserService {
    Context context;
    SQLiteDatabaseHelper sqLiteDatabaseHelper;
    SQLiteDatabase db;
    public UserService(Context context) {
        this.context = context;
        sqLiteDatabaseHelper = new SQLiteDatabaseHelper(context);
        db = sqLiteDatabaseHelper.getWritableDatabase();
    }

    public void registerUser(UserModel userModel) {
        ContentValues cv = new ContentValues();

        cv.put("id", userModel.getId());
        cv.put("first_name", userModel.getFirstName());
        cv.put("last_name", userModel.getLastName());
        cv.put("email", userModel.getEmail());
        cv.put("password", userModel.getPassword());
        cv.put("created_at", userModel.getCreatedAt());

        long result = db.insert("users", null, cv);

        if (result == -1) {
            Toast.makeText(context, "Failed to register user", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show();
        }
    }

    public void loginUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
    }
}
