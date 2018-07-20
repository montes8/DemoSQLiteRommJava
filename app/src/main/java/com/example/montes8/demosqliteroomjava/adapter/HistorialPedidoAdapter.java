package com.example.montes8.demosqliteroomjava.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.DetallePedido;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.utils.DemoUtils;

import java.util.ArrayList;

public class HistorialPedidoAdapter extends RecyclerView.Adapter<HistorialPedidoAdapter.HistorialPedidoViewholder>{
    private ArrayList<DetallePedido> listaDetallePedidos;
    Context context;
    Handler handler = new Handler();

    public HistorialPedidoAdapter(Context context) {
        this.context = context;
    }

    public void addList(ArrayList<DetallePedido> listaDetallePedidos){
        this.listaDetallePedidos = listaDetallePedidos;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public HistorialPedidoViewholder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.molde_historial_pedido, parent, false);
        return new HistorialPedidoViewholder (itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HistorialPedidoViewholder  holder, int position) {
        final DetallePedido detallePedido = listaDetallePedidos.get(position);


        Thread hiloListar = new Thread(new Runnable() {
            @Override
            public void run() {

                final Plato plato = DemoApplication.dataBase.detallePedidoDao().detalleDePlato(detallePedido.platoId);
                final Pedido pedido = DemoApplication.dataBase.detallePedidoDao().detalleDePedido(detallePedido.pedidoid);

             handler.post(new Runnable() {
                 @Override
                 public void run() {
                     holder.imagen.setImageDrawable(DemoUtils.getImage(context,plato.getImagen()));
                     holder.nombre.setText(plato.getNombrePlato());
                     holder.precio.setText(String.valueOf(plato.getPrecioPlto()));
                     holder.fecha.setText(pedido.getFecha());
                 }
             });

            }
        }) ;

        hiloListar.start();



        holder.cantidad.setText(String.valueOf(detallePedido.getCantidad()));
        holder.totalPagar.setText(String.valueOf(detallePedido.getSubTotal()));



    }

    @Override
    public int getItemCount() {
        return listaDetallePedidos.size();
    }

    public static class HistorialPedidoViewholder extends RecyclerView.ViewHolder{


        private ImageView imagen;
        private TextView nombre,precio,cantidad,totalPagar,fecha;

        private HistorialPedidoViewholder (View itemView) {
            super(itemView);

            imagen = itemView.findViewById(R.id.image_plato_historial);
            nombre = itemView.findViewById(R.id.nombre_plato_historial);
            precio = itemView.findViewById(R.id.precio_plato_historial);
            cantidad = itemView.findViewById(R.id.cantidad_platos_historial);
            totalPagar = itemView.findViewById(R.id.subtotal_pagar_historial);
            fecha = itemView.findViewById(R.id.fecha_pedido_historial);
        }


    }

}
