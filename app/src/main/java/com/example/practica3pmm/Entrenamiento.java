package com.example.practica3pmm;
public class Entrenamiento {
    private String tipoEjercicio;
    private String duracion;
    private String distancia;

    public Entrenamiento(String tipoEjercicio, String duracion, String distancia) {
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.distancia = distancia;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getDistancia() {
        return distancia;
    }
}
