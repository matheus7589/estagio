package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by suporte on 27/12/2016.
 */

public class TableCrianca extends SugarRecord {

    String descricao;

    public TableCrianca(){}

    public TableCrianca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
