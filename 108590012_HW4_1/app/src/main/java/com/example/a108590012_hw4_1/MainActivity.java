package com.example.a108590012_hw4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int countNum = 0;
    private TextView textView;
    private EditText editText;
    private static final String EDIT_TEXT_KEY = "com.example.a107590012_HW4_1_EDIT_TEXT_KEY";


    @SuppressLint("SetTextI18n")
    public void count(View view) {
        countNum++;
        textView.setText(Integer.toString(countNum));
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        editText.setText(savedInstanceState.getString(EDIT_TEXT_KEY));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count", String.valueOf(textView.getText()));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("count");
            countNum = Integer.parseInt(count);
            if (textView != null)
                textView.setText(count);
        }
        Log.i("MainActivity", "onCreate");
    }



}