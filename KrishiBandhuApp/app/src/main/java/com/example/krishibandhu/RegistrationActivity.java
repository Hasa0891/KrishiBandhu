package com.example.krishibandhu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText usernameField, emailField, passwordField;
    private Button registerButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize fields
        usernameField = findViewById(R.id.usernameField);
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        registerButton = findViewById(R.id.registerButton);

        // Initialize Database Helper
        databaseHelper = new DatabaseHelper(this);

        // Set click listener for the Register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString().trim();
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                // Validation checks
                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if the email already exists
                if (databaseHelper.isEmailExists(email)) {
                    Toast.makeText(RegistrationActivity.this, "Email already registered!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Register user
                boolean isInserted = databaseHelper.insertUser(username, email, password);

                if (isInserted) {
                    Toast.makeText(RegistrationActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                    // Redirect to LoginActivity
                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // Close the RegistrationActivity
                } else {
                    Toast.makeText(RegistrationActivity.this, "Registration failed. Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
