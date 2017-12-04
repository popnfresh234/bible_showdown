package com.dmtaiwan.alexander.bibleshowdown;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dmtaiwan.alexander.bibleshowdown.game.GameActivity;
import com.dmtaiwan.alexander.bibleshowdown.utils.Utils;

/**
 * Created by Alexander on 12/2/2017.
 */

public class TeamNameActivity extends AppCompatActivity{


    private EditText teamNameEditText;
    private Button submitButton;
    private String teamName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_name);
        teamNameEditText = (EditText) findViewById(R.id.edit_text_team_name);
        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamName = teamNameEditText.getText().toString().trim();
                Intent intent = new Intent(TeamNameActivity.this, GameActivity.class);
                intent.putExtra(Utils.KEY_TEAM_NAME, teamName);
                startActivity(intent);
            }
        });
    }
}
