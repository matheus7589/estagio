package com.example.root.novoteste.controllers;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.root.novoteste.R;
import com.example.root.novoteste.models.TableCadastroIndividual1;
import com.example.root.novoteste.models.TableIndividuo;

import java.lang.reflect.Array;
import java.util.ArrayList;
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


        final List<TableIndividuo> individuos = TableIndividuo.listAll(TableIndividuo.class);
        ArrayList<String> listaNome = new ArrayList<String>();

        for(TableIndividuo temporario : individuos){
            System.out.println(temporario.isResposavel());
            if(temporario.isResposavel()) {
                listaNome.add(temporario.getId() + "    " +temporario.getNomeCompleto());
            }
        }


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getBaseContext(),
                R.layout.content_listar_dados, R.id.idDomicilio, listaNome);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String codigo;
                // ListView Clicked item index
                int itemPosition = position+1;

                // Show Alert
                //Toast.makeText(getApplicationContext(), "Posição: " + itemPosition, Toast.LENGTH_SHORT).show();

                PopupMenu menu = new PopupMenu (listarDados.this, view);
                menu.setOnMenuItemClickListener (new PopupMenu.OnMenuItemClickListener ()
                {
                    @Override
                    public boolean onMenuItemClick (MenuItem item)
                    {
                        int id = item.getItemId();
                        switch (id)
                        {
                            case R.id.item_abrir:
                                //Log.i (Tag, "settings");
                                break;
                            case R.id.item_editar:
                                //Log.i (Tag, "about");
                                break;
                            case R.id.item_deletar:
                                break;
                        }
                        return true;
                    }
                });
                menu.inflate (R.menu.menu_editar);
                menu.show();
            }
        });

    }

}
