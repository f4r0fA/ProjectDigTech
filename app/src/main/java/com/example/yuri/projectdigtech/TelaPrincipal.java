package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class TelaPrincipal extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    //-----------------------------

    private GridLayout mainGrid;
    private ImageView lanche;
    private ImageView bebidas;
    private ImageView pratos;
    private ImageView sorvetes;

    //-----------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        firebaseAuth = FirebaseAuth.getInstance();
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        bebidas = (ImageView)findViewById(R.id.bebidas);
        lanche = (ImageView)findViewById(R.id.lanche);
        pratos = (ImageView)findViewById(R.id.pratos);
        sorvetes = (ImageView)findViewById(R.id.sorvetes);


        bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(TelaPrincipal.this, TelaBebidas.class));
            }
        });
        lanche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent (TelaPrincipal.this, TelaLanche.class));
            }
         });
        sorvetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(TelaPrincipal.this, TelaSorvetes.class));
            }
        });
        pratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaPrincipal.this, TelaPratos.class));
            }
        });

}
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(TelaPrincipal.this, TelaLogin.class));
            }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.LogoutMenu:
            Logout();
        }
        return super.onOptionsItemSelected(item);
    }

}
