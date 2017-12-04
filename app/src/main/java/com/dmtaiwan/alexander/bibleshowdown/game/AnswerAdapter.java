package com.dmtaiwan.alexander.bibleshowdown.game;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dmtaiwan.alexander.bibleshowdown.R;
import com.dmtaiwan.alexander.bibleshowdown.models.Answer;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/3/2017.
 */

public class AnswerAdapter extends ArrayAdapter<Answer> {

    public AnswerAdapter(@NonNull Context context, ArrayList<Answer> answers) {
        super(context, 0, answers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Answer answer = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_answer, parent, false);
        }

        TextView answerTextView = convertView.findViewById(R.id.text_view_list_item_answer);
        TextView scoreTextView = convertView.findViewById(R.id.text_view_list_item_score);

        if (answer.isCorrect()) {
            answerTextView.setText(answer.getAnswer());
            //Calculate score
            int highestScore = 5 * getCount();
            int score = 5 * position;
            scoreTextView.setText(String.valueOf(highestScore - score));
        }else answerTextView.setText(String.valueOf(position + 1));


        return convertView;
    }
}
