package com.dmtaiwan.alexander.bibleshowdown.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dmtaiwan.alexander.bibleshowdown.models.Answer;
import com.dmtaiwan.alexander.bibleshowdown.models.Game;
import com.dmtaiwan.alexander.bibleshowdown.models.Question;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/3/2017.
 */

public class QuestionWriter extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String gameOneQuestionOneString = "This is the first question";
        ArrayList<Answer> gameOneQuestionOneAnswers = new ArrayList<>();
        Answer gameOneQuestionOneAnswerOne = new Answer("this");
        Answer gameOneQuestionOneAnswerTwo = new Answer("is");
        Answer gameOneQuestionOneAnswerThree = new Answer("answer");
        gameOneQuestionOneAnswers.add(gameOneQuestionOneAnswerOne);
        gameOneQuestionOneAnswers.add(gameOneQuestionOneAnswerTwo);
        gameOneQuestionOneAnswers.add(gameOneQuestionOneAnswerThree);
        Question gameOneQuestionOne = new Question(gameOneQuestionOneString, gameOneQuestionOneAnswers);

        String gameOneQuestionTwoString = "This is the second question";

        ArrayList<Answer> gameOneQuestionTwoAnswers = new ArrayList<>();
        Answer gameOneQuestionTwoAnswerOne = new Answer("funky");
        Answer gameOneQuestionTwoAnswerTwo = new Answer("town");
        Answer gameOneQuestionTwoAnswerThree = new Answer("chicken");
        gameOneQuestionTwoAnswers.add(gameOneQuestionTwoAnswerOne);
        gameOneQuestionTwoAnswers.add(gameOneQuestionTwoAnswerTwo);
        gameOneQuestionTwoAnswers.add(gameOneQuestionTwoAnswerThree);

        Question gameOneQuestionTwo = new Question(gameOneQuestionTwoString, gameOneQuestionTwoAnswers);

        ArrayList<Question> gameOneQuestions = new ArrayList<>();
        gameOneQuestions.add(gameOneQuestionOne);
        gameOneQuestions.add(gameOneQuestionTwo);

        Game gameOne = new Game(gameOneQuestions);

        String gameTwoQuestionOneString = "How many bees?";
        ArrayList<Answer> gameTwoQuestionOneAnswers = new ArrayList<>();
        Answer gameTwoQuestionOneAnswerOne = new Answer("one");
        Answer gameTwoQuestionOneAnswerTwo = new Answer("two");
        Answer gameTwoQuestionOneAnswerThree = new Answer("three");
        gameTwoQuestionOneAnswers.add(gameTwoQuestionOneAnswerOne);
        gameTwoQuestionOneAnswers.add(gameTwoQuestionOneAnswerTwo);
        gameTwoQuestionOneAnswers.add(gameTwoQuestionOneAnswerThree);
        Question gameTwoQuestionOne = new Question(gameTwoQuestionOneString, gameTwoQuestionOneAnswers);

        String gameTwoQuestionTwoString = "How many elephants?";
        ArrayList<Answer> gameTwoQuestionTwoAnswers = new ArrayList<>();
        Answer gameTwoQuestionTwoAnswerOne = new Answer("dog");
        Answer gameTwoQuestionTwoAnswerTwo = new Answer("cat");
        Answer gameTwoQuestionTwoAnswerThree = new Answer("rhino");
        gameTwoQuestionTwoAnswers.add(gameTwoQuestionTwoAnswerOne);
        gameTwoQuestionTwoAnswers.add(gameTwoQuestionTwoAnswerTwo);
        gameTwoQuestionTwoAnswers.add(gameTwoQuestionTwoAnswerThree);
        Question gameTwoQuestionTwo = new Question(gameTwoQuestionTwoString, gameTwoQuestionTwoAnswers);

        ArrayList<Question> gameTwoQuestions = new ArrayList<>();
        gameTwoQuestions.add(gameTwoQuestionOne);
        gameTwoQuestions.add(gameTwoQuestionTwo);

        Game gameTwo = new Game(gameTwoQuestions);

        ArrayList<Game> games =new ArrayList<>();
        games.add(gameOne);
        games.add(gameTwo);

        Gson gson = new Gson();
        String jsonString = gson.toJson(games);
        Utils.writeRecipesToFile(jsonString, this);
    }
}
