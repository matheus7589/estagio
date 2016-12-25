package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by CCSST on 21/12/2016.
 */

public class TableFamilia extends SugarRecord {

    int nProntuarioFamiliar;
    TableIndividuo individuo;
    TableDomicilio domicilio;

    public TableFamilia(){}

    public TableFamilia(int nProntuarioFamiliar, TableIndividuo individuo, TableDomicilio domicilio){
        this.nProntuarioFamiliar = nProntuarioFamiliar;
        this.individuo = individuo;
        this.domicilio = domicilio;
    }

}
