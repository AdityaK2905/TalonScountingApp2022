package com.example.talonscoutingapp2022;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AutoActivity extends AppCompatActivity {
   boolean leftHangar = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_screen);

        Button left_hangar_button = findViewById(R.id.leftHangarButton);
        left_hangar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftHangar = !leftHangar;
                setContentView(R.layout.activity_auto_screen);
            }
        });



    }
}
