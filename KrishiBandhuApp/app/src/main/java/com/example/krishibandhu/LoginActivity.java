package com.example.krishibandhu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailField, passwordField;
    private Button loginButton;
    private TextView registerOption;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize fields
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);
        registerOption = findViewById(R.id.registerOption); // Initialize register option

        // Initialize Database Helper
        databaseHelper = new DatabaseHelper(this);

        // Set click listener for the Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                // Validation checks
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Both fields are required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Authenticate user
                if (authenticateUser(email, password)) {
                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    // Redirect to KnowledgeActivity
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Close the LoginActivity
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for the Register option
        registerOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to RegistrationActivity
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish(); // Close the LoginActivity
            }
        });
    }

    // Method to authenticate user
    private boolean authenticateUser(String email, String password) {
        Cursor cursor = databaseHelper.getUserByEmail(email);
        if (cursor != null && cursor.moveToFirst()) {
            int passwordIndex = cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD); // Use the constant here
            if (passwordIndex != -1) {
                String storedPassword = cursor.getString(passwordIndex);
                cursor.close();
                return password.equals(storedPassword); // Compare passwords
            } else {
                cursor.close();
                Toast.makeText(this, "Error retrieving password", Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }

}
