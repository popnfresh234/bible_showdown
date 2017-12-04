package com.dmtaiwan.alexander.bibleshowdown.game;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dmtaiwan.alexander.bibleshowdown.models.Question;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/3/2017.
 */

public class GamePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Question> questions;
    private String teamName;

    public GamePagerAdapter(FragmentManager fragmentManager, ArrayList<Question> questions, String teamName) {
        super(fragmentManager);
        this.questions = questions;
        this.teamName = teamName;
    }


    @Override
    public Fragment getItem(int position) {

        //Build position string
        String positionPrefix = String.valueOf(position + 1);
        String positionSuffix = String.valueOf(questions.size());
        String positionString = positionPrefix + "/" + positionSuffix;

        //Create and return fragment
        return GameFragment.newInstance(questions.get(position), teamName, positionString);
    }

    @Override
    public int getCount() {
        return questions.size();
    }
}
