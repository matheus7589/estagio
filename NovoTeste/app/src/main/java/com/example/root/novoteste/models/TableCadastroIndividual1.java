package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by CCSST on 13/01/2017.
 */

public class TableCadastroIndividual1 extends SugarRecord {

    String telefone;
    String municipio;
    String cartaoSus;
    String nomeCompleto;
    String nomeSocial;
    String dataNascimento;
    String pisPasep;
    String paisNascimento;
    String nomeMae;
    String email;

    int sexo, raca, nacionalidade;

    public TableCadastroIndividual1(){}

    public TableCadastroIndividual1(String telefone, String municipio, String cartaoSus, String nomeCompleto, String nomeSocial, String dataNascimento,
                                    String pisPasep, String paisNascimento, String nomeMae, String email, int sexo, int raca, int nacionalidade) {
        this.telefone = telefone;
        this.municipio = municipio;
        this.cartaoSus = cartaoSus;
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.dataNascimento = dataNascimento;
        this.pisPasep = pisPasep;
        this.paisNascimento = paisNascimento;
        this.nomeMae = nomeMae;
        this.email = email;
        this.sexo = sexo;
        this.raca = raca;
        this.nacionalidade = nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }

    public String getPaisNascimento() {
        return paisNascimento;
    }

    public void setPaisNascimento(String paisNascimento) {
        this.paisNascimento = paisNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
        this.raca = raca;
    }

    public int getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(int nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
