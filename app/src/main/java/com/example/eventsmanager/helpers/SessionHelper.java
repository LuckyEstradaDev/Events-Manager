package com.example.eventsmanager.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.eventsmanager.models.UserModel;

import org.json.JSONException;
import org.json.JSONObject;

public class SessionHelper {
    public static final String USER_FOLDER = "user_folder";
    public static final String KEY_USER = "KEY_USER";

    // there are two things, the set user and the get user

    public void setUser(Context context, UserModel user){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", user.getId());
            jsonObject.put("first_name", user.getFirstName());

            SharedPreferences sharedPreferences = context.getSharedPreferences(USER_FOLDER, Context.MODE_PRIVATE);
            sharedPreferences.edit().putString(KEY_USER, jsonObject.toString()).apply();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void getUser(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_FOLDER, Context.MODE_PRIVATE);
String jsonString = sharedPreferences.getString(KEY_USER, null);
        try {
JSONObject jsonObject = new JSONObject(jsonString);
            return new UserModel(
                jsonObject.getString("id"),
                jsonObject.getString("first_name")
            );

            //finish the constructor
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
