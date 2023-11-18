package com.example.practica3pmm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EntrenamientosAdapter extends RecyclerView.Adapter<EntrenamientosAdapter.ViewHolder> {

    private List<Entrenamiento> listaEntrenamientos;

    public EntrenamientosAdapter(List<Entrenamiento> listaEntrenamientos) {
        this.listaEntrenamientos = listaEntrenamientos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_entrenamiento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Entrenamiento entrenamiento = listaEntrenamientos.get(position);
        holder.bind(entrenamiento);
    }

    @Override
    public int getItemCount() {
        return listaEntrenamientos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtTipoEjercicio;
        private final TextView txtDuracion;
        private final TextView txtDistancia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTipoEjercicio = itemView.findViewById(R.id.txtTipoEjercicio);
            txtDuracion = itemView.findViewById(R.id.txtDuracion);
            txtDistancia = itemView.findViewById(R.id.txtDistancia);
        }

        public void bind(Entrenamiento entrenamiento) {
            txtTipoEjercicio.setText(entrenamiento.getTipoEjercicio());
            txtDuracion.setText(entrenamiento.getDuracion());
            txtDistancia.setText(entrenamiento.getDistancia());
        }
    }
}
