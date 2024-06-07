package com.faradilla.dewikajii;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.faradilla.dewikajii.Tab1Fragment;
import com.faradilla.dewikajii.Tab2Fragment;

public class PagerAdapter extends FragmentPagerAdapter {
    int numTab;
    public PagerAdapter(@NonNull FragmentManager fm, int numTab) {
        super(fm);
        this.numTab=numTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new Tab1Fragment();
            case 1 :
                return new Tab2Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTab;
    }
}
