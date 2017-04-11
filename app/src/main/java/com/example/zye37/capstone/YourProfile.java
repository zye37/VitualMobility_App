package com.example.zye37.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.IgnoreExtraProperties;

public class YourProfile extends AppCompatActivity {
    private Button btnCreate;
    private EditText userName, DOB, programStart;
    private RadioButton gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        btnCreate = (Button) findViewById(R.id.btnCreate);
        userName = (EditText) findViewById(R.id.InputName);
        DOB = (EditText) findViewById(R.id.InputDOB);
        programStart = (EditText) findViewById(R.id.ProgramStartDate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String DateOfBirth = DOB.getText().toString();
                String initiate = programStart.getText().toString();

                    patient newPatient = new patient(name, DateOfBirth, initiate);
                    ref.child("virvualmobilityapp").child(name).setValue(newPatient);
            }

        });

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
