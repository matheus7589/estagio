package com.example.root.novoteste;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 10/10/2016.
 */

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "Visita";
    private static final String ID = "_id";
    private static final String NOME = "nome";
    private static final String CARTAO_SUS = "cartao";
    private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOME + " VARCHAR(100) NOT NULL,"
                + CARTAO_SUS + " VARCHAR(11) NOT NULL"
                +" )";
        db.execSQL(sql); // SQL para adicionar/criar tabelas e valores no banco
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA); // Apaga a tabela, se ela existir e recria a tabela com as alterações feitas
        onCreate(db);
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getID() {
        return ID;
    }

    public static String getNOME() {
        return NOME;
    }

    public static String getRG() {
        return CARTAO_SUS;
    }

    public static int getVERSAO() {
        return VERSAO;
    }
}


