package com.example.eventsmanager.helpers;

import android.content.Context;
import android.content.Intent;

public class NavHelper {
    public static void navigate(Context context, Class<?> destination) {
        context.startActivity(new Intent(context, destination));
    }
}
