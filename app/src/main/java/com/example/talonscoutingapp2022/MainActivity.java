package com.example.talonscoutingapp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String teamNum;
    String matchNum;
    String driverStation;
    String scouter;
    String teamColor = "Red";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Scouter Drop Down List
        Spinner scoutList = (Spinner) findViewById(R.id.scouterList);
        ArrayAdapter<String> scoutListAdapter = new ArrayAdapter<>
                (MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.scout_names));
        scoutListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scoutList.setAdapter(scoutListAdapter);

        //team color selector
        Switch colorSwitch = (Switch) findViewById(R.id.teamSwitch);
        colorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked ==true){
                    teamColor = "Blue";
                    colorSwitch.setText(teamColor);
                }
                if(isChecked == false){
                    teamColor = "Red";
                    colorSwitch.setText(teamColor);
                }
            }
        });

        //set team number and match number
        EditText teamNumber =  (EditText) findViewById(R.id.editTeamNumber);
        EditText matchNumber =  (EditText) findViewById(R.id.editMatchNumber);

        teamNum = teamNumber.getText().toString();
        matchNum = matchNumber.getText().toString();



    }

    public void startAuto(View v){
        Intent AutoIntent = new Intent(this, AutoActivity.class);
        startActivity(AutoIntent);
    }
}