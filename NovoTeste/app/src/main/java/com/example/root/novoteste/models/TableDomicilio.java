package com.example.root.novoteste.models;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by suporte on 08/12/2016.
 */

public class TableDomicilio extends SugarRecord {

    String cartaoSus;
    String nomeLogradouro;
    String numeroLogradouro;
    String tipoLogradouro;
    String complemento;
    String telefoneResidencial;
    String numeroMoradores;
    String numeroComodos;


    public TableDomicilio(){}

    public TableDomicilio(String nomeLogradouro, String numeroLogradouro, String cartaoSus, String tipoLogradouro, String complemento, String telefoneResidencial, String numeroMoradores, String numeroComodos){
        this.nomeLogradouro = nomeLogradouro;
        this.numeroLogradouro = numeroLogradouro;
        this.cartaoSus = cartaoSus;
        this.tipoLogradouro = tipoLogradouro;
        this.complemento = complemento;
        this.telefoneResidencial = telefoneResidencial;
        this.numeroMoradores = numeroMoradores;
        this.numeroComodos = numeroComodos;
    }


    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getNumeroMoradores() {
        return numeroMoradores;
    }

    public void setNumeroMoradores(String numeroMoradores) {
        this.numeroMoradores = numeroMoradores;
    }

    public String getNumeroComodos() {
        return numeroComodos;
    }

    public void setNumeroComodos(String numeroComodos) {
        this.numeroComodos = numeroComodos;
    }
}
