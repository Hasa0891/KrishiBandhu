package com.example.krishibandhu;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MarketInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_information);

        TableLayout tableLayout = findViewById(R.id.marketPriceTable);

        String[][] marketPrices = {
                {"Mango", "£2.00"},
                {"Orange", "£1.20"},
                {"Grapes", "£3.50"},
                {"Paddy", "£1.50"},
                {"Onion", "£4.50"},
                {"Ginger", "£2.50"}
        };

        for (String[] price : marketPrices) {
            TableRow tableRow = new TableRow(this);

            TextView name = new TextView(this);
            name.setText(price[0]);
            name.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
            name.setPadding(8, 8, 8, 8);

            TextView priceView = new TextView(this);
            priceView.setText(price[1]);
            priceView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
            priceView.setPadding(8, 8, 8, 8);
            priceView.setGravity(Gravity.END);

            tableRow.addView(name);
            tableRow.addView(priceView);

            tableLayout.addView(tableRow);
        }
    }
}
