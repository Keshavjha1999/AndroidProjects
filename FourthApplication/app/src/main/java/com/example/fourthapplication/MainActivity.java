package com.example.fourthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView textview = new TextView(this);
        textview.setTextSize(40);
        textview.setText("This is my Fourth Application");
        super.onCreate(savedInstanceState);
        setContentView(textview);
    }
}