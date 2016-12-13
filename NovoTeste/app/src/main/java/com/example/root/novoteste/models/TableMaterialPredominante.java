package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by suporte on 13/12/2016.
 */

public class TableMaterialPredominante extends SugarRecord {

    String descricao;

    public TableMaterialPredominante(){}

    public TableMaterialPredominante(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
