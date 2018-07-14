package com.example.montes8.demosqliteroomjava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.Plato;
import com.example.montes8.demosqliteroomjava.utils.DemoUtils;

public class DetallePlatoActivity extends AppCompatActivity {

    private ImageView imagen;
    private TextView precio,calorias,descuento,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);

        imagen = findViewById(R.id.image_plato);
        precio = findViewById(R.id.text_precio_detalle);
        calorias = findViewById(R.id.text_calorias);
        descuento = findViewById(R.id.text_descuento);
        descripcion = findViewById(R.id.text_descripcion);



        Bundle extras = getIntent().getExtras();
        final Plato datosPlato = extras.getParcelable("detalleplato");

        imagen.setImageDrawable(DemoUtils.getImage(this,datosPlato.getImagen()));
        precio.setText(String.valueOf(datosPlato.getPrecioPlto()));
        calorias.setText(datosPlato.getCalorias());
        descuento.setText(String.valueOf(datosPlato.getDescuento()));
        descripcion.setText(datosPlato.getDescripcion());

        Toolbar toolbardetalle = (Toolbar) findViewById(R.id.detalleToolbar);
        setSupportActionBar(toolbardetalle);
        getSupportActionBar().setTitle(datosPlato.getNombrePlato());
        toolbardetalle.setNavigationIcon(R.drawable.ic_atras);
        toolbardetalle.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
