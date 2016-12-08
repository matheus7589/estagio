package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by root on 08/12/2016.
 */

public class TableAbastecimentoAgua extends SugarRecord {

    String descricao;

    public TableAbastecimentoAgua(){

    }

    public TableAbastecimentoAgua(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
