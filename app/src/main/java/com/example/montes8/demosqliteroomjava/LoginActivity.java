package com.example.montes8.demosqliteroomjava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView registarteTextView = (TextView) findViewById(R.id.tvRegistrate);


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
}
