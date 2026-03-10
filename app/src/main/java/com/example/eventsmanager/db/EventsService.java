package com.example.eventsmanager.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.eventsmanager.activities.CreateEventActivity;
import com.example.eventsmanager.models.EventModel;

import java.util.ArrayList;

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

    public ArrayList<EventModel> getAllEvents() {
        ArrayList<EventModel> events = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM events", null);
        while(cursor.moveToNext()) {
            events.add(new EventModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getInt(8),
                    cursor.getString(9)
            ));
        }

        return events;
    }

}
