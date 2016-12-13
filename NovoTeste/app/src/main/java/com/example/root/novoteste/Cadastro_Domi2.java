package com.example.root.novoteste;

import android.database.sqlite.SQLiteException;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.root.novoteste.models.TableAbastecimentoAgua;
import com.example.root.novoteste.models.TableCondicaoTerra;
import com.example.root.novoteste.models.TableDestinoLixo;
import com.example.root.novoteste.models.TableDomicilio;
import com.example.root.novoteste.models.TableEnergia;
import com.example.root.novoteste.models.TableFormaEscoamento;
import com.example.root.novoteste.models.TableLocalizacao;
import com.example.root.novoteste.models.TableMaterialPredominante;
import com.example.root.novoteste.models.TableMoradia;
import com.example.root.novoteste.models.TableTipoAcesso;
import com.example.root.novoteste.models.TableTipoAnimal;
import com.example.root.novoteste.models.TableTipoDomicilio;
import com.example.root.novoteste.models.TableTratamentoAgua;

import java.util.List;

/**
 * Created by root on 20/09/2016.
 */

public class Cadastro_Domi2 extends Fragment {

    private EditText cns, nomeLogradouro, numLogradouro, tipoLogradouro, complemento, telResidencial, numMoradores, numComodos, howManyAnimals;

    private String sus, nameLogradouro, numberLograd, tipoLograd, comple, teleResid,  numMora, numComods, quantosAnimais, teste;

    private RadioButton radioLocalizacao, radioTipoDomicilio, radioMoradia;

    // ID's dos radiobuttons sem converter
    int loca, mora, tipoDomi, condiTer, tipoAcess,
        abastAgua, tratAgua, destLixo, escoa, animals, energy;

    // ID's dos radiobuttons convertidos
    int estado, muni, CEP, localizacao, moradia, tipoDomicilio, condiTerra, tipoAcesso, abastecimentoAgua, tratamentoAgua, destinoLixo, formaEscoamento, animais, energia;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            if(TableLocalizacao.listAll(TableLocalizacao.class).size() == 0){
                new TableLocalizacao("Rural").save();
                new TableLocalizacao("Urbana").save();

                new TableTipoDomicilio("Casa").save();
                new TableTipoDomicilio("Apartamento").save();
                new TableTipoDomicilio("Cômodo").save();
                new TableTipoDomicilio("Outro").save();

                new TableMoradia("Próprio").save();
                new TableMoradia("Financiado").save();
                new TableMoradia("Alugado").save();
                new TableMoradia("Arrendado").save();
                new TableMoradia("Cedido").save();
                new TableMoradia("Ocupação").save();
                new TableMoradia("Situação de Rua").save();
                new TableMoradia("Outra").save();

                new TableCondicaoTerra("Proprietário").save();
                new TableCondicaoTerra("Parceiro(a)/Meeiro(a)").save();
                new TableCondicaoTerra("Assentado(a)").save();
                new TableCondicaoTerra("Posseiro").save();
                new TableCondicaoTerra("Arrendatário(a)").save();
                new TableCondicaoTerra("Comodatário(a)").save();
                new TableCondicaoTerra("Beneficiário(a) do Banco da Terra").save();
                new TableCondicaoTerra("Não se aplica").save();

                new TableTipoAcesso("Pavimento").save();
                new TableTipoAcesso("Chão Batido").save();
                new TableTipoAcesso("Fluvial").save();
                new TableTipoAcesso("Outro").save();

                new TableAbastecimentoAgua("Rede Encanada até o Domicílio").save();
                new TableAbastecimentoAgua("Poço/Nascente no Domicílio").save();
                new TableAbastecimentoAgua("Cisterna").save();
                new TableAbastecimentoAgua("Carro Pipa").save();
                new TableAbastecimentoAgua("Outro").save();

                new TableTratamentoAgua("Filtração").save();
                new TableTratamentoAgua("Fervura").save();
                new TableTratamentoAgua("Cloração").save();
                new TableTratamentoAgua("Sem Tratamento").save();

                new TableDestinoLixo("Coletado").save();
                new TableDestinoLixo("Queimado/Enterrado").save();
                new TableDestinoLixo("Céu Aberto").save();
                new TableDestinoLixo("Outro").save();

                new TableEnergia("Sim").save();
                new TableEnergia("Não").save();

                new TableFormaEscoamento("Rede Coletora de Esgoto ou Pluvial");
                new TableFormaEscoamento("Fossa Séptica");
                new TableFormaEscoamento("Fossa Rudimentar");
                new TableFormaEscoamento("Direto para um Rio, Lago ou Mar");
                new TableFormaEscoamento("Céu Aberto");
                new TableFormaEscoamento("Outro");

                new TableTipoAnimal("Gato").save();
                new TableTipoAnimal("Cachorro").save();
                new TableTipoAnimal("Pássaro").save();
                new TableTipoAnimal("De Criação(porco, galinha...)").save();
                new TableTipoAnimal("Outros").save();

                new TableMaterialPredominante("Com Revestimento").save();
                new TableMaterialPredominante("Sem Revestimento").save();
                new TableMaterialPredominante("Madeira Aparelhada").save();
                new TableMaterialPredominante("Material Aproveitado").save();
                new TableMaterialPredominante("Palha").save();
                new TableMaterialPredominante("Outro Material").save();

            }
        }catch (SQLiteException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.cadastro_domiciliar2, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button registrar = (Button)view.findViewById(R.id.registrador);

        registrar.setOnClickListener(regHandler);

    }

    View.OnClickListener regHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            ///////////////////////////// FRAGMENTO 1 /////////////////////////////////////////////

            //EditTexts
            cns = (EditText) getActivity().findViewById(R.id.cns);
            nomeLogradouro = (EditText)getActivity().findViewById(R.id.nomeLogradouro);
            numLogradouro = (EditText)getActivity().findViewById(R.id.numLogradouro);
            tipoLogradouro = (EditText)getActivity().findViewById(R.id.tipolograd);
            complemento = (EditText)getActivity().findViewById(R.id.complemento);
            Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner2);
            telResidencial = (EditText)getActivity().findViewById(R.id.telResidencial);
            numMoradores = (EditText) getActivity().findViewById(R.id.numMoradores);
            numComodos = (EditText) getActivity().findViewById(R.id.numComodos);

            //Radiogroups
            RadioGroup radio_grp1 = (RadioGroup) getActivity().findViewById(R.id.localizacao);
            loca = radio_grp1.getCheckedRadioButtonId();
            radioLocalizacao = (RadioButton) getActivity().findViewById(loca);
            TableLocalizacao table = new TableLocalizacao();
            List<TableLocalizacao> lista = table.find(TableLocalizacao.class, "descricao = ?", radioLocalizacao.getText().toString());
            for (TableLocalizacao temporaria : lista) {
                //Toast.makeText(getActivity().getApplicationContext(), ""+temporaria.getId(), Toast.LENGTH_LONG).show();
            }


            RadioGroup radio_grp2 = (RadioGroup) getActivity().findViewById(R.id.moradia);
            mora = radio_grp2.getCheckedRadioButtonId();
            radioMoradia = (RadioButton) getActivity().findViewById(mora);
            
            //moradia = setMoradia(mora);


            RadioGroup radio_grp3 = (RadioGroup) getActivity().findViewById(R.id.tipoDomicilio);
            tipoDomi = radio_grp3.getCheckedRadioButtonId();
            radioTipoDomicilio = (RadioButton) getActivity().findViewById(tipoDomi);
            TableTipoDomicilio tipo = new TableTipoDomicilio();
            List<TableTipoDomicilio> listaTipoDomicilio = tipo.find(TableTipoDomicilio.class, "descricao = ?", radioTipoDomicilio.getText().toString());
            //Toast.makeText(getActivity().getApplicationContext(), ""+listaTipoDomicilio.size(), Toast.LENGTH_LONG).show();
            for (TableTipoDomicilio tipod : listaTipoDomicilio) {
                Toast.makeText(getActivity().getApplicationContext(), ""+tipod.getId(), Toast.LENGTH_LONG).show();
            }
