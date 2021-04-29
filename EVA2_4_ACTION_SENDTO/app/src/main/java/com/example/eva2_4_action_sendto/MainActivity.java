package com.example.eva2_4_action_sendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText edtTxtTel, edtTxtMensaje;
Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtMensaje=findViewById(R.id.edtTxtMensaje);
        edtTxtTel=findViewById(R.id.edtTxtTel);
        btnEnviar=findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);
    }

    public void onClick (View view){
        String sTel, sMensaje;
        sTel="smsto: "+ edtTxtTel.getText().toString();
        sMensaje=edtTxtMensaje.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        //extra
        intent.putExtra("sms_body",sMensaje);
       // intent.getExtras()
        startActivity(intent);
    }
}