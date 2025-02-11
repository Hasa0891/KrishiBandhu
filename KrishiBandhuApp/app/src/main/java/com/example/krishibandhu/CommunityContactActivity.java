package com.example.krishibandhu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CommunityContactActivity extends AppCompatActivity {

    Button chatBtnFarmer1, chatBtnFarmer2, chatBtnFarmer3, chatBtnFarmer4, chatBtnFarmer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_contact);

        chatBtnFarmer1 = findViewById(R.id.chatBtnFarmer1);
        chatBtnFarmer2 = findViewById(R.id.chatBtnFarmer2);
        chatBtnFarmer3 = findViewById(R.id.chatBtnFarmer3);
        chatBtnFarmer4 = findViewById(R.id.chatBtnFarmer4);
        chatBtnFarmer5 = findViewById(R.id.chatBtnFarmer5);

        chatBtnFarmer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("Md Alamgir Hossen");
            }
        });

        chatBtnFarmer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("Shamsher Ali");
            }
        });

        chatBtnFarmer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("Nurunnahar Begum");
            }
        });

        chatBtnFarmer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("Ali Hosen");
            }
        });

        chatBtnFarmer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("Shahin Rahman");
            }
        });
    }

    private void openChatActivity(String farmerName) {
        Intent intent = new Intent(CommunityContactActivity.this, ChatActivity.class);
        intent.putExtra("farmerName", farmerName);
        startActivity(intent);
    }
}
