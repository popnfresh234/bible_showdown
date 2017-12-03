package com.dmtaiwan.alexander.bibleshowdown;

import android.content.Context;

import com.dmtaiwan.alexander.bibleshowdown.models.Game;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Alexander on 12/2/2017.
 */

public class Utils {
    //Keys
    public static final String KEY_TEAM_NAME = "com.dmtaiwan.alexander.team.name";

    //Question File Name
    public static final String FILE_NAME_QUESTIONS = "questions.json";

    static public boolean doesQuestionFileExist(Context context) {
        File file = context.getFileStreamPath(FILE_NAME_QUESTIONS);
        return file.exists();
    }

    public static String readGamesFromFile(Context context) {
        String json = "";
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.questions);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                json = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static ArrayList<Game> gamesFromJson(String json) {
        Type type = new TypeToken<ArrayList<Game>>() {
        }.getType();
        ArrayList<Game> recipeList = new Gson().fromJson(json, type);
        return recipeList;
    }
}

