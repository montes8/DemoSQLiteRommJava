package com.example.montes8.demosqliteroomjava.repository.temporal;

import com.example.montes8.demosqliteroomjava.model.DetalleTemporal;
import com.example.montes8.demosqliteroomjava.model.Plato;

import java.util.ArrayList;

public class OrdenTemporal {


    private static ArrayList<DetalleTemporal> orden = new ArrayList<>();
    private static OrdenTemporal ordenlista;
    public static OrdenTemporal getInstance() {

        if (ordenlista == null){

            ordenlista = new OrdenTemporal();
        }

        return ordenlista;
    }


    public  void agregaItemOrden(DetalleTemporal detalleTemporal){
        orden.add(detalleTemporal);
    }

    public  ArrayList<DetalleTemporal> optenerorden(){
        return orden;
    }

    public  void eliminarorden(DetalleTemporal detalleTemporal){
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

     public int optenerCantidadPlatoSegunIdice(int indice){

        return orden.get(indice).getCantidad();

        }

    public void actualizarItemOrden(DetalleTemporal ordenItem, int indic){

        orden.set(indic, ordenItem);

    }

    public void limpiarOrden(){

        orden.clear();
    }

    public int totalOrdenes(){
        return orden.size();
    }

}
