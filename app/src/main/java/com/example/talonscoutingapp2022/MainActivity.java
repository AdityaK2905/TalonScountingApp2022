package com.example.talonscoutingapp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
        /*
        EditText teamNumber =  (EditText) findViewById(R.id.editTeamNumber);
        EditText matchNumber =  (EditText) findViewById(R.id.editMatchNumber);

        teamNum = teamNumber.getText().toString();
        matchNum = matchNumber.getText().toString();
    */


    }

    public void startAuto(View v){
        //Making Data Bundle
        Bundle bundleStart = new Bundle();

        bundleStart.putString("teamNum", teamNum);
        bundleStart.putString("matchNum", matchNum);
        bundleStart.putString("driverStation", driverStation);
        bundleStart.putString("scouter", scouter);
        bundleStart.putString("teamColor", teamColor);

        Intent AutoIntent = new Intent(this, AutoActivity.class);
        AutoIntent.putExtras(bundleStart);
        startActivity(AutoIntent);
    }

    public void confirmPopup(View view) {

        EditText teamNumber =  (EditText) findViewById(R.id.editTeamNumber);
        EditText matchNumber =  (EditText) findViewById(R.id.editMatchNumber);

        teamNum = teamNumber.getText().toString();
        matchNum = matchNumber.getText().toString();

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.confirm_popup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}