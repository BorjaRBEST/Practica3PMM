package com.example.practica3pmm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NuevoEntrenamientoActivity extends AppCompatActivity {

    private Button selectedButton; // Agregamos esta línea para declarar la variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_entrenamiento);

        Button btnYoga1 = findViewById(R.id.btnYoga1);
        Button btnYoga2 = findViewById(R.id.btnYoga2);
        Button btnSelectStyle = findViewById(R.id.btnSelectStyle);

        // Configurar listeners para cada botón
        btnYoga1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnYoga1);
            }
        });

        btnYoga2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnYoga2);
            }
        });

        btnSelectStyle.setOnClickListener(new View.OnClickListener() {
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
