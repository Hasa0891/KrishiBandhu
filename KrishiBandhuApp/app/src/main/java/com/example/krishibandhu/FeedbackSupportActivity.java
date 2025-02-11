package com.example.krishibandhu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackSupportActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_support);

        TextView emailTextView = findViewById(R.id.emailInfo);
        TextView phoneTextView = findViewById(R.id.phoneInfo);

        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
    }

    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "support@krishibandhu.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback or Support Request");
        startActivity(Intent.createChooser(emailIntent, "Send email"));
    }

    private void makeCall() {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:+8801234567890"));  // Example number
        startActivity(callIntent);
    }
}
