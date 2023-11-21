package com.example.practica3pmm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectorMusicaActivity extends AppCompatActivity {

    private Button selectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        Button btnMusica1 = findViewById(R.id.btnMusica1);
        Button btnMusica2 = findViewById(R.id.btnMusica2);
        Button btnMusica3 = findViewById(R.id.btnMusica3);
        Button btnMusica4 = findViewById(R.id.btnMusica4);
        Button btnMusica5 = findViewById(R.id.btnMusica5);
        Button btnMusica6 = findViewById(R.id.btnMusica6);
        Button btnMusica7 = findViewById(R.id.btnMusica7);
        Button btnMusica8 = findViewById(R.id.btnMusica8);
        Button btnMusica9 = findViewById(R.id.btnMusica9);
        Button btnMusica10 = findViewById(R.id.btnMusica10);
        Button btnSelectMusica = findViewById(R.id.btnSelectMusica);

        btnMusica1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica1);
            }
        });

        btnMusica2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica2);
            }
        });

        btnMusica3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica3);
            }
        });

        btnMusica4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica4);
            }
        });

        btnMusica5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica5);
            }
        });

        btnMusica6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica6);
            }
        });

        btnMusica7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica7);
            }
        });

        btnMusica8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica8);
            }
        });

        btnMusica9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica9);
            }
        });

        btnMusica10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(btnMusica10);
            }
        });

        btnSelectMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedButton != null) {
                    String selectedMusica = selectedButton.getText().toString();
                    setResultAndFinish(selectedMusica);
                }
            }
        });
    }

    private void handleButtonClick(Button clickedButton) {
        if (selectedButton != null && !selectedButton.equals(clickedButton)) {
            selectedButton.setBackgroundResource(R.drawable.btn_background);
        }

        clickedButton.setBackgroundResource(R.drawable.boton_selected_background);
        selectedButton = clickedButton;
    }

    private void setResultAndFinish(String selectedMusica) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedMusica", selectedMusica);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
