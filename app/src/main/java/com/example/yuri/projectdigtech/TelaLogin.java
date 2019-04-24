package com.example.yuri.projectdigtech;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class TelaLogin extends AppCompatActivity {


    private EditText email;
    private EditText senha;
    private Button btnlogin;
    private int contador = 5;
    private TextView forgotpassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);


        email = (EditText)findViewById(R.id.email);
        senha = (EditText)findViewById(R.id.senha);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        forgotpassword = (TextView)findViewById(R.id.tvEsqueceuSenha);

        progressDialog = ProgressDialog.show(this, "", "Carregando");
        progressDialog.dismiss();
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            finish();
            startActivity(new Intent(TelaLogin.this, TelaPrincipal.class));
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText() .toString().isEmpty() || senha.getText() .toString().isEmpty()){
                    email.setError("Digite seu Email");
                    senha.setError("Digite sua Senha");
                    AlertDialog.Builder builder = new AlertDialog.Builder(TelaLogin.this);

                    builder.setTitle("AVISO");

                    builder.setMessage("Por favor, preencha todos os campos antes de continuar!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    validate(email.getText().toString(), senha.getText().toString());
                    progressDialog.show();
                }
            }
        });


        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (TelaLogin.this, TelaReSenha.class));
            }
        });

    }

        private void validate (String email, String senha){


            firebaseAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        startActivity(new Intent(TelaLogin.this, TelaPrincipal.class));
                        Toast.makeText(TelaLogin.this, "Ebaaa, Logado com sucesso!", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(TelaLogin.this, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();
                        contador--;
                        if(contador==0){
                            btnlogin.setEnabled(false);
                            btnlogin.setText("Não autorizado");
                        }

                    }
                }
            });
    }
}