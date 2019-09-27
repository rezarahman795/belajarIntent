package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import POJO.Person;

public class MoveActivityWithObject extends AppCompatActivity {
    TextView tv_WithObjectData;
    public static final String EXTRA_DATA = "person";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tv_WithObjectData = findViewById(R.id.tv_WithObject);

        Person person = getIntent().getParcelableExtra(EXTRA_DATA);
        String text = "name : "+person.getName()+", email : "+person.getEmail()+", umur : "+person.getUmur()+
                ", kota : "+person.getCity();
        tv_WithObjectData.setText(text);
    }
}
