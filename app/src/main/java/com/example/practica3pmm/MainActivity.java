package com.example.practica3pmm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNuevoEntrenamiento = findViewById(R.id.btnNuevoEntrenamiento);
        Button btnEntrenamientosAnteriores = findViewById(R.id.btnEntrenamientosAnteriores);

        btnNuevoEntrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, NuevoEntrenamientoActivity.class);
                startActivity(intent);
            }
        });

        btnEntrenamientosAnteriores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EntrenamientosAnterioresActivity.class);
                startActivity(intent);
            }
        });
    }
}
