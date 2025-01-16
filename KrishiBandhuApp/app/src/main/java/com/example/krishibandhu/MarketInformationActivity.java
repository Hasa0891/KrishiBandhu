package com.example.krishibandhu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MarketInformationActivity extends AppCompatActivity {

    private Button btnMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_information); // Ensure the XML file name matches

        // Initialize the button
        btnMoreInfo = findViewById(R.id.btnMoreInfo);

        // Set button click listener
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when the button is clicked
                Toast.makeText(MarketInformationActivity.this, "আরো তথ্য আসছে।", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
