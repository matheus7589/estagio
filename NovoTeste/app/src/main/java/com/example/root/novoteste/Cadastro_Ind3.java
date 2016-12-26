package com.example.root.novoteste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.root.novoteste.models.TableDomicilio;

/**
 * Created by root on 13/09/2016.
 */
public class Cadastro_Ind3 extends Fragment {

    private EditText ocupacao;
    private String ocup;
    int grau, parentensco, creche, mercadotrab, orientacao, deficiencia, crianca, cuidador, planosaude, grupoComunitario, comunidadeTradicional, saida;
    RadioButton texto;

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

        Button registrar = (Button)view.findViewById(R.id.registra);

        registrar.setOnClickListener(regHandler);

//        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
//        // Cria um  ArrayAdapter usando um array de string e um spinner padrão
//        // USAR getActivity().getApplicationContext() CASO getContext() NÃO FUNCIONE
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.UF, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
    }

    View.OnClickListener regHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BancoController crud = new BancoController(getActivity().getBaseContext());
            ///////////////////////////// FRAGMENTO 2 /////////////////////////////////////////////

            //EditTexts
            ocupacao = (EditText) getActivity().findViewById(R.id.ocupacao);

            //RadioGroups
            RadioGroup radio_grp3 = (RadioGroup) getActivity().findViewById(R.id.parentesco);
            parentensco = radio_grp3.getCheckedRadioButtonId();
            RadioGroup radio_grp4 = (RadioGroup) getActivity().findViewById(R.id.grau);
            grau = radio_grp4.getCheckedRadioButtonId();
            RadioGroup radio_grp5 = (RadioGroup) getActivity().findViewById(R.id.creche);
            creche = radio_grp5.getCheckedRadioButtonId();
            RadioGroup radio_grp6 = (RadioGroup) getActivity().findViewById(R.id.mercadotrab);
            mercadotrab = radio_grp6.getCheckedRadioButtonId();
            RadioGroup radio_grp7 = (RadioGroup) getActivity().findViewById(R.id.orientacao);
            orientacao = radio_grp7.getCheckedRadioButtonId();
            RadioGroup radio_grp8 = (RadioGroup) getActivity().findViewById(R.id.deficiencia);
            deficiencia = radio_grp8.getCheckedRadioButtonId();


            //Strings
            ocup = ocupacao.getText().toString();

            ///////////////////////////// FRAGMENTO 3 /////////////////////////////////////////////

            //EditTexts

            //RadioGroups
            RadioGroup radio_grp9 = (RadioGroup) getView().findViewById(R.id.crianca);
            crianca = radio_grp9.getCheckedRadioButtonId();
            RadioGroup radio_grp10 = (RadioGroup) getView().findViewById(R.id.cuidador);
            cuidador = radio_grp10.getCheckedRadioButtonId();
            RadioGroup radio_grp11 = (RadioGroup) getView().findViewById(R.id.planoSaude);
            planosaude = radio_grp11.getCheckedRadioButtonId();
            RadioGroup radio_grp12 = (RadioGroup) getView().findViewById(R.id.grupoComunitario);
            grupoComunitario = radio_grp12.getCheckedRadioButtonId();
            RadioGroup radio_grp13 = (RadioGroup) getView().findViewById(R.id.comunidadeTradicional);
            comunidadeTradicional = radio_grp13.getCheckedRadioButtonId();
            RadioGroup radio_grp15 = (RadioGroup) getView().findViewById(R.id.saida);
            saida = radio_grp15.getCheckedRadioButtonId();

            //Strings


//            BancoController crud = new BancoController(getActivity().getBaseContext());
//            telefone = (EditText)getView().findViewById(R.id.telefone);
//            municipio = (EditText)getView().findViewById(R.id.municipio);
//            tele = telefone.getText().toString();
//            muni = municipio.getText().toString();
//            String resultado;
            texto = (RadioButton) getActivity().findViewById(grau);

            Toast.makeText(getActivity().getApplicationContext(), texto.getText().toString(), Toast.LENGTH_LONG).show();

            Intent intent = getActivity().getIntent();
            TableDomicilio table = (TableDomicilio) intent.getExtras().getSerializable("Domicilio");

//            resultado = crud.insereDado(tele, muni);
//
//            Toast.makeText(getActivity().getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        }
    };


}