//            RadioGroup radio_grp4 = (RadioGroup) getActivity().findViewById(R.id.condiTerra);
//            condiTer = radio_grp4.getCheckedRadioButtonId();
//            //condiTerra = setCondiTerra(condiTer);
//            RadioGroup radio_grp5 = (RadioGroup) getActivity().findViewById(R.id.tipoAcesso);
//            tipoAcess = radio_grp5.getCheckedRadioButtonId();
//            //tipoAcesso = setTipoAcesso(tipoAcess);
//
//
//          //Strings
            sus = cns.getText().toString();
            nameLogradouro = nomeLogradouro.getText().toString();
            numberLograd = numLogradouro.getText().toString();
            tipoLograd = tipoLogradouro.getText().toString();
            comple = complemento.getText().toString();
            teleResid = telResidencial.getText().toString();
            numMora = numMoradores.getText().toString();
            numComods = numComodos.getText().toString();
//
//
//            ///////////////////////////// FRAGMENTO 2 /////////////////////////////////////////////
//
//            //EditTexts
            howManyAnimals = (EditText) getView().findViewById(R.id.quantos);
//
//
//            //RadioGroups
//            RadioGroup radio_grp6 = (RadioGroup) getView().findViewById(R.id.abastecimentoAgua);
//                abastAgua = radio_grp6.getCheckedRadioButtonId();
//                //abastecimentoAgua = setAbast(abastAgua);
//            RadioGroup radio_grp7 = (RadioGroup) getView().findViewById(R.id.tratamentoAgua);
//                tratAgua = radio_grp7.getCheckedRadioButtonId();
//                //tratamentoAgua = setTratamento(tratAgua);
//            RadioGroup radio_grp8 = (RadioGroup) getView().findViewById(R.id.destinoLixo);
//                destLixo = radio_grp8.getCheckedRadioButtonId();
//                //destinoLixo = setDestinoLixo(destLixo);
//            RadioGroup radio_grp9 = (RadioGroup) getView().findViewById(R.id.energia);
//                energy = radio_grp9.getCheckedRadioButtonId();
//                //energia = setEnerg(energy);
//            RadioGroup radio_grp10 = (RadioGroup) getView().findViewById(R.id.formaEscoamento);
//                escoa = radio_grp10.getCheckedRadioButtonId();
//                //formaEscoamento = setFormaEscoa(escoa);
//            RadioGroup radio_grp11 = (RadioGroup) getView().findViewById(R.id.animais);
//                animals = radio_grp11.getCheckedRadioButtonId();
//                //animais = setAnimaiss(animals);
//
//
//            //Strings
            quantosAnimais = howManyAnimals.getText().toString();
//
//
//            String resultado;
//
//            Toast.makeText(getActivity().getApplicationContext(), ""+localizacao, Toast.LENGTH_LONG).show();
//
//            //resultado = crud.insereDado(sus, nameLogradouro, tipoLograd, numberLograd, comple, bairr, teleResid, numComods, numMora);
//
//            //Toast.makeText(getActivity().getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


            TableDomicilio domicilio = new TableDomicilio(nameLogradouro, numberLograd, sus, tipoLograd, comple, teleResid, numMora, numComods);
            domicilio.save();


        }
    };

}
