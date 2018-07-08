package com.example.montes8.demosqliteroomjava.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Plato {

    @PrimaryKey(autoGenerate = true)
    private Long idPlato;
    private String nombrePlato;
    private String imagen;
    private Double precioPlto;
    private String calorias;
    private Integer descuento;
    private String descripcion;

    public Plato(Long idPlato, String nombrePlato, String imagen, Double precioPlto, String calorias, Integer descuento, String descripcion) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.imagen = imagen;
        this.precioPlto = precioPlto;
        this.calorias = calorias;
        this.descuento = descuento;
        this.descripcion = descripcion;
    }

    public Long getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Long idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecioPlto() {
        return precioPlto;
    }

    public void setPrecioPlto(Double precioPlto) {
        this.precioPlto = precioPlto;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
