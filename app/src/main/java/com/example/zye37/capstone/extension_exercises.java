package com.example.zye37.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class extension_exercises extends AppCompatActivity {
    private Button standingExtension;
    private Button pressUp;

    public void clickstandingExtension() {
        standingExtension= (Button) findViewById(R.id.StandingExtension);
        standingExtension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStandingExtension = new Intent(extension_exercises.this,StandingExtension.class );
                startActivity(toStandingExtension);
            }
        });
    }

    public void clickPressUp() {
        pressUp= (Button) findViewById(R.id.PressUp);
        pressUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPressUp = new Intent(extension_exercises.this,PressUp.class );
                startActivity(toPressUp);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension_exercises);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        clickstandingExtension();
        clickPressUp();

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
