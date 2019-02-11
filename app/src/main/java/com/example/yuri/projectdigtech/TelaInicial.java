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
            //Aqui a gente declara a itenção de interação entre duas classes! sempre use os parâmetros (classeatual.this, outraclasse.class)
            Intent myIntent = new Intent(TelaInicial.this, TelaLogin.class);

            //O putExtra serve para passar valores de uma tela para outra, no geral, ele é opcional
            myIntent.putExtra("nomeuser", "Yuri Fernandes Gomes"); //Lembre se do tipo do segundo parâmetro, nesse caso, String

            //Esse comando inicia a atividade, usando nossa intenção como parâmetro e passando quaisquer varáveis para a outra classa
            TelaInicial.this.startActivity(myIntent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
