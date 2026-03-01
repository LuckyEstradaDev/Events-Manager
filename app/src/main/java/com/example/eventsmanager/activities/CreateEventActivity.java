package com.example.eventsmanager.activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eventsmanager.R;
import com.example.eventsmanager.db.EventsService;
import com.example.eventsmanager.db.SQLiteDatabaseHelper;
import com.example.eventsmanager.models.EventModel;
import com.example.eventsmanager.utils.generateId;

import java.util.Arrays;
import java.util.List;

public class CreateEventActivity extends AppCompatActivity {
    Toolbar toolbar;
    SQLiteDatabaseHelper sqLiteDatabaseHelper;
    EditText et_event_name;
    EditText et_location;
    EditText et_description;
    EditText et_start_date;
    EditText et_end_date;
    Spinner spinnerCategory;
    EditText et_capacity;

    Button btn_create_event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_event);
        initViews();

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void initViews() {
        // Toolbar
        toolbar = findViewById(R.id.topAppBar);

        // EditTexts
        et_event_name = findViewById(R.id.et_event_name);
        et_location = findViewById(R.id.et_location);
        et_description = findViewById(R.id.et_description);
        et_start_date = findViewById(R.id.et_start_date);
        et_end_date = findViewById(R.id.et_end_date);
        et_capacity = findViewById(R.id.et_capacity);

        // Spinner for category (replace et_category)
        spinnerCategory = findViewById(R.id.spinner_category);
        List<String> categories = Arrays.asList("Conference", "Workshop", "Meetup", "Webinar");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                categories
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        // Buttons
        btn_create_event = findViewById(R.id.btn_create_event);

        // Optional: init listeners here
        initListeners();
    }

    void initListeners() {
        btn_create_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventModel model = new EventModel();
                model.setId(generateId.generateEventId("1"));
                model.setEventName(et_event_name.getText().toString());
                model.setLocation(et_location.getText().toString());
                model.setDescription(et_description.getText().toString());
                String capacityStr = et_capacity.getText().toString();
                if (capacityStr.isEmpty()) {
                    et_capacity.setError("Capacity is required");
                    return;
                }
                model.setCapacity(Integer.parseInt(capacityStr));
                model.setCategory(spinnerCategory.getSelectedItem().toString());
                model.setStartDate(et_start_date.getText().toString());
                model.setEndDate(et_end_date.getText().toString());

                EventsService eventsService = new EventsService(CreateEventActivity.this);
                eventsService.createEvent(model);

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}