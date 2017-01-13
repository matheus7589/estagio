package com.example.root.novoteste.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.root.novoteste.R;

/**
 * Created by suporte on 08/12/2016.
 */

public class Fragmento8 extends Fragment{

    ImageButton button1;
    int i = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.avaliacao_sensitiva8, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button1 = (ImageButton) view.findViewById(R.id.imageButton17);
        button1.setOnClickListener(imgButtonHandler);
    }

    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            if(i == 0) {
                button1.setImageResource(R.drawable.circled_1_red);
                i = 1;
            }else{
                button1.setImageResource(R.drawable.circled_1_green);
                i = 0;
            }

        }
    };
}
