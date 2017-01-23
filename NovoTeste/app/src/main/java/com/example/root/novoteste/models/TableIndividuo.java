package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by root on 08/12/2016.
 */

public class TableIndividuo extends SugarRecord {

    boolean isResposavel;

    String nomeCompleto;
    String nomeSocial;
    String cartaoSus;
    String dataNascimento;
    String nomeMae;
    String telefoneCelular;
    String ocupacao;
    String pis_pasep;
    String pais;
    String mail;
    String municipioNascimento;
    int sexo, raca, nacionalidade, grau, parentensco, creche, mercadotrab, orientacao, deficiencia, crianca, cuidador, planosaude,
            grupoComunitario, comunidadeTradicional, saida;

    String dataInicioResidencia;
    String dataFimResidencia;

    public TableIndividuo(){

    }

    public TableIndividuo(String nomeCompleto, String nomeSocial, String cartaoSus, String dataNascimento, String nomeMae, String telefoneCelular,
                          String ocupacao, String pis_pasep, String pais, String mail, String municipioNascimento, int sexo, int raca, int nacionalidade,
                          int grau, int parentensco, int creche, int mercadotrab, int orientacao, int deficiencia, int crianca, int cuidador, int planosaude,
                          int grupoComunitario, int comunidadeTradicional, int saida, String dataInicioResidencia, boolean isResposavel) {
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.cartaoSus = cartaoSus;
        this.dataNascimento = dataNascimento;
        this.nomeMae = nomeMae;
        this.telefoneCelular = telefoneCelular;
        this.ocupacao = ocupacao;
        this.pis_pasep = pis_pasep;
        this.pais = pais;
        this.mail = mail;
        this.municipioNascimento = municipioNascimento;
        this.sexo = sexo;
        this.raca = raca;
        this.nacionalidade = nacionalidade;
        this.grau = grau;
        this.parentensco = parentensco;
        this.creche = creche;
        this.mercadotrab = mercadotrab;
        this.orientacao = orientacao;
        this.deficiencia = deficiencia;
        this.crianca = crianca;
        this.cuidador = cuidador;
        this.planosaude = planosaude;
        this.grupoComunitario = grupoComunitario;
        this.comunidadeTradicional = comunidadeTradicional;
        this.saida = saida;
        this.dataInicioResidencia = dataInicioResidencia;
        this.isResposavel = isResposavel;
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

    public boolean isResposavel() {
        return isResposavel;
    }

    public void setResposavel(boolean resposavel) {
        isResposavel = resposavel;
    }
}
