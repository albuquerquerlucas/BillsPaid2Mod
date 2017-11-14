package com.samuniz.billspaid2.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.samuniz.billspaid2.Entitys.Conta;
import com.samuniz.billspaid2.Entitys.Usuario;
import com.samuniz.billspaid2.R;
import com.samuniz.billspaid2.Util.SingletonFirebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastroActivity extends AppCompatActivity {

    private EditText editUsuario, editEmail, editSenha;
    private Button btnCadastroLogin, btnCadastroSalvar;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private DatabaseReference bdReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mAuth = SingletonFirebase.getAutenticacao();
        user = SingletonFirebase.getUser();
        bdReference = SingletonFirebase.getReferenciaFirebase(SingletonFirebase.DB_USUARIOS);
    }

    @Override
    protected void onStart() {
        super.onStart();

        editUsuario = findViewById(R.id.cadUsuario);
        editEmail = findViewById(R.id.cadEmail);
        editSenha = findViewById(R.id.cadSenha);
        btnCadastroLogin = findViewById(R.id.btnCadastroLogin);
        btnCadastroSalvar = findViewById(R.id.btnCadastroSalvar);

        btnCadastroLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroLogin();
            }
        });

        btnCadastroSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String usuario = editUsuario.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();

                if(usuario.equals("")){
                    editUsuario.setError("Preencher este campo!");
                    editUsuario.requestFocus();
                    return;
                }
                if(email.equals("")){
                    editEmail.setError("Preencher este campo!");
                    editEmail.requestFocus();
                    return;
                }
                if(senha.equals("")){
                    editSenha.setError("Preencher este campo!");
                    editSenha.requestFocus();
                    return;
                }
                cadastroSalvar(usuario, email, senha);
            }
        });
    }

    private void cadastroSalvar(final String usuario, final String email, final String senha){


        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            List<String> lista = new ArrayList<>();
                            Usuario usu = new Usuario(user.getUid(), usuario, email, senha, lista);
                            bdReference.child(user.getUid()).setValue(usu);
                            cadastroLogin();

                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e){
                                editSenha.setError("Senha fraca!");
                                editSenha.requestFocus();
                            } catch (FirebaseAuthInvalidCredentialsException e){
                                editEmail.setError("E-mail inválido!");
                                editEmail.requestFocus();
                            } catch (FirebaseAuthUserCollisionException e){
                                editEmail.setError("E-mail já existe!");
                                editEmail.requestFocus();
                            } catch (Exception e){
                                Log.e("Cadastro", e.getMessage());
                            }
                        }
                    }
                });
    }

    private void cadastroLogin (){
        Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cadastroLogin ();
    }
}
