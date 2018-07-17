package com.example.montes8.demosqliteroomjava.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.DetalleTemporal;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.repository.temporal.OrdenTemporal;
import com.example.montes8.demosqliteroomjava.utils.DemoUtils;
import com.example.montes8.demosqliteroomjava.view.DetallePedidoActivity;

import java.util.ArrayList;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialViewholder>{

    private ArrayList<Pedido> listapedidos;

    public void addList(ArrayList<Pedido> listapedidos){
        this.listapedidos = listapedidos;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public HistorialViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.molde_historial, parent, false);
        return new HistorialViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialViewholder holder, int position) {
        Pedido pedido = listapedidos.get(position);

       holder.idPedido.setText(String.valueOf(pedido.getIdPedido()));
       holder.totalPagar.setText(String.valueOf(pedido.getMontoTotal()));
       holder.fecha.setText(pedido.getFecha());

    }

    @Override
    public int getItemCount() {
        return listapedidos.size();
    }

    public static class HistorialViewholder extends RecyclerView.ViewHolder{

        Context context;
        private TextView idPedido,totalPagar,fecha;

        private HistorialViewholder(View itemView) {
            super(itemView);


            context = itemView.getContext();
            idPedido = itemView.findViewById(R.id.id_pedido);
            totalPagar = itemView.findViewById(R.id.fecha_pedido);
            fecha = itemView.findViewById(R.id.total_pagar_pedido);
        }

    }
}
