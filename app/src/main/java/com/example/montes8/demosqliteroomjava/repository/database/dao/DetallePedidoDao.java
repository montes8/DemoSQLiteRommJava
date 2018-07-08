package com.example.montes8.demosqliteroomjava.repository.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.montes8.demosqliteroomjava.model.DetallePedido;
import com.example.montes8.demosqliteroomjava.model.Pedido;

import java.util.List;

@Dao
public interface DetallePedidoDao {

    @Query("select * from DetallePedido")
    List<DetallePedido> listarDetallepedido();

    @Query("select * from DetallePedido where pedidoid = :id")
    List<DetallePedido> listarDetallePedidoId(Long id);

    @Query("select * from DetallePedido inner join Pedido on DetallePedido.pedidoid=Pedido.idPedido where DetallePedido.pedidoid= :pedidoId")
    Pedido detalleDePedido(Long pedidoId);

    @Query("select * from DetallePedido inner join Plato on DetallePedido.platoId=Plato.idPlato where DetallePedido.platoId= :platoId")
    Pedido detalleDePlato(Long platoId);

    @Insert
    Long insertarDetallepedido(DetallePedido detalle);
}
