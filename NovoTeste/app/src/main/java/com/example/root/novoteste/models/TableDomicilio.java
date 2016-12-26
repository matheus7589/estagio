package com.example.root.novoteste.models;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by suporte on 08/12/2016.
 */

public class TableDomicilio extends SugarRecord implements Serializable{

    String cartaoSus;
    String nomeLogradouro;
    String numeroLogradouro;
    String tipoLogradouro;
    String complemento;
    String telefoneResidencial;
    String numeroMoradores;
    String numeroComodos;
    int localizacao;
    int situacaoMoradia;
    int tipoDomicilio;
    int condicaoTerra;
    int tipoAcesso;
    int abastecimentoAgua;
    int tratamentoAgua;
    int destinoLixo;
    int disponibilidadeEnergia;
    int formaEscoamento;
    int tipoAnimal;


    public TableDomicilio(){}

    public TableDomicilio(String nomeLogradouro, String numeroLogradouro, String cartaoSus, String tipoLogradouro, String complemento, String telefoneResidencial, String numeroMoradores, String numeroComodos,
                          int localizacao, int situacaoMoradia, int tipoDomicilio, int condicaoTerra, int tipoAcesso, int abastecimentoAgua, int tratamentoAgua,
                          int destinoLixo, int disponibilidadeEnergia, int formaEscoamento, int tipoAnimal){
        this.nomeLogradouro = nomeLogradouro;
        this.numeroLogradouro = numeroLogradouro;
        this.cartaoSus = cartaoSus;
        this.tipoLogradouro = tipoLogradouro;
        this.complemento = complemento;
        this.telefoneResidencial = telefoneResidencial;
        this.numeroMoradores = numeroMoradores;
        this.numeroComodos = numeroComodos;
        this.localizacao = localizacao;
        this.situacaoMoradia = situacaoMoradia;
        this.tipoDomicilio = tipoDomicilio;
        this.condicaoTerra = condicaoTerra;
        this.tipoAcesso = tipoAcesso;
        this.abastecimentoAgua = abastecimentoAgua;
        this.tratamentoAgua = tratamentoAgua;
        this.destinoLixo = destinoLixo;
        this.disponibilidadeEnergia = disponibilidadeEnergia;
        this.formaEscoamento = formaEscoamento;
        this.tipoAnimal = tipoAnimal;
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

    public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    public int getSituacaoMoradia() {
        return situacaoMoradia;
    }

    public void setSituacaoMoradia(int situacaoMoradia) {
        this.situacaoMoradia = situacaoMoradia;
    }

    public int getTipoDomicilio() {
        return tipoDomicilio;
    }

    public void setTipoDomicilio(int tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }

    public int getCondicaoTerra() {
        return condicaoTerra;
    }

    public void setCondicaoTerra(int condicaoTerra) {
        this.condicaoTerra = condicaoTerra;
    }

    public int getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(int tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public int getAbastecimentoAgua() {
        return abastecimentoAgua;
    }

    public void setAbastecimentoAgua(int abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public int getTratamentoAgua() {
        return tratamentoAgua;
    }

    public void setTratamentoAgua(int tratamentoAgua) {
        this.tratamentoAgua = tratamentoAgua;
    }

    public int getDestinoLixo() {
        return destinoLixo;
    }

    public void setDestinoLixo(int destinoLixo) {
        this.destinoLixo = destinoLixo;
    }

    public int getDisponibilidadeEnergia() {
        return disponibilidadeEnergia;
    }

    public void setDisponibilidadeEnergia(int disponibilidadeEnergia) {
        this.disponibilidadeEnergia = disponibilidadeEnergia;
    }

    public int getFormaEscoamento() {
        return formaEscoamento;
    }

    public void setFormaEscoamento(int formaEscoamento) {
        this.formaEscoamento = formaEscoamento;
    }

    public int getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(int tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}
