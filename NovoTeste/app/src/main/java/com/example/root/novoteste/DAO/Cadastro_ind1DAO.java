package com.example.root.novoteste.DAO;

import android.database.sqlite.SQLiteException;

import com.example.root.novoteste.models.TableCadastroIndividual1;

/**
 * Created by CCSST on 13/01/2017.
 */

public class Cadastro_ind1DAO {

    static public boolean inserir(TableCadastroIndividual1 cadastroIndividual1){
        boolean resultado = false;

        try{
            TableCadastroIndividual1 novoDado;
            novoDado = cadastroIndividual1;
            novoDado.save();
            resultado = true;
        }catch (SQLiteException e){
            System.out.println(e);
        }

        return resultado;
    }

}
