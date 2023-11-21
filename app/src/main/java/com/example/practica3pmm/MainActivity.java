package com.example.practica3pmm;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_STYLE_REQUEST_CODE = 1;
    private static final int SELECT_ZONA_REQUEST_CODE = 2;
    private static final int SELECT_REPOSO_REQUEST_CODE = 3;

    private Button btnZonaTrabajo;
    private Button btnNuevoEntrenamiento;
    private Button btnTiempoReposo;
    private NumberPicker numberPicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar el NumberPicker
        numberPicker = findViewById(R.id.npSelectorTiempo);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(60);
        numberPicker.setValue(5);

        // Cambiar el tamaño del texto
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            numberPicker.setTextSize(50);
        }

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // Hacer algo con el nuevo valor (en este caso, imprimirlo)
                Log.d("NumberPicker", "Nuevo valor: " + newVal + " minutos");
            }
        });

        // Controlador para el bóton que te manda a la pantalla de selección de entrenamiento
        btnNuevoEntrenamiento = findViewById(R.id.btnNuevoEntrenamiento);
        btnNuevoEntrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad de selección de estilo
                Intent intent = new Intent(MainActivity.this, NuevoEntrenamientoActivity.class);
                startActivityForResult(intent, SELECT_STYLE_REQUEST_CODE);
            }
        });

        // Controlador para el bóton que te manda a la pantalla de selección de zona de trabajo
        btnZonaTrabajo = findViewById(R.id.btnZonaTrabajo);
        btnZonaTrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad de zona de trabajo
                Intent intent = new Intent(MainActivity.this, SelectorZonaTrabajoActivity.class);
                startActivityForResult(intent, SELECT_ZONA_REQUEST_CODE);
            }
        });

        // Controlador para el bóton que te manda a la pantalla de selección de reposo
        btnTiempoReposo = findViewById(R.id.btnTiempoReposo);
        btnTiempoReposo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad de zona de trabajo
                Intent intent = new Intent(MainActivity.this, SelectorTiempoReposoActivity.class);
                startActivityForResult(intent, SELECT_ZONA_REQUEST_CODE);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_STYLE_REQUEST_CODE && resultCode == RESULT_OK) {
            // Actualizar el texto del botón de estilo en la pantalla principal
            String selectedStyle = data.getStringExtra("selectedStyle");
            btnNuevoEntrenamiento.setText("Estilo:\n " + selectedStyle);
        } else if (requestCode == SELECT_ZONA_REQUEST_CODE && resultCode == RESULT_OK) {
            // Actualizar el texto del botón de zona de trabajo
            String selectedZona = data.getStringExtra("selectedZona");
            btnZonaTrabajo.setText("Zona de Trabajo:\n " + selectedZona);
        } else if (requestCode == SELECT_REPOSO_REQUEST_CODE && resultCode == RESULT_OK) {
            // Actualizar el texto del botón de tiempo de reposo
            String selectedReposo = data.getStringExtra("selectedReposo");
            btnTiempoReposo.setText("Tiempo de Reposo:\n " + selectedReposo);
        }
    }

}
