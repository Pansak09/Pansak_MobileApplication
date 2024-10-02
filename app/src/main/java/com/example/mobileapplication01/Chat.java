package com.example.mobileapplication01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {

    private TextView textView;
    private EditText etInputText;
    private Button bSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        ArrayList<String> selectedItems = getIntent().getStringArrayListExtra("selectedItems");


        textView = findViewById(R.id.sellerNameTextView);
        etInputText = findViewById(R.id.etInputText);
        bSend = findViewById(R.id.bSend);


        if (selectedItems != null && !selectedItems.isEmpty()) {
            StringBuilder details = new StringBuilder("Selected items:\n");
            for (String item : selectedItems) {
                details.append(item).append("\n");
            }
            textView.setText(details.toString());
        } else {
            textView.setText("No items selected.");
        }

        bSend.setOnClickListener(v -> {
            String message = etInputText.getText().toString();
            if (!message.isEmpty()) {
                textView.append("\n" + message);
                etInputText.setText("");
            }
        });
    }
}
