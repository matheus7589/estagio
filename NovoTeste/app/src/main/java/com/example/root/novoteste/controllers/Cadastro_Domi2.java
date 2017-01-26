package com.example.root.novoteste.controllers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.root.novoteste.R;
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

    ProgressDialog dialog;

    TableDomicilio tableDomicilio = new TableDomicilio();

    private EditText cns, nomeLogradouro, numLogradouro, tipoLogradouro, complemento, telResidencial, numMoradores, numComodos, howManyAnimals;

    private String sus, nameLogradouro, numberLograd, tipoLograd, comple, teleResid,  numMora, numComods, quantosAnimais;

    private RadioButton radioLocalizacao, radioTipoDomicilio, radioMoradia, radioCondicaoTerra, radioTipoAcesso, radioAbastecimentoAgua, radioTratamentoAgua,
            radioDestinoLixo, radioEnergia, radioFormaEscoamento, radioTipoAnimal;

    // ID's dos radiobuttons sem converter
    int loca, mora, tipoDomi, condiTer, tipoAcess, abastAgua, tratAgua, destLixo, escoa, animals, energy;

    // ID's dos radiobuttons convertidos
    int localizacao, moradia, tipoDomicilio, condiTerra, tipoAcesso, abastecimentoAgua, tratamentoAgua, destinoLixo, formaEscoamento, tipoAnimai, energia;

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

