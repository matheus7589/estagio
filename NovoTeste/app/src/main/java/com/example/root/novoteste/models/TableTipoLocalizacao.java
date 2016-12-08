package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by root on 08/12/2016.
 */

public class TableTipoLocalizacao extends SugarRecord {

    String descricao;

    public TableTipoLocalizacao(){}

    public TableTipoLocalizacao(String descricao){

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
