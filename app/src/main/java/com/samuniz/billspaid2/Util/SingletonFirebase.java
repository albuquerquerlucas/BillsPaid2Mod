package com.samuniz.billspaid2.Util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Lucas on 13/11/2017.
 */

public class SingletonFirebase {

    final static public String DB_CONTAS = "contas";
    final static public String DB_USUARIOS = "usuarios";

    private static FirebaseDatabase database;
    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticacao;
    private static FirebaseUser user;

    public static FirebaseDatabase getDatabase() {
        database = FirebaseDatabase.getInstance();
        return database;
    }

    public static DatabaseReference getReferenciaFirebase(String s) {
        if (referenciaFirebase == null){
            referenciaFirebase = FirebaseDatabase.getInstance().getReference(s);
        }
        return referenciaFirebase;
    }

    public static FirebaseAuth getAutenticacao() {
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

    public static FirebaseUser getUser() {
        if (user == null){
            user = autenticacao.getCurrentUser();
        }
        return user;
    }
}
