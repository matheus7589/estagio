package com.example.root.novoteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.example.root.novoteste.R.id.toolbar;

public class AvaliacaoSensitiva extends AppCompatActivity {

    ImageButton button1, button2, button3, button4, button5, button6;
    Button next;
    ImageView imagem;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avaliacao_sensitiva1);


        button1 = (ImageButton)findViewById(R.id.imageButton);
        button1.setOnClickListener(imgButtonHandler);

        button2 = (ImageButton)findViewById(R.id.imageButton2);
        button2.setOnClickListener(imgButtonHandler2);

        button3 = (ImageButton)findViewById(R.id.imageButton3);
        button3.setOnClickListener(imgButtonHandler3);

        button4 = (ImageButton)findViewById(R.id.imageButton4);
        button4.setOnClickListener(imgButtonHandler4);

        button5 = (ImageButton)findViewById(R.id.imageButton5);
        button5.setOnClickListener(imgButtonHandler5);

        button6 = (ImageButton)findViewById(R.id.imageButton6);
        button6.setOnClickListener(imgButtonHandler6);


        //imagem = (ImageView) findViewById(R.id.imageView3);
        //next.setOnClickListener(nextButtonHandler);

        }

    View.OnClickListener nextButtonHandler = new View.OnClickListener(){

        public void onClick(View v){

        }

    };

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

    View.OnClickListener imgButtonHandler2 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i == 0) {
                button2.setImageResource(R.drawable.circled_2_red);
                i = 1;
            }else{
                button2.setImageResource(R.drawable.circled_2_green);
                i = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler3 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i == 0) {
                button3.setImageResource(R.drawable.circled_3_red);
                i = 1;
            }else{
                button3.setImageResource(R.drawable.circled_3_green);
                i = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler4 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i == 0) {
                button4.setImageResource(R.drawable.circled_4_red);
                i = 1;
            }else{
                button4.setImageResource(R.drawable.circled_4_green);
                i = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler5 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i == 0) {
                button5.setImageResource(R.drawable.circled_5_red);
                i = 1;
            }else{
                button5.setImageResource(R.drawable.circled_5_green);
                i = 0;
            }

        }
    };

    View.OnClickListener imgButtonHandler6 = new View.OnClickListener() {

        public void onClick(View v) {
            if(i == 0) {
                button6.setImageResource(R.drawable.circled_6_red);
                i = 1;
            }else{
                button6.setImageResource(R.drawable.circled_6_green);
                i = 0;
            }

        }
    };

}
