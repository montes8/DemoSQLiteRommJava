package com.example.montes8.demosqliteroomjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {

    LinearLayout once,doce;
    Animation arriba,abajo;

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


    }
}
