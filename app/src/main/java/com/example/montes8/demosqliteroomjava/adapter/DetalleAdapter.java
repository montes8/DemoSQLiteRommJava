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
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.utils.DemoUtils;
import java.util.ArrayList;

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.DetallePedidoViewholder> {

    Context context;

    public DetalleAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<DetalleTemporal> listaDetallesOrdenes;

    public void addList(ArrayList<DetalleTemporal> listaPlatos){
        this.listaDetallesOrdenes = listaDetallesOrdenes;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DetallePedidoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.molde_detalle_pedido, parent, false);
        return new DetallePedidoViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetalleAdapter.DetallePedidoViewholder holder, int position) {
        DetalleTemporal ordenes = listaDetallesOrdenes.get(position);

        holder.imagen.setImageDrawable(DemoUtils.getImage(context,plato.getImagen()));
        holder.nombre.setText(plato.getNombrePlato());
        holder.precio.setText(String.valueOf(plato.getPrecioPlto()));



    }

    @Override
    public int getItemCount() {
        return listaDetallesOrdenes.size();
    }

    public static class DetallePedidoViewholder extends RecyclerView.ViewHolder{

        Context context;
        private ImageView imagen,agregarplato,detallePlato;
        private TextView nombre, precio;

        private DetallePedidoViewholder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            imagen = itemView.findViewById(R.id.image_view_plato);
            nombre = itemView.findViewById(R.id.text_nombre_pletoitem);
            precio = itemView.findViewById(R.id.text_precio);
            agregarplato = itemView.findViewById(R.id.image_add);
            detallePlato = itemView.findViewById(R.id.image_detalles);
        }


    }
}
