package com.example.zye37.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Activity_YourExercises extends AppCompatActivity {
    private Button flexion, extension, lateral;

    public void clickFlexion() {
        flexion= (Button) findViewById(R.id.Flexion);
        flexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFlexion = new Intent(Activity_YourExercises.this,FlexionExercises.class );
                startActivity(toFlexion);
            }
        });
    }

    public void clickExtension() {
        extension= (Button) findViewById(R.id.Extension);
        extension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFlexion = new Intent(Activity_YourExercises.this,extension_exercises.class );
                startActivity(toFlexion);
            }
        });
    }

    public void clickLateral() {
        lateral= (Button) findViewById(R.id.LateralFlexion);
        lateral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLateral = new Intent(Activity_YourExercises.this,lateral_flexion.class );
                startActivity(toLateral);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__your_exercises);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        clickFlexion();
        clickExtension();
        clickLateral();

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
