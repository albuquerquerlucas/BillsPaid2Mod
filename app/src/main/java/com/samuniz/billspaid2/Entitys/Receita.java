package com.samuniz.billspaid2.Entitys;

import java.io.Serializable;

/**
 * Created by Lucas on 13/11/2017.
 */

public class Receita implements Serializable {

    private String idReceita;
    private String valorReceita;
    private String dataReceita;
    private String descricaoReceita;
    private String categoriaReceita;
    private String contaReceita;
    private String checkReceita;

    public Receita (){
    }

    public Receita(String id, String valorReceita, String dataReceita, String descricaoReceita,
                   String categoriaReceita, String contaReceita, String checkReceita) {
        this.idReceita = id;
        this.valorReceita = valorReceita;
        this.dataReceita = dataReceita;
        this.descricaoReceita = descricaoReceita;
        this.categoriaReceita = categoriaReceita;
        this.contaReceita = contaReceita;
        this.checkReceita = checkReceita;
    }

    public String getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(String idReceita) {
        this.idReceita = idReceita;
    }

    public String getValorReceita() {
        return valorReceita;
    }

    public void setValorReceita(String valorReceita) {
        this.valorReceita = valorReceita;
    }

    public String getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(String dataReceita) {
        this.dataReceita = dataReceita;
    }

    public String getDescricaoReceita() {
        return descricaoReceita;
    }

    public void setDescricaoReceita(String descricaoReceita) {
        this.descricaoReceita = descricaoReceita;
    }

    public String getCategoriaReceita() {
        return categoriaReceita;
    }

    public void setCategoriaReceita(String categoriaReceita) {
        this.categoriaReceita = categoriaReceita;
    }

    public String getContaReceita() {
        return contaReceita;
    }

    public void setContaReceita(String contaReceita) {
        this.contaReceita = contaReceita;
    }

    public String getCheckReceita() {
        return checkReceita;
    }

    public void setCheckReceita(String checkReceita) {
        this.checkReceita = checkReceita;
    }
}
