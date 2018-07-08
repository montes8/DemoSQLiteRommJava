package com.example.montes8.demosqliteroomjava.model;

public class DetalleTemporal {

    private Plato plato;
    private int cantidad=1;

    public DetalleTemporal(Plato plato, int cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
