package com.example.montes8.demosqliteroomjava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.model.Plato;

public class HistorialPedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_pedido);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        final Pedido datosPedido = extras.getParcelable("historialpedido");
    }
}
