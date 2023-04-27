package com.kolmenHengenTyhma.ammattikissat;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.kolmenHengenTyhma.ammattikissat.fragments.Battlescreen;
import com.kolmenHengenTyhma.ammattikissat.fragments.CatRecycler;
import com.kolmenHengenTyhma.ammattikissat.fragments.Information;

public class TabPagerAdapter extends FragmentStateAdapter {

    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new CatRecycler();
            case 1:
                return new Information();
            case 2:
                return new Battlescreen();
            default:
                return new CatRecycler();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
