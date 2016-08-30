package com.example.root.novoteste;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * Created by root on 01/08/2016.
 */
public class Fragmento1 extends Fragment {


    ImageButton button1, button2, button3, button4, button5, button6;
    int i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.avaliacao_sensitiva1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // IMG BUTTONS

        button1 = (ImageButton)view.findViewById(R.id.imageButton);
        button1.setOnClickListener(imgButtonHandler);

        button2 = (ImageButton)view.findViewById(R.id.imageButton2);
        button2.setOnClickListener(imgButtonHandler2);

        button3 = (ImageButton)view.findViewById(R.id.imageButton3);
        button3.setOnClickListener(imgButtonHandler3);

        button4 = (ImageButton)view.findViewById(R.id.imageButton4);
        button4.setOnClickListener(imgButtonHandler4);

        button5 = (ImageButton)view.findViewById(R.id.imageButton5);
        button5.setOnClickListener(imgButtonHandler5);

        button6 = (ImageButton)view.findViewById(R.id.imageButton6);
        button6.setOnClickListener(imgButtonHandler6);

        // IMG BUTTONS
    }

    // HANDLER DOS IMG BUTTON

    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            if(i1 == 0) {
                button1.setImageResource(R.drawable.circled_1_red);
                i1 = 1;
            }else{
                button1.setImageResource(R.drawable.circled_1_green);
                i1 = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler2 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i2 == 0) {
                button2.setImageResource(R.drawable.circled_2_red);
                i2 = 1;
            }else{
                button2.setImageResource(R.drawable.circled_2_green);
                i2 = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler3 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i3 == 0) {
                button3.setImageResource(R.drawable.circled_3_red);
                i3 = 1;
            }else{
                button3.setImageResource(R.drawable.circled_3_green);
                i3 = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler4 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i4 == 0) {
                button4.setImageResource(R.drawable.circled_4_red);
                i4 = 1;
            }else{
                button4.setImageResource(R.drawable.circled_4_green);
                i4 = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler5 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i5 == 0) {
                button5.setImageResource(R.drawable.circled_5_red);
                i5 = 1;
            }else{
                button5.setImageResource(R.drawable.circled_5_green);
                i5 = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler6 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i6 == 0) {
                button6.setImageResource(R.drawable.circled_6_red);
                i6 = 1;
            }else{
                button6.setImageResource(R.drawable.circled_6_green);
                i6 = 0;
            }

        }
    };

    // HANDLER DOS IMG BUTTON

}
