package com.example.montes8.demosqliteroomjava.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.adapter.ListaPlatosAdapter;
import com.example.montes8.demosqliteroomjava.model.DetallePedido;
import com.example.montes8.demosqliteroomjava.model.Plato;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListaPlatosAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.my_recyclerview);

        ajustarToolbarHome();

        recyclerView = findViewById(R.id.my_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ListaPlatosAdapter(this);

        HiloListarPlatos lista = new HiloListarPlatos();
        lista.execute();

        }

    public void ajustarToolbarHome(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lista de Platos");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_orden:
                Intent intentorden = new Intent(HomeActivity.this,DetallePedido.class);
                startActivity(intentorden);
               break;
            case  R.id.historial:
                Intent intenthistorial = new Intent(HomeActivity.this,HistorialActivity.class);
                startActivity(intenthistorial);
                break;
            case R.id.salir:
                Intent intentsalir = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intentsalir);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    public class HiloListarPlatos extends AsyncTask<Void,Integer,ArrayList<Plato>> {

        @Override
        protected ArrayList<Plato> doInBackground(Void... voids) {


            ArrayList<Plato>  lista = (ArrayList<Plato>) DemoApplication.dataBase.platoDao().listarPlatos();
            return lista;
        }

        @Override
        protected void onPostExecute(ArrayList<Plato> platos) {
            super.onPostExecute(platos);
            if (platos != null){

                mAdapter.addList(platos);
                recyclerView.setAdapter(mAdapter);
            }else{
                Toast.makeText(HomeActivity.this,"No hay lista",Toast.LENGTH_SHORT).show();

            }
        }
    }


}
