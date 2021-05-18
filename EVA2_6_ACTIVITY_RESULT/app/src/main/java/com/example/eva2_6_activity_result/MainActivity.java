package com.example.eva2_6_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    final static int COD_SEC=1000;
    final static  int COD_CONTACTOS=2000;
    Button btnIniSecu;
    Intent intent, intentCont, intentImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
        intentCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentImg = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnIniSecu=findViewById(R.id.btnIniSec);
        btnIniSecu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent, COD_SEC);
            }
            switch(requestCode){
                case COD_SEC:
                    if(resul)
            }
        });
    }

    //mecanismo asincrono: manejo de eventos, siempre un obj escuchando a que se produzca un resultado

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //escuha todos los eventos de resultados
        super.onActivityResult(requestCode, resultCode, data); //resultCode ->
        //AQUI PROCESAMOS LA RESPUESTA DE LA ACTIVIDAD:
        //1. identificar la actividad que devilvi'o el resultado con request
        switch (requestCode){
            case COD_SEC: //un case para cada actividad
                // 2. identificar si se devolvio un valor o no RESULT_OK
                if (resultCode == Activity.RESULT_OK){//si devuelve valor
                    //3. leer datos (intent)
                    Toast.makeText(this, data.getStringExtra("VALOR"), Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
        String returnedData = data.getDataString();
        //2. identificar si se devolvio un valor o no RESULT_OK

    }

    public void onClickCont(View view){
        if(view.getId()==R.id.btnCont){
            startActivityForResult(intent, COD_SEC);
        }
    }
}