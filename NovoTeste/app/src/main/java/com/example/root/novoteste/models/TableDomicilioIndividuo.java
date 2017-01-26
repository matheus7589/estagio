package com.example.root.novoteste.models;

import com.orm.SugarRecord;

/**
 * Created by root on 26/01/2017.
 */

public class TableDomicilioIndividuo extends SugarRecord {

    long idDomicilio;
    long idIndividuo;

    public TableDomicilioIndividuo(long idDomicilio, long idIndividuo) {
        this.idDomicilio = idDomicilio;
        this.idIndividuo = idIndividuo;
    }

    public long getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(long idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public long getIdIndividuo() {
        return idIndividuo;
    }

    public void setIdIndividuo(long idIndividuo) {
        this.idIndividuo = idIndividuo;
    }
}
