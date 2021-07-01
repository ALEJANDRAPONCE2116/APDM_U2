package com.example.eva_2_3_stack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
//Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      //  intent=new Intent();
    }

    public void OnClickMain2(View view) {
       // startActivity(intent);  ----> mal, porque se van creando una actividad y se pone en el stack
        finish();
    }
}