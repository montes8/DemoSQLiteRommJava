package com.example.montes8.demosqliteroomjava.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(primaryKeys = {"pedidoid","platoId"},foreignKeys = {@ForeignKey(entity = Pedido.class,parentColumns = "idPedido",childColumns = "pedidoid"),
                                                             @ForeignKey(entity = Plato.class,parentColumns = "idPlato",childColumns = "platoId")
                                                           })
public class DetallePedido {

    @PrimaryKey(autoGenerate = true)
    private Long idDetalle;
    private Long pedidoid;
    private Long platoId;
    private Integer cantidad;
    private Double subTotal;

    public DetallePedido(Long idDetalle, Long pedidoid, Long platoId, Integer cantidad, Double subTotal) {
        this.idDetalle = idDetalle;
        this.pedidoid = pedidoid;
        this.platoId = platoId;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Long getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(Long pedidoid) {
        this.pedidoid = pedidoid;
    }

    public Long getPlatoId() {
        return platoId;
    }

    public void setPlatoId(Long platoId) {
        this.platoId = platoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
