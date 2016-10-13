package com.example.root.novoteste;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {CriaBanco.getID(), CriaBanco.getNOME(), CriaBanco.getRG()};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro, R.id.cartaosus};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.content_listar_dados,cursor,nomeCampos,idViews, 0);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getID()));
                Intent intent = new Intent(listarDados.this, Alterar.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });

    }

}
