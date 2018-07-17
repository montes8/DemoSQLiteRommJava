package com.example.montes8.demosqliteroomjava.repository.temporal;

public class Singleton {
    private static final Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    public void hola(){}
}
