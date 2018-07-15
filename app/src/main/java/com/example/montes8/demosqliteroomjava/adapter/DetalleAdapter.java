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
import com.example.montes8.demosqliteroomjava.repository.temporal.OrdenTemporal;
import com.example.montes8.demosqliteroomjava.utils.DemoUtils;
import java.util.ArrayList;

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.DetallePedidoViewholder> {

    Context context;

    public DetalleAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<DetalleTemporal> listaDetallesOrdenes;

    public void addList(ArrayList<DetalleTemporal> listaDetallesOrdenes){
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
        DetalleTemporal detallesaPedido = listaDetallesOrdenes.get(position);

        Double subTotal = detallesaPedido.getPlato().getPrecioPlto() * detallesaPedido.getCantidad();

        holder.imagendetalle.setImageDrawable(DemoUtils.getImage(context,detallesaPedido.getPlato().getImagen()));
        holder.idPlatoNombre.setText(detallesaPedido.getPlato().getNombrePlato());
        holder.precioPlatounitario.setText(String.valueOf(detallesaPedido.getPlato().getPrecioPlto()));
        holder.cantidad.setText(String.valueOf(detallesaPedido.getCantidad()));
        holder.subtotal.setText("$/"+ String.valueOf(subTotal));

        holder.setOnClickListenerEliminarorden(detallesaPedido);



    }

    @Override
    public int getItemCount() {
        return listaDetallesOrdenes.size();
    }

    public static class DetallePedidoViewholder extends RecyclerView.ViewHolder{

        Context context;
        private ImageView imagendetalle,eliminarorden;
        private TextView idPlatoNombre,precioPlatounitario,cantidad,subtotal;


        private DetallePedidoViewholder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            imagendetalle = itemView.findViewById(R.id.image_view_plato_detalle);
            idPlatoNombre = itemView.findViewById(R.id.text_id_platodetalle);
            precioPlatounitario = itemView.findViewById(R.id.text_precio_unitario);
            cantidad = itemView.findViewById(R.id.text_cantidad_platos);
            subtotal = itemView.findViewById(R.id.text_subtotal_detalle);
            eliminarorden = itemView.findViewById(R.id.image_eliminar);
        }

        private void setOnClickListenerEliminarorden(final DetalleTemporal detalleTemporal){
            eliminarorden.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    OrdenTemporal.eliminarorden(detalleTemporal);

                }
            });
        }


    }
}
