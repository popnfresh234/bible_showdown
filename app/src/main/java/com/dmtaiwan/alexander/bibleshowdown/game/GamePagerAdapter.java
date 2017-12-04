package com.dmtaiwan.alexander.bibleshowdown.game;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dmtaiwan.alexander.bibleshowdown.models.Question;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/3/2017.
 */

public class GamePagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Question> questions;
    private String teamName;
    private GameFragment.ActivityCallback callback;
    private ScoreFragment.ScoreListener scoreListener;

    public GamePagerAdapter(FragmentManager fragmentManager, ArrayList<Question> questions, String teamName, GameFragment.ActivityCallback callback, ScoreFragment.ScoreListener scoreListener) {
        super(fragmentManager);
        this.questions = questions;
        this.teamName = teamName;
        this.callback = callback;
        this.scoreListener = scoreListener;
    }


    @Override
    public Fragment getItem(int position) {

        if (position < questions.size()) {


            //Build position string
            String positionPrefix = String.valueOf(position + 1);
            String positionSuffix = String.valueOf(questions.size());
            String positionString = positionPrefix + "/" + positionSuffix;

            //Create and return fragment
            return GameFragment.newInstance(questions.get(position), teamName, positionString, callback);
        } else
            return ScoreFragment.newInstance(scoreListener);

    }

    @Override
    public int getCount() {
        return questions.size()+1;
    }
}
