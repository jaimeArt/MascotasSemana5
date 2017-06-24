package com.example.jaimearturo.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onCorreoClick(View view)
    {
        EditText etNombreContacto = (EditText) findViewById(R.id.etNombreContacto);
        EditText etCorreoContacto = (EditText) findViewById(R.id.etCorreoContacto);
        EditText etMensajeContacto = (EditText) findViewById(R.id.etMensajeContacto);
        try{
            GMailSender envio = new GMailSender("Correo@envia", "password");
            envio.sendMail("Mascotas - Contactos  " + etNombreContacto.getText().toString(),
                    etMensajeContacto.getText().toString(),
                    etCorreoContacto.getText().toString(),
                    etCorreoContacto.getText().toString());
        }
        catch (Exception e)
        {
            Log.e("Envio Correo", e.getMessage(), e);

        }
    }
}
