package com.samuniz.billspaid2.Entitys;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lucas on 13/11/2017.
 */

public class Usuario implements Serializable {

    private String id;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private List<String> listaContas;

    public Usuario() {
    }

    public Usuario(String id, String nomeUsuario, String emailUsuario, String senhaUsuario, List<String> listaContas) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.listaContas = listaContas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public List<String> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<String> listaContas) {
        this.listaContas = listaContas;
    }
}
