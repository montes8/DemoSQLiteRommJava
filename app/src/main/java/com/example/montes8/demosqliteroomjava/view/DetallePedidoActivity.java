package com.example.montes8.demosqliteroomjava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.adapter.DetalleAdapter;
import com.example.montes8.demosqliteroomjava.adapter.ListaPlatosAdapter;
import com.example.montes8.demosqliteroomjava.model.DetalleTemporal;
import com.example.montes8.demosqliteroomjava.repository.temporal.OrdenTemporal;

import java.util.ArrayList;

public class DetallePedidoActivity extends AppCompatActivity {

    RecyclerView detalleRecyclerView;
    DetalleAdapter detalleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pedido);
        detalleRecyclerView = findViewById(R.id.pedidoToolbar);
        detalleRecyclerView = findViewById(R.id.my_recyclerview);
        detalleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        detalleAdapter = new DetalleAdapter(this);

        ArrayList<DetalleTemporal> lista = OrdenTemporal.optenerorden();

        detalleAdapter.addList(lista);
        detalleRecyclerView.setAdapter(detalleAdapter);

    }
}
