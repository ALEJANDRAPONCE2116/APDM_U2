package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnEnviar;
EditText edtNombre, edtSalario;
CheckBox chkBxAdicional;
RadioGroup rdgEstado;
Intent intent;
//RadioButton rdbSoltero, srdCasado, rdbDivorciado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainActivity2.class);
    }

    @Override
    public void onClick(View view) {
        intent.putExtra("Nombre", edtNombre.getText().toString());
        Double dSalario = 0.0;
        dSalario = Double.parseDouble(edtSalario.getText().toString());
        intent.putExtra("Salario",dSalario);
        intent.putExtra("info",chkBxAdicional.isChecked());
        intent.putExtra("Estado civil",rdgEstado.getCheckedRadioButtonId());
                //int iEstado;
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtNombre=findViewById(R.id.edtNombre);
        edtSalario=findViewById(R.id.edtSalario);
        rdgEstado=findViewById(R.id.rdgEstado);
        chkBxAdicional=findViewById(R.id.chkBxAdicional);
        btnEnviar=findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);
    }
}