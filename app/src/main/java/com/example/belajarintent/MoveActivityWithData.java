package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveActivityWithData extends AppCompatActivity {
    TextView tvDataReceived;

    public static final String AGE = "age";
    public static final String NAME ="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        tvDataReceived = findViewById(R.id.tvMoveData);

        String name = getIntent().getStringExtra(NAME);
        int age = getIntent().getIntExtra(AGE,0);

        String text = "Name : "+ name + ", Umur : "+ age;
        tvDataReceived.setText(text);




    }
}
