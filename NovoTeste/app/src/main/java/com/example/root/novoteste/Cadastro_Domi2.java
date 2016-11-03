package com.example.root.novoteste;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by root on 20/09/2016.
 */

public class Cadastro_Domi2 extends Fragment {

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


//        RadioButton urbana = (RadioButton) getActivity().findViewById(R.id.urbana);
//        RadioButton rural = (RadioButton) getActivity().findViewById(R.id.rural);
//
//
//        RadioButton casa = (RadioButton) getActivity().findViewById(R.id.casa);
//        RadioButton apartamento = (RadioButton) getActivity().findViewById(R.id.apartamento);
//        RadioButton comodo = (RadioButton) getActivity().findViewById(R.id.comodo);
//        //RadioButton outro = (RadioButton) getActivity().findViewById(R.id.outro);
//
//
//        urbana.setOnClickListener(next_Listener);
//        rural.setOnClickListener(next_Listener);
//
//        casa.setOnClickListener(outro_Listener);
//        apartamento.setOnClickListener(outro_Listener);
//        comodo.setOnClickListener(outro_Listener);
        //outro.setOnClickListener(outro_Listener);
    }

    private View.OnClickListener next_Listener = new View.OnClickListener() {
        public void onClick(View v) {

            //xml find out which radio button has been checked ...
            //RadioGroup radio_grp = (RadioGroup) getActivity().findViewById(R.id.radioGroup4); //change or leave out this line (I've put it in because you might find it useful later )

//            RadioButton urbana = (RadioButton) getActivity().findViewById(R.id.urbana);
//            RadioButton rural = (RadioButton) getActivity().findViewById(R.id.rural);
//            if (urbana.isChecked() == true) {
//                //toast ... button has been selected ...
//            } else if (rural.isChecked() == true) {
//
//            }
        }
    };

    private View.OnClickListener outro_Listener = new View.OnClickListener() {
        public void onClick(View v) {

            //xml find out which radio button has been checked ...
//            RadioGroup radio_grp = (RadioGroup) getActivity().findViewById(R.id.radioGroup5); //change or leave out this line (I've put it in because you might find it useful later )
//
//            RadioButton casa = (RadioButton) getActivity().findViewById(R.id.casa);  //you dont need to do this again if global ...
//            RadioButton apartamento = (RadioButton) getActivity().findViewById(R.id.apartamento);
//            RadioButton comodo = (RadioButton) getActivity().findViewById(R.id.comodo);
            //RadioButton outro = (RadioButton) getActivity().findViewById(R.id.outro);
//
//            if (casa.isChecked() == true) {
//                //toast ... button has been selected ...
//            } else if (apartamento.isChecked() == true) {
//
//            } else if (comodo.isChecked() == true) {
//
//            }
        }
    };
}
