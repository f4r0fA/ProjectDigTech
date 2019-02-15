package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class TelaInicial extends AppCompatActivity {

    private ImageView logo;
    private TextView versao;
    private ProgressBar ldg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        logo = (ImageView) findViewById(R.id.logo) ;
        versao = (TextView) findViewById(R.id.versao) ;
        ldg = (ProgressBar) findViewById(R.id.ldg) ;

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.transicao) ;
        logo.startAnimation(myanim);
        versao.startAnimation(myanim);
        ldg.startAnimation(myanim);

        final Intent i = new Intent(this,TelaLogin.class);
        final Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
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
