package com.example.montes8.demosqliteroomjava.repository.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.montes8.demosqliteroomjava.model.DetallePedido;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.model.Usuario;
import com.example.montes8.demosqliteroomjava.repository.database.dao.DetallePedidoDao;
import com.example.montes8.demosqliteroomjava.repository.database.dao.PedidoDao;
import com.example.montes8.demosqliteroomjava.repository.database.dao.PlatoDao;
import com.example.montes8.demosqliteroomjava.repository.database.dao.UsuarioDao;

@Database(entities = {Plato.class, Usuario.class, Pedido.class, DetallePedido.class},version = 1)
public abstract class DemoDataBase extends RoomDatabase{

    public abstract PlatoDao platoDao();
    public abstract UsuarioDao usuarioDao();
    public abstract PedidoDao pedidoDao();
    public abstract DetallePedidoDao detallePedidoDao();


}
