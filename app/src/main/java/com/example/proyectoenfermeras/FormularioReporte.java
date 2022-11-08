package com.example.proyectoenfermeras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;

import com.example.proyectoenfermeras.entities.Paciente;

public class FormularioReporte extends AppCompatActivity {

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
        datos.putExtra("nuevo-paciente", (Parcelable) nuevoPaciente);
        setResult(RESULT_OK, datos);

        finish();
        Intent intent = new Intent(FormularioReporte.this, MainActivity.class);
        startActivity(intent);

    }
}