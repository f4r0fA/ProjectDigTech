package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        //aqui dentro as coisas acontecem antes da tela aparecer
        try {
            Thread.sleep(5000);
            Intent myIntent = new Intent(TelaInicial.this, TelaLogin.class);
            myIntent.putExtra("login", "telalogin");
            TelaInicial.this.startActivity(myIntent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
