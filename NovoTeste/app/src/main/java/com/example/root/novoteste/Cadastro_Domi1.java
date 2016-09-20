package com.example.root.novoteste;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

/**
 * Created by root on 20/09/2016.
 */

public class Cadastro_Domi1 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.cadastro_domiciliar1, container, false);
    }
}
