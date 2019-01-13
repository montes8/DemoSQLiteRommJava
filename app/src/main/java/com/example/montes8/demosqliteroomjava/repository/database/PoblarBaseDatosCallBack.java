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
        listaPlatos.add(new Plato("Escabeche","escabeche",12.50,"1080",10,context.getString(R.string.escabeche)));

        listaPlatos.add(new Plato("Arroz con pollo","arroz",12.50,"1080",10,context.getString(R.string.arrozpollo)));

        listaPlatos.add(new Plato("Aji","aji",12.50,"1080",10,context.getString(R.string.aji)));

        listaPlatos.add(new Plato("Caucau","caucau",12.50,"1080",10,context.getString(R.string.caucau)));

        listaPlatos.add(new Plato("Ceviche","ceviche",12.50,"1080",10,context.getString(R.string.ceviche)));

        listaPlatos.add(new Plato("Chaufa","chaufa",12.50,"1080",10,context.getString(R.string.chaufa)));

        listaPlatos.add(new Plato("Cuy","cuy",12.50,"1080",10,context.getString(R.string.cuy)));

        listaPlatos.add(new Plato("Huancaina","huancaina",12.50,"1080",10,context.getString(R.string.papahuancaina)));

        listaPlatos.add(new Plato("Lomo","lomo",12.50,"1080",10,context.getString(R.string.lomo)));

        listaPlatos.add(new Plato("Rocoto","rocoto",12.50,"1080",10,context.getString(R.string.rocoto)));




        Thread poblarCallback = new Thread(new Runnable() {
            @Override
            public void run() {
                DemoApplication.dataBase.platoDao().insertarListaPlatos(listaPlatos);

            }
        });

        poblarCallback.start();


    }
}
