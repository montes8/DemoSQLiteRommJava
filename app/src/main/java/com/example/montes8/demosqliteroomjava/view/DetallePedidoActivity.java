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
import com.example.montes8.demosqliteroomjava.model.DetallePedido;
import com.example.montes8.demosqliteroomjava.model.DetalleTemporal;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.repository.temporal.OrdenTemporal;
import com.example.montes8.demosqliteroomjava.repository.temporal.Singleton;


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

                HiloIngresarDetalleEndPedido pedido = new HiloIngresarDetalleEndPedido();
                pedido.execute();

                break;


        }
        return super.onOptionsItemSelected(item);
    }

    public class HiloIngresarDetalleEndPedido extends AsyncTask<Void,Integer,Long> {


        @Override
        protected Long doInBackground(Void... voids) {

            String fecha = mostrarFechaIngresoOrden();
            SharedPreferences sharedPreferences = getSharedPreferences("idUsuario", Context.MODE_PRIVATE);
            Long idusuario = sharedPreferences.getLong("idUsu",0);
            Long a = 0L;
            ArrayList<DetalleTemporal> ordenTotal = OrdenTemporal.optenerorden();
            Double total = 0.00;
            for (DetalleTemporal x:ordenTotal) {
                total = total + x.getPlato().getPrecioPlto()*x.getCantidad();
            }

            Pedido pedido = new Pedido(idusuario,fecha,total);
            Long nuevoIdPedido = DemoApplication.dataBase.pedidoDao().insertPedido(pedido);

            ArrayList<DetalleTemporal> detalleOrden = OrdenTemporal.optenerorden();
            for (DetalleTemporal x:detalleOrden) {

                Double subtotal= x.getPlato().getPrecioPlto()*x.getCantidad();
                DetallePedido detallePedido = new DetallePedido(nuevoIdPedido,x.getPlato().getIdPlato(),x.getCantidad(),subtotal);

                 a= DemoApplication.dataBase.detallePedidoDao().insertarDetallepedido(detallePedido);
            }

         return a;
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);

            if (aLong>0){

                Toast.makeText(DetallePedidoActivity.this,"Su orden fue registrada",Toast.LENGTH_SHORT).show();
                finish();
                OrdenTemporal.limpiarOrden();
            }else{
                Toast.makeText(DetallePedidoActivity.this,"Ocurrio un Error",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
