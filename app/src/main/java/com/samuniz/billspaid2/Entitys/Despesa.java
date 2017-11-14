package com.samuniz.billspaid2.Entitys;

import java.io.Serializable;

/**
 * Created by Lucas on 13/11/2017.
 */

public class Despesa implements Serializable {

    private String idDespesa;
    private String valorDespesa;
    private String dataDespesa;
    private String descricaoDespesa;
    private String categoriaDespesa;
    private String contaDespesa;
    private String checkDespesa;

    public Despesa(){
    }

    public Despesa(String id, String valorDespesa, String dataDespesa, String descricaoDespesa,
                   String categoriaDespesa, String contaDespesa, String checkDespesa) {
        this.idDespesa = id;
        this.valorDespesa = valorDespesa;
        this.dataDespesa = dataDespesa;
        this.descricaoDespesa = descricaoDespesa;
        this.categoriaDespesa = categoriaDespesa;
        this.contaDespesa = contaDespesa;
        this.checkDespesa = checkDespesa;
    }

    public String getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(String idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(String valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public String getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(String dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public String getCategoriaDespesa() {
        return categoriaDespesa;
    }

    public void setCategoriaDespesa(String categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }

    public String getContaDespesa() {
        return contaDespesa;
    }

    public void setContaDespesa(String contaDespesa) {
        this.contaDespesa = contaDespesa;
    }

    public String getCheckDespesa() {
        return checkDespesa;
    }

    public void setCheckDespesa(String checkDespesa) {
        this.checkDespesa = checkDespesa;
    }
}
