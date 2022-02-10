package com.example.thirdapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        int statusBarColor = Color.parseColor("#FF8800");
        window.setStatusBarColor(statusBarColor);
    }

    private int teamAPoints = 0;
    private int teamBPoints = 0;

    public void displayA(int number){
        TextView pointView = (TextView) findViewById(R.id.point_view);
        pointView.setText("" + number);
    }

    public void threePointsTeamA(View view){
        this.teamAPoints+= 3;
        displayA(this.teamAPoints);
    }

    public void twoPointsTeamA(View view){
        this.teamAPoints+=2;
        displayA(this.teamAPoints);
    }

    public void FreeThrowA(View view){
        this.teamAPoints+=1;
        displayA(this.teamAPoints);
    }

    public void displayB(int number){
        TextView pointViewB = (TextView) findViewById(R.id.point_view_b);
        pointViewB.setText("" + number);
    }

    public void threePointsTeamB(View view){
        this.teamBPoints+= 3;
        displayB(this.teamBPoints);
    }

    public void twoPointsTeamB(View view){
        this.teamBPoints+=2;
        displayB(this.teamBPoints);
    }

    public void FreeThrowB(View view){
        this.teamBPoints+=1;
        displayB(this.teamBPoints);
    }

    public void reset(View view){
        this.teamAPoints = 0;
        this.teamBPoints = 0;
        displayA(this.teamAPoints);
        displayB(this.teamBPoints);
    }
}