package com.dmtaiwan.alexander.bibleshowdown;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dmtaiwan.alexander.bibleshowdown.models.Game;
import com.dmtaiwan.alexander.bibleshowdown.models.GameBank;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/2/2017.
 */

public class GameActivity extends AppCompatActivity {
    private String teamName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fetch intent and extras
        Intent intent = getIntent();
        teamName = intent.getStringExtra(Utils.KEY_TEAM_NAME);
        if (teamName == null || teamName.equals("")) {
            teamName = getResources().getString(R.string.default_team_name);
        }

        GameBank gameBank = GameBank.get(this);
        ArrayList<Game> games = gameBank.getGames();
        Log.i("TEST", games.size() + "");
    }
}
