package com.example.mobitech.livesoccerapp.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mobitech.livesoccerapp.fragments.Live_matches_Fragment;
import com.example.mobitech.livesoccerapp.fragments.News;
import com.example.mobitech.livesoccerapp.fragments.Recent_matches_Fragment;
import com.example.mobitech.livesoccerapp.fragments.live_streaming;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Live_matches_Fragment tab1 = new Live_matches_Fragment();
                return tab1;
            case 1:
                live_streaming tab2 = new live_streaming();
                return tab2;
            case 2:
                Recent_matches_Fragment tab3 = new Recent_matches_Fragment();
                return tab3;
            case 3:
                News tab4 = new News();
                return tab4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}