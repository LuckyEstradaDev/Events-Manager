package com.example.eventsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eventsmanager.activities.CreateEventActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    FloatingActionButton action_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        initViews();
    }

    void initViews() {
        toolbar = findViewById(R.id.topAppBar);
        action_btn = findViewById(R.id.floatingActionButton);
        initListeners();
    }

    void initListeners() {
        action_btn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, CreateEventActivity.class);
            startActivity(intent);
        });
    }
}