package com.example.talonscoutingapp2022;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Timer;

public class TeleOpActivity extends AppCompatActivity {
    //Tarmac Shot Variables
    public int tarmacUpperShotsMade = 0;
    public int tarmacLowerShotsMade = 0;
    public int tarmacUpperShotsMissed = 0;
    public int tarmacLowerShotsMissed = 0;
    //Middle Zone Shot Variables
    public int middleUpperShotsMade = 0;
    public int middleLowerShotsMade = 0;
    public int middleUpperShotsMissed = 0;
    public int middleLowerShotsMissed = 0;
    //Safe Zone Beyond Shot Variables
    public int farUpperShotsMade = 0;
    public int farLowerShotsMade = 0;
    public int farUpperShotsMissed = 0;
    public int farLowerShotsMissed = 0;


    //Defense Variables
    //public Timer defenseTimer = new Timer();

    public boolean is_running;
    public boolean pin_switch;
    public boolean hoard_switch;

    public int totalDefenseTimeSecs = 0;

    public int totalPinTime = 0;
    public int totalHoardTime = 0;

    //CLIMBER Variables
    int climber = 0;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_phase_screen);
        running_Timer();

    }

    public void defensePopup(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.defense_popup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, 600, 400, focusable);

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

    public void climberPopup(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.climber_popup, null);

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

    public void shootingInfoPopup(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.shooting_info_layout, null);

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

    public void shootingTarmacInfoPopup(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_shooting_tarmac, null);

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

    public void shootingMiddleInfoPopup(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_shooting_middle, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, 400, 800, focusable);

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

    public void shootingFarInfoPopup(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_shooting_far, null);

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
        /*
        Button cancelButton = (Button) findViewById(R.id.shootingButtonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();

            }
        });
        */
    }

    //Tarmac methods
    public void addTarmacUpperShotMade(View v){
        tarmacUpperShotsMade++;
        updateAllTexts();
    }

    public void addTarmacUpperShotMissed(View v){
        tarmacUpperShotsMissed++;
        updateAllTexts();
    }

    public void addTarmacLowerShotMade(View v){
        tarmacLowerShotsMade++;
        updateAllTexts();
    }

    public void addTarmacLowerShotMissed(View v){
        tarmacLowerShotsMissed++;
        updateAllTexts();
    }

    //UNDOS
    public void undoAddTarmacUpperShotMade(View v){
        if (tarmacUpperShotsMade == 0){
            return;
        }
        tarmacUpperShotsMade--;
        updateAllTexts();
    }

    public void undoAddTarmacUpperShotMissed(View v){
        if (tarmacUpperShotsMissed == 0){
            return;
        }
        tarmacUpperShotsMissed--;
        updateAllTexts();
    }

    public void undoAddTarmacLowerShotMade(View v){
        if (tarmacLowerShotsMade == 0){
            return;
        }
        tarmacLowerShotsMade--;
        updateAllTexts();
    }

    public void undoAddTarmacLowerShotMissed(View v){
        if (tarmacLowerShotsMissed == 0){
            return;
        }
        tarmacLowerShotsMissed--;
        updateAllTexts();
    }



    //Medium distance methods
    public void addMiddleUpperShotMade(View v){
        middleUpperShotsMade++;
        updateAllTexts();
    }

    public void addMiddleUpperShotMissed(View v){
        middleUpperShotsMissed++;
        updateAllTexts();
    }

    public void addMiddleLowerShotMade(View v){
        middleLowerShotsMade++;
        updateAllTexts();
    }

    public void addMiddleLowerShotMissed(View v){
        middleLowerShotsMissed++;
        updateAllTexts();
    }
    //UNDOS
    public void undoAddMiddleUpperShotMade(View v){
        if (middleUpperShotsMade == 0){
            return;
        }
        middleUpperShotsMade--;
        updateAllTexts();
    }

    public void undoAddMiddleUpperShotMissed(View v){
        if (middleUpperShotsMissed == 0){
            return;
        }
        middleUpperShotsMissed--;
        updateAllTexts();
    }

    public void undoAddMiddleLowerShotMade(View v){
        if (middleLowerShotsMade == 0){
            return;
        }
        middleLowerShotsMade--;
        updateAllTexts();
    }

    public void undoAddMiddleLowerShotMissed(View v){
        if (middleLowerShotsMissed == 0){
            return;
        }
        middleLowerShotsMissed--;
        updateAllTexts();
    }



    //Far distance methods
    public void addFarUpperShotMade(View v){
        farUpperShotsMade++;
        updateAllTexts();
    }

    public void addFarUpperShotMissed(View v){
        farUpperShotsMissed++;
        updateAllTexts();
    }

    public void addFarLowerShotMade(View v){
        farLowerShotsMade++;
        updateAllTexts();
    }

    public void addFarLowerShotMissed(View v){
        farLowerShotsMissed++;
        updateAllTexts();
    }
    //UNDOS
    public void undoAddFarUpperShotMade(View v){
        if (farUpperShotsMade == 0){
            return;
        }
        farUpperShotsMade--;
        updateAllTexts();
    }

    public void undoAddFarUpperShotMissed(View v){
        if (farUpperShotsMissed == 0){
            return;
        }
        farUpperShotsMissed--;
        updateAllTexts();
    }

    public void undoAddFarLowerShotMade(View v){
        if (farLowerShotsMade == 0){
            return;
        }
        farLowerShotsMade--;
        updateAllTexts();
    }

    public void undoAddFarLowerShotMissed(View v){
        if (farLowerShotsMissed == 0){
            return;
        }
        farLowerShotsMissed--;
        updateAllTexts();
    }

    //Defense Methods

    public void onClickStart(View view)
    {
        is_running = true;
    }
    public void onClickStop(View view)
    {
        is_running = false;
    }

    public void running_Timer()
    {

        final Handler handle = new Handler();
        handle.post(new Runnable() {
            @Override
            public void run()
            {
                int hrs = totalDefenseTimeSecs / 3600;
                int mins = (totalDefenseTimeSecs % 3600) / 60;
                int secs = totalDefenseTimeSecs % 60;
                String time_t = String .format(Locale.getDefault(), "    %d:%02d:%02d   ", hrs,mins, secs);


                if (is_running) {
                    totalDefenseTimeSecs++;
                }

                handle.postDelayed(this, 1000);
                ((TextView)findViewById(R.id.totalDefenseTimeText)).setText("Total Defense: "+totalDefenseTimeSecs );

            }
        });
    }

    //Climber Methods
    public void climbLevel1(View v){
        climber = 1;
        ((TextView)findViewById(R.id.climberText)).setText("Climber: " + climber);
    }

    public void climbLevel2(View v){
        climber = 2;
        ((TextView)findViewById(R.id.climberText)).setText("Climber: " + climber);
    }

    public void climbLevel3(View v){
        climber = 3;
        ((TextView)findViewById(R.id.climberText)).setText("Climber: " + climber);
    }

    public void climbLevel4(View v){
        climber = 4;
        ((TextView)findViewById(R.id.climberText)).setText("Climber: " + climber);
    }

    public void didntClimb(View v){
        climber = 0;
        ((TextView)findViewById(R.id.climberText)).setText("Climber: " + climber);
    }

    public void updateAllTexts(){
        //Far
        ((TextView)findViewById(R.id.farTeleOpInfoUpperMadeText)).setText("Upper: " + farUpperShotsMade);
        ((TextView)findViewById(R.id.farTeleOpInfoUpperMissedText)).setText(""+farUpperShotsMissed);
        ((TextView)findViewById(R.id.farTeleOpInfoLowerMadeText)).setText("Lower: " + farLowerShotsMade);
        ((TextView)findViewById(R.id.farTeleOpInfoLowerMissedText)).setText(""+farLowerShotsMissed);
        //Middle
        ((TextView)findViewById(R.id.middleTeleOpInfoUpperMadeText)).setText("Upper: " + middleUpperShotsMade);
        ((TextView)findViewById(R.id.middleTeleOpInfoUpperMissedText)).setText(""+middleUpperShotsMissed);
        ((TextView)findViewById(R.id.middleTeleOpInfoLowerMadeText)).setText("Lower: " + middleLowerShotsMade);
        ((TextView)findViewById(R.id.middleTeleOpInfoLowerMissedText)).setText(""+middleLowerShotsMissed);
        //Low
        ((TextView)findViewById(R.id.tarmacTeleOpInfoUpperMadeText)).setText("Upper: " + tarmacUpperShotsMade);
        ((TextView)findViewById(R.id.tarmacTeleOpInfoUpperMissedText)).setText(""+tarmacUpperShotsMissed);
        ((TextView)findViewById(R.id.tarmacTeleOpInfoLowerMadeText)).setText("Lower: " + tarmacLowerShotsMade);
        ((TextView)findViewById(R.id.tarmacTeleOpInfoLowerMissedText)).setText(""+tarmacLowerShotsMissed);
    }

}
