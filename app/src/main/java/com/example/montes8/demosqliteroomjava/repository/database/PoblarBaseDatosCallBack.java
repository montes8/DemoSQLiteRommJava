package com.example.montes8.demosqliteroomjava.repository.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.model.Plato;

import java.util.ArrayList;

public class PoblarBaseDatosCallBack extends RoomDatabase.Callback{

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);

        final ArrayList<Plato> listaPlatos = new ArrayList<>();
        listaPlatos.add(new Plato("Lomo","imagen",155.50,"1000",10,"descripcion"));
        listaPlatos.add(new Plato("Lomo","imagen",155.50,"1000",10,"descripcion"));

        Thread poblarCallback = new Thread(new Runnable() {
            @Override
            public void run() {
                DemoApplication.dataBase.platoDao().insertarListaPlatos(listaPlatos);

            }
        });




        poblarCallback.start();


    }
}
