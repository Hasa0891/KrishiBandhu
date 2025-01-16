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
    private Button sendButton;
    private TextView chatHeader;

    private final java.util.List<String> conversationHistory = new java.util.ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Initialize UI elements
        chatMessagesLayout = findViewById(R.id.chatMessagesLayout);
        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);

        // Retrieve the user name passed from the previous activity
        String userName = getIntent().getStringExtra("USER_NAME");

        // Add initial message
        addMessageToChat("হে! আপনি কেমন আছেন?");

        // Set up the send button functionality
        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();
            if (!message.isEmpty()) {
                // Add the user's message to the chat
                addMessageToChat("আপনার: " + message);
                messageInput.setText(""); // Clear the input field

                // Generate a reply based on the message
                generateReply(message);
            } else {
                Toast.makeText(ChatActivity.this, "দয়া করে একটি বার্তা লিখুন", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to add messages to the chat window
    private void addMessageToChat(String message) {
        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setTextSize(16f);
        textView.setTextColor(getResources().getColor(android.R.color.black));
        chatMessagesLayout.addView(textView);
    }

    // Method to generate a human-like reply
    private void generateReply(String userMessage) {
        String reply;
        if (userMessage.toLowerCase().contains("hello")) {
            reply = "হ্যালো! আমি কীভাবে সাহায্য করতে পারি?";
        } else if (userMessage.toLowerCase().contains("how are you")) {
            reply = "আমি ভাল আছি, ধন্যবাদ! আপনার কেমন আছে?";
        } else if (userMessage.toLowerCase().contains("season")) {
            reply = "আপনার এলাকার জন্য আবহাওয়ার পূর্বাভাস এবং বীজ বপনের সময় সম্পর্কে তথ্য এখানে পাওয়া যাবে।";
        } else if (userMessage.toLowerCase().contains("pest control")) {
            reply = "আপনার অঞ্চলের জন্য ক্ষতিকারক পোকা এবং রোগ নিয়ন্ত্রণের পরামর্শ পাওয়া যাবে।";
        } else if (userMessage.toLowerCase().contains("government schemes")) {
            reply = "সরকারি ও এনজিওর কৃষি স্কিম সম্পর্কে বিস্তারিত তথ্য পেতে, আমাদের প্রধান পরামর্শ বিভাগটি দেখুন।";
        } else if (userMessage.toLowerCase().contains("fertilizer")) {
            reply = "আপনার ফসলের জন্য উপযুক্ত সার ও এর ব্যবহার সম্পর্কিত তথ্য জানতে আমাদের সার পরামর্শ বিভাগ দেখুন।";
        } else if (userMessage.toLowerCase().contains("irrigation")) {
            reply = "আপনার জমির জন্য সঠিক সেচ ব্যবস্থা এবং পানি সংরক্ষণের পরামর্শ দেওয়া হবে।";
        } else if (userMessage.toLowerCase().contains("crop rotation")) {
            reply = "ফসল পরিবর্তন আপনার মাটির উর্বরতা বজায় রাখতে সাহায্য করবে। আপনার এলাকার জন্য উপযুক্ত ফসল পরিকল্পনা জানতে পারবেন।";
        } else if (userMessage.toLowerCase().contains("soil health")) {
            reply = "মাটির স্বাস্থ্য সম্পর্কিত পরামর্শ, যেমন পিএইচ স্তর এবং মাটির পুষ্টি, আমাদের পৃষ্ঠায় পাওয়া যাবে।";
        } else if (userMessage.toLowerCase().contains("weather forecast")) {
            reply = "আপনার এলাকার জন্য সঠিক আবহাওয়ার পূর্বাভাস আমাদের অ্যাপের আবহাওয়া বিভাগে পাবেন।";
        } else if (userMessage.toLowerCase().contains("market prices")) {
            reply = "আপনার এলাকার কৃষি পণ্যের বাজার মূল্য জানার জন্য আমাদের বাজার মূল্য বিভাগে যান।";
        } else if (userMessage.toLowerCase().contains("loan schemes")) {
            reply = "কৃষকদের জন্য সহজে প্রাপ্ত ঋণ স্কিম সম্পর্কিত বিস্তারিত তথ্য আমাদের অ্যাপের ঋণ বিভাগে পাওয়া যাবে।";
        } else if (userMessage.toLowerCase().contains("organic farming")) {
            reply = "জৈব চাষাবাদ সম্পর্কিত পরামর্শ এবং ভালো ফলাফল পাওয়ার জন্য উপযুক্ত পদ্ধতিগুলি শিখতে আমাদের বিভাগ দেখুন।";
        } else if (userMessage.toLowerCase().contains("pesticides")) {
            reply = "কৃষিতে উপকারী কীটনাশক ব্যবহার এবং তাদের নিরাপত্তা সম্পর্কে আরও জানুন আমাদের কীটনাশক নির্দেশিকা থেকে।";
        } else if (userMessage.toLowerCase().contains("rain forecast")) {
            reply = "বৃষ্টির পূর্বাভাস আপনার এলাকার জন্য এখানে পাওয়া যাবে।";
        } else if (userMessage.toLowerCase().contains("new features")) {
            reply = "আমরা নতুন ফিচার সংযোজনের জন্য কাজ করছি। নতুন আপডেটগুলির জন্য অ্যাপটি আপডেট রাখতে থাকুন।";
        } else if (userMessage.toLowerCase().contains("thanks")) {
            reply = "আপনার কোনো প্রশ্ন থাকলে, আমি এখানে আছি সাহায্য করার জন্য।";
        } else {
            reply = "দুঃখিত, আমি আপনার প্রশ্নটি বুঝতে পারিনি। দয়া করে পুনরায় লিখুন।";
        }

        addMessageToChat("বট: " + reply);
    }
}
