package com.example.zye37.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class lateral_flexion extends AppCompatActivity {
    private Button lateralFlexionStretch;

    public void clicksLateralFelxion() {
        lateralFlexionStretch= (Button) findViewById(R.id.LateralFlexionStretch);
        lateralFlexionStretch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLateralFlexion = new Intent(lateral_flexion.this,LateralFlexionStretch.class );
                startActivity(toLateralFlexion);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lateral_flexion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        clicksLateralFelxion();

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
