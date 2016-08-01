package com.example.root.novoteste;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by root on 01/08/2016.
 */
public class Fragmento extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.activity_avaliacao_sensitiva, container, false);
    }

}
