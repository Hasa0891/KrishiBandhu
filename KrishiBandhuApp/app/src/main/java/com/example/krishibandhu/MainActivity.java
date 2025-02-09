package com.example.krishibandhu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registerButton = findViewById(R.id.registerButton);
        Button loginButton = findViewById(R.id.loginButton);
        Button priceButton = findViewById(R.id.marketPriceButton);

        registerButton.setOnClickListener( v -> {
            Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });

        loginButton.setOnClickListener( v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        priceButton.setOnClickListener( v -> {
            Intent intent = new Intent(MainActivity.this, MarketInformationActivity.class);
            startActivity(intent);
        });

    }
}
