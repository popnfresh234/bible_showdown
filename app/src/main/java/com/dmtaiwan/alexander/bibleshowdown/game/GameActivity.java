package com.dmtaiwan.alexander.bibleshowdown.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dmtaiwan.alexander.bibleshowdown.R;
import com.dmtaiwan.alexander.bibleshowdown.models.Game;
import com.dmtaiwan.alexander.bibleshowdown.models.GameBank;
import com.dmtaiwan.alexander.bibleshowdown.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/2/2017.
 */

public class GameActivity extends AppCompatActivity {

    private String teamName;
    private ViewPager gamePager;
    private GamePagerAdapter gamePagerAdapter;
    private ArrayList<Game> games;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Fetch intent and extras
        Intent intent = getIntent();
        teamName = intent.getStringExtra(Utils.KEY_TEAM_NAME);
        if (teamName == null || teamName.equals("")) {
            teamName = getResources().getString(R.string.default_team_name);
        }

        //Get games
        GameBank gameBank = GameBank.get(this);
        games = gameBank.getGames();


        //Setup Viewpager
        gamePager = (ViewPager) findViewById(R.id.view_pager_game);

        Game game = games.get(0);
        gamePagerAdapter = new GamePagerAdapter(getSupportFragmentManager(), game.getQuestions(), teamName);
        gamePager.setAdapter(gamePagerAdapter);
    }
}
