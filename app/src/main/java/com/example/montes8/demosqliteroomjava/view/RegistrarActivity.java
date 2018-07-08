package com.example.montes8.demosqliteroomjava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.montes8.demosqliteroomjava.R;

public class RegistrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        ajustarToolbarHome();
        


    }

    public void ajustarToolbarHome(){


        Toolbar toolbars = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(toolbars);
        getSupportActionBar().setTitle("Guardar de Productos");
        toolbars.setNavigationIcon(R.drawable.ic_atras);
        toolbars.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
