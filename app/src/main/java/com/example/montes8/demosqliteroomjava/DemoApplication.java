package com.example.montes8.demosqliteroomjava;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.montes8.demosqliteroomjava.repository.database.DemoDataBase;

public class DemoApplication extends Application{

    public static DemoDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room.databaseBuilder(this,DemoDataBase.class,"demo_database.db")
                .build();
    }
}
