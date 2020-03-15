package com.example.mads.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mads.R;

public class SplashActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssplash);

        textView=(TextView) findViewById(R.id.stv);
        imageView=(ImageView) findViewById(R.id.spi);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        textView.startAnimation(myanim);
        imageView.startAnimation(myanim);
       final Intent i = new Intent(this,LoginActivity.class);

        Thread timer = new Thread(){
            public void run () {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    startActivity(i);
                    finish();

                }
            }
        };
        timer.start();

    }
}
