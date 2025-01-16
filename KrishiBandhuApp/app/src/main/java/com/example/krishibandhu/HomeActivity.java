package com.example.krishibandhu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button marketInfoButton, techAdviceButton, communityButton, financialSupportButton, feedbackSupportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Ensure this matches your XML file name

        // Initialize the buttons
        marketInfoButton = findViewById(R.id.marketInfoButton);
        techAdviceButton = findViewById(R.id.techAdviceButton);
        communityButton = findViewById(R.id.communityButton);
        financialSupportButton = findViewById(R.id.financialSupportButton);
        feedbackSupportButton = findViewById(R.id.feedbackSupportButton);

        // Set button click listeners
        marketInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Market Information Activity
                Intent intent = new Intent(HomeActivity.this, MarketInformationActivity.class);
                startActivity(intent);
            }
        });

        techAdviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Technical Advice Activity
                Intent intent = new Intent(HomeActivity.this, TechnicalAdviceActivity.class);
                startActivity(intent);
            }
        });

        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Community Contact Activity
                Intent intent = new Intent(HomeActivity.this, CommunityContactActivity.class);
                startActivity(intent);
            }
        });

        financialSupportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Financial Support Activity
                Intent intent = new Intent(HomeActivity.this, FinancialSupportActivity.class);
                startActivity(intent);
            }
        });

        feedbackSupportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Feedback and Support Activity
                Intent intent = new Intent(HomeActivity.this, FeedbackSupportActivity.class);
                startActivity(intent);
            }
        });
    }
}
