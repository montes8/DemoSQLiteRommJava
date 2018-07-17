package com.example.montes8.demosqliteroomjava.repository.temporal;

import com.example.montes8.demosqliteroomjava.model.DetalleTemporal;
import com.example.montes8.demosqliteroomjava.model.Plato;

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

    public static int buscarplato(Plato plato){
        for (DetalleTemporal a:orden) {
            if (a.getPlato().getIdPlato() == plato.getIdPlato()){
                return orden.indexOf(a);
            }
        }
        return -1;
        }

     public static int optenerCantidadPlatoSegunIdice(int indice){

        return orden.get(indice).getCantidad();

        }

    public static void actualizarItemOrden(DetalleTemporal ordenItem, int indic){

        orden.set(indic, ordenItem);

    }

    public static void limpiarOrden(){

        orden.clear();
    }

    public static int totalOrdenes(){
        return orden.size();
    }

}
