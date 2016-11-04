package com.example.root.novoteste;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by root on 13/09/2016.
 */
public class Cadastro_Ind3 extends Fragment {

    EditText telefone, municipio;
    String tele, muni;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.cadastro_individual3, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
//        // Cria um  ArrayAdapter usando um array de string e um spinner padrão
//        // USAR getActivity().getApplicationContext() CASO getContext() NÃO FUNCIONE
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.UF, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//
//        Button registrar = (Button)view.findViewById(R.id.registrar);
//
//        //telefone = (EditText)getView().findViewById(R.id.municipio);
//        //tele = telefone.getText().toString();
//
//        registrar.setOnClickListener(regHandler);
    }

//    View.OnClickListener regHandler = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            BancoController crud = new BancoController(getActivity().getBaseContext());
//            telefone = (EditText)getView().findViewById(R.id.telefone);
//            municipio = (EditText)getView().findViewById(R.id.municipio);
//            tele = telefone.getText().toString();
//            muni = municipio.getText().toString();
//            String resultado;
//
//            //Toast.makeText(getActivity().getApplicationContext(), tele, Toast.LENGTH_LONG).show();
//
//            //resultado = crud.insereDado(tele, muni);
//
//            //Toast.makeText(getActivity().getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
//        }
//    };
//

}
