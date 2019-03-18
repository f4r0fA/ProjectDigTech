package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class TelaPrincipal extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    //-----------------------------
    private ImageButton lanche;
    private ImageButton bebidas;
    private ImageButton pratos;
    private ImageButton sorvetes;

    //-----------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        firebaseAuth = FirebaseAuth.getInstance();

        bebidas = (ImageButton)findViewById(R.id.bebidas);
        lanche = (ImageButton)findViewById(R.id.lanche);
        pratos = (ImageButton)findViewById(R.id.pratos);
        sorvetes = (ImageButton)findViewById(R.id.sorvetes);


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
