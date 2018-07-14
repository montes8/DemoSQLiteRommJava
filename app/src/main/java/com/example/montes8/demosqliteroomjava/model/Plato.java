package com.example.montes8.demosqliteroomjava.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import io.reactivex.annotations.NonNull;

@Entity
public class Plato implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private Long idPlato;

    private String nombrePlato;
    private String imagen;
    private Double precioPlto;
    private String calorias;
    private Integer descuento;
    private String descripcion;

    public Plato(String nombrePlato, String imagen, Double precioPlto, String calorias, Integer descuento, String descripcion) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.idPlato);
        dest.writeString(this.nombrePlato);
        dest.writeString(this.imagen);
        dest.writeValue(this.precioPlto);
        dest.writeString(this.calorias);
        dest.writeValue(this.descuento);
        dest.writeString(this.descripcion);
    }

    protected Plato(Parcel in) {
        this.idPlato = (Long) in.readValue(Long.class.getClassLoader());
        this.nombrePlato = in.readString();
        this.imagen = in.readString();
        this.precioPlto = (Double) in.readValue(Double.class.getClassLoader());
        this.calorias = in.readString();
        this.descuento = (Integer) in.readValue(Integer.class.getClassLoader());
        this.descripcion = in.readString();
    }

    public static final Parcelable.Creator<Plato> CREATOR = new Parcelable.Creator<Plato>() {
        @Override
        public Plato createFromParcel(Parcel source) {
            return new Plato(source);
        }

        @Override
        public Plato[] newArray(int size) {
            return new Plato[size];
        }
    };
}
