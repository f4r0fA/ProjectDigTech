package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela_BemVindo extends AppCompatActivity {

    private Button btncadastrar01;
    private Button btnloggin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__bem_vindo);

        btncadastrar01 = (Button)findViewById(R.id.btncadastrar01);
        btnloggin = (Button)findViewById(R.id.btnloggin);

        btnloggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tela_BemVindo.this, TelaLogin.class));
            }
        });
        btncadastrar01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tela_BemVindo.this, TelaRegistro.class));
            }
        });
    }
}
