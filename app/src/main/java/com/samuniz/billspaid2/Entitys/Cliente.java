package com.samuniz.billspaid2.Entitys;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lucas on 14/11/2017.
 */

public class Cliente implements Serializable {

    private String id;
    private String nome;
    private List<String> contas;

    public Cliente() {
    }

    public Cliente(String id, String nome, List<String> contas) {
        this.id = id;
        this.nome = nome;
        this.contas = contas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getContas() {
        return contas;
    }

    public void setContas(List<String> contas) {
        this.contas = contas;
    }
}
