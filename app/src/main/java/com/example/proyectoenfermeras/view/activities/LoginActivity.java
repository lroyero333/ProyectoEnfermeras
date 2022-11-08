package com.example.proyectoenfermeras.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectoenfermeras.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario, etContra, etRol;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("preferencias", MODE_PRIVATE);

        if (sharedPreferences.getBoolean("logueado", false)){
            finish();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        etUsuario = findViewById(R.id.et_usuario);
        etContra = findViewById(R.id.et_contra);
        etRol = findViewById(R.id.et_rol);


    }

    public void clickLogin(View view){
        String Usuario = etUsuario.getText().toString();
        String Contra = etContra.getText().toString();
        String rol = etRol.getText().toString();

        if (Usuario.equals("admin") && Contra.equals("admin")&& rol.equals("enfermera")){

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("logueado", true);
            editor.apply();

            finish();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, getString(R.string.errorLogin), Toast.LENGTH_SHORT).show();
        }

    }
}