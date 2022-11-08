package com.example.proyectoenfermeras.view.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;

import com.example.proyectoenfermeras.R;
import com.example.proyectoenfermeras.model.entities.Paciente;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etUrlImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNombre = findViewById(R.id.et_Comentario);
        etApellido = findViewById(R.id.et_Realizado);
        etUrlImagen = findViewById(R.id.et_urlimagen);

    }

    public void clickGuardar(View view){
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String url = etUrlImagen.getText().toString();

        if ("".equals(nombre)){
            etNombre.setError(getString(R.string.errorDeValidacion));
            return;
        }
        if ("".equals(apellido)){
            etApellido.setError(getString(R.string.errorDeValidacion));
            return;
        }
        if ("".equals(url)){
            etUrlImagen.setError(getString(R.string.errorDeValidacion));
            return;
        }

        Paciente nuevoPaciente = new Paciente(nombre, apellido, url);



        Intent datos = new Intent();

        setResult(RESULT_OK, datos);

        finish();


    }
}