package com.example.montes8.demosqliteroomjava.repository.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.montes8.demosqliteroomjava.model.Usuario;
import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("select * from Usuario")
    List<Usuario> listaUsuario();

    @Query("select * from Usuario where nombreUsuario = :name and contrasenia = :pass")
    Usuario userLOgin(String name,String pass);

    @Query("select * from Usuario where idUsu = :id")
    Usuario verDetalleUsuarioLogeado(Long id);

    @Insert
    Long insertarUsuario(Usuario usuario);

}
