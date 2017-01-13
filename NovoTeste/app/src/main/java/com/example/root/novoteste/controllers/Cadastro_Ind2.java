package com.example.root.novoteste.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.root.novoteste.R;

/**
 * Created by root on 30/08/2016.
 */
public class Cadastro_Ind2 extends Fragment {

    EditText cartSUS, nomeCompleto, dataNascimento, nomeMae, telefone, muniNascimento, uf;

    String cartao_SUS, nome_completo, data_nascimento, nome_mae, telefone_, muni_nascimento, uf_;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.cadastro_individual2, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }




}
