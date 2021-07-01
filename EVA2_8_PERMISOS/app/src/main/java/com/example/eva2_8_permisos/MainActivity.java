package com.example.eva2_8_permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
EditText edtTxTel;
Intent intent;
Button btnLlamar;
final static int PERMISO_LLAMAR=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLlamar=findViewById(R.id.button);
        //primero en oncreate para que en cuanto la app arranque hacer la verif de los permisos
        //Aqui verifico si no tengo el permiso
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){ //regresa un entero
            Toast.makeText(this, "NO TIENES PERMISO", Toast.LENGTH_LONG).show();
            btnLlamar.setEnabled(false);
            //solicitar permiso
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISO_LLAMAR);
        }
        else{//se ejecuta alguna accion si la app tiene el permiso
            Toast.makeText(this, "YA TIENES PERMISO", Toast.LENGTH_LONG).show();
            btnLlamar.setEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtTxTel=findViewById(R.id.editText);
    }

    public void onClick(View view) {
        String sTel="tel: "+ edtTxTel.getText().toString();
        intent = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(intent);
    }

    //metodo que verifica permiso por permiso cuales fueron autorizados y cuales no
    //si hay 5 permisos, habran 5 resultados
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISO_LLAMAR:
                //en grandtResult verificmos los permisos
                if(grantResults[0]==getPackageManager().PERMISSION_GRANTED){
                    //si permiso es verificado se activa el btn
                    btnLlamar.setEnabled(true);
                    Toast.makeText(this, "permiso concedido",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "permiso denegado",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}