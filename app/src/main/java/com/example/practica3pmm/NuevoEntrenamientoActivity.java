package com.example.practica3pmm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoEntrenamientoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_entrenamiento);

        final EditText etTipoEjercicio = findViewById(R.id.etTipoEjercicio);
        final EditText etDuracion = findViewById(R.id.etDuracion);
        final EditText etDistancia = findViewById(R.id.etDistancia);
        Button btnGuardarEntrenamiento = findViewById(R.id.btnGuardarEntrenamiento);

        btnGuardarEntrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simular guardar datos en SharedPreferences
                String tipoEjercicio = etTipoEjercicio.getText().toString();
                String duracion = etDuracion.getText().toString();
                String distancia = etDistancia.getText().toString();

                // Validar que los campos no estén vacíos
                if (!tipoEjercicio.isEmpty() && !duracion.isEmpty() && !distancia.isEmpty()) {
                    // Puedes guardar los datos en SharedPreferences aquí

                    // Mostrar un Toast como simulación de datos guardados
                    Toast.makeText(NuevoEntrenamientoActivity.this, "Entrenamiento guardado", Toast.LENGTH_SHORT).show();

                    // Volver a la pantalla principal
                    Intent intent = new Intent(NuevoEntrenamientoActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(NuevoEntrenamientoActivity.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
