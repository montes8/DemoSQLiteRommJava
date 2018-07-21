package com.example.montes8.demosqliteroomjava.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.adapter.HistorialAdapter;
import com.example.montes8.demosqliteroomjava.adapter.ListaPlatosAdapter;
import com.example.montes8.demosqliteroomjava.model.Pedido;
import com.example.montes8.demosqliteroomjava.model.Plato;

import java.util.ArrayList;

public class HistorialActivity extends AppCompatActivity {

    RecyclerView historialRecyclerView;
    HistorialAdapter historialAdapter;
    Toolbar toolbarHistorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        toolbarHistorial = findViewById(R.id.historialprincipalToolbar);
        historialRecyclerView = findViewById(R.id.principalh_recyclerview);
        ajustarToolbardetallehistorial();

        historialRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        historialAdapter = new HistorialAdapter();
        HiloListarPedidos pedidos = new HiloListarPedidos();
        pedidos.execute();
    }

    private void ajustarToolbardetallehistorial(){

        setSupportActionBar(toolbarHistorial);
        getSupportActionBar().setTitle("Pedidos");
        toolbarHistorial.setNavigationIcon(R.drawable.ic_atras);
        toolbarHistorial.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    public class HiloListarPedidos extends AsyncTask<Void,Integer,ArrayList<Pedido>> {

        @Override
        protected ArrayList<Pedido> doInBackground(Void... voids) {
            SharedPreferences sharedPreferences = getSharedPreferences("idUsuario", Context.MODE_PRIVATE);
            Long idusuario = sharedPreferences.getLong("idUsu",0);


            ArrayList<Pedido>  lista = (ArrayList<Pedido>) DemoApplication.dataBase.pedidoDao().verpedidoSegunUsuario(idusuario);
            return lista;
        }

        @Override
        protected void onPostExecute(ArrayList<Pedido> pedidos) {
            super.onPostExecute(pedidos);
            if (pedidos != null){

                historialAdapter.addList(pedidos);
                historialRecyclerView.setAdapter(historialAdapter);
            }else{
                Toast.makeText(HistorialActivity.this,"No hay lista",Toast.LENGTH_SHORT).show();

            }
        }
    }
}
