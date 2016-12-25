package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by CCSST on 21/12/2016.
 */

public class TableRaca extends SugarRecord {

    String descricao;

    public TableRaca(){}

    public TableRaca(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
