package com.example.root.novoteste.controllers;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by root on 10/10/2016.
 */

public class BancoController extends Activity {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }


//    public String insereDado(String cartaosus, String nameLogradouro, String tipolograd, String numberLograd, String comple, String estado, String muni, String bairr, String CEP,
//                             String teleResid, String localizacao, String moradia, String tipoDomicilio, String condiTerra, String tipoAcesso, String numMora, String numComods){
        //public String insereDadoDomicilio(String cartaosus, String bairr, String teleResid){
public String insereDado(String cartaosus, String nameLogradouro, String tipolograd, String numberLograd, String comple, String bairr, String teleResid, String numComods, String numMora){
        ContentValues valoresdomi, valoresestado;
        long resultadoDomicilio, resultadoEndere;

        db = banco.getWritableDatabase();
        valoresdomi = new ContentValues();
        valoresdomi.put(banco.getCartaoSus(), cartaosus);
        valoresdomi.put(banco.getTELERESIDENCIAL(), teleResid);
        valoresdomi.put(banco.getTabelaTipologradouro(), tipolograd);
        valoresdomi.put(banco.getNOMELOGRAD(), nameLogradouro);
        valoresdomi.put(banco.getNUMLOGRAD(), numberLograd);
        valoresdomi.put(banco.getCOMPLEMENTO(), comple);
        valoresdomi.put(banco.getNUMEROCOMODOS(), numComods);
        valoresdomi.put(banco.getNMORADORES(), numMora);

          resultadoDomicilio = db.insert(CriaBanco.getTabelaDomicilio(), null, valoresdomi);

//      valores.put(banco.getCartaoSus(), cartaosus);
//      valores.put(banco.getNOMELOGRAD(), nameLogradouro);
//      valores.put(banco.getNUMLOGRAD(), numberLograd);
//      valores.put(banco.getCOMPLEMENTO(), comple);

          String[] id_Domicilio =  {banco.getID()};

        valoresestado = new ContentValues();
        valoresestado.put(banco.getDESCRICAO(), bairr);
        //valoresestado.put(banco.getID(), (db.query(banco.getTabelaDomicilio(), id_Domicilio, null, null, null, null, null, null)).getColumnIndex(banco.getID()));
        //valoresbairro.put(banco.getDESCRICAO(), muni);
        //valoresbairro.put(banco.getDESCRICAO(), bairr);
        //valoresbairro.put(banco.getDESCRICAO(), CEP);

//        valores.put(banco.getDESCRICAO(), estado);
//        valores.put(banco.getDESCRICAO(), muni);
//        valores.put(banco.getDESCRICAO(), bairr);
//        valores.put(banco.getDESCRICAO(), CEP);
//        valores.put(banco.getTELERESIDENCIAL(), teleResid);
//        valores.put(banco.getDESCRICAO(), localizacao);
//        valores.put(banco.getDESCRICAO(), moradia);
//        valores.put(banco.getDESCRICAO(), tipoDomicilio);
//        valores.put(banco.getDESCRICAO(), condiTerra);
//        valores.put(banco.getDESCRICAO(), tipoAcesso);
//        valores.put(banco.getNMORADORES(), numMora);
//        valores.put(banco.getNUMEROCOMODOS(), numComods);




            System.out.println((db.query(banco.getTabelaDomicilio(), id_Domicilio, null, null, null, null, null, null)).getColumnIndex(banco.getID()));
        resultadoEndere = db.insert(CriaBanco.getTabelaBairro(), null, valoresestado);
        db.close();

        if(resultadoEndere == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public Cursor carregaDadosDomicilio(){
        Cursor cursor;
        String[] campos =  {banco.getID(), banco.getCartaoSus()};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.getTabelaDomicilio(), campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosEstado(){
        Cursor cursor;
        String[] campos = {banco.getDESCRICAO()};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.getTabelaBairro(), campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }

//    public Cursor carregaDadoById(int id){
//        Cursor cursor;
//        String[] campos =  {banco.getID(), banco.getNOME(), banco.getRG()};
//        String where = CriaBanco.getID() + "=" + id;
//        db = banco.getReadableDatabase();
//        cursor = db.query(CriaBanco.getTABELA(),campos,where, null, null, null, null, null);
//
//        if(cursor!=null){
//            cursor.moveToFirst();
//        }
//        db.close();
//        return cursor;
//    }

    public int carregaDadoByName(String nome, String tabela){
        Cursor cursor;
        int idResultado;
        String teste;
        String[] campos = {banco.getID(), banco.getDESCRICAO()}; //Colunas
        String where = CriaBanco.getDESCRICAO() + " = ?"; // Where
        String[] valor = {nome}; //Valor do Where para substituir
        db = banco.getReadableDatabase();
        cursor = db.query(tabela, campos, where, valor, null, null, null, null);
        if(cursor!=null){
            //Toast.makeText(this.getApplicationContext(), "Entrou!", Toast.LENGTH_LONG).show();
            System.out.println("Entrou!!");
            cursor.moveToFirst();
        }
        db.close();
        //System.out.println(cursor.getString(cursor.getColumnIndex(CriaBanco.getDESCRICAO())));
        idResultado = Integer.parseInt(cursor.getString(cursor.getColumnIndex(CriaBanco.getID())));
        //System.out.println(teste);
        //Toast.makeText(getParent().getApplicationContext(), cursor.getCount(), Toast.LENGTH_LONG).show();
        return idResultado;
    }

//
//    public void alteraRegistro(int id, String autor, String editora){
//        ContentValues valores;
//        String where;
//
//        db = banco.getWritableDatabase();
//
//        where = CriaBanco.getID() + "=" + id;
//
//        valores = new ContentValues();
//        valores.put(CriaBanco.getNOME(), autor);
//        valores.put(CriaBanco.getRG(), editora);
//
//        db.update(CriaBanco.getTABELA(),valores,where,null);
//        db.close();
//    }

    public void deletaRegistro(int id){
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaDomicilio(),where,null);
        db.close();
    }
}
