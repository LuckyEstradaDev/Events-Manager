package com.example.eventsmanager.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.eventsmanager.activities.CreateEventActivity;
import com.example.eventsmanager.models.EventModel;

public class EventsService {
    Context context;
    SQLiteDatabaseHelper sqLiteDatabaseHelper;
    SQLiteDatabase db;
    public EventsService(Context context) {
        this.context = context;
        sqLiteDatabaseHelper = new SQLiteDatabaseHelper(context);
        db = sqLiteDatabaseHelper.getWritableDatabase();
    }

    public void createEvent(EventModel eventModel) {
        ContentValues cv = new ContentValues();
        cv.put("id", eventModel.getId());
        cv.put("event_handler_id", eventModel.getEventHandlerId());
        cv.put("event_name", eventModel.getEventName());
        cv.put("description", eventModel.getDescription());
        cv.put("location", eventModel.getLocation());
        cv.put("start_date", eventModel.getStartDate());
        cv.put("end_date", eventModel.getEndDate());
        cv.put("category", eventModel.getCategory());
        cv.put("capacity", eventModel.getCapacity());
        cv.put("created_at", eventModel.getCreatedAt());
        long result = db.insert("events", null, cv);

        if (result == -1) {
            Toast.makeText(context, "Failed to create event", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Event created successfully", Toast.LENGTH_SHORT).show();
        }
    }

}
