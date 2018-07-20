package com.example.montes8.demosqliteroomjava.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;


import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Usuario.class,parentColumns = "idUsu",childColumns = "userId",onDelete = CASCADE))
public class Pedido implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private Long idPedido;

    private Long userId;
    private String fecha;
    private Double montoTotal;

    public Pedido( Long userId, String fecha, Double montoTotal) {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.idPedido);
        dest.writeValue(this.userId);
        dest.writeString(this.fecha);
        dest.writeValue(this.montoTotal);
    }

    protected Pedido(Parcel in) {
        this.idPedido = (Long) in.readValue(Long.class.getClassLoader());
        this.userId = (Long) in.readValue(Long.class.getClassLoader());
        this.fecha = in.readString();
        this.montoTotal = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Pedido> CREATOR = new Parcelable.Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel source) {
            return new Pedido(source);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };
}
