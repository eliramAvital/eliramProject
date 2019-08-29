package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SeccondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccond);
        String temp = getIntent().getExtras().getString("name");

        TextView placeholder = findViewById(R.id.textView);
        placeholder.setText(temp);
        Toast.makeText(this,temp,Toast.LENGTH_LONG).show();





    }
}
