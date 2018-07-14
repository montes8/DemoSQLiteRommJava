package com.example.montes8.demosqliteroomjava.repository.temporal;

import com.example.montes8.demosqliteroomjava.model.DetalleTemporal;

import java.util.ArrayList;

public class OrdenTemporal {

    private static ArrayList<DetalleTemporal> orden = new ArrayList<>();

    public static void agregaItemOrden(DetalleTemporal detalleTemporal){
        orden.add(detalleTemporal);
    }

    public static ArrayList<DetalleTemporal> optenerorden(){
        return orden;
    }

    public static void eliminarorden(DetalleTemporal detalleTemporal){
        orden.remove(detalleTemporal);
    }

    

}
