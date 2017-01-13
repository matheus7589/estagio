package com.example.root.novoteste.controllers;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.root.novoteste.R;

/**
 * Created by root on 13/10/2016.
 */

public class Alterar extends Activity {

    EditText nome;
    EditText cartao;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alter);

//        codigo = this.getIntent().getStringExtra("codigo");
//
//        crud = new BancoController(getBaseContext());
//
//        nome = (EditText)findViewById(R.id.editText5);
//        cartao = (EditText)findViewById(R.id.editText6);
//
//        alterar = (Button)findViewById(R.id.button2);
//        deletar = (Button)findViewById(R.id.button3);
//
//        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
//        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getNOME())));
//        cartao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getRG())));
//
//        alterar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                crud.alteraRegistro(Integer.parseInt(codigo), nome.getText().toString(),
//                        cartao.getText().toString());
//                Intent intent = new Intent(Alterar.this, listarDados.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        deletar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                crud.deletaRegistro(Integer.parseInt(codigo));
//                Intent intent = new Intent(Alterar.this, listarDados.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }
}
