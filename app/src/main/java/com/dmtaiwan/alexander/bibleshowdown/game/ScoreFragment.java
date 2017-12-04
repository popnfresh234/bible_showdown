package com.dmtaiwan.alexander.bibleshowdown.game;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmtaiwan.alexander.bibleshowdown.R;

/**
 * Created by Alexander on 12/4/2017.
 */

public class ScoreFragment extends Fragment {
    private ScoreListener scoreListener;

    public static ScoreFragment newInstance(ScoreListener scoreListener) {
        ScoreFragment scoreFragment = new ScoreFragment();
        scoreFragment.scoreListener = scoreListener;
        return scoreFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_score, container, false);
        TextView scoreTextView = (TextView) rootView.findViewById(R.id.text_view_game_score);
        scoreTextView.setText(String.valueOf(scoreListener.getScore()));
        return rootView;
    }

    public interface ScoreListener {
        public int getScore();
    }
}
