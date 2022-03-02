package com.example.talonscoutingapp2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AutoActivity extends AppCompatActivity {
   boolean leftTarmac = false;
    public int upperMade = 0;
    public int lowerMade = 0;
    public int upperMissed = 0;
    public int lowerMissed = 0;

    //BUNDLE VARIABLES WOOOOOOOOOOOOOOOOOO
    String teamNum;
    String matchNum;
    String driverStation;
    String scouter;
    String teamColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_screen);
        Bundle bundleStart = getIntent().getExtras();

        //BUNDLE VARIABLES
        teamNum = bundleStart.getString("teamNum");
        matchNum = bundleStart.getString("matchNum");
        driverStation = bundleStart.getString("driverStation");
        scouter = bundleStart.getString("scouter");
        teamColor= bundleStart.getString("teamColor");

    }

    public void startTeleOp(View v){
        Bundle endBundle = new Bundle();
        endBundle.putString("teamNum", teamNum);
        endBundle.putString("matchNum", matchNum);
        endBundle.putString("driverStation", driverStation);
        endBundle.putString("scouter", scouter);
        endBundle.putString("teamColor", teamColor);

        endBundle.putBoolean("leftTarmac", leftTarmac);
        endBundle.putInt("upperMade", upperMade);
        endBundle.putInt("upperMissed", upperMissed);
        endBundle.putInt("lowerMade", lowerMade);
        endBundle.putInt("lowerMissed", lowerMissed);

        Intent teleOpIntent = new Intent(this, TeleOpActivity.class);
        teleOpIntent.putExtras(endBundle);
        startActivity(teleOpIntent);
    }


    //You get points if you leave the hangar in auto phase, so button for that
    public void leftHangerSuccessfully(View v){
        leftTarmac = true;
        ((TextView)findViewById(R.id.leftTarmacText)).setText("Left Tarmac: " + leftTarmac);
    }

    //undo button
    public void leftHangerUndo(View v){
        leftTarmac = false;
        ((TextView)findViewById(R.id.leftTarmacText)).setText("Left Tarmac: " + leftTarmac);
    }





    //adds points to made upper or lower
    public void upperMadePlus(View v){
        upperMade+=1;
        ((TextView)findViewById(R.id.upperMadeText2)).setText("Upper Made: " + upperMade);
    }

    public void lowerMadePlus(View v){
        lowerMade++;
        ((TextView) findViewById(R.id.lowerMadeText)).setText("Lower Made: "+lowerMade);
    }

    public void lowerGoalMiss(View v){
        lowerMissed++;
        ((TextView) findViewById(R.id.lowerMissedText)).setText("Lower Missed: "+ lowerMissed);
    }

    public void upperGoalMiss(View v){
        upperMissed++;
        ((TextView) findViewById(R.id.upperMissedText)).setText("Upper Missed: "+upperMissed);
    }

    public void undoUpperMade(View v){
        if (upperMade == 0) {
           return;
        }
        upperMade--;
        ((TextView)findViewById(R.id.upperMadeText2)).setText("Upper Made: " + upperMade);
    }

    public void undoUpperMiss(View v){
        if (upperMissed == 0) {
            return;
        }
        upperMissed--;
        ((TextView) findViewById(R.id.upperMissedText)).setText("Upper Missed: "+upperMissed);
    }

    public void undoLowerMiss(View v){
        if (lowerMissed == 0) {
            return;
        }
        lowerMissed--;
        ((TextView) findViewById(R.id.lowerMissedText)).setText("Lower Missed: "+ lowerMissed);
    }

    public void undoLowerMade(View v){
        if (lowerMade == 0) {
            return;
        }
        lowerMade--;
        ((TextView) findViewById(R.id.lowerMadeText)).setText("Lower Made: "+lowerMade);
    }
}
