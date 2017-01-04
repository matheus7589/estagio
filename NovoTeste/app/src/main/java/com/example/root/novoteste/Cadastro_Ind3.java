package com.example.root.novoteste;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.root.novoteste.models.TableComunidadeTradicional;
import com.example.root.novoteste.models.TableCreche;
import com.example.root.novoteste.models.TableCrianca;
import com.example.root.novoteste.models.TableCuidador;
import com.example.root.novoteste.models.TableDeficiencia;
import com.example.root.novoteste.models.TableDomicilio;
import com.example.root.novoteste.models.TableGrau;
import com.example.root.novoteste.models.TableGrupoComunitario;
import com.example.root.novoteste.models.TableIndividuo;
import com.example.root.novoteste.models.TableMercadoTrabalho;
import com.example.root.novoteste.models.TableNacionalidade;
import com.example.root.novoteste.models.TableOrientacaoSexual;
import com.example.root.novoteste.models.TableParentesco;
import com.example.root.novoteste.models.TablePlanoSaude;
import com.example.root.novoteste.models.TableRaca;
import com.example.root.novoteste.models.TableSaidaCadastro;
import com.example.root.novoteste.models.TableSexo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by root on 13/09/2016.
 */
public class Cadastro_Ind3 extends Fragment {


    private EditText ocupacao, telefone, municipio, cartaoSus, nomeCompleto, nomeSocial, dataNascimento, pisPasep, paisNascimento, nomeMae, eMail;
    private String ocup, tele, muni, sus, nomeComp, nomeSoci, data, pasep, pais, mae, mail;

    //ID's sem converter
    int sex, rac, naci, gra, paren, cre, merc, orien, defi, cria, cuida, plano, grupo, comu, sai;

    //ID's convertidos
    int sexo, raca, nacionalidade, grau, parentensco, creche, mercadotrab, orientacao, deficiencia, crianca, cuidador, planosaude,
            grupoComunitario, comunidadeTradicional, saida;

    RadioButton texto, radioSexo, radioRaca, radioNacionalidade, radioParentesco, radioGrauEscolaridade, radioCreche, radioMercadoTrabalho,
            radioOrientacao, radioDeficiencia, radioCrianca, radioCuidador, radioPlanoSaude, radioGrupoComunitario, radioComunidadeTradicional,
            radioSaida;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            if(TableSexo.listAll(TableSexo.class).size() == 0){
                new TableSexo("Masculino").save();
                new TableSexo("Feminino").save();

                new TableNacionalidade("Brasileiro").save();
                new TableNacionalidade("Naturalizado").save();
                new TableNacionalidade("Estrangeiro").save();



            }
        }catch (SQLiteException exception) {
            exception.printStackTrace();
        }



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
            ///////////////////////////// FRAGMENTO 1 /////////////////////////////////////////////
            //EditTexts
