package com.example.root.novoteste;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by root on 30/08/2016.
 */
public class Cadastro_Ind1 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.cadastro_individual1, container, false);
    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.masculino:
//                if (checked)
//                    // Pirates are the best
//                    break;
//            case R.id.feminino:
//                if (checked)
//                    // Ninjas rule
//                    break;
//        }
//    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
//        // Cria um  ArrayAdapter usando um array de string e um spinner padrão
//        // USAR getActivity().getApplicationContext() CASO getContext() NÃO FUNCIONE
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.UF, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);


        RadioButton masculino = (RadioButton) getActivity().findViewById(R.id.masculino);
        RadioButton feminino = (RadioButton) getActivity().findViewById(R.id.feminino);

        masculino.setOnClickListener(next_Listener);
        feminino.setOnClickListener(next_Listener);

    }

    private View.OnClickListener next_Listener = new View.OnClickListener() {
        public void onClick(View v) {

            //xml find out which radio button has been checked ...
            RadioGroup radio_grp=(RadioGroup)getActivity().findViewById(R.id.radioGroup); //change or leave out this line (I've put it in because you might find it useful later )
            RadioButton masculino = (RadioButton)getActivity().findViewById(R.id.masculino);  //you dont need to do this again if global ...
            RadioButton feminino = (RadioButton) getActivity().findViewById(R.id.feminino);
            if(masculino.isChecked() == true) {
                //toast ... button has been selected ...
            }else if(feminino.isChecked() == true){

            }
        }
    };
}
