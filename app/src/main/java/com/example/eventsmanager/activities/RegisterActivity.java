package com.example.eventsmanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eventsmanager.R;
import com.example.eventsmanager.db.UserService;
import com.example.eventsmanager.models.UserModel;
import com.example.eventsmanager.utils.generateId;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputEditText etFirstName, etLastName, etEmail, etPassword;
    private Button btnRegister;
    private TextView tvGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        initViews();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initViews() {
        toolbar = findViewById(R.id.topAppBar);
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnRegister = findViewById(R.id.btn_register);
        tvGoToLogin = findViewById(R.id.tv_go_to_login);

        initListeners();
    }

    private void initListeners() {
        btnRegister.setOnClickListener(v -> {
            String firstName = etFirstName.getText().toString().trim();
            String lastName = etLastName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (validateInput(firstName, lastName, email, password)) {
                UserService userService = new UserService(this);
                UserModel user = new UserModel();
                user.setId(generateId.generateEventId("U"));
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPassword(password);
                user.setCreatedAt(new Date().toString());

                userService.registerUser(user);
            }
        });

        tvGoToLogin.setOnClickListener(v -> {
            finish(); // Returns to previous activity (likely Login)
        });
    }

    private boolean validateInput(String fName, String lName, String email, String pass) {
        if (fName.isEmpty()) {
            etFirstName.setError("Required");
            return false;
        }
        if (lName.isEmpty()) {
            etLastName.setError("Required");
            return false;
        }
        if (email.isEmpty()) {
            etEmail.setError("Required");
            return false;
        }
        if (pass.isEmpty()) {
            etPassword.setError("Required");
            return false;
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}