package com.example.krishibandhu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackSupportActivity extends AppCompatActivity {

    private TextView emailTextView;
    private TextView phoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_support);

        // Initialize the TextViews for email and phone
        emailTextView = findViewById(R.id.emailInfo);
        phoneTextView = findViewById(R.id.phoneInfo);

        // Set click listener for email to open the default email app
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        // Set click listener for phone number to dial the support number
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
    }

    // Method to open the default email app with the support email address
    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "support@krishibandhu.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback or Support Request");
        startActivity(Intent.createChooser(emailIntent, "Send email"));
    }

    // Method to initiate a phone call to the support number
    private void makeCall() {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:+8801234567890"));  // Example number
        startActivity(callIntent);
    }
}
