package com.example.krishibandhu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CommunityContactActivity extends AppCompatActivity {

    // Declare the buttons for each farmer
    Button chatBtnFarmer1, chatBtnFarmer2, chatBtnFarmer3, chatBtnFarmer4, chatBtnFarmer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_contact);

        // Initialize the buttons
        chatBtnFarmer1 = findViewById(R.id.chatBtnFarmer1);
        chatBtnFarmer2 = findViewById(R.id.chatBtnFarmer2);
        chatBtnFarmer3 = findViewById(R.id.chatBtnFarmer3);
        chatBtnFarmer4 = findViewById(R.id.chatBtnFarmer4);
        chatBtnFarmer5 = findViewById(R.id.chatBtnFarmer5);

        // Set click listeners for each button
        chatBtnFarmer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("মো. আলমগীর হোসেন");
            }
        });

        chatBtnFarmer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("শমসের আলী");
            }
        });

        chatBtnFarmer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("নুরুন্নাহার বেগম");
            }
        });

        chatBtnFarmer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("আলী হোসেন");
            }
        });

        chatBtnFarmer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity("শাহীন রহমান");
            }
        });
    }

    // Method to open the ChatActivity with farmer's name as an extra
    private void openChatActivity(String farmerName) {
        Intent intent = new Intent(CommunityContactActivity.this, ChatActivity.class);
        intent.putExtra("farmerName", farmerName); // Send the farmer's name to the chat activity
        startActivity(intent);
    }
}
