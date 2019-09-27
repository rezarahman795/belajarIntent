package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MoveResult extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rd_grp;
    Button btnPilih;

    public static int RESULT_CODE = 110;
    public static String EXTRA_SELECTED_VALUE = "select_value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_result);

        btnPilih = findViewById(R.id.btn_pilih);
        rd_grp = findViewById(R.id.rd_grp_);

        btnPilih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_pilih){
            if (rd_grp.getCheckedRadioButtonId()!=0){
                int value = 0;
                switch (rd_grp.getCheckedRadioButtonId()){
                    case R.id.rd_50:
                        value = 50;
                        break;
                    case R.id.rd_100:
                        value = 100;
                        break;
                    case R.id.rd_150:
                        value = 150;
                        break;
                    case R.id.rd_200:
                        value = 200;
                        break;

                }

                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}
