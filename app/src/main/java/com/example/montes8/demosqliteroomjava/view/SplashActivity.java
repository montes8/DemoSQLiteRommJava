package com.example.montes8.demosqliteroomjava.view;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.montes8.demosqliteroomjava.R;

public class SplashActivity extends AppCompatActivity {

    LinearLayout once,doce;
    Animation arriba,abajo;

    private final int SPLASH_DISPLAY_LENGTH = 3 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        once =(LinearLayout) findViewById(R.id.once);
        doce = (LinearLayout) findViewById(R.id.doce);

        arriba = AnimationUtils.loadAnimation(this,R.anim.animacion);
        abajo = AnimationUtils.loadAnimation(this,R.anim.animacion_botton);

        once.setAnimation(arriba);
        doce.setAnimation(abajo);

     Thread splash = new Thread(){

         public void run (){

             try{

                 sleep(SPLASH_DISPLAY_LENGTH);
                 Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                 startActivity(mainIntent);
                 finish();
                 } catch (Exception e){
                 e.printStackTrace();
             }
         }

         };
     splash.start();

    }
}
