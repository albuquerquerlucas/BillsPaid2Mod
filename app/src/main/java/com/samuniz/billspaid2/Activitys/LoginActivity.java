package com.samuniz.billspaid2.Activitys;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.samuniz.billspaid2.R;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editEmail;
    private EditText editSenha;
    private Button btnlogin, btnSalvarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        editEmail = findViewById(R.id.campoEmail);
        editSenha = findViewById(R.id.campoSenha);
        btnlogin = findViewById(R.id.btnLogin);
        btnSalvarLogin = findViewById(R.id.btnCadastroSalvar);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btnSalvarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastro();
            }
        });
    }

    private void updateUI(FirebaseUser user){
        if (user != null){
            //Passar para outra tela.
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    private void login(){
        String email = editEmail.getText().toString().trim();
        String senha = editSenha.getText().toString().trim();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (email.equals("")){
            editEmail.setError("Preencha este campo");
            return;
        }
        if (senha.equals("")){
            editSenha.setError("Preencha este campo");
            return;
        }

        mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    updateUI(mAuth.getCurrentUser());
                } else {
                    Toast.makeText(LoginActivity.this, "Usuário ou senha incorreta!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cadastro(){
        Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
