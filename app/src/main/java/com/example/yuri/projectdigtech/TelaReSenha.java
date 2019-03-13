package com.example.yuri.projectdigtech;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class TelaReSenha extends AppCompatActivity {

    private EditText SenhaEmail;
    private Button ResetSenha;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);

        SenhaEmail = (EditText) findViewById(R.id.etSenhaEmail);
        ResetSenha = (Button) findViewById(R.id.btResetSenha);
        firebaseAuth = FirebaseAuth.getInstance();

        ResetSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail = SenhaEmail.getText().toString().trim();

                if(useremail.equals("")){
                    Toast.makeText(TelaReSenha.this, "Entre com um email.", Toast.LENGTH_SHORT).show() ;
                }else{
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(TelaReSenha.this, "Email enviado para o endereço correspondente", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(TelaReSenha.this, TelaLogin.class));
                            }else{
                                Toast.makeText(TelaReSenha.this, "Entre com um endereço valido", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}
