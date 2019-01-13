package com.example.montes8.demosqliteroomjava.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.DetalleTemporal;
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.repository.temporal.OrdenTemporal;
import com.example.montes8.demosqliteroomjava.utils.DemoUtils;
import com.example.montes8.demosqliteroomjava.view.DetallePlatoActivity;
import com.example.montes8.demosqliteroomjava.view.LoginActivity;

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

        holder.setOnClickListener(plato);

        holder.setOnClickAgregarOrden(plato);
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

        private void setOnClickListener(final Plato plato){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                   final  View dialogView = View.inflate(context,R.layout.dialog_cantidad,null);

                    TextView nombrePlato = dialogView.findViewById(R.id.nombre_plato_dialog);
                    TextView precioPlato = dialogView.findViewById(R.id.precio_plato_dialog);
                    final EditText cantidad = dialogView.findViewById(R.id.cantidad_plato_dialog);
                    Button agregarPlato = dialogView.findViewById(R.id.btnagregar_orden_dialog);

                    dialogBuilder.setView(dialogView);
                    dialogBuilder.setCancelable(true);

                    nombrePlato.setText(plato.getNombrePlato());
                    precioPlato.setText("$/ "+plato.getPrecioPlto().toString());

                    final Dialog dialog = dialogBuilder.create();
                    agregarPlato.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(!cantidad.getText().toString().isEmpty()){
                                Toast.makeText(context,"orden agregada",Toast.LENGTH_SHORT).show();
                                int cantidadPlatoOrden = Integer.parseInt(cantidad.getText().toString());


                                agregarOrActulizarItemorde(plato, cantidadPlatoOrden);

                                dialog.dismiss();
                            }else{

                                Toast.makeText(context,"Ingrese Cantidad",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    dialog.show();
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

        private void setOnClickAgregarOrden(final Plato plato){

            agregarplato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    agregarOrActulizarItemorde(plato,1);
                    Toast.makeText(context,"orden agregada",Toast.LENGTH_SHORT).show();
                }
            });


        }

        private static void agregarOrActulizarItemorde(Plato plato,int cantidad){
            int indicePlatoSiExiste = OrdenTemporal.buscarplato(plato);
            OrdenTemporal orden = OrdenTemporal.getInstance();
            if (indicePlatoSiExiste >= 0){

                int catidadActual = orden.optenerCantidadPlatoSegunIdice(indicePlatoSiExiste);
                //int catidadActual = OrdenTemporal.optenerCantidadPlatoSegunIdice(indicePlatoSiExiste);

                int totalCantidad = catidadActual + cantidad;
                DetalleTemporal pedidoActulizado = new DetalleTemporal(plato,totalCantidad);
                 orden.actualizarItemOrden(pedidoActulizado,indicePlatoSiExiste);
                //OrdenTemporal.actualizarItemOrden(pedidoActulizado,indicePlatoSiExiste);
            }else{
                DetalleTemporal nuevaOrden = new DetalleTemporal(plato,cantidad);
                orden.agregaItemOrden(nuevaOrden);
                //OrdenTemporal.agregaItemOrden(nuevaOrden);

            }
        }
    }
}
