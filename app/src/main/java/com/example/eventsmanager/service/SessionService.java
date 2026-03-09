package com.example.eventsmanager.service;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionService {
    private static SessionService instance;
    SharedPreferences prefs;
    private static final String PREF_NAME = "user_session";
    private static final String KEY_USER_ID = "user_id";

    private SessionService(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SessionService getInstance(Context context) {
        if(instance == null) {
            instance = new SessionService(context);
        }
        return instance;
    }

    public void saveUser(String userId) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_USER_ID, userId);
        editor.apply();
    }

    public String getUserId() {
        return prefs.getString(KEY_USER_ID, null);
    }

}
