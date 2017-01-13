package com.example.root.novoteste.controllers;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;


import com.example.root.novoteste.R;

public class Abas extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

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
        setContentView(R.layout.activity_cadastro_individual);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragmento1(), "Mão Dir. Palma");
        adapter.addFragment(new Fragmento2(), "Mão Dir. Dorso");
        adapter.addFragment(new Fragmento3(), "Mao Esq. Palma");
        adapter.addFragment(new Fragmento4(), "Mão Esq. Dorso");
        adapter.addFragment(new Fragmento5(), "Pé Dir. Sola");
        adapter.addFragment(new Fragmento6(), "Pé Dir. Frente");
        adapter.addFragment(new Fragmento7(), "Pé Esq. Sola");
        adapter.addFragment(new Fragmento8(), "Pé Esq. Frente");

        viewPager.setAdapter(adapter);
    }
}
