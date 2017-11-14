package com.samuniz.billspaid2.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samuniz.billspaid2.Entitys.Conta;
import com.samuniz.billspaid2.Entitys.Usuario;
import com.samuniz.billspaid2.R;
import com.samuniz.billspaid2.Util.SingletonFirebase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CriarContaActivity extends AppCompatActivity {

    private EditText editConta, editValor;
    private Button btnContaSalvar;
    private FirebaseAuth authUsuario;
    private FirebaseUser authUser;
    private DatabaseReference dbConta, dbUsuario;
    private ArrayList<String> listaContas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        authUsuario = SingletonFirebase.getAutenticacao();
        authUser = SingletonFirebase.getUser();
        dbConta = SingletonFirebase.getReferenciaFirebase(SingletonFirebase.DB_CONTAS);

        listaContas = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        editConta = findViewById(R.id.contaDesc);
        editValor = findViewById(R.id.contaValor);
        btnContaSalvar = findViewById(R.id.btnContaSalvar);

        btnContaSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String idConta = UUID.randomUUID().toString();
                String nomeConta = editConta.getText().toString();
                String valorConta = editValor.getText().toString();

                if(!nomeConta.equals("") && !valorConta.equals("")){
                    cadastroConta(idConta, nomeConta, valorConta);
                }else{
                    Toast.makeText(CriarContaActivity.this, "Preencha os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cadastroConta(final String id, final String descricao, final String valor){

        Conta conta = new Conta(id, descricao, valor);
        dbConta.child(conta.getIdConta()).setValue(conta);
        listaContas.add(conta.getIdConta());

        Usuario usu = new Usuario();
        final List<List<String>> list = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(SingletonFirebase.DB_USUARIOS);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Usuario u = snapshot.getValue(Usuario.class);
                    list.add(u.getListaContas());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        for(int i = 0; i < list.size(); i++){
            listaContas.add(String.valueOf(i));
        }


        DatabaseReference refForAtributos = FirebaseDatabase.getInstance().getReference(SingletonFirebase.DB_USUARIOS);
        refForAtributos.child(authUser.getUid()).child("listaContas").setValue(listaContas);

        limparCampos();
    }

    private void goToMainActivity(){
        Intent it = new Intent(CriarContaActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }

    private void limparCampos(){
        editConta.setText("");
        editValor.setText("");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*DatabaseReference ref = FirebaseDatabase.getInstance().getReference(SingletonFirebase.DB_USUARIOS);
        ref.child(authUser.getUid()).child("listaContas").setValue(listaContas);*/
        goToMainActivity();
    }
}
