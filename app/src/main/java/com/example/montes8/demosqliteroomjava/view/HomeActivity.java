package com.example.montes8.demosqliteroomjava.view;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.adapter.ListaPlatosAdapter;
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
