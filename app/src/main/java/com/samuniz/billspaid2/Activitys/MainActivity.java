package com.samuniz.billspaid2.Activitys;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.samuniz.billspaid2.Entitys.Conta;
import com.samuniz.billspaid2.Entitys.Despesa;
import com.samuniz.billspaid2.Entitys.Receita;
import com.samuniz.billspaid2.R;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtContasM, txtDespesasM, txtReceitasM;
    private Button btnContaM, btnDespesaM, btnReceitaM;
    private AlertDialog aFormContas, aFormDespesas, aFormReceitas;
    private FirebaseAuth mmAuth;
    private FirebaseUser mmUser;
    private DatabaseReference mmReference, dbClientes, dbContas, dbDespesas, dbReceitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mmAuth = FirebaseAuth.getInstance();
        mmUser = mmAuth.getCurrentUser();
        mmReference = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void onResume() {
        super.onResume();

        txtContasM = findViewById(R.id.txtContasM);
        txtContasM.setOnClickListener(this);

        txtDespesasM = findViewById(R.id.txtDespesasM);
        txtDespesasM.setOnClickListener(this);

        txtReceitasM = findViewById(R.id.txtReceitasM);
        txtReceitasM.setOnClickListener(this);

        btnContaM = findViewById(R.id.btnContaM);
        btnContaM.setOnClickListener(this);

        btnDespesaM = findViewById(R.id.btnDespesaM);
        btnDespesaM.setOnClickListener(this);

        btnReceitaM = findViewById(R.id.btnReceitaM);
        btnReceitaM.setOnClickListener(this);

        //txtContasM.setText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtContasM:
                goToContasLista();
                break;
            case R.id.txtDespesasM:
                goToDespesasLista();
                break;
            case R.id.txtReceitasM:
                goToReceitasLista();
                break;
            case R.id.btnContaM:
                formNovaConta();
                break;
            case R.id.btnDespesaM:
                formNovaDespesa();
                break;
            case R.id.btnReceitaM:
                formNovaReceita();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goToLogin();
    }

    private void formNovaConta(){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.form_conta, null);
        dialogBuilder.setView(dialogView);

        final EditText edtDescricaoFormC = dialogView.findViewById(R.id.edtDescricaoFormC);
        final EditText edtValorFormC = dialogView.findViewById(R.id.edtValorFormC);
        Button btnSalvarFormC = dialogView.findViewById(R.id.btnSalvarFormC);

        aFormContas = dialogBuilder.create();
        aFormContas.show();

        btnSalvarFormC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = UUID.randomUUID().toString();
                String descricao = edtDescricaoFormC.getText().toString();
                String valor = edtValorFormC.getText().toString();

                if(!descricao.equals("") && !valor.equals("")){
                    Conta c = new Conta(id, descricao, valor);
                    dbContas = FirebaseDatabase.getInstance().getReference("contas");
                    dbContas.child(id).setValue(c);
                }else{
                    Toast.makeText(getApplicationContext(), "Preencha os campos.", Toast.LENGTH_SHORT).show();
                }
                aFormContas.dismiss();
            }
        });
    }

    private void formNovaDespesa(){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.form_despesa, null);
        dialogBuilder.setView(dialogView);

        final EditText edtDescricaoFormD = dialogView.findViewById(R.id.edtDescricaoFormD);
        final EditText edtValorFormD = dialogView.findViewById(R.id.edtValorFormD);
        Button btnSalvarFormD = dialogView.findViewById(R.id.btnSalvarFormD);

        aFormDespesas = dialogBuilder.create();
        aFormDespesas.show();

        btnSalvarFormD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = UUID.randomUUID().toString();
                String descricao = edtDescricaoFormD.getText().toString();
                String valor = edtValorFormD.getText().toString();

                if(!descricao.equals("") && !valor.equals("")){
                    Despesa d = new Despesa(id, descricao, valor);
                    dbDespesas = FirebaseDatabase.getInstance().getReference("despesas");
                    dbDespesas.child(id).setValue(d);
                }else{
                    Toast.makeText(getApplicationContext(), "Preencha os campos.", Toast.LENGTH_SHORT).show();
                }
                aFormDespesas.dismiss();
            }
        });
    }

    private void formNovaReceita(){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.form_receita, null);
        dialogBuilder.setView(dialogView);

        final EditText edtDescricaoFormR = dialogView.findViewById(R.id.edtDescricaoFormR);
        final EditText edtValorFormR = dialogView.findViewById(R.id.edtValorFormR);
        Button btnSalvarFormR = dialogView.findViewById(R.id.btnSalvarFormR);

        aFormReceitas = dialogBuilder.create();
        aFormReceitas.show();

        btnSalvarFormR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = UUID.randomUUID().toString();
                String descricao = edtDescricaoFormR.getText().toString();
                String valor = edtValorFormR.getText().toString();

                if(!descricao.equals("") && !valor.equals("")){
                    Receita r = new Receita(id, descricao, valor);
                    dbReceitas = FirebaseDatabase.getInstance().getReference("receitas");
                    dbReceitas.child(id).setValue(r);
                }else{
                    Toast.makeText(getApplicationContext(), "Preencha os campos.", Toast.LENGTH_SHORT).show();
                }
                aFormReceitas.dismiss();
            }
        });
    }

    private void goToContasLista(){
        Intent it = new Intent(getApplicationContext(), ContasActivity.class);
        startActivity(it);
        finish();
    }

    private void goToDespesasLista(){
        Intent it = new Intent(getApplicationContext(), DespesasActivity.class);
        startActivity(it);
        finish();
    }

    private void goToReceitasLista(){
        Intent it = new Intent(getApplicationContext(), ReceitasActivity.class);
        startActivity(it);
        finish();
    }

    private void goToLogin(){
        Intent it = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(it);
        finish();
    }
}
