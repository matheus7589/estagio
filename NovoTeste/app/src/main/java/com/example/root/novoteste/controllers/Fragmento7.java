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

public class Fragmento7 extends Fragment {

    ImageButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
    int i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0, i7 = 0, i8 = 0, i9 = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o Layout pra esse fragmento
        return inflater.inflate(R.layout.avaliacao_sensitiva7, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // IMG BUTTONS

        button1 = (ImageButton)view.findViewById(R.id.imageButton21);
        button1.setOnClickListener(imgButtonHandler);

        button2 = (ImageButton)view.findViewById(R.id.imageButton22);
        button2.setOnClickListener(imgButtonHandler2);

        button3 = (ImageButton)view.findViewById(R.id.imageButton23);
        button3.setOnClickListener(imgButtonHandler3);

        button4 = (ImageButton)view.findViewById(R.id.imageButton24);
        button4.setOnClickListener(imgButtonHandler4);

        button5 = (ImageButton)view.findViewById(R.id.imageButton25);
        button5.setOnClickListener(imgButtonHandler5);

        button6 = (ImageButton)view.findViewById(R.id.imageButton26);
        button6.setOnClickListener(imgButtonHandler6);

        button7 = (ImageButton)view.findViewById(R.id.imageButton27);
        button7.setOnClickListener(imgButtonHandler7);

        button8 = (ImageButton)view.findViewById(R.id.imageButton28);
        button8.setOnClickListener(imgButtonHandler8);

        button9 = (ImageButton)view.findViewById(R.id.imageButton29);
        button9.setOnClickListener(imgButtonHandler9);

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

    View.OnClickListener imgButtonHandler7 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i7 == 0) {
                button7.setImageResource(R.drawable.circled_7_red);
                i7 = 1;
            }else{
                button7.setImageResource(R.drawable.circled_7_green);
                i7 = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler8 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i8 == 0) {
                button8.setImageResource(R.drawable.circled_8_red);
                i8 = 1;
            }else{
                button8.setImageResource(R.drawable.circled_8_green);
                i8 = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler9 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i9 == 0) {
                button9.setImageResource(R.drawable.circled_9_red);
                i9 = 1;
            }else{
                button9.setImageResource(R.drawable.circled_9_green);
                i9 = 0;
            }

        }
    };
}
