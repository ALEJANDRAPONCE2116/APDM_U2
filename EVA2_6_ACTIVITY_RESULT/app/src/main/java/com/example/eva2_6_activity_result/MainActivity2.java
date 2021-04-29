package com.example.eva2_6_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
Button btnIniSecu;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = new Intent();
    }

   /* CLASE ANONIMA
   @Override
    protected void onStart() {
        super.onStart();
        btnIniSecu=findViewById(R.id.btnIniSec);
        btnIniSecu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getApplicationContext()).setResult();
            }
        });
    }*/
   public void onClick(View view) {
       intent.putExtra("VALOR", "HOLA MUNDO");
       //invocar en el
       setResult(Activity.RESULT_OK, intent); //RESULT_OK -> devuelve un valor
       finish();
   }
}