package com.example.krishibandhu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TechnicalAdviceActivity extends AppCompatActivity {

    private Button btnSchemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisory_services); // Make sure the XML file name matches

        // Initialize the button
        btnSchemes = findViewById(R.id.btnSchemes);

        // Set button click listener
        btnSchemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Start NgoActivity when the button is clicked
                Intent intent = new Intent(TechnicalAdviceActivity.this, NgoActivity.class);
                startActivity(intent);
            }
        });
    }
}
