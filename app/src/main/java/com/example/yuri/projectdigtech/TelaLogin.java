package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        //Para usar os Extras que colocamos na classe anterior, devemos declarar outra intenção, mas pegando a que acabamos de usar pra chegar nesssa tela
        Intent intent = getIntent();//get intent pega a última instância conhecida de intenção
        String nomeUsuario = intent.getStringExtra("nomeuser");//aqui vc declara uma variável do msm tipo do segundo parâmetro do seu putExtra na classe anterior!
        //Agora vc pode usar o nomeUsuário que vc declarou na Activity anterior! Lembre-se de usar o tipo certo!
    }
}
