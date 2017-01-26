package com.example.root.novoteste.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.root.novoteste.DAO.Cadastro_ind1DAO;

import com.example.root.novoteste.R;
import com.example.root.novoteste.models.TableCadastroIndividual1;
import com.example.root.novoteste.models.TableDomicilio;
import com.example.root.novoteste.models.TableIndividuo;
import com.example.root.novoteste.models.TableNacionalidade;
import com.example.root.novoteste.models.TableOrientacaoSexual;
import com.example.root.novoteste.models.TableRaca;

import java.util.List;

/**
 * Created by root on 30/08/2016.
 */
public class Cadastro_Ind1 extends Fragment {

    boolean isVazio;
    int salvou = 0;

    CheckBox resposavel;

    boolean resp, isResponsavel;

    private EditText telefone, municipio, cartaoSus, nomeCompleto, nomeSocial, dataNascimento, pisPasep, paisNascimento, nomeMae, eMail;
    private String tele, muni, sus, nomeComp, nomeSoci, data, pasep, pais, mae, mail;

    //ID's sem converter
    int sex, rac, naci;

    //ID's convertidos
    int sexo, raca, nacionalidade;

    RadioButton radioSexo, radioRaca, radioNacionalidade;

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

        resposavel = (CheckBox) getView().findViewById(R.id.responsavel);

        Intent intent = getActivity().getIntent();
        isResponsavel = (boolean) intent.getExtras().getSerializable("Responsavel");

        if(isResponsavel == true){
            resposavel.setEnabled(false);
            resp = false;
        }

        Button registrar = (Button)view.findViewById(R.id.registrar);

        registrar.setOnClickListener(regHandler);

    }

    View.OnClickListener regHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            isVazio = true;
            //BancoController crud = new BancoController(getActivity().getBaseContext());
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

            //checkBox
            resposavel = (CheckBox) getView().findViewById(R.id.responsavel);

            if(isResponsavel == false) {
                if (resposavel.isChecked()) {
                    resp = true;
                } else {
                    resp = false;
                }
            }

            //Strings
            tele = telefone.getText().toString();
            if(TextUtils.isEmpty(tele)) {
                telefone.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }

            muni = municipio.getText().toString();
            if(TextUtils.isEmpty(muni)) {
                municipio.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }

            sus = cartaoSus.getText().toString();
            if(TextUtils.isEmpty(sus)) {
                cartaoSus.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }
            nomeComp = nomeCompleto.getText().toString();
            if(TextUtils.isEmpty(nomeComp)) {
                nomeCompleto.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }

            nomeSoci = nomeSocial.getText().toString();
            if(TextUtils.isEmpty(nomeSoci)) {
                nomeSocial.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }

            data = dataNascimento.getText().toString();
            if(TextUtils.isEmpty(data)) {
                dataNascimento.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }
            pasep = pisPasep.getText().toString();
            if(TextUtils.isEmpty(pasep)) {
                pisPasep.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }

            pais = paisNascimento.getText().toString();
            if(TextUtils.isEmpty(pais)) {
                paisNascimento.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }
            mae = nomeMae.getText().toString();
            if(TextUtils.isEmpty(mae)) {
                nomeMae.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }

            mail = eMail.getText().toString();
            if(TextUtils.isEmpty(mail)) {
                eMail.setError("Este campo não pode estar vazio!");
                isVazio = false;
                return;
            }

            //RadioGroups
            RadioGroup radio_grp1 = (RadioGroup) getView().findViewById(R.id.sexoInd);
            if(radio_grp1.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Sexo não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                sex = radio_grp1.getCheckedRadioButtonId();
                radioSexo = (RadioButton) getActivity().findViewById(sex);
                TableOrientacaoSexual tableOrientacaoSexual = new TableOrientacaoSexual();
                List<TableOrientacaoSexual> listaOrientacaoSexual = tableOrientacaoSexual.find(TableOrientacaoSexual.class, "descricao = ?", radioSexo.getText().toString());
                for (TableOrientacaoSexual temporaria : listaOrientacaoSexual) {
                    sexo = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp2 = (RadioGroup) getView().findViewById(R.id.raca);
            if(radio_grp2.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Raça não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                rac = radio_grp2.getCheckedRadioButtonId();
                radioRaca = (RadioButton) getActivity().findViewById(rac);
                TableRaca tableRaca = new TableRaca();
                List<TableRaca> listaRaca = tableRaca.find(TableRaca.class, "descricao = ?", radioRaca.getText().toString());
                for(TableRaca temporaria : listaRaca){
                    raca = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp14 = (RadioGroup) getView().findViewById(R.id.nacionalidade);
            if(radio_grp14.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Raça não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                naci = radio_grp2.getCheckedRadioButtonId();
                radioNacionalidade = (RadioButton) getActivity().findViewById(naci);
                TableNacionalidade tableNacionalidade = new TableNacionalidade();
                List<TableNacionalidade> listaNacionalidade = tableNacionalidade.find(TableNacionalidade.class, "descricao = ?", radioNacionalidade.getText().toString());
                for(TableNacionalidade temporaria : listaNacionalidade){
                    nacionalidade = (int) (long) temporaria.getId();
                }
            }


            if(salvou == 0) {
                if (isVazio == true) {
                    TableCadastroIndividual1 tableCadastroIndividual1 = new TableCadastroIndividual1(tele, muni, sus, nomeComp, nomeSoci, data, pasep, pais,
                            mae, mail, sexo, raca, nacionalidade, resp);
                    if (Cadastro_ind1DAO.inserir(tableCadastroIndividual1)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Salvou!", Toast.LENGTH_LONG).show();
                        salvou++;
                    }
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Não é possível inserir objeto vazio!", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getActivity().getApplicationContext(), "Não é possível inserir mais de uma vez!", Toast.LENGTH_LONG).show();
            }

        }
    };



}


