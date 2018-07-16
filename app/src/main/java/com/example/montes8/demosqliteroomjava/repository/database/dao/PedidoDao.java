package com.example.montes8.demosqliteroomjava.repository.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.montes8.demosqliteroomjava.model.Pedido;

import java.util.List;

@Dao
public interface PedidoDao {

    @Query("select * from Pedido")
    List<Pedido> listarPedidos();

    @Query("select * from Pedido where userId = :userId")
    List<Pedido> verpedidoSegunUsuario(Long userId);

    @Query("SELECT COUNT(*) FROM Pedido")
    Integer optieneCantidadFila();


    @Insert
    Long insertPedido(Pedido pedido);
}
