package com.example.root.novoteste.controllers;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.root.novoteste.R;
import com.example.root.novoteste.models.TableCadastroIndividual1;
import com.example.root.novoteste.models.TableIndividuo;

import java.util.List;

public class listarDados extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_dados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //BancoController crud = new BancoController(getBaseContext());
        //final Cursor cursorDomi = crud.carregaDadosDomicilio();
        //final Cursor cursorBairro = crud.carregaDadosEstado();

        final List<TableIndividuo> individuo = TableIndividuo.listAll(TableIndividuo.class);


//        final CursorJoiner mergedCursor = new CursorJoiner(new Cursor[]{
//                cursorDomi,
//                cursorBairro
//        });

//        if(cursorBairro!=null)
//            Toast.makeText(getApplicationContext(), mergedCursor.getString(mergedCursor.getColumnIndex(CriaBanco.getDESCRICAO())), Toast.LENGTH_LONG).show();

        String[] nomeCampos = new String[] {CriaBanco.getID(), CriaBanco.getCartaoSus(), CriaBanco.getDESCRICAO()};
        int[] idViews = new int[] {R.id.idDomicilio, R.id.nomeTelefone, R.id.cartaosus};

        ArrayAdapter<TableIndividuo> adaptador = new ArrayAdapter<TableIndividuo>(getBaseContext(),
                R.layout.content_listar_dados, android.R.id.text1, individuo);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) lista.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(), "Position: " + itemPosition + " ListItem: " + itemValue, Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

}
