package com.example.practica3pmm;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_STYLE_REQUEST_CODE = 1;
    private static final int SELECT_ZONA_REQUEST_CODE = 2;
    private static final int SELECT_REPOSO_REQUEST_CODE = 3;
    private static final int SELECT_MUSICA_REQUEST_CODE = 4;

    private Button btnZonaTrabajo;
    private Button btnNuevoEntrenamiento;
    private Button btnTiempoReposo;
    private Button btnMusica;
    private Button btnComenzarEntreno;
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
            numberPicker.setTextSize(60);
        }

        // Obtener el TextView del NumberPicker para modificar su estilo
        TextView numberPickerTextView = findNumberPickerTextView(numberPicker);

        // Aplicar estilo al TextView del NumberPicker
        if (numberPickerTextView != null) {
            numberPickerTextView.setTextColor(ContextCompat.getColor(this, R.color.morado));
            numberPickerTextView.setTypeface(null, Typeface.BOLD);
        }

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
                startActivityForResult(intent, SELECT_REPOSO_REQUEST_CODE);
            }
        });

        // Controlador para el botón que te manda a la pantalla de selección de música
        btnMusica = findViewById(R.id.btnEstiloMusica);
        btnMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad de selección de música
                Intent intent = new Intent(MainActivity.this, SelectorMusicaActivity.class);
                startActivityForResult(intent, SELECT_MUSICA_REQUEST_CODE);
            }
        });

        // Agregar controlador para el botón que inicia el entrenamiento
        btnComenzarEntreno = findViewById(R.id.btnComenzarEntreno);
        btnComenzarEntreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EntrenamientoActivity.class);
                iniciarEntrenamiento();
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
        } else if (requestCode == SELECT_MUSICA_REQUEST_CODE && resultCode == RESULT_OK) {
            // Actualizar el texto del botón de música
            String selectedMusica = data.getStringExtra("selectedMusica");
            btnMusica.setText("Música:\n " + selectedMusica);
        }
    }

    // Método para encontrar el TextView dentro de un NumberPicker
    private TextView findNumberPickerTextView(NumberPicker numberPicker) {
        for (int i = 0; i < numberPicker.getChildCount(); i++) {
            View child = numberPicker.getChildAt(i);

            if (child instanceof EditText) {
                return (TextView) child;
            }
        }

        return null;
    }

    // Método para iniciar el entrenamiento con los valores seleccionados
    private void iniciarEntrenamiento() {
        // Obtener los valores seleccionados
        String estilo = btnNuevoEntrenamiento.getText().toString();
        String zonaTrabajo = btnZonaTrabajo.getText().toString();
        String tiempoReposo = btnTiempoReposo.getText().toString();
        String musica = btnMusica.getText().toString();
        int tiempoSesion = numberPicker.getValue();

        // Crear un intent para la actividad de entrenamiento
        Intent intent = new Intent(MainActivity.this, EntrenamientoActivity.class);

        // Pasar los valores como extras al intent
        intent.putExtra("estilo", estilo);
        intent.putExtra("zona", zonaTrabajo);
        intent.putExtra("reposo", tiempoReposo);
        intent.putExtra("musica", musica);
        intent.putExtra("duracion", tiempoSesion);

        // Iniciar la actividad de entrenamiento
        startActivity(intent);
    }
}
