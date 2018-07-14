package com.example.montes8.demosqliteroomjava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.Plato;

public class DetallePlatoActivity extends AppCompatActivity {

    private ImageView imagen;
    private TextView precio,calorias,descuento,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);

        imagen = findViewById(R.id.image_detalles);
        precio = findViewById(R.id.text_precio_detalle);
        calorias = findViewById(R.id.text_calorias);
        descuento = findViewById(R.id.text_descuento);
        descripcion = findViewById(R.id.text_descripcion);



        Bundle extras = getIntent().getExtras();
        final Plato datosPlato = extras.getParcelable("detalleplato");
    }
}
