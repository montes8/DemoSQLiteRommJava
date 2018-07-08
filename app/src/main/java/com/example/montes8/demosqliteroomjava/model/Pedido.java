package com.example.montes8.demosqliteroomjava.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Pedido {

    @PrimaryKey(autoGenerate = true)
    private Long idPedido;
    private Long userId;
    private String fecha;
    private Double montoTotal;

    public Pedido(Long idPedido, Long userId, String fecha, Double montoTotal) {
        this.idPedido = idPedido;
        this.userId = userId;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
