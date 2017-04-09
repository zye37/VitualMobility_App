package com.example.zye37.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FlexionExercises extends AppCompatActivity {
    private Button standingLumbar;

    public void clickstandingLumbar() {
        standingLumbar= (Button) findViewById(R.id.StandingLumbar);
        standingLumbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStandingLumbar = new Intent(FlexionExercises.this,StandingLumbarFlexion.class );
                startActivity(toStandingLumbar);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexion_exercises);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
