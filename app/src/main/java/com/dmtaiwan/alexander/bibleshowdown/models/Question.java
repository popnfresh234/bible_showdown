package com.dmtaiwan.alexander.bibleshowdown.models;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/2/2017.
 */

public class Question {

    public Question(String question, ArrayList<String> correctAnswers) {
        this.question = question;
        this.correctAnswers = correctAnswers;
    }

    private String question;
    private ArrayList<String> correctAnswers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(ArrayList<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
}
