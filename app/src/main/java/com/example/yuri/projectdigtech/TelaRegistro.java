package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.*;

public class TelaRegistro extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etuseremail;
    private EditText etSenha;
    private EditText etConfirmaSenha;
    private FirebaseAuth firebaseAuth;
    private Button btnregistrar;
    private TextView userloggin;
    private ImageView logoregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registro);
        setupUIViews();

        firebaseAuth = firebaseAuth.getInstance();
        logoregister = (ImageView) (findViewById(R.id.logoregistro));

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String user_email = etuseremail.getText().toString().trim();
                    String user_senha = etSenha.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(TelaRegistro.this, "Ficamos felizes em ter você por aqui!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(TelaRegistro.this, TelaLogin.class));
                            }else{
                                Toast.makeText(TelaRegistro.this, "Aaah não :( Usuário ja cadastrado.", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });

        userloggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaRegistro.this, TelaLogin.class));
            }
        });


    }

    private void setupUIViews(){

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText)findViewById(R.id.etSenha);
        etConfirmaSenha = (EditText)findViewById(R.id.etConfirmasenha);
        etuseremail = (EditText)findViewById(R.id.etuseremail);
        btnregistrar = (Button)findViewById(R.id.btnregistrar);
        userloggin = (TextView)findViewById(R.id.userloggin) ;



    }

    private Boolean validate(){
        Boolean result = false;

        String nome = etUsuario.getText().toString();
        String senha = etSenha.getText().toString();
        String cosenha = etConfirmaSenha.getText().toString();
        String email = etuseremail.getText().toString();

        if(nome.isEmpty() || senha.isEmpty() || cosenha.isEmpty() || email.isEmpty()){
            makeText(TelaRegistro.this,"Nada de gracinhas, introduza seus dados corretamente.", LENGTH_LONG).show();
        }else{
            result = true;
        }
        return result;
    }


}
