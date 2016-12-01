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


      //public String insereDado(String cartaosus, String nameLogradouro, String numberLograd, String comple, String estado, String muni, String bairr, String CEP,
        //                     String teleResid, String localizacao, String moradia, String tipoDomicilio, String condiTerra, String tipoAcesso, String numMora, String numComods){
        public String insereDadoDomicilio(String cartaosus, String bairr, String teleResid){
        ContentValues valoresdomi, valoresestado;
        long resultadoDomicilio, resultadoEndere;

        db = banco.getWritableDatabase();
        valoresdomi = new ContentValues();
        valoresdomi.put(banco.getCartaoSus(), cartaosus);

        valoresdomi.put(banco.getTELERESIDENCIAL(), teleResid);
        //valoresdomi.put(banco.getNOMELOGRAD(), nameLogradouro);
        //valoresdomi.put(banco.getNUMLOGRAD(), numberLograd);
        //valoresdomi.put(banco.getCOMPLEMENTO(), comple);

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


            System.out.println(CriaBanco.getTabelaBairro());
        resultadoEndere = db.insert(CriaBanco.getTabelaBairro(), null, valoresestado);
        db.close();

        if(resultadoEndere == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public Cursor carregaDadosDomicilio(){
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

    public Cursor carregaDadosEstado(){
        Cursor cursor;
        String[] campos = {banco.getID(), banco.getDESCRICAO()};
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
