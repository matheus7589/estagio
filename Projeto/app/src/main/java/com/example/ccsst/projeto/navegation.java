package com.example.ccsst.projeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class navegation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int MenuCad = 1;
    private static final int MenuSet = 2;
    private static final int SubmenuEst  = 3;
    private static final int SubmenuCid = 4;
    private static final int SubmenuBai = 5;
    private static final int GROUP1 = 6;
    private SupportMapFragment mapFragment;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //MENU LATERAL
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //MENU LATERAL

        //GOOGLE MAP
        //seta o menu lateral para nao ficar em baixo do google map
        GoogleMapOptions options = new GoogleMapOptions();
        options.zOrderOnTop(true);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        map = mapFragment.getMap();

        /*mapFragment = SupportMapFragment.newInstance(options);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.llContainer, mapFragment);
        ft.commit();*/

        configMap();


        //GOOGLE MAP
    }


    //é necessário usar isso porque está trabalhando com fragment via API
    @Override
    public void onResume(){
        super.onResume();

       /* new Thread(){
            public void run(){
                while (mapFragment.getMap()==null){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        configMap();
                    }
                });
            }
        }.start();*/
    }

    public void configMap(){
        map = mapFragment.getMap();

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setMyLocationEnabled(true);

        LatLng latLng = new LatLng(-10.1689, -48.3317);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(13).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);

        map.animateCamera(update);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.



        SubMenu menu1 = menu.addSubMenu(Menu.NONE, MenuCad, 1,"Cadastro");
        menu1.add(GROUP1, SubmenuEst, 0, "Estado");
        menu1.add(GROUP1, SubmenuCid, 1, "Cidade");
        menu1.add(GROUP1, SubmenuBai, 2, "Bairro");
        //menu1.setGroupCheckable(GROUP1, true, true);

        MenuItem menu2 = menu.add(Menu.NONE, MenuSet, 2, "Configurações");
        menu2.setAlphabeticShortcut('b');


        getMenuInflater().inflate(R.menu.navegation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case MenuCad:
                return true;
            case SubmenuEst:
                Intent intentEstado = new Intent(this, Cad_Estado.class);
                startActivity(intentEstado);
                return true;
            case SubmenuCid:
                Intent intentCidade = new Intent(this, Cad_Cidade.class);
                startActivity(intentCidade);
                return true;
            case SubmenuBai:
                Intent intentBairro = new Intent(this, Cad_Bairro.class);
                startActivity(intentBairro);
                return true;
            case MenuSet:
                Toast.makeText(this, "Adicionar funcionalidade", Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

         if (id == R.id.nav_RCC) {

        } else if (id == R.id.nav_Licenciadas) {

        } else if (id == R.id.nav_ComColeta) {

        } else if (id == R.id.nav_Quadras) {

        } else if (id == R.id.nav_MeioFio) {

        } else if (id == R.id.nav_Localizacao){

        } else if (id == R.id.nav_Hidrografia){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
