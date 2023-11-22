package com.example.practica3pmm;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EntrenamientoActivity extends AppCompatActivity {

    private TextView tvDuracion;
    private TextView tvEstilo;
    private TextView tvZona;
    private TextView tvReposo;
    private TextView tvMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_entrenamiento);

        // Obtener referencias a los TextView en tu layout de entrenamiento
        tvDuracion = findViewById(R.id.tvDuracion);
        tvEstilo = findViewById(R.id.tvEstilo);
        tvZona = findViewById(R.id.tvZona);
        tvReposo = findViewById(R.id.tvReposo);
        tvMusica = findViewById(R.id.tvMusica);

        // Obtener los datos pasados desde MainActivity
        int duracion = getIntent().getIntExtra("duracion", 0);
        String estilo = getIntent().getStringExtra("estilo");
        String zona = getIntent().getStringExtra("zona");
        String reposo = getIntent().getStringExtra("reposo");
        String musica = getIntent().getStringExtra("musica");

        // Mostrar los datos en los TextView
        tvDuracion.setText(duracion + " minutos");
        tvEstilo.setText(estilo);
        tvZona.setText(zona);
        tvReposo.setText(reposo);
        tvMusica.setText(musica);

        // Iniciar temporizador con la duración seleccionada
        iniciarTemporizador(duracion * 60 * 1000); // Convertir minutos a milisegundos
    }

    private void iniciarTemporizador(long duracionEnMilisegundos) {
        new CountDownTimer(duracionEnMilisegundos, 1000) {
            public void onTick(long millisUntilFinished) {
                // Actualizar el tiempo restante en tiempo real si es necesario
                long minutosRestantes = millisUntilFinished / 60000;
                long segundosRestantes = (millisUntilFinished % 60000) / 1000;
                String tiempoRestante = String.format("%02d:%02d", minutosRestantes, segundosRestantes);
                // Puedes mostrar el tiempo restante en algún TextView si lo deseas
                // Ejemplo: tvTiempoRestante.setText(tiempoRestante);
            }

            public void onFinish() {
                // Aquí puedes realizar acciones cuando el temporizador llega a cero
                // Por ejemplo, mostrar un mensaje de agradecimiento
                // o realizar alguna otra lógica específica de tu aplicación
            }
        }.start();
    }
}
