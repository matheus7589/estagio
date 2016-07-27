package com.example.root.novoteste;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class AvaliacaoSensitiva extends AppCompatActivity {

    ImageButton button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_sensitiva);


        button1 = (ImageButton)findViewById(R.id.imageButton);
        button1.setOnClickListener(imgButtonHandler);

        }

    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            button1.setBackgroundResource(R.drawable.circled_1_red);

        }
    };

}
