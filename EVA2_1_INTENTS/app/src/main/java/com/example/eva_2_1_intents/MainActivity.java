package com.example.eva_2_1_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TEL = "tel:5555";

    Intent inTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //----------INTENTS EXPLÍCITOS----------//
    public void onClickDial (View v){
        //MARCAR PERO NO LLAMAR
        inTel=new Intent(Intent.ACTION_DIAL, Uri.parse(TEL)); //Accion: marcar, Dato:TEL
        startActivity(inTel);

    }

    public void onClickCall (View v){
        //LLAMAR DIRECTAMENTE
        inTel=new Intent(Intent.ACTION_CALL, Uri.parse(TEL));
        startActivity(inTel);
    }

    public void onClickCont(View v){
        //ELEGIR CONTACTO
        String sData="content://contacts/people/";
        inTel=new Intent(Intent.ACTION_CALL, Uri.parse(TEL));
        startActivity(inTel);
    }

    public void onClickUrl (View v){
        //ABRIR URL
        //No es la app la que tiene conexión, sino otra, en este caso el navegador
        String sData = "https://youtube.com/";
        Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse(sData));
        startActivity(intent);
        /*String myUriString = "https://youtube.com/";
        Intent myActivity2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUriString));
        startActivity(myActivity2);*/
    }


}