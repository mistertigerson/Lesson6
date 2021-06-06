package com.example.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView = findViewById(R.id.main3_tv);
        Bundle arguments = getIntent().getExtras();
        textView.setText(arguments.get("name").toString());
    }
}