package com.example.montes8.demosqliteroomjava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.model.Plato;

public class HistorialPedidoActivity extends AppCompatActivity {

    Toolbar toolbarhistorialpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_pedido);
        toolbarhistorialpedido = (Toolbar) findViewById(R.id.historialToolbar);
        ajustarToolbarhistorialpedido();

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        final Pedido datosPedido = extras.getParcelable("historialpedido");
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
