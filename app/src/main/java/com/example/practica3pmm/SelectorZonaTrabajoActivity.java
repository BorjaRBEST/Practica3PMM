package com.example.practica3pmm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectorZonaTrabajoActivity extends AppCompatActivity {

    private Button selectedButton; // Agregamos esta línea para declarar la variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zona_trabajo);

        Button btnZona1 = findViewById(R.id.btnZona1);
        Button btnZona2 = findViewById(R.id.btnZona2);
        Button btnSelectZona = findViewById(R.id.btnSelectZona);

        // Configurar listeners para cada botón
        btnZona1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnZona1);
            }
        });

        btnZona2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnZona2);
            }
        });

        btnSelectZona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Confirmar la selección y enviar de vuelta a MainActivity
                if (selectedButton != null) {
                    String selectedStyle = selectedButton.getText().toString();
                    setResultAndFinish(selectedStyle);
                }
            }
        });
    }

    private void handleButtonClick(Button clickedButton) {
        // Restaurar el estado inicial del botón previamente seleccionado
        if (selectedButton != null && !selectedButton.equals(clickedButton)) {
            selectedButton.setBackgroundResource(R.drawable.btn_background);
        }

        // Resaltar el botón actual
        clickedButton.setBackgroundResource(R.drawable.boton_selected_background);

        // Actualizar el botón seleccionado
        selectedButton = clickedButton;
    }

    private void setResultAndFinish(String selectedStyle) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedStyle", selectedStyle);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
