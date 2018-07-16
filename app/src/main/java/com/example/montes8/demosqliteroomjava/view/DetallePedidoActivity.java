package com.example.montes8.demosqliteroomjava.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.adapter.DetalleAdapter;
import com.example.montes8.demosqliteroomjava.model.DetalleTemporal;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.repository.temporal.OrdenTemporal;


import java.util.ArrayList;
import java.util.Calendar;

public class DetallePedidoActivity extends AppCompatActivity {

    RecyclerView detalleRecyclerView;
    DetalleAdapter detalleAdapter;
    Toolbar toolbarpedido;
    TextView totalPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pedido);
        detalleRecyclerView = findViewById(R.id.pedido_recyclerview);
        toolbarpedido = (Toolbar) findViewById(R.id.pedidoToolbar);
        totalPagar = findViewById(R.id.text_subtotal_ordenes);

        ajustarToolbardetallepedido();
        opteniendoTotal();

        pedidoRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void ajustarToolbardetallepedido(){

        setSupportActionBar(toolbarpedido);
        getSupportActionBar().setTitle("Detalle de Ordenes");
        toolbarpedido.setNavigationIcon(R.drawable.ic_atras);
        toolbarpedido.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void pedidoRecyclerView(){
        detalleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        detalleAdapter = new DetalleAdapter(this);

        refrescarListaDetalle();

    }

    private void refrescarListaDetalle(){

        ArrayList<DetalleTemporal> orden = OrdenTemporal.optenerorden();
        detalleAdapter.addList(orden);
        detalleRecyclerView.setAdapter(detalleAdapter);
    }

    private void opteniendoTotal(){
        ArrayList<DetalleTemporal> ordenTotal = OrdenTemporal.optenerorden();
        Double total = 0.00;
        for (DetalleTemporal x:ordenTotal) {
            total = total + x.getPlato().getPrecioPlto()*x.getCantidad();
            }
        totalPagar.setText(String.valueOf(total));
    }

    private String mostrarFechaIngresoOrden(){

        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH);
        int mess = mes-1;
        int anio = c.get(Calendar.YEAR);
        String fecha = dia+"/"+mess+"/"+anio;

        return fecha;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_orden,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_ordenar_pedido:

                break;


        }
        return super.onOptionsItemSelected(item);
    }

    public class HiloIngresarDetalleEndPedido extends AsyncTask<Void,Integer,Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            String fecha = mostrarFechaIngresoOrden();
            SharedPreferences sharedPreferences = getSharedPreferences("idUsuario", Context.MODE_PRIVATE);
            Long idusuario = sharedPreferences.getLong("clave",0);
            Pedido pedido = new Pedido(idusuario,fecha,Double.parseDouble(String.valueOf(totalPagar)));

            
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}
