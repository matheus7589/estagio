package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by suporte on 08/12/2016.
 */

public class tb_Domicilio extends SugarRecord {

    String nomeLogradouro;
    //String nomeSocial;
    String cartaoSus;
    //String dataNascimento;
    //String sexo;
    //String nomeMae;
    //String telefoneCelular;
    //String ocupacao;

    public tb_Domicilio(){}

    public tb_Domicilio(String nomeLogradouro, String cartaoSus){
        this.nomeLogradouro = nomeLogradouro;
        this.cartaoSus = cartaoSus;
    }

}
