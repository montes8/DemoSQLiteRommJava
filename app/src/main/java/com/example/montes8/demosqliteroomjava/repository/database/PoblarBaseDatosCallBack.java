package com.example.montes8.demosqliteroomjava.repository.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.Plato;

import java.util.ArrayList;

public class PoblarBaseDatosCallBack extends RoomDatabase.Callback{

    Context context;

    public PoblarBaseDatosCallBack(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);

        final ArrayList<Plato> listaPlatos = new ArrayList<>();
        listaPlatos.add(new Plato("Lomo Saltado","lomo",15.50,"1000",10,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Arroz Con Pollo","arroz",10.50,"2000",20,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Ceviche","ceviche",12.50,"500",10,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Rocoto Relleno","rocoto",15.50,"800",20,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Aji de Gallina","aji",14.50,"300",10,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Papa a la Huancaina","huancaina",16.50,"1200",20,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Cuy","cuy",15.50,"2500",10,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Arroz Chaufa","chaufa",155.50,"1000",10,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Cau Cau","caucau",15.00,"1100",20,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Causa","causa",11.50,"1500",10,context.getString(R.string.lomo)));
        listaPlatos.add(new Plato("Escabeche","escabeche",12.50,"1080",10,context.getString(R.string.lomo)));


        Thread poblarCallback = new Thread(new Runnable() {
            @Override
            public void run() {
                DemoApplication.dataBase.platoDao().insertarListaPlatos(listaPlatos);

            }
        });




        poblarCallback.start();


    }
}
