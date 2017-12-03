package com.dmtaiwan.alexander.bibleshowdown.models;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/2/2017.
 */

public class Game {
    private ArrayList<Question> questions;

    public Game(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
