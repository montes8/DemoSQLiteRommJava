package com.example.montes8.demosqliteroomjava.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.Usuario;

public class RegistrarActivity extends AppCompatActivity {

    EditText nombre,nomdreusuario,contrasenia,pais;
    Button registar;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        ajustarToolbarHome();

        nombre = findViewById(R.id.edit_text_nombre);
        nomdreusuario = findViewById(R.id.edit_text_user);
        contrasenia = findViewById(R.id.edit_password);
        pais = findViewById(R.id.edit_pais);
        registar = findViewById(R.id.button_click_register);

        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarusuario();
            }
        });


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

    public void registrarusuario(){

        Thread hiloRegister = new Thread(new Runnable() {
            @Override
            public void run() {

                Usuario usuario = new Usuario(nombre.getText().toString(), nomdreusuario.getText().toString(), contrasenia.getText().toString(), pais.getText().toString());
                Long nuevoId = DemoApplication.dataBase.usuarioDao().insertarUsuario(usuario);
                SharedPreferences sharedPreferences = getSharedPreferences("idUsuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putLong("idUsu",nuevoId);
                Intent intent = new Intent(RegistrarActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegistrarActivity.this,"Usuario Registrado",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }) ;

        hiloRegister.start();

    }


}
