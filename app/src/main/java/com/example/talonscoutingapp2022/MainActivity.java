package com.example.talonscoutingapp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button start_game_button = findViewById(R.id.startGameButton);
        /*
        start_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AutoActivity.class));
            }
        });
*/


    }

    public void startAuto(View v){
        Intent AutoIntent = new Intent(this, AutoActivity.class);
        startActivity(AutoIntent);
    }
}