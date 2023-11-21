package com.example.practica3pmm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectorTiempoReposoActivity extends AppCompatActivity {

    private Button selectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo_reposo);

        Button btnReposo1 = findViewById(R.id.btnReposo1);
        Button btnReposo2 = findViewById(R.id.btnReposo2);
        Button btnReposo3 = findViewById(R.id.btnReposo3);
        Button btnReposo4 = findViewById(R.id.btnReposo4);
        Button btnReposo5 = findViewById(R.id.btnReposo5);
        Button btnReposo6 = findViewById(R.id.btnReposo6);
        Button btnReposo7 = findViewById(R.id.btnReposo7);
        Button btnReposo8 = findViewById(R.id.btnReposo8);
        Button btnReposo9 = findViewById(R.id.btnReposo9);
        Button btnReposo10 = findViewById(R.id.btnReposo10);
        Button btnSelectReposo = findViewById(R.id.btnSelectReposo);

        // Configurar listeners para cada botón
        btnReposo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo1);
            }
        });

        btnReposo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo2);
            }
        });
        btnReposo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo3);
            }
        });

        btnReposo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo4);
            }
        });
        btnReposo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo5);
            }
        });

        btnReposo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo6);
            }
        });
        btnReposo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo7);
            }
        });

        btnReposo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo8);
            }
        });
        btnReposo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo9);
            }
        });

        btnReposo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnReposo10);
            }
        });

        btnSelectReposo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Confirmar la selección y enviar de vuelta a MainActivity
                if (selectedButton != null) {
                    String selectedReposo = selectedButton.getText().toString();
                    setResultAndFinish(selectedReposo);
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

    private void setResultAndFinish(String selectedReposo) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedReposo", selectedReposo);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
