package com.samuniz.billspaid2.Entitys;

import java.io.Serializable;

/**
 * Created by Lucas on 14/11/2017.
 */

public class Conta implements Serializable {

    private String id;
    private String descicao;
    private String valor;

    public Conta() {
    }

    public Conta(String id, String descicao, String valor) {
        this.id = id;
        this.descicao = descicao;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
