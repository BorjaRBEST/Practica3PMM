package com.example.practica3pmm;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EntrenamientosAnterioresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamientos_anteriores);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Simular una lista de entrenamientos anteriores
        List<Entrenamiento> listaEntrenamientos = obtenerListaEntrenamientos();

        // Crear y asignar el adaptador al RecyclerView
        EntrenamientosAdapter adapter = new EntrenamientosAdapter(listaEntrenamientos);
        recyclerView.setAdapter(adapter);
    }

    private List<Entrenamiento> obtenerListaEntrenamientos() {
        List<Entrenamiento> lista = new ArrayList<>();
        // Aquí puedes agregar entrenamientos a la lista, por ejemplo:
        lista.add(new Entrenamiento("Correr", "30 min", "5 km"));
        lista.add(new Entrenamiento("Ciclismo", "45 min", "15 km"));
        // ...

        return lista;
    }
}
