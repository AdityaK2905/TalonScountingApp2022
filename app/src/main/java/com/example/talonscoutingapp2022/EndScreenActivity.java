package com.example.talonscoutingapp2022;
import android.net.Uri;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.talonscoutingapp2022.fileManagement.ApplicationInstance;
import com.example.talonscoutingapp2022.fileManagement.Constants;

import java.io.File;
import java.io.FileWriter;

public class EndScreenActivity extends AppCompatActivity {

    MainActivity mainActivityVariables = new MainActivity();
    TeleOpActivity teleOpActivityVariables = new TeleOpActivity();

    String defenseType = "";
    String otherComments = "";
    String drivingSkills = "";

    //BUNDLE VARIABLES WOOOOOOOOOOOOOOOOOO
    String teamNum;
    String matchNum;
    String driverStation;
    String scouter;
    String teamColor;

    boolean leftTarmac = false;
    public int upperMade = 0;
    public int lowerMade = 0;
    public int upperMissed = 0;
    public int lowerMissed = 0;

    int climber = 0;

    public int totalDefenseTimeSecs = 0;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);
        Bundle startBundle = getIntent().getExtras();

        //BUNDLE VARIABLES
        teamNum = startBundle.getString("teamNum");
        matchNum = startBundle.getString("matchNum");
        driverStation = startBundle.getString("driverStation");
        scouter = startBundle.getString("scouter");
        teamColor= startBundle.getString("teamColor");

        leftTarmac = startBundle.getBoolean("leftTarmac");
        upperMade = startBundle.getInt("upperMade");
        lowerMade = startBundle.getInt("lowerMade");
        upperMissed = startBundle.getInt("upperMissed");
        lowerMissed = startBundle.getInt("lowerMissed");

        tarmacUpperShotsMade = startBundle.getInt("tarmacUpperShotsMade");
        tarmacUpperShotsMissed = startBundle.getInt("tarmacUpperShotsMissed");
        tarmacLowerShotsMade = startBundle.getInt("tarmacLowerShotsMade");
        tarmacLowerShotsMissed = startBundle.getInt("tarmacLowerShotsMissed");

        middleUpperShotsMade = startBundle.getInt("middleUpperShotsMade");
        middleUpperShotsMissed = startBundle.getInt("middleUpperShotsMissed");
        middleLowerShotsMade = startBundle.getInt("middleLowerShotsMade");
        middleLowerShotsMissed = startBundle.getInt("middleLowerShotsMissed");

        farUpperShotsMade = startBundle.getInt("farUpperShotsMade");
        farUpperShotsMissed = startBundle.getInt("farUpperShotsMissed");
        farLowerShotsMade = startBundle.getInt("farLowerShotsMade");
        farLowerShotsMissed = startBundle.getInt("farLowerShotsMissed");

        climber = startBundle.getInt("climber");
        totalDefenseTimeSecs = startBundle.getInt("totalDefenseTimeSecs");



        EditText defenseTypeEditable =  (EditText) findViewById(R.id.defenseTypeEditText);
        EditText otherCommentsEditable =  (EditText) findViewById(R.id.otherCommentsEditText);
        EditText drivingSkillsEditable =  (EditText) findViewById(R.id.drivingSkillsEditText);

    }


    public void createCSV(View v){
        EditText defenseTypeEditable =  (EditText) findViewById(R.id.defenseTypeEditText);
        EditText otherCommentsEditable =  (EditText) findViewById(R.id.otherCommentsEditText);
        EditText drivingSkillsEditable =  (EditText) findViewById(R.id.drivingSkillsEditText);


        MediaScannerConnection mMs;
        drivingSkills = drivingSkillsEditable.getText().toString();
        defenseType = defenseTypeEditable.getText().toString();
        otherComments = otherCommentsEditable.getText().toString();
        removeCommas(drivingSkills);
        removeCommas(defenseType);
        removeCommas(otherComments);

        String FILENAME = ("m:_"+ matchNum + "_t:_"+teamNum+"_.csv");
        //((TextView)findViewById(R.id.testTextView)).setText("m:"+ matchNum + "t:"+teamNum+".csv");

        //calculations

        int totalPoints = 0;
        if (leftTarmac){
            totalPoints = 2;
        }
        totalPoints += upperMade*4+lowerMade*2+(farLowerShotsMade+middleLowerShotsMade+tarmacLowerShotsMade)*1+(farUpperShotsMade+middleUpperShotsMade+tarmacUpperShotsMade)*2;
        if (climber == 1){
            totalPoints += 4;
        } else if (climber == 2){
            totalPoints += 6;
        } else if (climber == 3){
            totalPoints += 10;
        } else if (climber == 4){
            totalPoints += 15;
        }
        String entry = ""+teamNum+","+matchNum+","+teamColor+","+leftTarmac+","+upperMade+","+lowerMade+","+upperMissed+","+lowerMissed+","+tarmacUpperShotsMade+","+tarmacUpperShotsMissed+","+tarmacLowerShotsMade+","+tarmacLowerShotsMissed+","+middleUpperShotsMade+","+middleUpperShotsMissed+","+middleLowerShotsMade+","+middleLowerShotsMissed+","+farUpperShotsMade+","+farUpperShotsMissed+","+farLowerShotsMade +","+farLowerShotsMissed+","+climber+","+totalPoints+","+totalDefenseTimeSecs+","+defenseType+","+otherComments+","+drivingSkills+","+scouter+"\n";




        // Create directory if it does not exist
        File directory = new File(Constants.SCOUTING_DIR);
        if (!directory.exists()) {
            directory.mkdir();
        }
        // Write file and save in directory specified
        try {
            File file = new File(directory, FILENAME);
            FileWriter writer = new FileWriter(file);
            writer.append(entry);
            writer.flush();
            writer.close();
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"+Environment.getExternalStorageDirectory())));

        }
        catch (Exception e) {

        }
        Toast toast = Toast.makeText(getApplicationContext(), "File Downloaded! Check Directory.", Toast.LENGTH_LONG);
        toast.show();

        Intent resetIntent = new Intent(this, MainActivity.class);
        startActivity(resetIntent);

    }

    public String removeCommas(String str){
        str = str.replace(",","");
        return str;
    }
}
