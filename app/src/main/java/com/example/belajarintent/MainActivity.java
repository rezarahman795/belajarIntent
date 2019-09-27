package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import POJO.Person;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMove,btnMoveWithData,
            btnMoveWithObject,
            btnMoveDial,btnMoveResult;
    TextView tv_hasil_pilih;

    private int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove= findViewById(R.id.btn_move);
        btnMove.setOnClickListener(this);

        btnMoveWithData = findViewById(R.id.btn_move_with_data);
        btnMoveWithData.setOnClickListener(this);

        btnMoveWithObject = findViewById(R.id.btn_with_object);
        btnMoveWithObject.setOnClickListener(this);

        btnMoveDial = findViewById(R.id.btn_dial);
        btnMoveDial.setOnClickListener(this);

        btnMoveResult = findViewById(R.id.btn_moveResult);
        btnMoveResult.setOnClickListener(this);

        tv_hasil_pilih = findViewById(R.id.result_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move:
                Intent intent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(intent);
            break;
            case R.id.btn_move_with_data:
                Intent intent1 = new Intent(MainActivity.this,MoveActivityWithData.class);
                intent1.putExtra(MoveActivityWithData.AGE,10);
                intent1.putExtra(MoveActivityWithData.NAME,"REZA");
                startActivity(intent1);
                break;
            case R.id.btn_with_object:
                Person person = new Person();
                person.setName("Reza Rahman");
                person.setEmail("reza@gmail.com");
                person.setCity("bangka");
                person.setUmur(20);
                Intent intent2 = new Intent(MainActivity.this,MoveActivityWithObject.class);
                intent2.putExtra(MoveActivityWithObject.EXTRA_DATA,person);
                startActivity(intent2);
                break;
            case R.id.btn_dial:
                String phoneNumber  = "081918965045";
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(intentDial);
                break;
            case R.id.btn_moveResult:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveResult.class);
               startActivityForResult(moveForResultIntent,REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveResult.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveResult.EXTRA_SELECTED_VALUE, 0);
               tv_hasil_pilih.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }


}
