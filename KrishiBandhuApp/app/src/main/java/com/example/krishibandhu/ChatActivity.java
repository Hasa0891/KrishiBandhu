package com.example.krishibandhu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {

    private LinearLayout chatMessagesLayout;
    private EditText messageInput;

    private final java.util.List<String> conversationHistory = new java.util.ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatMessagesLayout = findViewById(R.id.chatMessagesLayout);
        messageInput = findViewById(R.id.messageInput);
        Button sendButton = findViewById(R.id.sendButton);

        addMessageToChat("Hello, How are you?");

        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();
            if (!message.isEmpty()) {
                addMessageToChat("You: " + message);
                messageInput.setText("");

                generateReply(message);
            } else {
                Toast.makeText(ChatActivity.this, "Please, Write a message", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addMessageToChat(String message) {
        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setTextSize(16f);
        textView.setTextColor(getResources().getColor(android.R.color.black));
        chatMessagesLayout.addView(textView);
    }

    private void generateReply(String userMessage) {
        String reply = "Writing...";
        addMessageToChat("Farmer 2: " + reply);
    }
}
