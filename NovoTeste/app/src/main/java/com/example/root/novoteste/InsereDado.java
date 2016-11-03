package com.example.root.novoteste;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by root on 10/10/2016.
 */

public class InsereDado extends Activity {

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_individual3);

        Button registrar = (Button)findViewById(R.id.registrar);

        registrar.setOnClickListener(regHandler);
    }

    View.OnClickListener regHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            BancoController crud = new BancoController(getBaseContext());
            EditText telefone = (EditText)findViewById(R.id.telefone);
            EditText municipio = (EditText)findViewById(R.id.municipio);
            String tele = telefone.getText().toString();
            String muni = municipio.getText().toString();
            String resultado;

            //resultado = crud.insereDado(tele, muni);

            //Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        }
    };

}
