package com.e.petagramsemana4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    Toolbar aBar;
    TabLayout tabLay;
    ViewPager viewPager;
    ArrayList<Fragment> fragments;
    ArrayList<String>nombres;
    ArrayList<Integer>fotos, votos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aBar = findViewById(R.id.aBar);
        setSupportActionBar(aBar);

        tabLay = findViewById(R.id.tablay);
         viewPager = findViewById(R.id.viewPager);

        loadPager(viewPager);
        tabLay.setupWithViewPager(viewPager);

        tabLay.getTabAt(0).setIcon(R.drawable.icons_home);
        tabLay.getTabAt(1).setIcon(R.drawable.icons_dog);
        aBar.setNavigationIcon(R.drawable.huella);


}



    private void loadPager(ViewPager viewPager){
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.addFragment(new MascotasFragment());
        adapter.addFragment(new PerfilesFragment());
        viewPager.setAdapter(adapter);

    }




    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }





}