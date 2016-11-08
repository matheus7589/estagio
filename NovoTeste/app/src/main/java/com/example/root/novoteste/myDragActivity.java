package com.example.root.novoteste;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by root on 07/11/2016.
 */

public class myDragActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);

        findViewById(R.id.img1).setOnLongClickListener(new MyOnLongClickListener());
        findViewById(R.id.img2).setOnLongClickListener(new MyOnLongClickListener());

        findViewById(R.id.topleft).setOnDragListener(new MyOnDragListener(1));
        findViewById(R.id.topright).setOnDragListener(new MyOnDragListener(2));
    }

    class MyOnLongClickListener implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View view) {
            ClipData clipData = ClipData.newPlainText("simple_teste", "texte");

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            view.startDrag(clipData, shadowBuilder, view, 0);
            view.setVisibility(view.INVISIBLE);

            return true;
        }
    }

    class MyOnDragListener implements View.OnDragListener{
        private  int numero;

        public MyOnDragListener(int numero){
            super();
            this.numero = numero;
        }

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int acao = dragEvent.getAction();

            switch(acao){
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.i("Script", numero+" - ACTION_DRAG_STARTED");
                    if(dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)){
                        return(true);
                    }
                    return(false);
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Script", numero+" - ACTION_DRAG_ENTERED");
                    view.setBackgroundColor(Color.YELLOW);
                    break;
                case DragEvent.ACTION_DRAG_LOCATION:
                    Log.i("Script", numero +" - ACTION_DRAG_LOCATION");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Script", numero +" - ACTION_DRAG_EXITED");
                    view.setBackgroundColor(Color.BLUE);
                    break;
                case DragEvent.ACTION_DROP:
                    Log.i("Script", numero +" - ACTION_DROP");
                    View visualisar = (View) dragEvent.getLocalState();
                    ViewGroup owner = (ViewGroup) visualisar.getParent();
                    owner.removeView(visualisar);
                    LinearLayout container = (LinearLayout) view;
                    container.addView(visualisar);
                    visualisar.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.i("Script", numero +" - ACTION_DRAG_ENDED");
                    view.setBackgroundColor(Color.BLUE);
                    break;
            }

            return true;
        }
    }
}
