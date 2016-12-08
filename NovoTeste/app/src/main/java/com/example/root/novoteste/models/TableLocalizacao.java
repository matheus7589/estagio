package com.example.root.novoteste.models;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by root on 08/12/2016.
 */

public class TableLocalizacao extends SugarRecord {

    String descricao;


    public TableLocalizacao(){
    }

    public TableLocalizacao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
