package com.example.montes8.demosqliteroomjava.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

public class DemoUtils {

    public static Drawable getImage(Context c,String imageName){
        int id = c.getResources().getIdentifier(imageName,"drawable",c.getPackageName());
        if(id != 0){
            return ContextCompat.getDrawable(c, id);
        }
        return null;
    }
}
