package com.example.montes8.demosqliteroomjava.repository.temporal;

public class OrdenTemporal {
    private static final OrdenTemporal ourInstance = new OrdenTemporal();

    public static OrdenTemporal getInstance() {
        return ourInstance;
    }

    private OrdenTemporal() {


    }
}
