package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by root on 08/12/2016.
 */

public class TableIndividuo extends SugarRecord {

    String nomeCompleto;
    String nomeSocial;
    String cartaoSus;
    String dataNascimento;
    String nomeMae;
    String telefoneCelular;
    String ocupacao;
    String dataInicioResidencia;
    String dataFimResidencia;

    public TableIndividuo(){

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getDataInicioResidencia() {
        return dataInicioResidencia;
    }

    public void setDataInicioResidencia(String dataInicioResidencia) {
        this.dataInicioResidencia = dataInicioResidencia;
    }

    public String getDataFimResidencia() {
        return dataFimResidencia;
    }

    public void setDataFimResidencia(String dataFimResidencia) {
        this.dataFimResidencia = dataFimResidencia;
    }
}
