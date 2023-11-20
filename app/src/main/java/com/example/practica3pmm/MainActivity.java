package com.example.practica3pmm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNuevoEntrenamiento;
    static final int SELECT_STYLE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNuevoEntrenamiento = findViewById(R.id.btnNuevoEntrenamiento);

        btnNuevoEntrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad de selección de estilo
                Intent intent = new Intent(MainActivity.this, NuevoEntrenamientoActivity.class);
                startActivityForResult(intent, SELECT_STYLE_REQUEST_CODE);
            }
        });

        // Otros listeners...

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_STYLE_REQUEST_CODE && resultCode == RESULT_OK) {
            // Actualizar el texto del botón de estilo en la pantalla principal
            String selectedStyle = data.getStringExtra("selectedStyle");
            btnNuevoEntrenamiento.setText("Estilo:\n " + selectedStyle);
        }
    }
}
