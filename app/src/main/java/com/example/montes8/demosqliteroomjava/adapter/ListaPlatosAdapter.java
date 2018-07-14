package com.example.montes8.demosqliteroomjava.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.utils.DemoUtils;
import com.example.montes8.demosqliteroomjava.view.DetallePlatoActivity;

import java.util.ArrayList;

public class ListaPlatosAdapter extends RecyclerView.Adapter<ListaPlatosAdapter.PlatoViewholder>{

    Context context;

    public ListaPlatosAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Plato> listaPlatos;

    public void addList(ArrayList<Plato> listaPlatos){
        this.listaPlatos = listaPlatos;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PlatoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_molde_platos, parent, false);
        return new PlatoViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoViewholder holder, int position) {
        Plato plato = listaPlatos.get(position);

        holder.imagen.setImageDrawable(DemoUtils.getImage(context,plato.getImagen()));
        holder.nombre.setText(plato.getNombrePlato());
        holder.precio.setText(String.valueOf(plato.getPrecioPlto()));

        holder.setOnClickListenerDetalle(plato);


    }

    @Override
    public int getItemCount() {
            return listaPlatos.size();
    }

    public static class PlatoViewholder extends RecyclerView.ViewHolder{

        Context context;
        private ImageView imagen,agregarplato,detallePlato;
        private TextView nombre, precio;

        private PlatoViewholder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            imagen = itemView.findViewById(R.id.image_view_plato);
            nombre = itemView.findViewById(R.id.text_nombre_pletoitem);
            precio = itemView.findViewById(R.id.text_precio);
            agregarplato = itemView.findViewById(R.id.image_add);
            detallePlato = itemView.findViewById(R.id.image_detalles);
        }

        private void setOnClickListener(){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        private void setOnClickListenerDetalle(final Plato plato){
            detallePlato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,DetallePlatoActivity.class);
                    intent.putExtra("detalleplato",plato);
                    context.startActivity(intent);
                }
            });
        }
    }
}
