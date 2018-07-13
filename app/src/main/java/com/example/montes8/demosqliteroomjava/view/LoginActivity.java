package com.example.montes8.demosqliteroomjava.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.montes8.demosqliteroomjava.DemoApplication;
import com.example.montes8.demosqliteroomjava.R;
import com.example.montes8.demosqliteroomjava.model.Usuario;


public class LoginActivity extends AppCompatActivity {

    EditText nombre,contasenia;
    Button logearle;
    TextView registarteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registarteTextView = (TextView) findViewById(R.id.tvRegistrate);
        nombre = findViewById(R.id.edit_nombre_login);
        contasenia = findViewById(R.id.edit_password_login);
        logearle = findViewById(R.id.button_login);

       ajusteTextRegister();

       logearle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               LoginAsyntask login = new LoginAsyntask();
               login.execute();
           }
       });

    }

    public void ajusteTextRegister(){
        String string =getString(R.string.registrate);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(LoginActivity.this, RegistrarActivity.class));
            }
        };
        spannableStringBuilder.setSpan(boldSpan,13,string.length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(clickableSpan, 13, string.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        registarteTextView.setText(spannableStringBuilder);
        registarteTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private class LoginAsyntask extends AsyncTask<Void,Integer,Usuario>{

        @Override
        protected Usuario doInBackground(Void... voids) {

            Usuario usuario = DemoApplication.dataBase.usuarioDao().userLOgin(nombre.getText().toString(),contasenia.getText().toString());
            return usuario;
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            super.onPostExecute(usuario);
            if (usuario != null){
                Toast.makeText(LoginActivity.this,"Bienvenida"+usuario.getNombre(),Toast.LENGTH_SHORT).show();
                Intent inten = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(inten);
            }else{

                Toast.makeText(LoginActivity.this,"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
