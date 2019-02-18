package com.example.yuri.projectdigtech;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {


    private EditText nome;
    private EditText senha;
    private TextView tvinfo;
    private Button btnlogin;
    private int contador = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);


        nome = (EditText)findViewById(R.id.nome);
        senha = (EditText)findViewById(R.id.senha);
        tvinfo = (TextView)findViewById(R.id.tvInfo);
        btnlogin = (Button)findViewById(R.id.btnlogin);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(nome.getText() .toString(), senha.getText() .toString());
            }
        });
    }

        private void validate (String usuario, String senha){
        if ((usuario.equals("DigTech")) && (senha.equals("tecnico"))){
            Intent intent = new Intent(TelaLogin.this, TelaPrincipal.class);
            startActivity(intent);
        }else{
            contador--;

            tvinfo.setText("Tentativas Restantes: " + String.valueOf(contador));

            if (contador == 0){
                btnlogin.setEnabled(false);
                tvinfo.setText("Por motivos de segurança, tente novamente mais tarde");
            }
        }
        }


}
