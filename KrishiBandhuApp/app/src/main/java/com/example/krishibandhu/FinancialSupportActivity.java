package com.example.krishibandhu;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinancialSupportActivity extends AppCompatActivity {

    private TextView titleText;
    private TextView introductionText;
    private TextView schemeOneTitle;
    private TextView schemeOneDescription;
    private TextView schemeTwoTitle;
    private TextView schemeTwoDescription;
    private TextView schemeThreeTitle;
    private TextView schemeThreeDescription;
    private TextView schemeFourTitle;
    private TextView schemeFourDescription;
    private TextView schemeFiveTitle;
    private TextView schemeFiveDescription;
    private TextView closingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_support);

        // Initialize UI elements
        titleText = findViewById(R.id.titleText);
        introductionText = findViewById(R.id.introductionText);
        schemeOneTitle = findViewById(R.id.schemeOneTitle);
        schemeOneDescription = findViewById(R.id.schemeOneDescription);
        schemeTwoTitle = findViewById(R.id.schemeTwoTitle);
        schemeTwoDescription = findViewById(R.id.schemeTwoDescription);
        schemeThreeTitle = findViewById(R.id.schemeThreeTitle);
        schemeThreeDescription = findViewById(R.id.schemeThreeDescription);
        schemeFourTitle = findViewById(R.id.schemeFourTitle);
        schemeFourDescription = findViewById(R.id.schemeFourDescription);
        schemeFiveTitle = findViewById(R.id.schemeFiveTitle);
        schemeFiveDescription = findViewById(R.id.schemeFiveDescription);
        closingText = findViewById(R.id.closingText);
    }
}
