package com.example.petagram.menuopc;

import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petagram.R;
import com.google.android.material.textfield.TextInputEditText;

public class Contacto extends AppCompatActivity {

    private TextInputEditText nombreCompleto;
    private TextInputEditText correoElectronico;
    private TextInputEditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombreCompleto = (TextInputEditText) findViewById(R.id.inputNombreCompleto);
        correoElectronico = (TextInputEditText) findViewById(R.id.inputCorreoElectronico);
        mensaje = (TextInputEditText) findViewById(R.id.inputDescripcion);
    }

    public void enviarMensaje(View view) {

        String titulo = "Mensaje para Petagram";
        String correo = correoElectronico.getText().toString().trim();
        String msj = nombreCompleto.getText().toString().trim() + " " + mensaje.getText().toString().trim();

        EnviarMail enviar = new EnviarMail(this, correo, titulo, msj);
        enviar.execute();
    }
}
