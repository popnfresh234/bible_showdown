package com.dmtaiwan.alexander.bibleshowdown.models;

import android.content.Context;

import com.dmtaiwan.alexander.bibleshowdown.Utils;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/2/2017.
 */

public class GameBank {
    private static GameBank gameBank;
    private ArrayList<Game> games;

    private GameBank(Context context) {
        games = getGamesFromStorage(context);
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public static GameBank get(Context context) {
        if (gameBank == null) {
            gameBank = new GameBank(context);
        }
        return gameBank;
    }

    private ArrayList<Game> getGamesFromStorage(Context context) {
        String json = Utils.readGamesFromFile(context);
        return Utils.gamesFromJson(json);
    }
}
