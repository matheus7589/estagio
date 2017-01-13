package com.example.root.novoteste.controllers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.root.novoteste.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends AppCompatActivity implements OnMapReadyCallback, OnMapClickListener, OnMapLongClickListener {

    GoogleMap mapa;
    ProgressDialog dialog;
    double lat, lon;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_maps2);


        //CONTROLA TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //CONTROLA TOOLBAR

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapClick(LatLng point) {

//        mapa.addMarker(new MarkerOptions().position(point).title(
//                point.toString()));
//
//        Toast.makeText(getApplicationContext(),
//                "New marker added@" + point.toString(), Toast.LENGTH_LONG)
//                .show();

    }

    @Override
    public void onMapLongClick(LatLng point) {
        mapa.addMarker(new MarkerOptions()
                .position(point)
                .title("Você está aqui!")
                .draggable(true));

        Toast.makeText(getApplicationContext(),
                "Novo marcador adicionado: " + point.toString(), Toast.LENGTH_LONG)
                .show();

        lat = point.latitude;
        lon = point.longitude;

        dialog = ProgressDialog.show(Maps.this,"Novo Cadastro","Salvando localização. Aguarde...", false, true);
        dialog.setCancelable(false);


        new Thread() {

            public void run() {

                try {

                    Thread.sleep(2500);
                    dialog.dismiss();
                    Intent intent = new Intent(Maps.this, CadastroDomiciliar.class);
                    startActivity(intent);
                }catch (Exception e) {

                }
            }
        }.start();

        //finish();

    }



    @Override
    public void onMapReady(GoogleMap map) {
        mapa = map;

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng latLng = new LatLng(-10.1689, -48.3317);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(13).build();

        //LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(latLng).title("Marcador em Palmas"));
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);

    }



    //    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }
}
