package com.example.montes8.demosqliteroomjava.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.adapter.DetalleAdapter;
import com.example.montes8.demosqliteroomjava.adapter.HistorialPedidoAdapter;
import com.example.montes8.demosqliteroomjava.model.DetallePedido;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.model.Usuario;

import java.util.ArrayList;

public class HistorialPedidoActivity extends AppCompatActivity {

    Toolbar toolbarhistorialpedido;
    HistorialPedidoAdapter historialAdapter ;
    Handler handler = new Handler();
    RecyclerView historial_recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_pedido);
        toolbarhistorialpedido = (Toolbar) findViewById(R.id.historialToolbar);
        historial_recyclerview = findViewById(R.id.historial_recyclerview);


        ajustarToolbarhistorialpedido();

        Bundle extras = getIntent().getExtras();
        final Pedido datosPedido = extras.getParcelable("historialpedido");

        historial_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        historialAdapter = new HistorialPedidoAdapter(this);
        Thread hiloAgragarLista = new Thread(new Runnable() {
            @Override
            public void run() {

         final ArrayList<DetallePedido> lista = (ArrayList<DetallePedido>) DemoApplication.dataBase.detallePedidoDao()
                                                 .listarDetallePedidoId(datosPedido.getIdPedido());

         runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        historialAdapter.addList(lista);
                        historial_recyclerview.setAdapter(historialAdapter);
                    }
                });

            }
        }) ;

        hiloAgragarLista.start();



    }

    private void ajustarToolbarhistorialpedido(){

        setSupportActionBar(toolbarhistorialpedido);
        getSupportActionBar().setTitle("Detalle de Pedidos");
        toolbarhistorialpedido.setNavigationIcon(R.drawable.ic_atras);
        toolbarhistorialpedido.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
