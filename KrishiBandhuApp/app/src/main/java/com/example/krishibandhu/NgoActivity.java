package com.example.krishibandhu;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class NgoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo); // Make sure the XML file name matches
    }

    // This method is called when the back button is pressed
    public void goBack(View view) {
        finish(); // Close the current activity and return to the previous one
    }
}
