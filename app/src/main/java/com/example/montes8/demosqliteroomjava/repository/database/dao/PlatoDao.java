package com.example.montes8.demosqliteroomjava.repository.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.montes8.demosqliteroomjava.model.Plato;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PlatoDao {

    @Query("select * from Plato")
    List<Plato> listarPlatos();

    @Insert
    ArrayList<Long> insertarListaPlatos(ArrayList<Plato> plato);
}
