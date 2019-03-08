package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class TelaPrincipal extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        firebaseAuth = FirebaseAuth.getInstance();

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
