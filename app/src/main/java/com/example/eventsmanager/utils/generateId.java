package com.example.eventsmanager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class generateId {
    public static String generateEventId(String userId) {
        // Current date and time as yyyyMMddHHmmss
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
                .format(new Date());

        // Combine userId and timestamp
        return userId + "_" + timestamp;
    }
}
