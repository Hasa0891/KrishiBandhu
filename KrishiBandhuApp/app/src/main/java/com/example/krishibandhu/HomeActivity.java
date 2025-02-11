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
        setContentView(R.layout.activity_home);

        marketInfoButton = findViewById(R.id.marketInfoButton);
        techAdviceButton = findViewById(R.id.techAdviceButton);
        communityButton = findViewById(R.id.communityButton);
        financialSupportButton = findViewById(R.id.financialSupportButton);
        feedbackSupportButton = findViewById(R.id.feedbackSupportButton);

        marketInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MarketInformationActivity.class);
                startActivity(intent);
            }
        });

        techAdviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, TechnicalAdviceActivity.class);
                startActivity(intent);
            }
        });

        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CommunityContactActivity.class);
                startActivity(intent);
            }
        });

        financialSupportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FinancialSupportActivity.class);
                startActivity(intent);
            }
        });

        feedbackSupportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FeedbackSupportActivity.class);
                startActivity(intent);
            }
        });
    }
}
