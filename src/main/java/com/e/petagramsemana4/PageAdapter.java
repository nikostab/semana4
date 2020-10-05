package com.e.petagramsemana4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fragments;

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
        //this.fragments=fragments;
    }

    public void addFragment(Fragment fragment){
        try {
            fragments.add(fragment);
        }catch (Exception e){}

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
switch (position){
        case 0 :return new MascotasFragment();

        case 1: return new PerfilesFragment();

            }
            return null;
       }

    @Override
    public int getCount() {
      return 2;
    }

   }