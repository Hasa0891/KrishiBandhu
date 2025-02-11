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
        setContentView(R.layout.activity_advisory_services);

        btnSchemes = findViewById(R.id.btnSchemes);

        btnSchemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TechnicalAdviceActivity.this, NgoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onSchemesButtonClick(View view) {
    }
}