//            telefone = (EditText) getActivity().findViewById(R.id.telefone);
//            municipio = (EditText) getActivity().findViewById(R.id.municipio);
//            cartaoSus = (EditText) getActivity().findViewById(R.id.sus);
//            nomeCompleto = (EditText) getActivity().findViewById(R.id.nomeCompleto);
//            nomeSocial = (EditText) getActivity().findViewById(R.id.nomeSocial);
//            dataNascimento = (EditText) getActivity().findViewById(R.id.dataNascimento);
//            pisPasep = (EditText) getActivity().findViewById(R.id.pisPasep);
//            paisNascimento = (EditText) getActivity().findViewById(R.id.paisNascimento);
//            nomeMae = (EditText) getActivity().findViewById(R.id.nomeMae);
//            eMail = (EditText) getActivity().findViewById(R.id.email);
//
//            //Strings
//            tele = telefone.getText().toString();
//            if(TextUtils.isEmpty(tele)) {
//                telefone.setError("Este campo não pode estar vazio!");
//                return;
//            }
//
//            muni = municipio.getText().toString();
//            if(TextUtils.isEmpty(muni)) {
//                municipio.setError("Este campo não pode estar vazio!");
//                return;
//            }
//
//            sus = cartaoSus.getText().toString();
//            if(TextUtils.isEmpty(sus)) {
//                cartaoSus.setError("Este campo não pode estar vazio!");
//                return;
//            }
//            nomeComp = nomeCompleto.getText().toString();
//            if(TextUtils.isEmpty(nomeComp)) {
//                nomeCompleto.setError("Este campo não pode estar vazio!");
//                return;
//            }
//
//            nomeSoci = nomeSocial.getText().toString();
//            if(TextUtils.isEmpty(nomeSoci)) {
//                nomeSocial.setError("Este campo não pode estar vazio!");
//                return;
//            }
//
//            data = dataNascimento.getText().toString();
//            if(TextUtils.isEmpty(data)) {
//                dataNascimento.setError("Este campo não pode estar vazio!");
//                return;
//            }
//            pasep = pisPasep.getText().toString();
//            if(TextUtils.isEmpty(pasep)) {
//                pisPasep.setError("Este campo não pode estar vazio!");
//                return;
//            }
//
//            pais = paisNascimento.getText().toString();
//            if(TextUtils.isEmpty(pais)) {
//                paisNascimento.setError("Este campo não pode estar vazio!");
//                return;
//            }
//            mae = nomeMae.getText().toString();
//            if(TextUtils.isEmpty(mae)) {
//                nomeMae.setError("Este campo não pode estar vazio!");
//                return;
//            }
//
//            mail = eMail.getText().toString();
//            if(TextUtils.isEmpty(mail)) {
//                eMail.setError("Este campo não pode estar vazio!");
//                return;
//            }
//
//            //RadioGroups
//            RadioGroup radio_grp1 = (RadioGroup) getView().findViewById(R.id.sexoInd);
//            if(radio_grp1.getCheckedRadioButtonId() == -1){
//                Toast.makeText(getActivity().getApplicationContext(), "Sexo não selecionado!", Toast.LENGTH_LONG).show();
//                return;
//            }else {
//                sex = radio_grp1.getCheckedRadioButtonId();
//                radioSexo = (RadioButton) getActivity().findViewById(sex);
//                TableSexo tableSexo = new TableSexo();
//                List<TableSexo> listaSexo = tableSexo.find(TableSexo.class, "descricao = ?", radioSexo.getText().toString());
//                for (TableSexo temporaria : listaSexo) {
//                    sexo = (int) (long) temporaria.getId();
//                }
//            }
//
//            RadioGroup radio_grp2 = (RadioGroup) getView().findViewById(R.id.raca);
//            if(radio_grp2.getCheckedRadioButtonId() == -1){
//                Toast.makeText(getActivity().getApplicationContext(), "Raça não selecionada!", Toast.LENGTH_LONG).show();
//                return;
//            }else {
//                rac = radio_grp2.getCheckedRadioButtonId();
//                radioRaca = (RadioButton) getActivity().findViewById(rac);
//                TableRaca tableRaca = new TableRaca();
//                List<TableRaca> listaRaca = tableRaca.find(TableRaca.class, "descricao = ?", radioRaca.getText().toString());
//                for(TableRaca temporaria : listaRaca){
//                    raca = (int) (long) temporaria.getId();
//                }
//            }
//
//            RadioGroup radio_grp14 = (RadioGroup) getView().findViewById(R.id.nacionalidade);
//            if(radio_grp14.getCheckedRadioButtonId() == -1){
//                Toast.makeText(getActivity().getApplicationContext(), "Raça não selecionada!", Toast.LENGTH_LONG).show();
//                return;
//            }else {
//                naci = radio_grp2.getCheckedRadioButtonId();
//                radioNacionalidade = (RadioButton) getActivity().findViewById(naci);
//                TableNacionalidade tableNacionalidade = new TableNacionalidade();
//                List<TableNacionalidade> listaNacionalidade = tableNacionalidade.find(TableNacionalidade.class, "descricao = ?", radioNacionalidade.getText().toString());
//                for(TableNacionalidade temporaria : listaNacionalidade){
//                    nacionalidade = (int) (long) temporaria.getId();
//                }
//            }


            ///////////////////////////// FRAGMENTO 2 /////////////////////////////////////////////

            //EditTexts
            ocupacao = (EditText) getActivity().findViewById(R.id.ocupacao);

            //Strings
            ocup = ocupacao.getText().toString();
            if(TextUtils.isEmpty(ocup)){
                ocupacao.setError("Este campo não pode estar vazio!");
                return;
            }

            //RadioGroups
            RadioGroup radio_grp3 = (RadioGroup) getActivity().findViewById(R.id.parentesco);
            if(radio_grp3.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Grau de parentesco não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                paren = radio_grp3.getCheckedRadioButtonId();
                radioParentesco = (RadioButton) getActivity().findViewById(paren);
                TableParentesco tableParentesco = new TableParentesco();
                List<TableParentesco> listaParentesco = tableParentesco.find(TableParentesco.class, "descricao = ?", radioParentesco.getText().toString());
                for(TableParentesco temporaria : listaParentesco){
                    parentensco = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp4 = (RadioGroup) getActivity().findViewById(R.id.grau);
            if(radio_grp4.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Grau de Escolaridade não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                gra = radio_grp4.getCheckedRadioButtonId();
                radioGrauEscolaridade = (RadioButton) getActivity().findViewById(gra);
                TableGrau tableGrau = new TableGrau();
                List<TableGrau> listaGrau = tableGrau.find(TableGrau.class, "descricao = ?", radioGrauEscolaridade.getText().toString());
                for(TableGrau temporaria : listaGrau){
                    grau = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp5 = (RadioGroup) getActivity().findViewById(R.id.creche);
            if(radio_grp5.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Situação de escola ou creche não informado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                cre = radio_grp5.getCheckedRadioButtonId();
                radioCreche = (RadioButton) getActivity().findViewById(cre);
                TableCreche tableCreche = new TableCreche();
                List<TableCreche> listaCreche = tableCreche.find(TableCreche.class, "descricao = ?", radioCreche.getText().toString());
                for(TableCreche temporaria : listaCreche){
                    creche = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp6 = (RadioGroup) getActivity().findViewById(R.id.mercadotrab);
            if(radio_grp6.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Situação no mercado de trabalho não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                merc = radio_grp6.getCheckedRadioButtonId();
                radioMercadoTrabalho = (RadioButton) getActivity().findViewById(merc);
                TableMercadoTrabalho tableMercadoTrabalho = new TableMercadoTrabalho();
                List<TableMercadoTrabalho> listaMercado = tableMercadoTrabalho.find(TableMercadoTrabalho.class, "descricao = ?", radioMercadoTrabalho.getText().toString());
                for(TableMercadoTrabalho temporaria : listaMercado){
                    mercadotrab = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp7 = (RadioGroup) getActivity().findViewById(R.id.orientacao);
            if(radio_grp7.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Orientação sexual não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                orien = radio_grp7.getCheckedRadioButtonId();
                radioOrientacao = (RadioButton) getActivity().findViewById(orien);
                TableOrientacaoSexual tableOrientacaoSexual = new TableOrientacaoSexual();
                List<TableOrientacaoSexual> listaOrientacao = tableOrientacaoSexual.find(TableOrientacaoSexual.class, "descricao = ?", radioOrientacao.getText().toString());
                for(TableOrientacaoSexual temporaria : listaOrientacao){
                    orientacao = (int) (long) temporaria.getId();
                }
            }

            RadioGroup radio_grp8 = (RadioGroup) getActivity().findViewById(R.id.deficiencia);
            if(radio_grp8.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Deficiência não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                defi = radio_grp8.getCheckedRadioButtonId();
                radioDeficiencia = (RadioButton) getActivity().findViewById(defi);
                TableDeficiencia tableDeficiencia = new TableDeficiencia();
                List<TableDeficiencia> listaDeficiencia = tableDeficiencia.find(TableDeficiencia.class, "descricao = ?", radioDeficiencia.getText().toString());
                for(TableDeficiencia temporaria : listaDeficiencia){
                    deficiencia = (int) (long) temporaria.getId();
                }
            }


            ///////////////////////////// FRAGMENTO 3 /////////////////////////////////////////////

            //RadioGroups
            RadioGroup radio_grp9 = (RadioGroup) getView().findViewById(R.id.crianca);
            if(radio_grp9.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Não foi informado com quem a criança fica!", Toast.LENGTH_LONG).show();
                return;
            }else {
                cria = radio_grp8.getCheckedRadioButtonId();
                radioCrianca = (RadioButton) getActivity().findViewById(cria);
                TableCrianca tableCrianca = new TableCrianca();
                List<TableCrianca> listaCrianca = tableCrianca.find(TableCrianca.class, "descricao = ?", radioCrianca.getText().toString());
                for(TableCrianca temporaria : listaCrianca){
                    crianca = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp10 = (RadioGroup) getView().findViewById(R.id.cuidador);
            if(radio_grp10.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Cuidador tradicional não informado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                cuida = radio_grp10.getCheckedRadioButtonId();
                radioCuidador = (RadioButton) getActivity().findViewById(cuida);
                TableCuidador tableCuidador = new TableCuidador();
                List<TableCuidador> listaCuidador = tableCuidador.find(TableCuidador.class, "descricao = ?", radioCuidador.getText().toString());
                for(TableCuidador temporaria : listaCuidador){
                    cuidador = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp11 = (RadioGroup) getView().findViewById(R.id.planoSaude);
            if(radio_grp11.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Plano de saúde não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                plano = radio_grp11.getCheckedRadioButtonId();
                radioPlanoSaude = (RadioButton) getActivity().findViewById(plano);
                TablePlanoSaude tablePlanoSaude = new TablePlanoSaude();
                List<TablePlanoSaude> listaPlano = tablePlanoSaude.find(TablePlanoSaude.class, "descricao = ?", radioPlanoSaude.getText().toString());
                for(TablePlanoSaude temporaria : listaPlano){
                    planosaude = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp12 = (RadioGroup) getView().findViewById(R.id.grupoComunitario);
            if(radio_grp12.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Grupo Comunitário não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                grupo = radio_grp12.getCheckedRadioButtonId();
                radioGrupoComunitario = (RadioButton) getActivity().findViewById(grupo);
                TableGrupoComunitario tableGrupoComunitario = new TableGrupoComunitario();
                List<TableGrupoComunitario> listaGrupo = tableGrupoComunitario.find(TableGrupoComunitario.class, "descricao = ?", radioGrupoComunitario.getText().toString());
                for(TableGrupoComunitario temporaria : listaGrupo){
                    grupoComunitario = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp13 = (RadioGroup) getView().findViewById(R.id.comunidadeTradicional);
            if(radio_grp13.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Comunidade Tradicional não selecionada!", Toast.LENGTH_LONG).show();
                return;
            }else {
                comu = radio_grp13.getCheckedRadioButtonId();
                radioComunidadeTradicional = (RadioButton) getActivity().findViewById(comu);
                TableComunidadeTradicional tableComunidadeTradicional = new TableComunidadeTradicional();
                List<TableComunidadeTradicional> listaComunidade = tableComunidadeTradicional.find(TableComunidadeTradicional.class, "descricao = ?", radioComunidadeTradicional.getText().toString());
                for(TableComunidadeTradicional temporaria : listaComunidade){
                    comunidadeTradicional = (int) (long) temporaria.getId();
                }
            }


            RadioGroup radio_grp15 = (RadioGroup) getView().findViewById(R.id.saida);
            if(radio_grp15.getCheckedRadioButtonId() == -1){
                Toast.makeText(getActivity().getApplicationContext(), "Motivo de saída não selecionado!", Toast.LENGTH_LONG).show();
                return;
            }else {
                sai = radio_grp15.getCheckedRadioButtonId();
                radioSaida = (RadioButton) getActivity().findViewById(sai);
                TableSaidaCadastro tableSaidaCadastro = new TableSaidaCadastro();
                List<TableSaidaCadastro> listaSaida = tableSaidaCadastro.find(TableSaidaCadastro.class, "descricao = ?", radioSaida.getText().toString());
                for(TableSaidaCadastro temporaria : listaSaida){
                    saida = (int) (long) temporaria.getId();
                }
            }


            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
            String dataInicioResidencia = dateformat.format(c.getTime());



//            TableIndividuo individuo = new TableIndividuo(nomeComp, nomeSoci, sus, data, mae, tele, ocup, pasep, pais, mail, muni, sexo, raca, nacionalidade, grau,
//                    parentensco, creche, mercadotrab, orientacao, deficiencia, crianca, cuidador, planosaude, grupoComunitario, comunidadeTradicional, saida,
//                    dataInicioResidencia);
//
//            individuo.save();








            //Intent intent = getActivity().getIntent();
            //TableDomicilio table = (TableDomicilio) intent.getExtras().getSerializable("Domicilio");

//            resultado = crud.insereDado(tele, muni);
//
//            Toast.makeText(getActivity().getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        }
    };

    public void updateText(String string)
    {
        tele = string;
        //Toast.makeText(getActivity().getApplicationContext(), ""+tele, Toast.LENGTH_LONG).show();
    }


}
