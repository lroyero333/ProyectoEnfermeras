package com.example.proyectoenfermeras;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectoenfermeras.entities.Paciente;

import java.util.ArrayList;

//mi lindo comentario
public class MainActivity extends AppCompatActivity {

    private ArrayList<Paciente> listadoPaciente;
    private RecyclerView rv_paciente;
    private Button btnAgregar;
    private AdaptadorPersonalizado adaptador;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItemCerrarSesion:
                SharedPreferences sharedPreferences = getSharedPreferences("preferencias", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("logueado", false);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP | intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarFakeAlListado();

        adaptador = new AdaptadorPersonalizado(listadoPaciente);
        adaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Paciente paciente, int posicion) {
                Toast.makeText(MainActivity.this, "Click " + paciente.getNombre(), Toast.LENGTH_LONG).show();
            }

        });
        //referenciar
        rv_paciente = findViewById(R.id.rv_paciente);
        rv_paciente.setLayoutManager(new LinearLayoutManager(this));
        rv_paciente.setAdapter(adaptador);

        btnAgregar = findViewById(R.id.btnAgregar);
    }

    private void cargarFakeAlListado() {

        listadoPaciente = new ArrayList<>();

        Paciente seriePokemon = new Paciente("Pokemon", "Pikachu", "https://www.ayayay.tv/wp-content/uploads/2016/02/portada-pokemon.jpg");
        Paciente serieTheBoys = new Paciente("The boys", "Critica a la sociedad.", "https://arc-anglerfish-arc2-prod-copesa.s3.amazonaws.com/public/K5S52WFLOZEBTMIA7Q23ZV4CTM.jpg");

        listadoPaciente.add(seriePokemon);
        listadoPaciente.add(serieTheBoys);
    }

    public void clickIrFormulario(View view){
        Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
        //startActivity(intent);
        irFormulario.launch(intent);
    }


    ActivityResultLauncher<Intent> irFormulario = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            if(result.getResultCode() == RESULT_OK ){
                Paciente serieAtrapada = (Paciente) result.getData().getSerializableExtra("nuevo-paciente");
                Toast.makeText(MainActivity.this, serieAtrapada.getApellido(), Toast.LENGTH_SHORT).show();
                if (serieAtrapada != null) {
                    listadoPaciente.add(serieAtrapada);
                    adaptador.setListadoDatos(listadoPaciente);
                }
            }
        }
    });
}
