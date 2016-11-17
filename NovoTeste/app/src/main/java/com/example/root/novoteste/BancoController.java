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


//    public String insereDado(String nameLogradouro, String numberLograd, String comple, String estado, String muni, String bairr, String CEP,
//                             String teleResid, String localizacao, String moradia, String tipoDomicilio, String condiTerra, String tipoAcesso, String numMora, String numComods){
    public String insereDadoDomicilio(String cartaosus, String nameLogradouro, String comple, String teleResid){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(banco.getCartaoSus(), cartaosus);
        //valores.put(banco.getNOMELOGRAD(), nameLogradouro);
        //valores.put(banco.getNUMLOGRAD(), numberLograd);
        //valores.put(banco.getCOMPLEMENTO(), comple);
        //valores.put(banco.getUF(), estado);
        //valores.put(banco.getMUNICIPIO(), muni);
        //valores.put(banco.getBAIRRO(), bairr);
        //valores.put(banco.getCEP(), CEP);
        valores.put(banco.getTELERESIDENCIAL(), teleResid);
        //valores.put(banco.getTIPOLOCALIZACAO(), localizacao);
        //valores.put(banco.getSITDMORADIA(), moradia);
        //valores.put(banco.getTIPODOMICILIO(), tipoDomicilio);
        //valores.put(banco.getPosseUsoTerrra(), condiTerra);
        //valores.put(banco.getTIPOACESSO(), tipoAcesso);
        //valores.put(banco.getNMORADORES(), numMora);
        //valores.put(banco.getNUMEROCOMODOS(), numComods);


        resultado = db.insert(CriaBanco.getTabelaDomicilio(), null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.getID(),banco.getTELERESIDENCIAL(), banco.getCartaoSus()};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.getTabelaDomicilio(), campos, null, null, null, null, null, null);

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
