package com.example.root.novoteste.enums;

/**
 * Created by root on 08/12/2016.
 */

public enum Localizacao {

    RURAL("Rural"),
    URBANA("Urbana");

    private String descricao;

    private Localizacao(String descricao){
        this.descricao = descricao;
    }

}
