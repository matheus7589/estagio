package com.example.root.novoteste;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by root on 20/09/2016.
 */

public class Cadastro_Domi2 extends Fragment {

    private EditText cns, nomeLogradouro, numLogradouro, complemento, municipio, bairro, cep, telResidencial, numMoradores, numComodos, howManyAnimals;
    private String sus, nameLogradouro, numberLograd, comple, estado, muni, bairr, CEP, teleResid, localizacao, moradia, tipoDomicilio, condiTerra, tipoAcesso, numMora, numComods,
            abastecimentoAgua, tratamentoAgua, destinoLixo, formaEscoamento, animais, energia, quantosAnimais;
    int loca, mora, tipoDomi, condiTer, tipoAcess,
        abastAgua, tratAgua, destLixo, escoa, animals, energy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            BancoController crud = new BancoController(getActivity().getBaseContext());
            ///////////////////////////// FRAGMENTO 1 /////////////////////////////////////////////

            //EditTexts
            cns = (EditText) getActivity().findViewById(R.id.cns);
            nomeLogradouro = (EditText)getActivity().findViewById(R.id.nomeLogradouro);
            numLogradouro = (EditText)getActivity().findViewById(R.id.numLogradouro);
            complemento = (EditText)getActivity().findViewById(R.id.complemento);
            Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner2);
            municipio = (EditText)getActivity().findViewById(R.id.municipio);
            bairro = (EditText)getActivity().findViewById(R.id.bairro);
            cep = (EditText)getActivity().findViewById(R.id.cep);
            telResidencial = (EditText)getActivity().findViewById(R.id.telResidencial);
            numMoradores = (EditText) getActivity().findViewById(R.id.numMoradores);
            numComodos = (EditText) getActivity().findViewById(R.id.numComodos);

            //Radiogroups
            RadioGroup radio_grp1 = (RadioGroup) getActivity().findViewById(R.id.localizacao);
            loca = radio_grp1.getCheckedRadioButtonId();
            localizacao = setLocal(loca);
            RadioGroup radio_grp2 = (RadioGroup) getActivity().findViewById(R.id.moradia);
            mora = radio_grp2.getCheckedRadioButtonId();
            moradia = setMoradia(mora);
            RadioGroup radio_grp3 = (RadioGroup) getActivity().findViewById(R.id.tipoDomicilio);
            tipoDomi = radio_grp3.getCheckedRadioButtonId();
            tipoDomicilio = setTipoDomicilio(tipoDomi);
            RadioGroup radio_grp4 = (RadioGroup) getActivity().findViewById(R.id.condiTerra);
            condiTer = radio_grp4.getCheckedRadioButtonId();
            condiTerra = setCondiTerra(condiTer);
            RadioGroup radio_grp5 = (RadioGroup) getActivity().findViewById(R.id.tipoAcesso);
            tipoAcess = radio_grp5.getCheckedRadioButtonId();
            tipoAcesso = setTipoAcesso(tipoAcess);


            //Strings
            sus = cns.getText().toString();
            nameLogradouro = nomeLogradouro.getText().toString();
            numberLograd = numLogradouro.getText().toString();
            comple = complemento.getText().toString();
            estado = spinner.getSelectedItem().toString();
            muni = municipio.getText().toString();
            bairr = bairro.getText().toString();
            CEP = cep.getText().toString();
            teleResid = telResidencial.getText().toString();
            numMora = numMoradores.getText().toString();
            numComods = numComodos.getText().toString();


            ///////////////////////////// FRAGMENTO 2 /////////////////////////////////////////////

            //EditTexts
            howManyAnimals = (EditText) getView().findViewById(R.id.quantos);


            //RadioGroups
            RadioGroup radio_grp6 = (RadioGroup) getView().findViewById(R.id.abastecimentoAgua);
                abastAgua = radio_grp6.getCheckedRadioButtonId();
                abastecimentoAgua = setAbast(abastAgua);
            RadioGroup radio_grp7 = (RadioGroup) getView().findViewById(R.id.tratamentoAgua);
                tratAgua = radio_grp7.getCheckedRadioButtonId();
                tratamentoAgua = setTratamento(tratAgua);
            RadioGroup radio_grp8 = (RadioGroup) getView().findViewById(R.id.destinoLixo);
                destLixo = radio_grp8.getCheckedRadioButtonId();
                destinoLixo = setDestinoLixo(destLixo);
            RadioGroup radio_grp9 = (RadioGroup) getView().findViewById(R.id.energia);
                energy = radio_grp9.getCheckedRadioButtonId();
                energia = setEnerg(energy);
            RadioGroup radio_grp10 = (RadioGroup) getView().findViewById(R.id.formaEscoamento);
                escoa = radio_grp10.getCheckedRadioButtonId();
                formaEscoamento = setFormaEscoa(escoa);
            RadioGroup radio_grp11 = (RadioGroup) getView().findViewById(R.id.animais);
                animals = radio_grp11.getCheckedRadioButtonId();
                animais = setAnimaiss(animals);


            //Strings
            quantosAnimais = howManyAnimals.getText().toString();


            String resultado;

            //Toast.makeText(getActivity().getApplicationContext(), tratamentoAgua, Toast.LENGTH_LONG).show();

            resultado = crud.insereDadoDomicilio(sus, bairr, teleResid);

            Toast.makeText(getActivity().getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        }
    };

    public String setAbast(int id){
        if(id == R.id.redeEncanada)
            return "Rede Encanada até o Domicílio";
        else if(id == R.id.pocoNascente)
            return "Poço/Nascente no Domicílio";
        else if(id == R.id.cisternas)
            return "Cisterna";
        else if(id == R.id.carroPipa)
            return "Carro Pipa";
        else
            return "Outro";
    }

    public String setTratamento(int id){
        if(id == R.id.filtracao)
            return "Filtração";
        else if(id == R.id.fervura)
            return "Fervura";
        else if(id == R.id.cloracao)
            return "Cloração";
        else
            return "Sem Tratamento";
    }

    public String setDestinoLixo(int id){
        if(id == R.id.coletado)
            return "Coletado";
        else if(id == R.id.queimado)
            return "Queimado/Enterrado";
        else if(id == R.id.ceuAberto)
            return "Céu Aberto";
        else
            return "Outro";
    }

    public String setEnerg(int id){
        if(id == R.id.sim)
            return "Sim";
        else
            return "Não";
    }

    public String setFormaEscoa(int id){
        if(id == R.id.redeColetora)
            return "Rede Coletora de Esgoto ou Pluvial";
        else if(id == R.id.fossaSeptica)
            return "Fossa Séptica";
        else if(id == R.id.fossaRudimentar)
            return "Fossa Rudimentar";
        else if(id == R.id.diretoRio)
            return "Direto para um Rio, Lago ou Mar";
        else if(id == R.id.ceuAberto2)
            return "Céu Aberto";
        else
            return "Outro";
    }

    public String setAnimaiss(int id){
        if(id == R.id.gato)
            return "Gato";
        else if(id == R.id.dog)
            return "Cachorro";
        else if(id == R.id.bird)
            return "Pássaro";
        else if(id == R.id.porco)
            return "De Criação(porco, galinha...)";
        else
            return "Outros";
    }


    public String setLocal(int id){
        if(id == R.id.rural)
            return "Rural";
        else
            return "Urbana";
    }

    public String setMoradia(int id){
        if(id == R.id.proprio)
            return "Próprio";
        else if(id == R.id.financiado)
            return "Financiado";
        else if(id == R.id.alugado)
            return "Alugado";
        else if(id == R.id.arrendado)
            return "Arrendado";
        else if(id == R.id.cedido)
            return "Cedido";
        else if(id == R.id.ocupacao)
            return "Ocupação";
        else if(id == R.id.rua)
            return "Situação de Rua";
        else
            return "Outros";
    }

    public String setTipoDomicilio(int id){
        if(id == R.id.casa)
            return "Casa";
        else if(id == R.id.apartamento)
            return "Apartamento";
        else if(id == R.id.comodo)
            return "Cômodo";
        else
            return "Outro";
    }

    public String setCondiTerra(int id){
        if(id == R.id.proprietario)
            return "Proprietário";
        else if(id == R.id.parceiro)
            return "Parceiro(a)/Meeiro(a)";
        else if(id == R.id.assentado)
            return "Assentado(a)";
        else if(id == R.id.posseiro)
            return "Posseiro";
        else if(id == R.id.arrendatario)
            return "Arrendatário(a)";
        else if(id == R.id.comodatario)
            return "Comodatário(a)";
        else if(id == R.id.beneficiario)
            return "Beneficiário(a) do Banco da Terra";
        else
            return "Não se aplica";
    }

    public String setTipoAcesso(int id){
        if(id == R.id.pavimento)
            return "Pavimento";
        else if(id == R.id.chaoBatido)
            return "Chão Batido";
        else if(id == R.id.fluvial)
            return "Fluvial";
        else
            return "Outro";
    }

}
