package com.example.root.novoteste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by root on 10/10/2016.
 */

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String nome, String cartao){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(banco.getNOME(), nome);
        valores.put(banco.getRG(), cartao);

        resultado = db.insert(CriaBanco.getTABELA(), null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.getID(),banco.getNOME(), banco.getRG()};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.getTABELA(), campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.getID(), banco.getNOME(), banco.getRG()};
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTABELA(),campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String autor, String editora){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.getID() + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.getNOME(), autor);
        valores.put(CriaBanco.getRG(), editora);

        db.update(CriaBanco.getTABELA(),valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTABELA(),where,null);
        db.close();
    }
}
