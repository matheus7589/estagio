package com.example.root.novoteste.DAO;

import android.database.sqlite.SQLiteException;

import com.example.root.novoteste.models.TableIndividuo;

/**
 * Created by CCSST on 13/01/2017.
 */

public class CadastroIndividualDAO {

    static public boolean inserir(TableIndividuo individuo){
        boolean resultado = false;

        try{
            TableIndividuo novoIndividuo;
            novoIndividuo = individuo;
            novoIndividuo.save();
            resultado = true;
        }catch (SQLiteException e){
            System.out.println(e);
        }

        return resultado;
    }
}