//          //Strings
            sus = cns.getText().toString();
            if(TextUtils.isEmpty(sus)) {
                cns.setError("Este campo não pode estar vazio!");
                return;
            }

            nameLogradouro = nomeLogradouro.getText().toString();
            if(TextUtils.isEmpty(nameLogradouro)) {
                nomeLogradouro.setError("Este campo não pode estar vazio!");
                return;
            }

            numberLograd = numLogradouro.getText().toString();
            if(TextUtils.isEmpty(numberLograd)) {
                numLogradouro.setError("Este campo não pode estar vazio!");
                return;
            }

            tipoLograd = tipoLogradouro.getText().toString();
            if(TextUtils.isEmpty(tipoLograd)) {
                tipoLogradouro.setError("Este campo não pode estar vazio!");
                return;
            }

            comple = complemento.getText().toString();
            if(TextUtils.isEmpty(comple)) {
                complemento.setError("Este campo não pode estar vazio!");
                return;
            }

            teleResid = telResidencial.getText().toString();
            if(TextUtils.isEmpty(teleResid)) {
                telResidencial.setError("Este campo não pode estar vazio!");
                return;
            }

            numMora = numMoradores.getText().toString();
            if(TextUtils.isEmpty(numMora)) {
                numMoradores.setError("Este campo não pode estar vazio!");
                return;
            }

            numComods = numComodos.getText().toString();
            if(TextUtils.isEmpty(numComods)) {
                numComodos.setError("Este campo não pode estar vazio!");
                return;
            }

            //Radiogroups
            RadioGroup radio_grp1 = (RadioGroup) getActivity().findViewById(R.id.localizacao);
            if(radio_grp1.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Localização não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                loca = radio_grp1.getCheckedRadioButtonId();
                radioLocalizacao = (RadioButton) getActivity().findViewById(loca);
                TableLocalizacao tableLocalizacao = new TableLocalizacao();
                List<TableLocalizacao> listaLocalizacao = tableLocalizacao.find(TableLocalizacao.class, "descricao = ?", radioLocalizacao.getText().toString());
                for (TableLocalizacao temporaria : listaLocalizacao) {
                    localizacao = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp2 = (RadioGroup) getActivity().findViewById(R.id.moradia);
            if(radio_grp2.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Situação de moradia/Posse da terra não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                mora = radio_grp2.getCheckedRadioButtonId();
                radioMoradia = (RadioButton) getActivity().findViewById(mora);
                TableMoradia tableMoradia = new TableMoradia();
                List<TableMoradia> listaMoradia = tableMoradia.find(TableMoradia.class, "descricao = ?", radioMoradia.getText().toString());
                for (TableMoradia temporaria : listaMoradia) {
                    moradia = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp3 = (RadioGroup) getActivity().findViewById(R.id.tipoDomicilio);
            if(radio_grp3.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Tipo de domicílio não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                tipoDomi = radio_grp3.getCheckedRadioButtonId();
                radioTipoDomicilio = (RadioButton) getActivity().findViewById(tipoDomi);
                TableTipoDomicilio tableTipoDomicilio = new TableTipoDomicilio();
                List<TableTipoDomicilio> listaTipoDomicilio = tableTipoDomicilio.find(TableTipoDomicilio.class, "descricao = ?", radioTipoDomicilio.getText().toString());
                for (TableTipoDomicilio temporaria : listaTipoDomicilio) {
                    tipoDomicilio = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp4 = (RadioGroup) getActivity().findViewById(R.id.condiTerra);
            if(radio_grp4.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Condição de posse e uso da terra não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                condiTer = radio_grp4.getCheckedRadioButtonId();
                radioCondicaoTerra = (RadioButton) getActivity().findViewById(condiTer);
                TableCondicaoTerra tableCondicaoTerra = new TableCondicaoTerra();
                List<TableCondicaoTerra> listaCondicaoTerra = tableCondicaoTerra.find(TableCondicaoTerra.class, "descricao = ?", radioCondicaoTerra.getText().toString());
                for (TableCondicaoTerra temporaria : listaCondicaoTerra) {
                    condiTerra = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp5 = (RadioGroup) getActivity().findViewById(R.id.tipoAcesso);
            if(radio_grp5.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Tipo de Acesso não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                tipoAcess = radio_grp5.getCheckedRadioButtonId();
                radioTipoAcesso = (RadioButton) getActivity().findViewById(tipoAcess);
                TableTipoAcesso tableTipoAcesso = new TableTipoAcesso();
                List<TableTipoAcesso> listaTipoAcesso = tableTipoAcesso.find(TableTipoAcesso.class, "descricao = ?", radioTipoAcesso.getText().toString());
                for (TableTipoAcesso temporaria : listaTipoAcesso) {
                    tipoAcesso = (int) (long) temporaria.getId();
                }
            }


//            ///////////////////////////// FRAGMENTO 2 /////////////////////////////////////////////

            //EditTexts
            howManyAnimals = (EditText) getView().findViewById(R.id.quantos);

            //Strings
            quantosAnimais = howManyAnimals.getText().toString();


            //RadioGroups
            RadioGroup radio_grp6 = (RadioGroup) getView().findViewById(R.id.abastecimentoAgua);
            if(radio_grp6.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Tipo de abastecimento de água não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                abastAgua = radio_grp6.getCheckedRadioButtonId();
                radioAbastecimentoAgua = (RadioButton) getActivity().findViewById(abastAgua);
                TableAbastecimentoAgua tableAbastecimentoAgua = new TableAbastecimentoAgua();
                List<TableAbastecimentoAgua> listaAbastecimentoAgua = tableAbastecimentoAgua.find(TableAbastecimentoAgua.class, "descricao = ?", radioAbastecimentoAgua.getText().toString());
                for (TableAbastecimentoAgua temporaria : listaAbastecimentoAgua) {
                    abastecimentoAgua = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp7 = (RadioGroup) getView().findViewById(R.id.tratamentoAgua);
            if(radio_grp7.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Tratamento de água não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                tratAgua = radio_grp7.getCheckedRadioButtonId();
                radioTratamentoAgua = (RadioButton) getActivity().findViewById(tratAgua);
                TableTratamentoAgua tableTratamentoAgua = new TableTratamentoAgua();
                List<TableTratamentoAgua> listaTratamentoAgua = tableTratamentoAgua.find(TableTratamentoAgua.class, "descricao = ?", radioTratamentoAgua.getText().toString());
                for (TableTratamentoAgua temporaria : listaTratamentoAgua) {
                    tratamentoAgua = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp8 = (RadioGroup) getView().findViewById(R.id.destinoLixo);
            if(radio_grp8.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Destino do lixo não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                destLixo = radio_grp8.getCheckedRadioButtonId();
                radioDestinoLixo = (RadioButton) getActivity().findViewById(destLixo);
                TableDestinoLixo tableDestinoLixo = new TableDestinoLixo();
                List<TableDestinoLixo> listaDestinoLixo = tableDestinoLixo.find(TableDestinoLixo.class, "descricao = ?", radioDestinoLixo.getText().toString());
                for (TableDestinoLixo temporaria : listaDestinoLixo) {
                    destinoLixo = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp9 = (RadioGroup) getView().findViewById(R.id.energia);
            if(radio_grp9.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Disponibilidade de energia elétrica não informada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                energy = radio_grp9.getCheckedRadioButtonId();
                radioEnergia = (RadioButton) getActivity().findViewById(energy);
                TableEnergia tableEnergia = new TableEnergia();
                List<TableEnergia> listaEnergia = tableEnergia.find(TableEnergia.class, "descricao = ?", radioEnergia.getText().toString());
                for (TableEnergia temporaria : listaEnergia) {
                    energia = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp10 = (RadioGroup) getView().findViewById(R.id.formaEscoamento);
            if(radio_grp10.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Forma de Escoamento não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                escoa = radio_grp10.getCheckedRadioButtonId();
                radioFormaEscoamento = (RadioButton) getActivity().findViewById(escoa);
                TableFormaEscoamento tableFormaEscoamento = new TableFormaEscoamento();
                List<TableFormaEscoamento> listaFormaEscoamento = tableFormaEscoamento.find(TableFormaEscoamento.class, "descricao = ?", radioFormaEscoamento.getText().toString());
                for (TableFormaEscoamento temporaria : listaFormaEscoamento) {
                    formaEscoamento = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp11 = (RadioGroup) getView().findViewById(R.id.animais);
            if(radio_grp11.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Tipo de animal não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                animals = radio_grp11.getCheckedRadioButtonId();
                radioTipoAnimal = (RadioButton) getActivity().findViewById(animals);
                TableTipoAnimal tableTipoAnimal = new TableTipoAnimal();
                List<TableTipoAnimal> listaTipoAnimal = tableTipoAnimal.find(TableTipoAnimal.class, "descricao = ?", radioTipoAnimal.getText().toString());
                for (TableTipoAnimal temporaria : listaTipoAnimal) {
                    tipoAnimai = (int) (long) temporaria.getId();
                }
            }


            try {
                final TableDomicilio domicilio = new TableDomicilio(nameLogradouro, numberLograd, sus, tipoLograd, comple, teleResid, numMora, numComods, localizacao,
                        moradia, tipoDomicilio, condiTerra, tipoAcesso, abastecimentoAgua, tratamentoAgua, destinoLixo, energia, formaEscoamento, tipoAnimai);
                domicilio.save();

                tableDomicilio = domicilio;

                dialog = ProgressDialog.show(getActivity(),"Novo Domicílio","Salvando Domicílio. Aguarde...", false, true);
                dialog.setCancelable(false);


                new Thread() {

                    public void run() {

                        try {
                            Thread.sleep(2500);
                            dialog.dismiss();

                            //System.out.println(tableDomicilio.getId());

                            Intent individuo = new Intent(getActivity(), CadastroIndividual.class);
                            individuo.putExtra("Domicilio", tableDomicilio.getId());
                            individuo.putExtra("Responsavel", false);
                            startActivity(individuo);

                            getActivity().finish();

                        }catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }.start();

                Toast.makeText(getActivity().getApplicationContext(), "Domicílio salvo com sucesso!", Toast.LENGTH_LONG).show();

            }catch (SQLiteException exception) {
                Toast.makeText(getActivity().getApplicationContext(), "Erro ao adicionar domicílio!", Toast.LENGTH_LONG).show();
            }
        }
    };

}
