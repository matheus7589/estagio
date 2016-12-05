package com.example.root.novoteste;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorJoiner;
import android.database.MergeCursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        final Cursor cursorDomi = crud.carregaDadosDomicilio();
        final Cursor cursorBairro = crud.carregaDadosEstado();

//        final CursorJoiner mergedCursor = new CursorJoiner(new Cursor[]{
//                cursorDomi,
//                cursorBairro
//        });

//        if(cursorBairro!=null)
//            Toast.makeText(getApplicationContext(), mergedCursor.getString(mergedCursor.getColumnIndex(CriaBanco.getDESCRICAO())), Toast.LENGTH_LONG).show();

//        String[] nomeCampos = new String[] {CriaBanco.getID(), CriaBanco.getCartaoSus(), CriaBanco.getDESCRICAO()};
//        int[] idViews = new int[] {R.id.idDomicilio, R.id.nomeTelefone, R.id.cartaosus};
//
//        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
//                R.layout.content_listar_dados,mergedCursor,nomeCampos,idViews, 0);
//        lista = (ListView)findViewById(R.id.listView);
//        lista.setAdapter(adaptador);

//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String codigo;
//                cursor.moveToPosition(position);
//                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getID()));
//                Intent intent = new Intent(listarDados.this, Alterar.class);
//                intent.putExtra("codigo", codigo);
//                startActivity(intent);
//                finish();
//            }
//        });

    }

}
