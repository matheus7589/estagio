package com.example.root.novoteste;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by root on 30/08/2016.
 */
public class Cadastro_Ind1 extends Fragment {

    private EditText telefone, municipio, cartaoSus, nomeCompleto, nomeSocial, dataNascimento, pisPasep, paisNascimento, nomeMae, eMail;
    private String tele, muni, sus, nomeComp, nomeSoci, data, pasep, pais, mae, mail;
    int sexo, raca, nacionalidade;
    RadioButton radioButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.cadastro_individual1, container, false);
    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.masculino:
//                if (checked)
//                    // Pirates are the best
//                    break;
//            case R.id.feminino:
//                if (checked)
//                    // Ninjas rule
//                    break;
//        }
//    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner1);
        // Cria um  ArrayAdapter usando um array de string e um spinner padrão
        // USAR getActivity().getApplicationContext() CASO getContext() NÃO FUNCIONE
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.UF, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Button registrar = (Button) view.findViewById(R.id.cadastrar);
        registrar.setOnClickListener(regHandler);

//        RadioButton masculino = (RadioButton) getActivity().findViewById(R.id.masculino);
//        RadioButton feminino = (RadioButton) getActivity().findViewById(R.id.feminino);
//
//        masculino.setOnClickListener(next_Listener);
//        feminino.setOnClickListener(next_Listener);

    }

    View.OnClickListener regHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BancoController crud = new BancoController(getActivity().getBaseContext());
            ///////////////////////////// FRAGMENTO 1 /////////////////////////////////////////////

            //EditTexts
            telefone = (EditText) getView().findViewById(R.id.telefone);
            municipio = (EditText) getView().findViewById(R.id.municipio);
            cartaoSus = (EditText) getView().findViewById(R.id.sus);
            nomeCompleto = (EditText) getView().findViewById(R.id.nomeCompleto);
            nomeSocial = (EditText) getView().findViewById(R.id.nomeSocial);
            dataNascimento = (EditText) getView().findViewById(R.id.dataNascimento);
            pisPasep = (EditText) getView().findViewById(R.id.pisPasep);
            paisNascimento = (EditText) getView().findViewById(R.id.paisNascimento);
            nomeMae = (EditText) getView().findViewById(R.id.nomeMae);
            eMail = (EditText) getView().findViewById(R.id.email);


            //RadioGroups
            RadioGroup radio_grp1 = (RadioGroup) getView().findViewById(R.id.sexoInd);
            sexo = radio_grp1.getCheckedRadioButtonId();
            RadioGroup radio_grp2 = (RadioGroup) getView().findViewById(R.id.raca);
            raca = radio_grp2.getCheckedRadioButtonId();
            RadioGroup radio_grp14 = (RadioGroup) getView().findViewById(R.id.nacionalidade);
            nacionalidade = radio_grp14.getCheckedRadioButtonId();


            //Strings
            tele = telefone.getText().toString();
            muni = municipio.getText().toString();
            sus = cartaoSus.getText().toString();
            nomeComp = nomeCompleto.getText().toString();
            nomeSoci = nomeSocial.getText().toString();
            data = dataNascimento.getText().toString();
            pasep = pisPasep.getText().toString();
            pais = paisNascimento.getText().toString();
            mae = nomeMae.getText().toString();
            mail = eMail.getText().toString();

//            BancoController crud = new BancoController(getActivity().getBaseContext());
//            telefone = (EditText)getView().findViewById(R.id.telefone);
//            municipio = (EditText)getView().findViewById(R.id.municipio);
//            tele = telefone.getText().toString();
//            muni = municipio.getText().toString();
//            String resultado;

            radioButton = (RadioButton) getView().findViewById(nacionalidade);


            Toast.makeText(getActivity().getApplicationContext(), radioButton.getText().toString(), Toast.LENGTH_LONG).show();

//            resultado = crud.insereDado(tele, muni);
//
//            Toast.makeText(getActivity().getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

        }
    };


    public String setNacionalidade(int id){
        if(id == R.id.brasileiro)
            return "Brasileiro";
        else if(id == R.id.naturalizado)
            return "Naturalizado";
        else
            return "Estrangeiro";
    }

    public String setSexo(int id){
        if(id == R.id.masculino)
            return "Masculino";
        else
            return "Feminino";
    }

    public String setraca(int id){
        if(id == R.id.branca)
            return "Branca";
        else if(id == R.id.preta)
            return "Preta";
        else if(id == R.id.parda)
            return "Parda";
        else
            return "Indígena";
    }
}


