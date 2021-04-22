package com.example.eva2_2_intentos_explicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                        //ACCION Y DATOS
                        //ACTIVIDAD DE ORIGEN (contexto), CLASE DE LA ACTIVIDAD DESTINO (la que quiero ejecutar)
                        //(obj que representa la actividad de origen), (clase de la actividad a lanzar)
                        //(this), (OtraActividad)
        //Declarar intento
        intent = new Intent(this, OtraActividad.class);
    }

    public void Onclick(View v){
        //LANZAR INTENTO IMPLICITO
        //
        startActivity(intent);
    }
}