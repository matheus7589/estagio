package com.example.root.novoteste;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by root on 30/08/2016.
 */
public class Cadastro_Ind2 extends Fragment {

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


        RadioButton branca = (RadioButton) getActivity().findViewById(R.id.branca);
        RadioButton preta = (RadioButton) getActivity().findViewById(R.id.preta);
        RadioButton parda = (RadioButton) getActivity().findViewById(R.id.parda);
        RadioButton indigena = (RadioButton) getActivity().findViewById(R.id.indigena);


        RadioButton brasileiro = (RadioButton) getActivity().findViewById(R.id.brasileiro);
        RadioButton naturalizado = (RadioButton) getActivity().findViewById(R.id.naturalizado);
        RadioButton estrangeiro = (RadioButton) getActivity().findViewById(R.id.estrangeiro);

        branca.setOnClickListener(next_Listener);
        preta.setOnClickListener(next_Listener);
        parda.setOnClickListener(next_Listener);
        indigena.setOnClickListener(next_Listener);

        brasileiro.setOnClickListener(outro_Listener);
        naturalizado.setOnClickListener(outro_Listener);
        estrangeiro.setOnClickListener(outro_Listener);

    }

    private View.OnClickListener next_Listener = new View.OnClickListener() {
        public void onClick(View v) {

            //xml find out which radio button has been checked ...
            RadioGroup radio_grp = (RadioGroup) getActivity().findViewById(R.id.radioGroup2); //change or leave out this line (I've put it in because you might find it useful later )
            RadioButton branca = (RadioButton) getActivity().findViewById(R.id.branca);  //you dont need to do this again if global ...
            RadioButton preta = (RadioButton) getActivity().findViewById(R.id.preta);
            RadioButton parda = (RadioButton) getActivity().findViewById(R.id.parda);
            RadioButton indigena = (RadioButton) getActivity().findViewById(R.id.indigena);
            if (branca.isChecked() == true) {
                //toast ... button has been selected ...
            } else if (preta.isChecked() == true) {

            } else if (parda.isChecked() == true) {

            } else if (indigena.isChecked() == true) {

            }
        }
    };


    private View.OnClickListener outro_Listener = new View.OnClickListener() {
        public void onClick(View v) {

            //xml find out which radio button has been checked ...
            RadioGroup radio_grp = (RadioGroup) getActivity().findViewById(R.id.radioGroup3); //change or leave out this line (I've put it in because you might find it useful later )
            RadioButton brasileiro = (RadioButton) getActivity().findViewById(R.id.brasileiro);  //you dont need to do this again if global ...
            RadioButton naturalizado = (RadioButton) getActivity().findViewById(R.id.naturalizado);
            RadioButton estrangeiro = (RadioButton) getActivity().findViewById(R.id.estrangeiro);

            if (brasileiro.isChecked() == true) {
                //toast ... button has been selected ...
            } else if (naturalizado.isChecked() == true) {

            } else if (estrangeiro.isChecked() == true) {

            }
        }
    };

}
