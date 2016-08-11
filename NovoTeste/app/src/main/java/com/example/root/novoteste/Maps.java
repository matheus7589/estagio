package com.example.root.novoteste;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends AppCompatActivity implements OnMapReadyCallback, OnMapClickListener, OnMapLongClickListener {

    GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);

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
    }



    @Override
    public void onMapReady(GoogleMap map) {
        mapa = map;

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.addMarker(new MarkerOptions()
                .position(new LatLng(-10.1689, -48.3317)).title("Palmas").draggable(true));

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);

        LatLng latLng = new LatLng(-10.1689, -48.3317);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(13).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);

        map.animateCamera(update);

        mapa.setOnMapClickListener(this);
        mapa.setOnMapLongClickListener(this);

    }



    //    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }
}
