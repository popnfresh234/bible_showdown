package com.dmtaiwan.alexander.bibleshowdown.game;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dmtaiwan.alexander.bibleshowdown.R;
import com.dmtaiwan.alexander.bibleshowdown.models.Answer;
import com.dmtaiwan.alexander.bibleshowdown.models.Question;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/3/2017.
 */

public class GameFragment extends Fragment {

    private int score;

    private Question question;
    private String teamName;
    private String position;
    private AnswerAdapter adapter;
    ArrayList<Answer> answers;
    private EditText entryEditText;
    private TextView scoreTextView;
    private int totalScore;
    private int incorrect = 0;

    private ImageView smileyOne;
    private ImageView smileyTwo;
    private ImageView smileyThree;

    public static GameFragment newInstance(Question question, String teamName, String position) {
        GameFragment gameFragment = new GameFragment();
        gameFragment.question = question;
        gameFragment.teamName = teamName;
        gameFragment.position = position;
        return gameFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);

        entryEditText = (EditText) rootView.findViewById(R.id.edit_text_answer_entry);
        scoreTextView = (TextView) rootView.findViewById(R.id.text_view_score);
        smileyOne = (ImageView) rootView.findViewById(R.id.image_view_fail_one);
        smileyTwo = (ImageView) rootView.findViewById(R.id.image_view_fail_two);
        smileyThree = (ImageView) rootView.findViewById(R.id.image_view_fail_three);

        //Set team name
        TextView teamNameTextView = rootView.findViewById(R.id.text_view_team_name);
        teamNameTextView.setText(teamName);

        //Set position
        TextView positionTextView = rootView.findViewById(R.id.text_view_question_number);
        positionTextView.setText(position);

        //Set question
        TextView questionTextView = rootView.findViewById(R.id.text_view_game_question);
        questionTextView.setText(question.getQuestion());

        ListView listView = rootView.findViewById(R.id.list_view_game);
        answers = question.getAnswers();
        adapter = new AnswerAdapter(getActivity(), answers);
        listView.setAdapter(adapter);


        Button enterButton = rootView.findViewById(R.id.button_enter);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEntry();
            }
        });
        return rootView;
    }

    private void validateEntry() {
        if (incorrect < 3) {
            String entry = entryEditText.getText().toString().toLowerCase().trim();
            boolean correct = false;
            for (int i = 0; i < answers.size(); i++) {
                Answer answer = answers.get(i);
                if (answer.getAnswer().equals(entry) && !answer.isCorrect()) {
                    answer.setCorrect(true);
                    int highestScore = 5 * answers.size();
                    int points = highestScore - 5 * i;
                    totalScore += points;
                    correct = true;
                    scoreTextView.setText(String.valueOf(totalScore));
                    adapter.notifyDataSetChanged();
                } else if (answer.getAnswer().equals(entry) && answer.isCorrect()) {
                    correct = true;
                }
            }
            if (!correct) {
                incorrect++;
                calculateSmileys();
            }
        }else{
            Toast.makeText(getActivity(), "No more guesses!", Toast.LENGTH_SHORT).show();
        }

    }

    private void calculateSmileys() {
        switch (incorrect) {
            case 1:
                smileyOne.setVisibility(View.VISIBLE);
                break;
            case 2:
                smileyTwo.setVisibility(View.VISIBLE);
                break;
            case 3:
                smileyThree.setVisibility(View.VISIBLE);
                break;
            default:
                break;

        }
    }

}
