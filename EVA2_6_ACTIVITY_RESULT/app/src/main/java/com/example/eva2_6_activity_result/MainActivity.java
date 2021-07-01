package com.example.eva2_6_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    final static int COD_SEC=1000;
    final static  int COD_CONTACTOS=2000;
    final static int COD_IMAGENES = 3000;
    Button btnIniSecu;
    Intent intent, intentCont, intentImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
        intentCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentImg = new Intent(Intent.ACTION_PICK, Uri.parse("content://media/external/images/media"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnIniSecu=findViewById(R.id.btnIniSec);
        btnIniSecu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("DATOS", "Info enviada desde principal");
                startActivityForResult(intent, COD_SEC);
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
            case COD_CONTACTOS:
                if (resultCode==Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();

                }
                    break;
            case COD_IMAGENES:
                if (resultCode==Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
        String returnedData = data.getDataString();
        //2. identificar si se devolvio un valor o no RESULT_OK

    }

    public void onClickCont(View view){
        if(view.getId()==R.id.btnCont){
            startActivityForResult(intentCont, COD_CONTACTOS);
        }else{
            startActivityForResult(intentImg, COD_IMAGENES);
        }
    }
}