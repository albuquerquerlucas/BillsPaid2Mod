package com.samuniz.billspaid2.Entitys;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lucas on 13/11/2017.
 */

public class Conta implements Serializable {

    private String idConta;
    private String descricaoConta;
    private String valorConta;
    private List<Usuario> usuarios;

    public Conta (){
    }

    public Conta(String id, String descricaoConta, String valorConta) {
        this.idConta = id;
        this.descricaoConta = descricaoConta;
        this.valorConta = valorConta;
    }

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public String getValorConta() {
        return valorConta;
    }

    public void setValorConta(String valorConta) {
        this.valorConta = valorConta;
    }

}
